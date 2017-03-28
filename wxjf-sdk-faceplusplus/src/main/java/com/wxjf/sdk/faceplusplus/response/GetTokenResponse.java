package com.wxjf.sdk.faceplusplus.response;

import com.alibaba.fastjson.annotation.JSONField;

public class GetTokenResponse extends FaceIdResponse {

	private static final long serialVersionUID = 7697742575128907632L;

	private String token;

	@JSONField(name = "expired_time")
	private int expiredTime;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getExpiredTime() {
		return expiredTime;
	}

	public void setExpiredTime(int expiredTime) {
		this.expiredTime = expiredTime;
	}

}
