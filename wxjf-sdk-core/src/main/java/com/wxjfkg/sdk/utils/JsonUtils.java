package com.wxjfkg.sdk.utils;

import com.alibaba.fastjson.JSON;

public class JsonUtils {
	
	public static String toJson(Object object) {
		return JSON.toJSONString(object);
	}
	
	public static <T> T toObject(String json, Class<T> clazz) {
		return JSON.parseObject(json, clazz);
	}
	
}
