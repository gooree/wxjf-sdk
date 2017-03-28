package com.wxjf.sdk.faceplusplus.model;

import com.alibaba.fastjson.annotation.JSONField;

public class IdException {

	@JSONField(name = "id_attacked")
	private String idAttacked;

	@JSONField(name = "id_photo_monochrome")
	private String idPhotoMonochrome;

	public String getIdAttacked() {
		return idAttacked;
	}

	public void setIdAttacked(String idAttacked) {
		this.idAttacked = idAttacked;
	}

	public String getIdPhotoMonochrome() {
		return idPhotoMonochrome;
	}

	public void setIdPhotoMonochrome(String idPhotoMonochrome) {
		this.idPhotoMonochrome = idPhotoMonochrome;
	}

}
