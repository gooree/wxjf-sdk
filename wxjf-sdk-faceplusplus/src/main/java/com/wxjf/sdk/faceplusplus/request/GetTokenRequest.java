package com.wxjf.sdk.faceplusplus.request;

import com.wxjfkg.sdk.annotation.HttpParam;
import com.wxjfkg.sdk.http.HttpApiRequestWrapper;
import com.wxjfkg.sdk.http.HttpMethod;

public class GetTokenRequest extends HttpApiRequestWrapper {

	public GetTokenRequest() {
		super("https://api.megvii.com/faceid/liveness/v2/get_token", HttpMethod.POST);
	}
	
	@HttpParam("api_key")
	private String apiKey;

	@HttpParam("api_secret")
	private String apiSecret;

	@HttpParam("comparison_type")
	private String comparisonType;
	
	@HttpParam("idcard_name")
	private String idCardName;

	@HttpParam("idcard_number")
	private String idCardNumber;
	
	@HttpParam("return_url")
	private String returnUrl;
	
	@HttpParam("notify_url")
	private String notifyUrl;
	
	@HttpParam("biz_no")
	private String bizNo;

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

	public String getComparisonType() {
		return comparisonType;
	}

	public void setComparisonType(String comparisonType) {
		this.comparisonType = comparisonType;
	}

	public String getIdCardName() {
		return idCardName;
	}

	public void setIdCardName(String idCardName) {
		this.idCardName = idCardName;
	}

	public String getIdCardNumber() {
		return idCardNumber;
	}

	public void setIdCardNumber(String idCardNumber) {
		this.idCardNumber = idCardNumber;
	}

	public String getReturnUrl() {
		return returnUrl;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public String getBizNo() {
		return bizNo;
	}

	public void setBizNo(String bizNo) {
		this.bizNo = bizNo;
	}
	
}
