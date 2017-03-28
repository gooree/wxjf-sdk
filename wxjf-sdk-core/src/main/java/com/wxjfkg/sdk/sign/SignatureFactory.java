package com.wxjfkg.sdk.sign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wxjfkg.sdk.ApiConstants;

/**
 * 签名工厂类
 * 
 * @author GuoRui
 *
 */
public class SignatureFactory {
	
	private static final Logger logger = LoggerFactory.getLogger(SignatureFactory.class);
	
	public static Signature getInstance(String signType, String privateKey) {
		return getInstance(signType, privateKey, ApiConstants.DEFAULT_CHARSET);
	}

	public static Signature getInstance(String signType, String privateKey, String charset) {
		
		Signature signature = null;
		if (ApiConstants.SIGN_TYPE_RSA.equalsIgnoreCase(signType)) {
			signature = new RsaSignature(privateKey, charset);
		} else if (ApiConstants.SIGN_TYPE_RSA2.equalsIgnoreCase(signType)) {
			signature = new Rsa256Signature(privateKey, charset);
		} else if(ApiConstants.SIGN_TYPE_HMACSHA1.equalsIgnoreCase(signType)) {
			signature = new HmacSha1Signature(privateKey, charset);
		} else if(ApiConstants.SIGN_TYPE_MD5.equalsIgnoreCase(signType)) {
			signature = new HmacSha1Signature(privateKey, charset);
		}
		
		if(signature == null) {
			if (signType != null) {
				logger.warn("unsupported signature type:{}, default signature will be used.", signType);
			}
			signature = new RsaSignature(privateKey, charset);
		}
		return signature;
	}
	
}
