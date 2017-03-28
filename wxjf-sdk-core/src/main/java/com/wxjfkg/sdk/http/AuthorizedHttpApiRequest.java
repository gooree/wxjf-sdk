package com.wxjfkg.sdk.http;

/**
 * 第三方授权Http请求接口（需通过api_key和api_secret进行访问）
 * 
 * @author GuoRui
 *
 */
public interface AuthorizedHttpApiRequest {

	/**
	 * 获取api_key
	 * @return
	 */
	public String getApiKey();
	
	/**
	 * 获取api_secret
	 * @return
	 */
	public String getApiSecret();
	
}
