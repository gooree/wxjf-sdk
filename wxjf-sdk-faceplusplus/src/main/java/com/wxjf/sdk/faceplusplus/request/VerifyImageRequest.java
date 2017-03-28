package com.wxjf.sdk.faceplusplus.request;

import com.wxjfkg.sdk.annotation.HttpParam;
import com.wxjfkg.sdk.http.HttpApiRequestWrapper;
import com.wxjfkg.sdk.http.HttpMethod;

public class VerifyImageRequest extends HttpApiRequestWrapper {

	public VerifyImageRequest() {
		super("https://api.megvii.com/faceid/v2/verify", HttpMethod.POST);
	}

	@HttpParam("api_key")
	private String apiKey;

	@HttpParam("api_secret")
	private String apiSecret;

	@HttpParam("comparison_type")
	private String comparisonType;

	@HttpParam("face_image_type")
	private String faceImageType;

	@HttpParam("idcard_name")
	private String idCardName;

	@HttpParam("idcard_number")
	private String idCardNumber;
	
	@HttpParam("face_token")
	private String faceToken;
	
	private String delta;

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

	public String getFaceImageType() {
		return faceImageType;
	}

	public void setFaceImageType(String faceImageType) {
		this.faceImageType = faceImageType;
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

	public String getFaceToken() {
		return faceToken;
	}

	public void setFaceToken(String faceToken) {
		this.faceToken = faceToken;
	}

	public String getDelta() {
		return delta;
	}

	public void setDelta(String delta) {
		this.delta = delta;
	}

}
