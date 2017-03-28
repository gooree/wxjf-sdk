package com.wxjf.sdk.faceplusplus.request;

import com.wxjfkg.sdk.annotation.HttpParam;
import com.wxjfkg.sdk.http.HttpApiRequestWrapper;
import com.wxjfkg.sdk.http.HttpMethod;

public class DetectOcrRequest extends HttpApiRequestWrapper {

	public DetectOcrRequest() {
		super("https://api.faceid.com/faceid/v1/ocridcard", HttpMethod.POST);
	}
	
	@HttpParam("api_key")
	private String apiKey;

	@HttpParam("api_secret")
	private String apiSecret;
	
	private String legality;

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

	public String getLegality() {
		return legality;
	}

	public void setLegality(String legality) {
		this.legality = legality;
	}

}
