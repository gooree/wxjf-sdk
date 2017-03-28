package com.wxjf.sdk.fadada.request;

import com.wxjfkg.sdk.annotation.HttpParam;
import com.wxjfkg.sdk.http.HttpApiRequestWrapper;
import com.wxjfkg.sdk.http.HttpMethod;

/**
 * 自动签署合同接口
 * 
 * @author GuoRui
 *
 */
public class SignAutoRequest extends HttpApiRequestWrapper {

	public SignAutoRequest(String url, HttpMethod method) {
		super(url, method);
	}

	@HttpParam("app_id")
	private String appId;

	private String timestamp;

	@HttpParam("v")
	private String version;

	@HttpParam("transaction_id")
	private String transactionId;
	
	@HttpParam("batch_id")
	private String batchId;

	@HttpParam("contract_id")
	private String contractId;

	@HttpParam("client_type")
	private String clientType;

	@HttpParam("client_role")
	private String clientRole;

	@HttpParam("customer_id")
	private String customerId;

	@HttpParam("doc_title")
	private String docTitle;

	@HttpParam("sign_keyword")
	private String signKeyword;

	@HttpParam("notify_url")
	private String notifyUrl;

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

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public String getClientType() {
		return clientType;
	}

	public void setClientType(String clientType) {
		this.clientType = clientType;
	}

	public String getClientRole() {
		return clientRole;
	}

	public void setClientRole(String clientRole) {
		this.clientRole = clientRole;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getDocTitle() {
		return docTitle;
	}

	public void setDocTitle(String docTitle) {
		this.docTitle = docTitle;
	}

	public String getSignKeyword() {
		return signKeyword;
	}

	public void setSignKeyword(String signKeyword) {
		this.signKeyword = signKeyword;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public String getMsgDigest() {
		return msgDigest;
	}

	public void setMsgDigest(String msgDigest) {
		this.msgDigest = msgDigest;
	}

}
