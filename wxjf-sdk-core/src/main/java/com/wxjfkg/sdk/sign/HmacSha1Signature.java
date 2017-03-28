package com.wxjfkg.sdk.sign;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wxjfkg.sdk.ApiException;
import com.wxjfkg.sdk.utils.HmacUtils;

/**
 * hmac-sha1签名算法实现类
 * 
 * @author GuoRui
 *
 */
public class HmacSha1Signature extends AbstractSignature {
	
	private static final Logger logger = LoggerFactory.getLogger(HmacSha1Signature.class);

	public HmacSha1Signature(String privateKey, String charset) {
		super(privateKey, charset);
	}

	public String sign(String content) {
		try {
			byte[] key = getPrivateKey().getBytes(this.getCharset());
			byte[] data = content.getBytes(this.getCharset());
			
			byte[] signed = HmacUtils.encodeHmacSHA(data, key);
			
			return new String(Base64.encodeBase64(signed));
		} catch (Exception e) {
			logger.error("HmacSha1 signature error,RSAcontent:{},charset:{}", content, charset);
			throw new ApiException("RSAcontent = " + content + "; charset = " + charset, e);
		}
	}
	
}
