package com.wxjfkg.sdk.http;

import com.wxjfkg.sdk.ApiResponse;

/**
 * <pre>
 * HttpApiResponse
 * 
 * Http Api响应泛型类
 * </pre>
 * 
 * @author GuoRui
 *
 */
public class HttpApiResponse<T> extends ApiResponse<T> {

	private static final long serialVersionUID = -2630875399632029346L;
	
	private String body;
	
	public T entity;
	
	public T getEntity() {
		return entity;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

}
