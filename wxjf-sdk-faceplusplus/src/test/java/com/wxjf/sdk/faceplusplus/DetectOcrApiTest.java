package com.wxjf.sdk.faceplusplus;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;

import com.wxjf.sdk.faceplusplus.request.DetectOcrRequest;
import com.wxjf.sdk.faceplusplus.response.OcrIdCardResponse;
import com.wxjfkg.sdk.HttpApiClient;
import com.wxjfkg.sdk.http.FileItem;
import com.wxjfkg.sdk.http.HttpApiResponse;

public class DetectOcrApiTest {

	@Test
	public void testDetectOcr() {
		DetectOcrRequest request = new DetectOcrRequest();
		request.setApiKey("XYa9HH_-HD51IPqgtBfn1VHyTKFZrVgT");
		request.setApiSecret("503omxQkLcwbnYPW3TkmCOwwT3bI_CFL");
		request.setLegality("1");
		request.addFile(new FileItem("image", new File("D:\\guo.jpg")));
		
		HttpApiClient apiClient = new HttpApiClient();
		HttpApiResponse<OcrIdCardResponse> response = apiClient.execute(request, OcrIdCardResponse.class);
		OcrIdCardResponse result = (OcrIdCardResponse) response.getEntity();
		
		Assert.assertNotNull(response);
		Assert.assertNotNull(result);
	}
}
