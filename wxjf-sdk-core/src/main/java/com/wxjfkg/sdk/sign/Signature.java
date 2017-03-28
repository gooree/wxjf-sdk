package com.wxjfkg.sdk.sign;

/**
 * 签名接口
 * 
 * @author GuoRui
 *
 */
public interface Signature {

	/**
	 * http请求签名
	 * @param content
	 * @return
	 */
	public String sign(String content);
	
	/**
	 * http请求签名校验
	 * @param content
	 * @param sign
	 * @return
	 */
	public boolean verify(String content, String sign);
	
	/**
	 * 设置密钥
	 * @param privateKey
	 */
	public void setPrivateKey(String privateKey);
	
	/**
	 * 设置字符编码
	 * @param charset
	 */
	public void setCharset(String charset);
	
}
