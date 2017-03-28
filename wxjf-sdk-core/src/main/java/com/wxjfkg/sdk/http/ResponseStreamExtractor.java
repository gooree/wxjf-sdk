package com.wxjfkg.sdk.http;

import java.io.InputStream;

import okhttp3.Response;

public class ResponseStreamExtractor implements ResponseExtractor<InputStream> {

	@Override
	public InputStream extract(Response response) {
		return response.body().byteStream();
	}

}
