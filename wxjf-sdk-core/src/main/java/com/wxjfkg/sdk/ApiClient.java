package com.wxjfkg.sdk;

import com.wxjfkg.sdk.http.EncryptMethod;
import com.wxjfkg.sdk.http.HttpApiRequest;
import com.wxjfkg.sdk.http.HttpApiResponse;

/**
 * <pre>
 * ApiClient
 * 
 * 客户端调用接口
 * </pre>
 * 
 * @author GuoRui
 *
 */
public interface ApiClient<P extends ApiRequest> {

	/**
	 * 执行Api请求并获得返回结果
	 * 
	 * @param request
	 * @return
	 * 
	 */
	public <T> ApiResponse<T> execute(P request, Class<T> clazz);

	/**
	 * 执行带请求签名的Api请求并获得返回结果
	 * 
	 * @param request
	 * @param clazz
	 * @param encryptMethod
	 * @param privateKey
	 * @return
	 */
	public <T> HttpApiResponse<T> execute(HttpApiRequest request,
			Class<T> clazz, EncryptMethod encryptMethod, String privateKey);

}
