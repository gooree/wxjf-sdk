package com.wxjf.sdk.faceplusplus.model;

public class ResultFaceid {

	private String confidence;
	
	private Thresholds thresholds;

	public String getConfidence() {
		return confidence;
	}

	public void setConfidence(String confidence) {
		this.confidence = confidence;
	}

	public Thresholds getThresholds() {
		return thresholds;
	}

	public void setThresholds(Thresholds thresholds) {
		this.thresholds = thresholds;
	}
	
}
