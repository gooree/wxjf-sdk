package com.wxjfkg.sdk.http;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wxjfkg.sdk.ApiConstants;
import com.wxjfkg.sdk.utils.MimeUtils;

/**
 * 公用OkHttp调用模板类
 * 
 * @author GuoRui
 *
 */
public class OkHttpTemplate {
	
	private static final Logger logger = LoggerFactory.getLogger(OkHttpTemplate.class);

	private static OkHttpClient client;

	private int connectTimeout;

	private int readTimeout;
	
	private static SSLContext ctx = null;

	private static HostnameVerifier verifier = null;

	private static SSLSocketFactory socketFactory = null;
	
	private static X509TrustManager trustManager = null;
	
	public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
	
	public static final MediaType TEXT = MediaType.parse("text/plain; charset=utf-8");
	
	public static final MediaType XML = MediaType.parse("application/xml; charset=utf-8");
	
	/**
	 * 默认信任所有的服务器端证书
	 * 
	 * @author GuoRui
	 *
	 */
	private static class DefaultTrustManager implements X509TrustManager {
		public X509Certificate[] getAcceptedIssuers() {
			return null;
		}

		public void checkClientTrusted(X509Certificate[] chain, String authType)
				throws CertificateException {
		}

		public void checkServerTrusted(X509Certificate[] chain, String authType)
				throws CertificateException {
		}
		
		@SuppressWarnings("unused")
		public TrustAnchor findTrustAnchorByIssuerAndSignature(X509Certificate lastCert) {
			return null;
		}
	}

	static {
		try {
			trustManager = new DefaultTrustManager();
			ctx = SSLContext.getInstance("TLS");
			ctx.init(null, new TrustManager[] { trustManager } , new SecureRandom());

			ctx.getClientSessionContext().setSessionTimeout(15);
			ctx.getClientSessionContext().setSessionCacheSize(1000);

			socketFactory = ctx.getSocketFactory();
		} catch (Exception e) {
			logger.error("init ssl socket factory error", e);
		}

		verifier = new HostnameVerifier() {
			public boolean verify(String hostname, SSLSession session) {
				// return false;// 默认认证不通过，进行证书校验。
				return true;// 忽略证书校验
			}
		};
	}

	public OkHttpTemplate() {
		this(3000, 15000);
	}

	public OkHttpTemplate(int connectTimeout, int readTimeout) {
		this.connectTimeout = connectTimeout;
		this.readTimeout = readTimeout;
		init();
	}

	private void init() {
		if (client == null) {
			client = new OkHttpClient.Builder()
					.connectTimeout(connectTimeout, TimeUnit.MILLISECONDS)
					.readTimeout(readTimeout, TimeUnit.MILLISECONDS)
					.sslSocketFactory(socketFactory, trustManager)
					.hostnameVerifier(verifier)
					.retryOnConnectionFailure(false).build();
		}
	}
	
	public String execute(String url, String method,
			Map<String, String> parameters) throws HttpException {
		return execute(url, method, parameters, null, null);
	}
	
	public String execute(String url, String method,
			Map<String, String> parameters, Map<String, File> files, Map<String, String> headers)
			throws HttpException {
		if ("GET".equalsIgnoreCase(method)) {
			return doGet(url, parameters, headers);
		} else {
			return doPost(url, parameters, files, headers, new ResponseStringExtractor());
		}
	}
	
	public String get(String url) throws HttpException {
		return get(url, null);
	}
	
	public String get(String url, Map<String, String> parameters)
			throws HttpException {
		return doGet(url, parameters, null);
	}
	
	public <T> T get(String url, Map<String, String> parameters,
			ResponseExtractor<T> extractor) throws HttpException {
		return doGet(url, parameters, null, extractor);
	}
	
	private String encodeUrl(String value) throws HttpException {
		if (StringUtils.isBlank(value)) {
			return "";
		}
		try {
			return URLEncoder.encode(value, "utf-8");
		} catch (UnsupportedEncodingException uee) {
			throw new HttpException(uee);
		}
	}
	
	private String doGet(String url, Map<String, String> parameters,
			Map<String, String> headers) throws HttpException {
		return doGet(url, parameters, headers, new ResponseStringExtractor());
	}
	
	private <T> T doGet(String url, Map<String, String> parameters,
			Map<String, String> headers, ResponseExtractor<T> extractor)
			throws HttpException {
		StringBuilder parameterBuilder = new StringBuilder();
		if (parameters != null && parameters.size() > 0) {
			int pos = 0;
			for (String key : parameters.keySet()) {
				if (pos > 0) {
					parameterBuilder.append("&");
				}
				String value = parameters.get(key);
				parameterBuilder.append(key).append("=")
						.append(encodeUrl(value));
				pos++;
			}
		}
		StringBuilder urlBuilder = new StringBuilder(url);
		urlBuilder.append(url.contains("?") ? "" : "?");
		urlBuilder.append(parameterBuilder.toString());
		
		Request.Builder builder = new Request.Builder();
		if (headers != null && !headers.isEmpty()) {
			for (Map.Entry<String, String> entry : headers.entrySet()) {
				builder.addHeader(entry.getKey(), entry.getValue());
			}
		}
		
		Request request = builder.url(urlBuilder.toString())
				.build();
		
		Response response = null;
		try {
			response = client.newCall(request).execute();
			
			if (response.isSuccessful()) {
				return extractor.extract(response);
			} else {
				logger.info(
						"http request failure.response code:{},response message:{}",
						response.code(), response.message());
				throw new HttpException(response.code(), response.message());
			}
		} catch (IOException ioEx) {
			if (ioEx instanceof HttpException) {
				throw (HttpException) ioEx;
			}
			logger.error("http request failure,exception ocurred.", ioEx);
			if (response != null) {
				throw new HttpException(response.code(), response.message(),
						ioEx);
			} else {
				throw new HttpException(ioEx);
			}
		}
	}
	
