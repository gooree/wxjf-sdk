package com.wxjfkg.sdk;

import java.io.File;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wxjfkg.sdk.http.EncryptMethod;
import com.wxjfkg.sdk.http.FileItem;
import com.wxjfkg.sdk.http.HttpApiRequest;
import com.wxjfkg.sdk.http.HttpApiResponse;
import com.wxjfkg.sdk.http.HttpException;
import com.wxjfkg.sdk.http.HttpMethod;
import com.wxjfkg.sdk.http.MultipartHttpApiRequest;
import com.wxjfkg.sdk.http.OkHttpTemplate;
import com.wxjfkg.sdk.http.ResponseStreamExtractor;
import com.wxjfkg.sdk.request.InternalHttpApiRequest;
import com.wxjfkg.sdk.sign.HttpApiSignature;
import com.wxjfkg.sdk.sign.Md5HttpApiSignature;
import com.wxjfkg.sdk.utils.JsonUtils;

/**
 * Http Api客户端调用类
 * 
 * @author GuoRui
 *
 */
public class HttpApiClient implements ApiClient<HttpApiRequest> {
	
	private static final Logger logger = LoggerFactory.getLogger(HttpApiClient.class);
	
	private static final OkHttpTemplate template = new OkHttpTemplate();

	public <T> HttpApiResponse<T> execute(HttpApiRequest request, Class<T> clazz) {
		return execute(request, clazz, EncryptMethod.NONE, null);
	}
	
	@SuppressWarnings("rawtypes")
	public <T> HttpApiResponse<T> execute(HttpApiRequest request,
			Class<T> clazz, EncryptMethod encryptMethod, String privateKey) {
		if(request instanceof InternalHttpApiRequest) {
			InternalHttpApiRequest req = (InternalHttpApiRequest) request;
			return executeInternalRequest(req, clazz, encryptMethod, privateKey);
		}
		
		HttpApiResponse<T> response = new HttpApiResponse<T>();

		String result = null;
		Map<String, File> files = null;
		try {
			if (encryptMethod != null && encryptMethod != EncryptMethod.NONE
					&& privateKey != null) {
				HttpApiSignature<HttpApiRequest> has = new HttpApiSignature<HttpApiRequest>();
				request.setParameter(ApiConstants.SIGN, has.sign(request,
						encryptMethod.getMethod(), privateKey));
			}

			if (!HttpMethod.GET.getMethod().equalsIgnoreCase(
					request.getMethod())
					&& request.isMultipartRequest()) {
				MultipartHttpApiRequest multipartRequest = (MultipartHttpApiRequest) request;

				files = new HashMap<String, File>();
				Map<String, FileItem> map = multipartRequest.getFileMap();
				for (String key : map.keySet()) {
					files.put(key, map.get(key).getFile());
				}
			}
			
			Map<String, String> headers = new HashMap<String, String>();
			Enumeration<String> names = request.getHeaderNames();
			while (names.hasMoreElements()) {
				String name = names.nextElement();
				String value = null;
				Enumeration<String> values = request.getHeaders(name);
				if(values.hasMoreElements()) {
					value = values.nextElement();
				}
				headers.put(name, value);
			}

			result = template.execute(request.getUrl(), request.getMethod(),
					request.getParameterMap(), files, headers);
			logger.debug("http response content:{}", result);
		} catch (HttpException ex) {
			logger.error("http api execute failure.", ex);
			response.setCode(String.valueOf(ex.getStatus()));
			response.setMessage(ex.getReason());
		}

		if (StringUtils.isNotBlank(result)) {
			response.setBody(result);
			response.setEntity(JsonUtils.toObject(result, clazz));
		}
		return response;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public <T> HttpApiResponse<T> executeInternalRequest(
			InternalHttpApiRequest request, Class<T> clazz,
			EncryptMethod encryptMethod, String privateKey) {
		HttpApiResponse<T> response = new HttpApiResponse<T>();

		MediaType mediaType = OkHttpTemplate.TEXT;
		String body = null;
		String result = null;

		try {
			if (encryptMethod != null && privateKey != null) {
				Md5HttpApiSignature sign = new Md5HttpApiSignature();
				body = sign
						.sign(request, encryptMethod.getMethod(), privateKey);
			} else {
				mediaType = OkHttpTemplate.JSON;
				body = JsonUtils.toJson(request.getEntity());
			}

			logger.debug("http post body:{}", body);
			result = template.postEntity(request.getUrl(), mediaType, body);
			logger.debug("http response content:{}", result);
		} catch (HttpException ex) {
			logger.error("http api execute failure.", ex);
			response.setCode(String.valueOf(ex.getStatus()));
			response.setMessage(ex.getReason());
		}

		if (StringUtils.isNotBlank(result)) {
			response.setBody(result);
			response.setEntity(JsonUtils.toObject(result, clazz));
		}
		return response;
	}
	
	public InputStream executeWithRawStream(HttpApiRequest request) {
		InputStream stream = null;
		Map<String, File> files = null;
		try {
			if (!HttpMethod.GET.getMethod().equalsIgnoreCase(
					request.getMethod())
					&& request.isMultipartRequest()) {
				MultipartHttpApiRequest multipartRequest = (MultipartHttpApiRequest) request;

				files = new HashMap<String, File>();
				Map<String, FileItem> map = multipartRequest.getFileMap();
				for (String key : map.keySet()) {
					files.put(key, map.get(key).getFile());
				}
			}
			
			Map<String, String> headers = new HashMap<String, String>();
			Enumeration<String> names = request.getHeaderNames();
			while (names.hasMoreElements()) {
				String name = names.nextElement();
				String value = null;
				Enumeration<String> values = request.getHeaders(name);
				if(values.hasMoreElements()) {
					value = values.nextElement();
				}
				headers.put(name, value);
			}

			stream = template.execute(request.getUrl(), request.getMethod(),
					request.getParameterMap(), files, headers,
					new ResponseStreamExtractor());
		} catch (HttpException ex) {
			logger.error("http api execute failure.", ex);
		}
		return stream;
	}

}
