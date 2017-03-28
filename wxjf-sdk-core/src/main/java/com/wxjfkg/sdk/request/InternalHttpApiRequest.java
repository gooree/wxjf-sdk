package com.wxjfkg.sdk.request;

import com.wxjfkg.sdk.http.HttpApiRequestWrapper;
import com.wxjfkg.sdk.http.HttpMethod;

public class InternalHttpApiRequest<T> extends HttpApiRequestWrapper {

	private T entity;
	
	public InternalHttpApiRequest(String url) {
		super(url, HttpMethod.POST);
	}

	public T getEntity() {
		return entity;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}
	
}
