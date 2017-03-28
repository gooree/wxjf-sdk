package com.wxjf.sdk.fadada;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.wxjf.sdk.fadada.request.CustomerInfoChangeRequest;
import com.wxjf.sdk.fadada.response.FadadaResponse;
import com.wxjf.sdk.fadada.utils.FadadaUtils;
import com.wxjf.sdk.fadada.utils.FddEncryptTool;
import com.wxjf.sdk.fadada.utils.TimestampUtils;
import com.wxjfkg.sdk.HttpApiClient;
import com.wxjfkg.sdk.http.HttpApiResponse;
import com.wxjfkg.sdk.http.HttpMethod;

public class CustomerInfoChangeRequestTest {

	private String appSecret;

	private String customerId;

	@Before
	public void setup() {
		appSecret = "kFeiEquMRIUflxTuEQjEBIOo";
		customerId = "F047F666736E9A7536A0F776B7A857BF";
	}

	@Test
	public void testCustomerInfoChange() throws Exception {
		CustomerInfoChangeRequest request = new CustomerInfoChangeRequest("https://testapi.fadada.com:8443/api/infochange.api", HttpMethod.POST);
		request.setAppId(FadadaUtils.APP_ID);
		request.setVersion(FadadaUtils.VERSION);
		request.setTimestamp(TimestampUtils.getCurrentTimestamp());
		
		request.setCustomerId(customerId);
		request.setEmail("abc123@163.com");
		
		String sha1 = FddEncryptTool.sha1(request.getAppId()
				+ FddEncryptTool.md5Digest(request.getTimestamp())
				+ FddEncryptTool.sha1(appSecret));
		String sign = new String(FddEncryptTool.Base64Encode(sha1.getBytes()));
		request.setMsgDigest(sign);
		
		HttpApiClient apiClient = new HttpApiClient();
		HttpApiResponse<FadadaResponse> response = apiClient.execute(request, FadadaResponse.class);
		FadadaResponse result = response.getEntity();
		
		Assert.assertNotNull(response);
		Assert.assertNotNull(result);
	}
}
