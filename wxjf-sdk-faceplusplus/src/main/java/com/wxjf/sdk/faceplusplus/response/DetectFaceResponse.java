package com.wxjf.sdk.faceplusplus.response;

import java.util.List;

import com.wxjf.sdk.faceplusplus.model.Face;
import com.wxjfkg.sdk.utils.JsonUtils;

public class DetectFaceResponse extends FaceIdResponse {

	private static final long serialVersionUID = -7452395416138102237L;
	
	private List<Face> faces;

	public List<Face> getFaces() {
		return faces;
	}

	public void setFaces(List<Face> faces) {
		this.faces = faces;
	}
	
	public String toString() {
		return JsonUtils.toJson(this);
	}
	
}
