package com.wxjf.sdk.fadada.response;

import com.alibaba.fastjson.annotation.JSONField;

public class SyncPersonAutoResponse extends FadadaResponse {

	@JSONField(name = "customer_id")
	private String customerId;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
}
