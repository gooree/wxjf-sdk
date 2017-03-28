package com.wxjf.sdk.faceplusplus.request;

import com.wxjfkg.sdk.annotation.HttpParam;
import com.wxjfkg.sdk.http.HttpApiRequestWrapper;
import com.wxjfkg.sdk.http.HttpMethod;

public class DetectFaceRequest extends HttpApiRequestWrapper {

	public DetectFaceRequest() {
		super("https://api.faceid.com/faceid/v1/detect", HttpMethod.POST);
	}

	@HttpParam("api_key")
	private String apiKey;

	@HttpParam("api_secret")
	private String apiSecret;

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getApiSecret() {
		return apiSecret;
	}

	public void setApiSecret(String apiSecret) {
		this.apiSecret = apiSecret;
	}

}
