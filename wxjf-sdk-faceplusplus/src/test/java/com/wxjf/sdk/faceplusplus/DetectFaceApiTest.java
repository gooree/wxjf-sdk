package com.wxjf.sdk.faceplusplus;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;

import com.wxjf.sdk.faceplusplus.request.DetectFaceRequest;
import com.wxjf.sdk.faceplusplus.response.DetectFaceResponse;
import com.wxjfkg.sdk.HttpApiClient;
import com.wxjfkg.sdk.http.FileItem;
import com.wxjfkg.sdk.http.HttpApiResponse;

public class DetectFaceApiTest {

	@Test
	public void testDetectFace() {
		DetectFaceRequest request = new DetectFaceRequest();
		request.setApiKey("XYa9HH_-HD51IPqgtBfn1VHyTKFZrVgT");
		request.setApiSecret("503omxQkLcwbnYPW3TkmCOwwT3bI_CFL");
		request.addFile(new FileItem("image", new File("D:\\face.jpg")));
		
		HttpApiClient apiClient = new HttpApiClient();
		HttpApiResponse<DetectFaceResponse> response = apiClient.execute(request, DetectFaceResponse.class);
		DetectFaceResponse result = (DetectFaceResponse) response.getEntity();
		
		Assert.assertNotNull(response);
		Assert.assertNotNull(result);
	}
	
}
