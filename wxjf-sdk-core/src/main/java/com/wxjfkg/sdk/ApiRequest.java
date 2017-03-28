package com.wxjfkg.sdk;

/**
 * Api请求接口
 * 
 * @author GuoRui
 *
 */
public interface ApiRequest {

	/**
	 * 请求协议（可支持http、tcp等多种协议）
	 * 
	 * @return
	 */
	public String getProtocol();
	
	/**
	 * 请求资源路径
	 * 
	 * @return
	 */
	public String getUrl();
	
	/**
	 * 请求方法
	 * 
	 * @return
	 */
	public String getMethod();
	
	/**
	 * 请求报文编码
	 * 
	 * @return
	 */
	public String getCharacterEncoding();
	
}
