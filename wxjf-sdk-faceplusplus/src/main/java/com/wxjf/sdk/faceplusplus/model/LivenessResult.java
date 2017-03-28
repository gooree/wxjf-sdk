package com.wxjf.sdk.faceplusplus.model;

import com.alibaba.fastjson.annotation.JSONField;

public class LivenessResult {

	@JSONField(name = "failure_reason")
	private String failureReason;

	private String log;

	private String result;

	private String version;

	public String getFailureReason() {
		return failureReason;
	}

	public void setFailureReason(String failureReason) {
		this.failureReason = failureReason;
	}

	public String getLog() {
		return log;
	}

	public void setLog(String log) {
		this.log = log;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}
