package com.wxjf.sdk.faceplusplus.model;

import com.alibaba.fastjson.annotation.JSONField;

public class Face {

	private String quality;

	@JSONField(name = "quality_threshold")
	private String qualityThreshold;

	private String token;
	
	private Rect rect;

	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}

	public String getQualityThreshold() {
		return qualityThreshold;
	}

	public void setQualityThreshold(String qualityThreshold) {
		this.qualityThreshold = qualityThreshold;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Rect getRect() {
		return rect;
	}

	public void setRect(Rect rect) {
		this.rect = rect;
	}

}
