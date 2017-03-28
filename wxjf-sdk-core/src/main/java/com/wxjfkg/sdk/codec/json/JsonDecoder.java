package com.wxjfkg.sdk.codec.json;

import com.alibaba.fastjson.JSON;
import com.wxjfkg.sdk.codec.ProtocolDecoder;

/**
 * <pre>
 * JsonDecoder
 * 
 * Json解码器
 * </pre>
 * 
 * @author GuoRui
 *
 */
public class JsonDecoder implements ProtocolDecoder {

	public Object decode(String value) {
		return JSON.parse(value);
	}

}
