package com.wxjfkg.sdk.http;

import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * <pre>
 * BasicHttpApiRequest
 * 
 * 基本的Http Api请求实现类
 * </pre>
 * 
 * @author GuoRui
 *
 */
public class BasicHttpApiRequest implements HttpApiRequest, MultipartHttpApiRequest {
	
	private final Map<String, String> parameters = new LinkedHashMap<String, String>(16);
	
	private final Map<String, HeaderValueHolder> headers = new LinkedHashMap<String, HeaderValueHolder>(10);
	
	private final Map<String, FileItem> multipartFiles = new LinkedHashMap<String, FileItem>(5);
	
	private String url = null;

	private String protocol = HttpApiConstants.DEFAULT_PROTOCOL;
	
	private String method = HttpApiConstants.DEFAULT_METHOD;
	
	private String characterEncoding = HttpApiConstants.DEFAULT_CHARACTER_ENCODING;
	
	private String contentType = HttpApiConstants.DEFAULT_CONTENT_TYPE;
	
	private String notifyUrl;
	
	private String returnUrl;
	
	public BasicHttpApiRequest(String url) {
		this(url, HttpMethod.GET);
	}
	
	public BasicHttpApiRequest(String url, HttpMethod method) {
		this.url = url;
		this.method = method.getMethod();
	}
	
	public String getProtocol() {
		return protocol;
	}
	
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}

	public String getMethod() {
		return method;
	}
	
	public void setMethod(String method) {
		this.method = method;
	}

	public String getCharacterEncoding() {
		return characterEncoding;
	}
	
	public void setCharacterEncoding(String characterEncoding) {
		this.characterEncoding = characterEncoding;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public String getReturnUrl() {
		return returnUrl;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}

	/*
	 * -------------------------http parameters method area-------------------------
	 */
	public Map<String, String> getParameterMap() {
		return parameters;
	}

	public String getParameter(String name) {
		return parameters.get(name);
	}
	
	public void setParameter(String name, String value) {
		this.parameters.put(name, value);
	}
	
	public void setParameters(Map<String, String> params) {
		this.parameters.putAll(params);
	}
	
	/*
	 * -------------------------http header method area-------------------------
	 */
	public void addHeader(String name, Object value) {
		doAddHeaderValue(name, value, false);
	}

	@SuppressWarnings("rawtypes")
	private void doAddHeaderValue(String name, Object value, boolean replace) {
		HeaderValueHolder header = HeaderValueHolder.getByName(this.headers,
				name);
		if (header == null || replace) {
			header = new HeaderValueHolder();
			this.headers.put(name, header);
		}
		if (value instanceof Collection) {
			header.addValues((Collection) value);
		} else if (value.getClass().isArray()) {
			header.addValueArray(value);
		} else {
			header.addValue(value);
		}
	}

	public String getHeader(String name) {
		HeaderValueHolder header = HeaderValueHolder.getByName(this.headers, name);
		return (header != null ? header.getStringValue() : null);
	}

	public Enumeration<String> getHeaders(String name) {
		HeaderValueHolder header = HeaderValueHolder.getByName(this.headers, name);
		return Collections.enumeration(header != null ? header.getStringValues() : new LinkedList<String>());
	}

	public Enumeration<String> getHeaderNames() {
		return Collections.enumeration(this.headers.keySet());
	}

	/*
	 * -------------------------multipart http method area-------------------------
	 */
	/**
	 * 增加上传文件
	 * 
	 * @param file
	 */
	public void addFile(FileItem file) {
		this.multipartFiles.put(file.getFileName(), file);
	}

	public Iterator<String> getFileNames() {
		return this.multipartFiles.keySet().iterator();
	}

	public FileItem getFile(String name) {
		return this.multipartFiles.get(name);
	}

	public Map<String, FileItem> getFileMap() {
		return multipartFiles;
	}
	
	public boolean isMultipartRequest() {
		return (multipartFiles.size() > 0) ? true : false;
	}
	
}
