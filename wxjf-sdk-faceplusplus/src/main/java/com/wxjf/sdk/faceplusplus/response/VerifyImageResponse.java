package com.wxjf.sdk.faceplusplus.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.wxjf.sdk.faceplusplus.model.IdException;
import com.wxjf.sdk.faceplusplus.model.RsltFaceId;

public class VerifyImageResponse extends FaceIdResponse {

	private static final long serialVersionUID = -2262700313919091044L;

	@JSONField(name = "id_exceptions")
	private IdException idException;
	
	@JSONField(name = "result_faceid")
	private RsltFaceId resultFaceId;

	public IdException getIdException() {
		return idException;
	}

	public void setIdException(IdException idException) {
		this.idException = idException;
	}

	public RsltFaceId getResultFaceId() {
		return resultFaceId;
	}

	public void setResultFaceId(RsltFaceId resultFaceId) {
		this.resultFaceId = resultFaceId;
	}
	
}
