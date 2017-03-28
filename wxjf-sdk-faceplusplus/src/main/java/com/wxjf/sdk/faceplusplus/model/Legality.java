package com.wxjf.sdk.faceplusplus.model;

import com.alibaba.fastjson.annotation.JSONField;

public class Legality {

	@JSONField(name="ID Photo")
	private String idPhoto;

	@JSONField(name="Temporary ID Photo")
	private String temporaryIdPhoto;

	@JSONField(name="Photocopy")
	private String photocopy;

	@JSONField(name="Screen")
	private String screen;

	@JSONField(name="Edited")
	private String edited;

	public String getIdPhoto() {
		return idPhoto;
	}

	public void setIdPhoto(String idPhoto) {
		this.idPhoto = idPhoto;
	}

	public String getTemporaryIdPhoto() {
		return temporaryIdPhoto;
	}

	public void setTemporaryIdPhoto(String temporaryIdPhoto) {
		this.temporaryIdPhoto = temporaryIdPhoto;
	}

	public String getPhotocopy() {
		return photocopy;
	}

	public void setPhotocopy(String photocopy) {
		this.photocopy = photocopy;
	}

	public String getScreen() {
		return screen;
	}

	public void setScreen(String screen) {
		this.screen = screen;
	}

	public String getEdited() {
		return edited;
	}

	public void setEdited(String edited) {
		this.edited = edited;
	}

}
