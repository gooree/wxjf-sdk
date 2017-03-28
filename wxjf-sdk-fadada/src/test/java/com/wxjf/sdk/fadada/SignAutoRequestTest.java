package com.wxjf.sdk.fadada;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.wxjf.sdk.fadada.request.SignAutoRequest;
import com.wxjf.sdk.fadada.response.SignAutoResponse;
import com.wxjf.sdk.fadada.utils.FadadaUtils;
import com.wxjf.sdk.fadada.utils.FddEncryptTool;
import com.wxjf.sdk.fadada.utils.TimestampUtils;
import com.wxjfkg.sdk.HttpApiClient;
import com.wxjfkg.sdk.http.HttpApiResponse;
import com.wxjfkg.sdk.http.HttpMethod;

public class SignAutoRequestTest {

	private String appSecret;

	private String contractId;

	private String customerId;
	
	private String signKeyword;

	@Before
	public void setup() {
		appSecret = "kFeiEquMRIUflxTuEQjEBIOo";
		contractId = "TEST20170301003";
		customerId = "F047F666736E9A7536A0F776B7A857BF";
		signKeyword = "借款人";
	}

	@Test
	public void testSignAuto() throws Exception {
		SignAutoRequest request = new SignAutoRequest("https://testapi.fadada.com:8443/api/extsign_auto.api", HttpMethod.POST);
		request.setAppId(FadadaUtils.APP_ID);
		request.setVersion(FadadaUtils.VERSION);
		request.setTimestamp(TimestampUtils.getCurrentTimestamp());
		String transactionId = String.valueOf(System.currentTimeMillis());
		request.setTransactionId(transactionId);
		request.setContractId(contractId);
		request.setClientType("1");
		request.setClientRole("1");
		request.setCustomerId(customerId);
		request.setDocTitle("测试签署文档");
		request.setSignKeyword(signKeyword);
		
		String sha1 = FddEncryptTool.sha1(request.getAppId()
				+ FddEncryptTool.md5Digest(transactionId
						+ request.getTimestamp())
				+ FddEncryptTool.sha1(appSecret + customerId));
		String sign = new String(FddEncryptTool.Base64Encode(sha1.getBytes()));
		
		request.setMsgDigest(sign);
		
		HttpApiClient apiClient = new HttpApiClient();
		HttpApiResponse<SignAutoResponse> response = apiClient.execute(request, SignAutoResponse.class);
		SignAutoResponse result = response.getEntity();
		
		Assert.assertNotNull(response);
		Assert.assertNotNull(result);
		
	}
}
