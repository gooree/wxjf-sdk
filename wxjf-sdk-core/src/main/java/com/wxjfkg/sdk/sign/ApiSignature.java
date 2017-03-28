package com.wxjfkg.sdk.sign;

import com.wxjfkg.sdk.ApiRequest;

/**
 * API请求签名接口
 * 
 * @author GuoRui
 *
 * @param <T>
 */
public interface ApiSignature<T extends ApiRequest> {

	public String sign(T request, String signType, String privateKey);
	
}
