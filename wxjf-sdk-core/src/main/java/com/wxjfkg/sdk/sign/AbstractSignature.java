package com.wxjfkg.sdk.sign;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;

import org.apache.commons.codec.binary.Base64;

/**
 * 抽象签名类
 * 
 * @author GuoRui
 *
 */
public abstract class AbstractSignature implements Signature {

	protected String privateKey;

	protected String charset;
	
	public AbstractSignature() {
	}

	public AbstractSignature(String privateKey, String charset) {
		this.privateKey = privateKey;
		this.charset = charset;
	}
	
	protected PrivateKey getPrivateKeyFromPKCS8(String algorithm, byte[] encodedKey) throws Exception {
		KeyFactory keyFactory = KeyFactory.getInstance(algorithm);

		encodedKey = Base64.decodeBase64(encodedKey);

		return keyFactory.generatePrivate(new PKCS8EncodedKeySpec(encodedKey));
	}
	
	public boolean verify(String content, String sign) {
		String verify = sign(content);
		if (sign.equals(verify)) {
			return true;
		} else {
			return false;
		}
	}

	public String getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

}
