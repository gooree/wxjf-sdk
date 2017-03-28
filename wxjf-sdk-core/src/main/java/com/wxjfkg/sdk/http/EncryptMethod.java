package com.wxjfkg.sdk.http;

/**
 * <pre>
 * EncryptMethod
 * 
 * 签名算法枚举类
 * </pre>
 * 
 * @author GuoRui
 *
 */
public enum EncryptMethod {

	NONE("NONE"), RSA("RSA"), RSA2("RSA2"), HMAC_SHA1("HMAC"), AES("AES"), MD5("MD5");

	private String method;

	private EncryptMethod(String method) {
		this.method = method;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

}
