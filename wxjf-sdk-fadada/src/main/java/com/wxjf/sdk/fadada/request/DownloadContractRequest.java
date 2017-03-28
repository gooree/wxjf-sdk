package com.wxjf.sdk.fadada.request;

import com.wxjfkg.sdk.annotation.HttpParam;
import com.wxjfkg.sdk.http.HttpApiRequestWrapper;
import com.wxjfkg.sdk.http.HttpMethod;

/**
 * 下载合同接口
 * 
 * @author GuoRui
 *
 */
public class DownloadContractRequest extends HttpApiRequestWrapper {

	public DownloadContractRequest(String url, HttpMethod method) {
		super(url, method);
	}

	@HttpParam("app_id")
	private String appId;

	@HttpParam("v")
	private String version;

	private String timestamp;
	
	@HttpParam("contract_id")
	private String contractId;

	private String transactionId;

	private String keepfile;

	@HttpParam("msg_digest")
	private String msgDigest;

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getKeepfile() {
		return keepfile;
	}

	public void setKeepfile(String keepfile) {
		this.keepfile = keepfile;
	}

	public String getMsgDigest() {
		return msgDigest;
	}

	public void setMsgDigest(String msgDigest) {
		this.msgDigest = msgDigest;
	}

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

}
