package com.wxjfkg.sdk.sign;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wxjfkg.sdk.ApiConstants;
import com.wxjfkg.sdk.ApiException;

/**
 * Md5签名算法实现类
 * 
 * @author GuoRui
 *
 */
public class Md5Signature extends AbstractSignature {
	
	private static final Logger logger = LoggerFactory.getLogger(Md5Signature.class);
	
	public Md5Signature(String privateKey, String charset) {
		super(privateKey, charset);
	}

	@Override
	public String sign(String content) {
		String encryptJson = "";
		String sign = "";
		try {
			encryptJson = Base64.encodeBase64String(content
					.getBytes(ApiConstants.DEFAULT_CHARSET)) + privateKey;
			sign = DigestUtils.md5Hex(encryptJson);
		} catch (Exception e) {
			logger.error("Md5 signature error,content:{},charset:{}", content, charset);
            throw new ApiException("content = " + content + "; charset = " + charset, e);
		}
		return sign;
	}

}
