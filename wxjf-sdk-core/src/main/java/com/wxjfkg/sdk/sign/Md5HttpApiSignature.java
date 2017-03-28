package com.wxjfkg.sdk.sign;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

import com.wxjfkg.sdk.ApiConstants;
import com.wxjfkg.sdk.request.InternalHttpApiRequest;
import com.wxjfkg.sdk.utils.JsonUtils;

/**
 * MD5签名实现类
 * 
 * @author GuoRui
 *
 * @param <T>
 */
public class Md5HttpApiSignature<T extends InternalHttpApiRequest>
		implements ApiSignature<T> {

	public String sign(T request, String signType, String privateKey) {
		Object entity = request.getEntity();
		String jsonString = JsonUtils.toJson(entity);

		String encryptJson = "";
		String sign = "";
		try {
			encryptJson = Base64.encodeBase64String(jsonString
					.getBytes(ApiConstants.DEFAULT_CHARSET)) + privateKey;
			sign = DigestUtils.md5Hex(encryptJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sign + "," + jsonString;
	}

}
