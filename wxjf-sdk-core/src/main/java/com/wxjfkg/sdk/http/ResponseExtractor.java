package com.wxjfkg.sdk.http;

import java.io.IOException;

import okhttp3.Response;

public interface ResponseExtractor<T> {

	public T extract(Response response) throws IOException;
	
}
