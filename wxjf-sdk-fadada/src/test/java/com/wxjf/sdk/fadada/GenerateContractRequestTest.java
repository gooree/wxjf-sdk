package com.wxjf.sdk.fadada;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.wxjf.sdk.fadada.request.GenerateContractRequest;
import com.wxjf.sdk.fadada.response.GenerateContractResponse;
import com.wxjf.sdk.fadada.utils.FadadaUtils;
import com.wxjf.sdk.fadada.utils.FddEncryptTool;
import com.wxjf.sdk.fadada.utils.TimestampUtils;
import com.wxjfkg.sdk.HttpApiClient;
import com.wxjfkg.sdk.http.HttpApiResponse;
import com.wxjfkg.sdk.http.HttpMethod;

public class GenerateContractRequestTest {
	
	private String appSecret;
	
	@Before
	public void setup() {
		appSecret = "kFeiEquMRIUflxTuEQjEBIOo";
	}

	@Test
	public void testGenerateContract() throws Exception {
		GenerateContractRequest request = new GenerateContractRequest("https://testapi.fadada.com:8443/api/generate_contract.api", HttpMethod.POST);
		request.setAppId(FadadaUtils.APP_ID);
		request.setVersion(FadadaUtils.VERSION);
		request.setTimestamp(TimestampUtils.getCurrentTimestamp());
		
		request.setDocTitle("测试模板");
		request.setTemplateId("WXJF20170301005");
		request.setContractId("WXJF20170301006");
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("contract_id", "WXJF20170301006");
		map.put("loan_type", "1");
		request.setParamMap(JSON.toJSONString(map));
		
		String sha1 = FddEncryptTool.sha1(request.getAppId()
				+ FddEncryptTool.md5Digest(request.getTimestamp())
				+ FddEncryptTool.sha1(appSecret
						+ request.getTemplateId() + request.getContractId()) + request.getParamMap());
		String sign = new String(FddEncryptTool.Base64Encode(sha1.getBytes()));
		
		request.setMsgDigest(sign);
		
		HttpApiClient apiClient = new HttpApiClient();
		HttpApiResponse<GenerateContractResponse> response = apiClient.execute(request, GenerateContractResponse.class);
		GenerateContractResponse result = response.getEntity();
		
		Assert.assertNotNull(response);
		Assert.assertNotNull(result);
	}
	
}
