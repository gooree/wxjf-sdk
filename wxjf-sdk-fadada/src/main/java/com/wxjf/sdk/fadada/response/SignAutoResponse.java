package com.wxjf.sdk.fadada.response;

import com.alibaba.fastjson.annotation.JSONField;

public class SignAutoResponse extends FadadaResponse {

	@JSONField(name = "download_url")
	private String downloadUrl;
	
	@JSONField(name = "viewpdf_url")
	private String viewpdfUrl;

	public String getDownloadUrl() {
		return downloadUrl;
	}

	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}

	public String getViewpdfUrl() {
		return viewpdfUrl;
	}

	public void setViewpdfUrl(String viewpdfUrl) {
		this.viewpdfUrl = viewpdfUrl;
	}
	
}
