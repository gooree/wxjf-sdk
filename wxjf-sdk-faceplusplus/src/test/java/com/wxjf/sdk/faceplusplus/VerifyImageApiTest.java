package com.wxjf.sdk.faceplusplus;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;

import com.wxjf.sdk.faceplusplus.model.Face;
import com.wxjf.sdk.faceplusplus.request.DetectFaceRequest;
import com.wxjf.sdk.faceplusplus.request.VerifyImageRequest;
import com.wxjf.sdk.faceplusplus.response.DetectFaceResponse;
import com.wxjf.sdk.faceplusplus.response.VerifyImageResponse;
import com.wxjfkg.sdk.HttpApiClient;
import com.wxjfkg.sdk.http.FileItem;
import com.wxjfkg.sdk.http.HttpApiResponse;

public class VerifyImageApiTest {

	@Test
	public void testVerifyImage() {
		VerifyImageRequest request = new VerifyImageRequest();
		request.setApiKey("XYa9HH_-HD51IPqgtBfn1VHyTKFZrVgT");
		request.setApiSecret("503omxQkLcwbnYPW3TkmCOwwT3bI_CFL");
		request.setComparisonType("1");
		request.setFaceImageType("raw_image");
		request.setIdCardName("郭国国");
		request.setIdCardNumber("412326199005162770");
		
		request.addFile(new FileItem("image", new File("D:\\guo.jpg")));
		
		HttpApiClient apiClient = new HttpApiClient();
		HttpApiResponse<VerifyImageResponse> response = apiClient.execute(request, VerifyImageResponse.class);
		VerifyImageResponse result = (VerifyImageResponse) response.getEntity();
		
		Assert.assertNotNull(response);
		Assert.assertNotNull(result);
	}
	
	@Test
	public void testDetectFaceVerify() {
		DetectFaceRequest detectReq = new DetectFaceRequest();
		detectReq.setApiKey("XYa9HH_-HD51IPqgtBfn1VHyTKFZrVgT");
		detectReq.setApiSecret("503omxQkLcwbnYPW3TkmCOwwT3bI_CFL");
		detectReq.addFile(new FileItem("image", new File("D:\\guo.jpg")));
		
		HttpApiClient apiClient = new HttpApiClient();
		HttpApiResponse<DetectFaceResponse> detectResponse = apiClient.execute(detectReq, DetectFaceResponse.class);
		DetectFaceResponse detectResult = (DetectFaceResponse) detectResponse.getEntity();
		
		Assert.assertNotNull(detectResponse);
		Assert.assertNotNull(detectResult);
		
		Face detectFace = null;
		if(detectResult.getFaces() != null && !detectResult.getFaces().isEmpty()) {
			detectFace = detectResult.getFaces().get(0);
		}
		
		VerifyImageRequest request = new VerifyImageRequest();
		request.setApiKey("XYa9HH_-HD51IPqgtBfn1VHyTKFZrVgT");
		request.setApiSecret("503omxQkLcwbnYPW3TkmCOwwT3bI_CFL");
		request.setComparisonType("1");
		request.setFaceImageType("facetoken");
		request.setIdCardName("郭国国");
		request.setIdCardNumber("412326199005162770");
		request.setFaceToken(detectFace.getToken());
		HttpApiResponse<VerifyImageResponse> response = apiClient.execute(request, VerifyImageResponse.class);
		VerifyImageResponse result = (VerifyImageResponse) response.getEntity();
		
		Assert.assertNotNull(response);
		Assert.assertNotNull(result);
		
		System.out.println("是否被攻击:"+ result.getIdException().getIdAttacked());
		System.out.println("照片可信度:"+ result.getResultFaceId().getConfidence());
	}
	
}
