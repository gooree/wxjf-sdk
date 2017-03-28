package com.wxjf.sdk.faceplusplus.model;

import com.alibaba.fastjson.annotation.JSONField;

public class VerifyResult {

	@JSONField(name = "request_id")
	private String requestId;

	@JSONField(name = "time_used")
	private String timeUsed;

	@JSONField(name = "result_faceid")
	private ResultFaceid resultFaceid;

	@JSONField(name = "result_ref1")
	private ResultFaceid resultRef1;

	@JSONField(name = "face_genuineness")
	private FaceGenuineness faceGenuineness;

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getTimeUsed() {
		return timeUsed;
	}

	public void setTimeUsed(String timeUsed) {
		this.timeUsed = timeUsed;
	}

	public ResultFaceid getResultFaceid() {
		return resultFaceid;
	}

	public void setResultFaceid(ResultFaceid resultFaceid) {
		this.resultFaceid = resultFaceid;
	}

	public ResultFaceid getResultRef1() {
		return resultRef1;
	}

	public void setResultRef1(ResultFaceid resultRef1) {
		this.resultRef1 = resultRef1;
	}

	public FaceGenuineness getFaceGenuineness() {
		return faceGenuineness;
	}

	public void setFaceGenuineness(FaceGenuineness faceGenuineness) {
		this.faceGenuineness = faceGenuineness;
	}

}