	public String post(String url, Map<String, String> parameters)
			throws HttpException {
		return post(url, parameters, null);
	}

	public String post(String url, Map<String, String> parameters,
			Map<String, File> files) throws HttpException {
		return doPost(url, parameters, files, null, new ResponseStringExtractor());
	}
	
	public <T> T post(String url, MediaType mediaType, String content,
			ResponseExtractor<T> extractor) throws HttpException {
		RequestBody body = RequestBody.create(mediaType, content);
		
		Request.Builder builder = new Request.Builder();
		builder.addHeader("version", ApiConstants.VERSION);
		builder.addHeader("user-agent", ApiConstants.WXJF_SDK);
		Request request = builder.url(url).post(body).build();

		Response response = null;
		try {
			response = client.newCall(request).execute();
			if (response.isSuccessful()) {
				return extractor.extract(response);
			} else {
				logger.info("http request failure.response code:{},response message:{}",
						response.code(), response.message());
				throw new HttpException(response.code(), response.message());
			}
		} catch (IOException ioEx) {
			if (ioEx instanceof HttpException) {
				throw (HttpException) ioEx;
			}
			logger.error("http request failure,exception ocurred.", ioEx);
			if (response != null) {
				throw new HttpException(response.code(), response.message(),
						ioEx);
			} else {
				throw new HttpException(ioEx);
			}
		}
	}
	
	public String postEntity(String url, MediaType mediaType, String content) throws HttpException {
		RequestBody body = RequestBody.create(mediaType, content);
		
		Request.Builder builder = new Request.Builder();
		builder.addHeader("version", ApiConstants.VERSION);
		builder.addHeader("user-agent", ApiConstants.WXJF_SDK);
		Request request = builder.url(url).post(body).build();

		Response response = null;
		try {
			response = client.newCall(request).execute();
			if (response.isSuccessful()) {
				return response.body().string();
			} else {
				logger.info("http request failure.response code:{},response message:{}",
						response.code(), response.message());
				throw new HttpException(response.code(), response.message());
			}
		} catch (IOException ioEx) {
			if (ioEx instanceof HttpException) {
				throw (HttpException) ioEx;
			}
			logger.error("http request failure,exception ocurred.", ioEx);
			if (response != null) {
				throw new HttpException(response.code(), response.message(),
						ioEx);
			} else {
				throw new HttpException(ioEx);
			}
		}
	}
	
	private <T> T doPost(String url, Map<String, String> parameters,
			Map<String, File> files, Map<String, String> headers,
			ResponseExtractor<T> extractor) throws HttpException {
		MultipartBody.Builder mBuilder = new MultipartBody.Builder()
				.setType(MultipartBody.FORM);
		if (parameters != null && parameters.size() > 0) {
			for (String key : parameters.keySet()) {
				mBuilder.addFormDataPart(key, parameters.get(key));
			}
		}
		if (files != null && files.size() > 0) {
			for (String key : files.keySet()) {
				File file = files.get(key);
				String filename = file.getName();
				String contentType = MimeUtils.getContentType(file);
				if (StringUtils.isBlank(contentType)) {
					contentType = HttpApiConstants.APPLICATION_OCTET_STREAM_VALUE;
				}
				mBuilder.addPart(
						Headers.of("Content-Disposition", "form-data; name=\""
								+ key + "\"; filename=\"" + filename + "\""),
						RequestBody.create(MediaType.parse(contentType), file));
			}
		}
		RequestBody body = mBuilder.build();

		Request.Builder builder = new Request.Builder();
		if (headers != null && !headers.isEmpty()) {
			for (Map.Entry<String, String> entry : headers.entrySet()) {
				builder.addHeader(entry.getKey(), entry.getValue());
			}
		}

		Request request = builder.url(url).post(body).build();

		Response response = null;
		try {
			response = client.newCall(request).execute();
			if (response.isSuccessful()) {
				return extractor.extract(response);
			} else {
				logger.info(
						"http request failure.response code:{},response message:{}",
						response.code(), response.message());
				throw new HttpException(response.code(), response.message());
			}
		} catch (IOException ioEx) {
			if (ioEx instanceof HttpException) {
				throw (HttpException) ioEx;
			}
			logger.error("http request failure,exception ocurred.", ioEx);
			if (response != null) {
				throw new HttpException(response.code(), response.message(),
						ioEx);
			} else {
				throw new HttpException(ioEx);
			}
		}
	}
	
	public <T> T execute(String url, String method,
			Map<String, String> parameters, Map<String, File> files,
			Map<String, String> headers, ResponseExtractor<T> extractor)
			throws HttpException {
		if ("GET".equalsIgnoreCase(method)) {
			return doGet(url, parameters, headers, extractor);
		} else {
			return doPost(url, parameters, files, headers, extractor);
		}
	}

	public int getConnectTimeout() {
		return connectTimeout;
	}

	public void setConnectTimeout(int connectTimeout) {
		this.connectTimeout = connectTimeout;
	}

	public int getReadTimeout() {
		return readTimeout;
	}

	public void setReadTimeout(int readTimeout) {
		this.readTimeout = readTimeout;
	}

}
