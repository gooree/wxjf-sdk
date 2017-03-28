package com.wxjf.sdk.fadada.request;

import com.wxjfkg.sdk.annotation.HttpParam;
import com.wxjfkg.sdk.http.HttpApiRequestWrapper;
import com.wxjfkg.sdk.http.HttpMethod;

/**
 * 企业CA证书申请接口
 * 
 * @author GuoRui
 *
 */
public class SyncCompanyAutoRequest extends HttpApiRequestWrapper {

	public SyncCompanyAutoRequest(String url, HttpMethod method) {
		super(url, method);
	}

	@HttpParam("app_id")
	private String appId;

	private String timestamp;

	@HttpParam("v")
	private String version;

	@HttpParam("customer_name")
	private String customerName;

	private String email;

	@HttpParam("id_mobile")
	private String idMobile;

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

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdMobile() {
		return idMobile;
	}

	public void setIdMobile(String idMobile) {
		this.idMobile = idMobile;
	}

	public String getMsgDigest() {
		return msgDigest;
	}

	public void setMsgDigest(String msgDigest) {
		this.msgDigest = msgDigest;
	}

}
