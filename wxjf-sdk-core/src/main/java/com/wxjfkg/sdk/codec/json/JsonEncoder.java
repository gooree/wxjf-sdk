package com.wxjfkg.sdk.codec.json;

import com.alibaba.fastjson.JSON;
import com.wxjfkg.sdk.codec.ProtocolEncoder;

/**
 * <pre>
 * JsonEncoder	
 * 
 * Json编码器
 * </pre>
 * 
 * @author GuoRui
 *
 */
public class JsonEncoder implements ProtocolEncoder {

	public String encode(Object object) {
		return JSON.toJSONString(object);
	}

}
