package com.wxjf.sdk.faceplusplus.response;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

public class FaceIdResponse implements Serializable {

	private static final long serialVersionUID = 8037705306142163023L;

	@JSONField(name = "time_used")
	private String timeUsed;
	
	@JSONField(name = "request_id")
	private String requestId;
	
	@JSONField(name = "error_message")
	private String errorMessage;

	public String getTimeUsed() {
		return timeUsed;
	}

	public void setTimeUsed(String timeUsed) {
		this.timeUsed = timeUsed;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}
