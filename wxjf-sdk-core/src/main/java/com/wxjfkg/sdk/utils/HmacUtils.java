package com.wxjfkg.sdk.utils;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * Mac算法加密工具类
 * 
 * @author GuoRui
 *
 */
public class HmacUtils {

	public static byte[] encodeHmacMD5(byte[] data, byte[] key)
			throws Exception {
		SecretKey secretKey = new SecretKeySpec(key, "HmacMD5");
		Mac mac = Mac.getInstance(secretKey.getAlgorithm());
		mac.init(secretKey);
		return mac.doFinal(data);
	}
	
	public static byte[] encodeHmacSHA(byte[] data, byte[] key)
			throws Exception {
		SecretKey secretKey = new SecretKeySpec(key, "HmacSHA1");
		Mac mac = Mac.getInstance(secretKey.getAlgorithm());
		mac.init(secretKey);
		return mac.doFinal(data);
	}
	
	public static byte[] encodeHmacSHA256(byte[] data, byte[] key)
			throws Exception {
		SecretKey secretKey = new SecretKeySpec(key, "HmacSHA256");
		Mac mac = Mac.getInstance(secretKey.getAlgorithm());
		mac.init(secretKey);
		return mac.doFinal(data);
	}
	
}
