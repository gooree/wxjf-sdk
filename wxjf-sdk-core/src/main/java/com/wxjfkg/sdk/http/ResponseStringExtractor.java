package com.wxjfkg.sdk.http;

import java.io.IOException;

import okhttp3.Response;

public class ResponseStringExtractor implements ResponseExtractor<String> {

	@Override
	public String extract(Response response) throws IOException {
		return response.body().string();
	}

}
