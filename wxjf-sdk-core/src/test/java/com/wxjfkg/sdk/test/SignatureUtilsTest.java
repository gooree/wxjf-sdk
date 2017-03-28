package com.wxjfkg.sdk.test;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wxjfkg.sdk.sign.Md5Signature;
import com.wxjfkg.sdk.sign.Signature;
import com.wxjfkg.sdk.utils.SignatureUtils;

public class SignatureUtilsTest {

	private static final Logger logger = LoggerFactory.getLogger(SignatureUtilsTest.class);
	
	@Test
	public void testSignUtils1() {
		logger.debug("test begin.");
		
		String url = "http://localhost:8080/test?a=1&b=2&c=3";

		Signature signature = new Md5Signature("12345678", "UTF-8");
		String sign1 = SignatureUtils.sign(url, signature);
		
		url = "test?a=1&b=2&c=3";
		String sign2 = SignatureUtils.sign(url, signature);
		
		url = "?a=1&b=2&c=3";
		String sign3 = SignatureUtils.sign(url, signature);
		
		url = "a=1&b=2&c=3";
		String sign4 = SignatureUtils.sign(url, signature);
		
		Assert.assertEquals(sign1, sign2);
		Assert.assertEquals(sign1, sign3);
		Assert.assertEquals(sign1, sign4);
		
		logger.debug("test end.");
	}
	
}
