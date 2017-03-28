package com.wxjf.sdk.fadada;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.wxjf.sdk.fadada.request.SyncPersonAutoRequest;
import com.wxjf.sdk.fadada.response.SyncCompanyAutoResponse;
import com.wxjf.sdk.fadada.utils.FadadaUtils;
import com.wxjf.sdk.fadada.utils.FddEncryptTool;
import com.wxjf.sdk.fadada.utils.TimestampUtils;
import com.wxjfkg.sdk.HttpApiClient;
import com.wxjfkg.sdk.http.HttpApiResponse;
import com.wxjfkg.sdk.http.HttpMethod;

public class SyncCompanyAutoRequestTest {

	private String appSecret;
	
	private String customerName;
	
	private String idCard;
	
	private String mobile;
	
	private String email;

	@Before
	public void setup() {
		appSecret = "kFeiEquMRIUflxTuEQjEBIOo";
		customerName = "test";
		idCard = "332980800";
		mobile = "18651600514";
		email = "test@163.com";
	}

	@Test
	public void testSyncCompany() throws Exception {
		SyncPersonAutoRequest request = new SyncPersonAutoRequest("https://testapi.fadada.com:8443/api/syncCompany_auto.api", HttpMethod.POST);
		request.setAppId(FadadaUtils.APP_ID);
		request.setVersion(FadadaUtils.VERSION);
		request.setTimestamp(TimestampUtils.getCurrentTimestamp());
		request.setCustomerName(customerName);
		request.setEmail(email);
		
		String idMobile = FddEncryptTool.encrypt(idCard + "|" + mobile, appSecret);
		request.setIdMobile(idMobile);
		
		// Base64(SHA1(appid+md5(timestamp)+SHA1(appsecret)))
		String sha1 = FddEncryptTool.sha1(request.getAppId()
				+ FddEncryptTool.md5Digest(request.getTimestamp())
				+ FddEncryptTool.sha1(appSecret));
		String sign = new String(FddEncryptTool.Base64Encode(sha1.getBytes()));
		
		request.setMsgDigest(sign);
		
		HttpApiClient apiClient = new HttpApiClient();
		HttpApiResponse<SyncCompanyAutoResponse> response = apiClient.execute(request, SyncCompanyAutoResponse.class);
		SyncCompanyAutoResponse result = response.getEntity();
		
		Assert.assertNotNull(response);
		Assert.assertNotNull(result);
	}
	
}
