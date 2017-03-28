package com.wxjfkg.sdk.http;

/**
 * <pre>
 * HttpMethod
 * 
 * 请求方法枚举类（目前只考虑支持GET和POST方法）
 * </pre>
 * 
 * @author GuoRui
 *
 */
public enum HttpMethod {

	GET("GET"), POST("POST");

	private String method;

	private HttpMethod(String method) {
		this.method = method;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

}
