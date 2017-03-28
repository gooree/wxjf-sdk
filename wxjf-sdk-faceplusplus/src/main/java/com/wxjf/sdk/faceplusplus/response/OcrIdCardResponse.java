package com.wxjf.sdk.faceplusplus.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.wxjf.sdk.faceplusplus.model.HeadRect;
import com.wxjf.sdk.faceplusplus.model.IdCardDate;
import com.wxjf.sdk.faceplusplus.model.Legality;
import com.wxjfkg.sdk.utils.JsonUtils;

public class OcrIdCardResponse extends FaceIdResponse {

	private static final long serialVersionUID = -6153476680826167054L;

	private String address;

	private IdCardDate birthday;

	@JSONField(name="head_rect")
	private HeadRect headRect;

	private String gender;

	@JSONField(name="id_card_number")
	private String idCardNumber;

	private String name;

	private String race;

	private String side;

	@JSONField(name="issued_by")
	private String issuedBy;

	@JSONField(name="valid_date")
	private String validDate;

	private Legality legality;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public IdCardDate getBirthday() {
		return birthday;
	}

	public void setBirthday(IdCardDate birthday) {
		this.birthday = birthday;
	}

	public HeadRect getHeadRect() {
		return headRect;
	}

	public void setHeadRect(HeadRect headRect) {
		this.headRect = headRect;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIdCardNumber() {
		return idCardNumber;
	}

	public void setIdCardNumber(String idCardNumber) {
		this.idCardNumber = idCardNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}

	public String getIssuedBy() {
		return issuedBy;
	}

	public void setIssuedBy(String issuedBy) {
		this.issuedBy = issuedBy;
	}

	public String getValidDate() {
		return validDate;
	}

	public void setValidDate(String validDate) {
		this.validDate = validDate;
	}

	public Legality getLegality() {
		return legality;
	}

	public void setLegality(Legality legality) {
		this.legality = legality;
	}
	
	public String toString() {
		return JsonUtils.toJson(this);
	}
}
