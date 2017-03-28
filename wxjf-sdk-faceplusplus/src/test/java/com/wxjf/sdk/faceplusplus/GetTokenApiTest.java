package com.wxjf.sdk.faceplusplus;

import org.junit.Assert;
import org.junit.Test;

import com.wxjf.sdk.faceplusplus.request.GetTokenRequest;
import com.wxjf.sdk.faceplusplus.response.GetTokenResponse;
import com.wxjfkg.sdk.HttpApiClient;
import com.wxjfkg.sdk.http.HttpApiResponse;

public class GetTokenApiTest {

	@Test
	public void testGetToken() {
		GetTokenRequest request = new GetTokenRequest();
		request.setApiKey("XYa9HH_-HD51IPqgtBfn1VHyTKFZrVgT");
		request.setApiSecret("503omxQkLcwbnYPW3TkmCOwwT3bI_CFL");
		request.setComparisonType("1");
		request.setIdCardName("郭国国");
		request.setIdCardNumber("412326199005162770");
		request.setReturnUrl("https://api.wxjfkg.com/liveness_return");
		request.setNotifyUrl("https://api.wxjfkg.com/liveness_notify");
		request.setBizNo(String.valueOf(System.currentTimeMillis()));
		
		HttpApiClient apiClient = new HttpApiClient();
		HttpApiResponse<GetTokenResponse> response = apiClient.execute(request, GetTokenResponse.class);
		GetTokenResponse result = (GetTokenResponse) response.getEntity();
		
		Assert.assertNotNull(response);
		Assert.assertNotNull(result);
	}
	
}
