package com.wxjf.sdk.fadada.request;

import com.wxjfkg.sdk.annotation.HttpParam;
import com.wxjfkg.sdk.http.HttpApiRequestWrapper;
import com.wxjfkg.sdk.http.HttpMethod;

/**
 * 上传合同文档接口
 * 
 * @author GuoRui
 *
 */
public class UploadContractDocRequest extends HttpApiRequestWrapper {

	public UploadContractDocRequest(String url, HttpMethod method) {
		super(url, method);
	}
	
	@HttpParam("app_id")
	private String appId;

	private String timestamp;

	@HttpParam("v")
	private String version;

	@HttpParam("contract_id")
	private String contractId;
	
	@HttpParam("doc_title")
	private String docTitle;

	@HttpParam("doc_url")
	private String docUrl;
	
	@HttpParam("doc_type")
	private String docType;

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

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public String getDocTitle() {
		return docTitle;
	}

	public void setDocTitle(String docTitle) {
		this.docTitle = docTitle;
	}

	public String getDocUrl() {
		return docUrl;
	}

	public void setDocUrl(String docUrl) {
		this.docUrl = docUrl;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getMsgDigest() {
		return msgDigest;
	}

	public void setMsgDigest(String msgDigest) {
		this.msgDigest = msgDigest;
	}
	
}
