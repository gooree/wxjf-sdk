package com.wxjf.sdk.faceplusplus.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.wxjf.sdk.faceplusplus.model.LivenessResult;
import com.wxjf.sdk.faceplusplus.model.VerifyResult;

public class GetResultResponse extends FaceIdResponse {

	private static final long serialVersionUID = -3713816408389407462L;

	@JSONField(name = "biz_extra_data")
	private String bizExtraData;
	
	@JSONField(name = "biz_id")
	private String bizId;
	
	@JSONField(name = "biz_no")
	private String bizNo;
	
	@JSONField(name = "liveness_result")
	private LivenessResult livenessResult;
	
	@JSONField(name = "verify_result")
	private VerifyResult verifyResult;

	public String getBizExtraData() {
		return bizExtraData;
	}

	public void setBizExtraData(String bizExtraData) {
		this.bizExtraData = bizExtraData;
	}

	public String getBizId() {
		return bizId;
	}

	public void setBizId(String bizId) {
		this.bizId = bizId;
	}

	public String getBizNo() {
		return bizNo;
	}

	public void setBizNo(String bizNo) {
		this.bizNo = bizNo;
	}

	public LivenessResult getLivenessResult() {
		return livenessResult;
	}

	public void setLivenessResult(LivenessResult livenessResult) {
		this.livenessResult = livenessResult;
	}

	public VerifyResult getVerifyResult() {
		return verifyResult;
	}

	public void setVerifyResult(VerifyResult verifyResult) {
		this.verifyResult = verifyResult;
	}
	
}
