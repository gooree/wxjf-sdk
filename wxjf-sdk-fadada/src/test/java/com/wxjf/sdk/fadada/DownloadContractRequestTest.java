package com.wxjf.sdk.fadada;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.wxjf.sdk.fadada.request.DownloadContractRequest;
import com.wxjf.sdk.fadada.utils.FadadaUtils;
import com.wxjf.sdk.fadada.utils.FddEncryptTool;
import com.wxjf.sdk.fadada.utils.TimestampUtils;
import com.wxjfkg.sdk.HttpApiClient;
import com.wxjfkg.sdk.http.HttpMethod;

public class DownloadContractRequestTest {

	private String appSecret;
	
	private String contractId;
	
	@Before
	public void setup() {
		appSecret = "kFeiEquMRIUflxTuEQjEBIOo";
		contractId = "TEST20170301003";
	}
	
	@Test
	public void testDownloadContract() throws Exception {
		DownloadContractRequest request = new DownloadContractRequest("https://testapi.fadada.com:8443/api/downLoadContract.api", HttpMethod.GET);
		request.setAppId(FadadaUtils.APP_ID);
		request.setVersion(FadadaUtils.VERSION);
		request.setTimestamp(TimestampUtils.getCurrentTimestamp());
		request.setContractId(contractId);
		
		String sha1 = FddEncryptTool.sha1(request.getAppId()
				+ FddEncryptTool.md5Digest(request.getTimestamp())
				+ FddEncryptTool.sha1(appSecret + request.getContractId()));
		String sign = new String(FddEncryptTool.Base64Encode(sha1.getBytes())).trim();
		
		request.setMsgDigest(sign);
		
		String path = "D:\\" + contractId + ".pdf";
		
		HttpApiClient apiClient = new HttpApiClient();
		InputStream stream = apiClient.executeWithRawStream(request);
		Assert.assertNotNull(stream);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int bytes = 0;
		while ((bytes = stream.read(buffer)) != -1) {
			baos.write(buffer, 0, bytes);
		}
		
		FileOutputStream fos = new FileOutputStream(new File(path));
		fos.write(baos.toByteArray());
		fos.flush();
		fos.close();
	}
}
