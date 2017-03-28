package com.wxjf.sdk.fadada.request;

import com.wxjfkg.sdk.annotation.HttpParam;
import com.wxjfkg.sdk.http.HttpApiRequestWrapper;
import com.wxjfkg.sdk.http.HttpMethod;

/**
 * 生成合同接口
 * 
 * @author GuoRui
 *
 */
public class GenerateContractRequest extends HttpApiRequestWrapper {

	public GenerateContractRequest(String url, HttpMethod method) {
		super(url, method);
	}
	
	@HttpParam("app_id")
	private String appId;

	private String timestamp;

	@HttpParam("v")
	private String version;
	
	@HttpParam("doc_title")
	private String docTitle;

	@HttpParam("template_id")
	private String templateId;
	
	@HttpParam("contract_id")
	private String contractId;
	
	@HttpParam("parameter_map")
	private String paramMap;
	
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

	public String getDocTitle() {
		return docTitle;
	}

	public void setDocTitle(String docTitle) {
		this.docTitle = docTitle;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public String getParamMap() {
		return paramMap;
	}

	public void setParamMap(String paramMap) {
		this.paramMap = paramMap;
	}

	public String getMsgDigest() {
		return msgDigest;
	}

	public void setMsgDigest(String msgDigest) {
		this.msgDigest = msgDigest;
	}

}
