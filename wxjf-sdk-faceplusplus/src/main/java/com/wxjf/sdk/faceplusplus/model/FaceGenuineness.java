package com.wxjf.sdk.faceplusplus.model;

import com.alibaba.fastjson.annotation.JSONField;

public class FaceGenuineness {

	@JSONField(name = "synthetic_face_confidence")
	private String syntheticFaceConfidence;
	
	@JSONField(name = "synthetic_face_threshold")
	private String syntheticFaceThreshold;
	
	@JSONField(name = "mask_confidence")
	private String maskConfidence;
	
	@JSONField(name = "mask_threshold")
	private String maskThreshold;

	public String getSyntheticFaceConfidence() {
		return syntheticFaceConfidence;
	}

	public void setSyntheticFaceConfidence(String syntheticFaceConfidence) {
		this.syntheticFaceConfidence = syntheticFaceConfidence;
	}

	public String getSyntheticFaceThreshold() {
		return syntheticFaceThreshold;
	}

	public void setSyntheticFaceThreshold(String syntheticFaceThreshold) {
		this.syntheticFaceThreshold = syntheticFaceThreshold;
	}

	public String getMaskConfidence() {
		return maskConfidence;
	}

	public void setMaskConfidence(String maskConfidence) {
		this.maskConfidence = maskConfidence;
	}

	public String getMaskThreshold() {
		return maskThreshold;
	}

	public void setMaskThreshold(String maskThreshold) {
		this.maskThreshold = maskThreshold;
	}
	
}
