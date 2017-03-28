package com.wxjf.sdk.fadada.request;

import com.wxjfkg.sdk.annotation.HttpParam;
import com.wxjfkg.sdk.http.HttpApiRequestWrapper;
import com.wxjfkg.sdk.http.HttpMethod;

/**
 * 客户信息变更接口
 * 
 * @author GuoRui
 *
 */
public class CustomerInfoChangeRequest extends HttpApiRequestWrapper {

	public CustomerInfoChangeRequest(String url, HttpMethod method) {
		super(url, method);
	}

	@HttpParam("app_id")
	private String appId;

	private String timestamp;

	@HttpParam("v")
	private String version;

	@HttpParam("customer_id")
	private String customerId;

	private String email;

	@HttpParam("mobile")
	private String mobile;

	@HttpParam("msg_digest")
	private String msgDigest;

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getMsgDigest() {
		return msgDigest;
	}

	public void setMsgDigest(String msgDigest) {
		this.msgDigest = msgDigest;
	}

}
