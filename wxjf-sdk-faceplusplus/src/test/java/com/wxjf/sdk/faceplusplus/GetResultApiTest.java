package com.wxjf.sdk.faceplusplus;

import org.junit.Assert;
import org.junit.Test;

import com.wxjf.sdk.faceplusplus.request.GetResultRequest;
import com.wxjf.sdk.faceplusplus.response.GetResultResponse;
import com.wxjfkg.sdk.HttpApiClient;
import com.wxjfkg.sdk.http.HttpApiResponse;

public class GetResultApiTest {

	@Test
	public void testGetToken() {
		GetResultRequest request = new GetResultRequest();
		request.setApiKey("XYa9HH_-HD51IPqgtBfn1VHyTKFZrVgT");
		request.setApiSecret("503omxQkLcwbnYPW3TkmCOwwT3bI_CFL");
		request.setBizId("1489400612,a9131c95-5b50-4367-befe-fd3ad1cda99a");
		request.setGetImageType(0);
		
		HttpApiClient apiClient = new HttpApiClient();
		HttpApiResponse<GetResultResponse> response = apiClient.execute(request, GetResultResponse.class);
		GetResultResponse result = (GetResultResponse) response.getEntity();
		
		Assert.assertNotNull(response);
		Assert.assertNotNull(result);
	}
	
}
