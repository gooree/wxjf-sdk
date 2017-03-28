package com.wxjf.sdk.faceplusplus.request;

import com.wxjfkg.sdk.annotation.HttpParam;
import com.wxjfkg.sdk.http.HttpApiRequestWrapper;
import com.wxjfkg.sdk.http.HttpMethod;

public class GetResultRequest extends HttpApiRequestWrapper {

	public GetResultRequest() {
		super("https://api.megvii.com/faceid/liveness/v2/get_result", HttpMethod.GET);
	}
	
	@HttpParam("api_key")
	private String apiKey;

	@HttpParam("api_secret")
	private String apiSecret;
	
	@HttpParam("biz_id")
	private String bizId;
	
	@HttpParam("get_image_type")
	private int getImageType;
	
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

	public String getBizId() {
		return bizId;
	}

	public void setBizId(String bizId) {
		this.bizId = bizId;
	}

	public int getGetImageType() {
		return getImageType;
	}

	public void setGetImageType(int getImageType) {
		this.getImageType = getImageType;
	}
	
}
