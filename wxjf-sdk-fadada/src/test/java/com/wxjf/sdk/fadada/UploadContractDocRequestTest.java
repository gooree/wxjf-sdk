package com.wxjf.sdk.fadada;

import java.io.File;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.wxjf.sdk.fadada.request.UploadContractDocRequest;
import com.wxjf.sdk.fadada.response.FadadaResponse;
import com.wxjf.sdk.fadada.utils.FadadaUtils;
import com.wxjf.sdk.fadada.utils.FddEncryptTool;
import com.wxjf.sdk.fadada.utils.TimestampUtils;
import com.wxjfkg.sdk.HttpApiClient;
import com.wxjfkg.sdk.http.FileItem;
import com.wxjfkg.sdk.http.HttpApiResponse;
import com.wxjfkg.sdk.http.HttpMethod;

public class UploadContractDocRequestTest {

	private String appSecret;

	@Before
	public void setup() {
		appSecret = "kFeiEquMRIUflxTuEQjEBIOo";
	}

	@Test
	public void testUploadContractDoc() throws Exception {
		UploadContractDocRequest request = new UploadContractDocRequest("https://testapi.fadada.com:8443/api/uploaddocs.api", HttpMethod.POST);
		request.setAppId(FadadaUtils.APP_ID);
		request.setVersion(FadadaUtils.VERSION);
		request.setTimestamp(TimestampUtils.getCurrentTimestamp());
		
		request.setContractId("TEST20170301003");
		request.setDocTitle("文档标题-上传");
		request.setDocType(".pdf");
		request.addFile(new FileItem("file", new File("D:\\doc_test.pdf")));
		
		String sha1 = FddEncryptTool.sha1(request.getAppId()
				+ FddEncryptTool.md5Digest(request.getTimestamp())
				+ FddEncryptTool.sha1(appSecret + request.getContractId()));
		String sign = new String(FddEncryptTool.Base64Encode(sha1.getBytes()));
		
		request.setMsgDigest(sign);
		
		HttpApiClient apiClient = new HttpApiClient();
		HttpApiResponse<FadadaResponse> response = apiClient.execute(request, FadadaResponse.class);
		FadadaResponse result = response.getEntity();
		
		Assert.assertNotNull(response);
		Assert.assertNotNull(result);
	}
}
