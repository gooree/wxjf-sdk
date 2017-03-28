package com.wxjfkg.sdk.request;

import com.wxjfkg.sdk.http.HttpApiRequestWrapper;
import com.wxjfkg.sdk.http.HttpMethod;

public class SimpleHttpRequest extends HttpApiRequestWrapper {

	public SimpleHttpRequest(String url, HttpMethod method) {
		super(url, method);
	}

}
