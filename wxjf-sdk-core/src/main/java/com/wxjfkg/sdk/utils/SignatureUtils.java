package com.wxjfkg.sdk.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wxjfkg.sdk.sign.Signature;

public class SignatureUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(SignatureUtils.class);
	
	/**
	 * 根据请求参数Map计算签名值
	 * @param parameterMap	参数Map
	 * @param signature	签名算法实现类
	 * @return
	 */
	public static String sign(Map<String, String> parameterMap, Signature signature) {
		if(parameterMap == null || parameterMap.isEmpty()) {
			logger.warn("parameterMap is null or empty.");
			return null;
		}
		
		TreeMap<String, String> treeMap = new TreeMap<String, String>();
		for(Map.Entry<String, String> entry : parameterMap.entrySet()) {
			treeMap.put(entry.getKey(), entry.getValue());
		}
		
		String signContent = getSignContent(treeMap);
		return signature.sign(signContent);
	}
	
	/**
	 * 根据请求url计算签名值
	 * @param url	请求URL
	 * @param signature	签名算法实现类
	 * @return
	 */
	public static String sign(String url, Signature signature) {
		if (StringUtils.isBlank(url)) {
			logger.warn("url is null or blank.");
			return null;
		}
		
		if (url.contains("?") || url.contains("=")) {
			int index = url.contains("?") ? url.indexOf("?") : -1;
			String queryString = url.substring(index + 1);
			Map<String,String> params = new TreeMap<String, String>();
			String[] pairs = queryString.split("&");
			if (pairs != null && pairs.length > 0) {
				for (int i = 0; i < pairs.length; i++) {
					String[] pair = pairs[i].split("=");
					if (StringUtils.isNotBlank(pair[0])
							&& StringUtils.isNotBlank(pair[1])) {
						params.put(pair[0], pair[1]);
					}
				}
			}
			String signContent = getSignContent(params);
			return signature.sign(signContent);
		}
		
		return "";
	}
	
	/**
	 * 计算签名字符串
	 * 
	 * @param params
	 * @return
	 */
	private static String getSignContent(Map<String, String> params) {
		StringBuffer content = new StringBuffer();
		List<String> keys = new ArrayList<String>(params.keySet());
		Collections.sort(keys);
		int index = 0;
		for (int i = 0; i < keys.size(); i++) {
			String key = (String) keys.get(i);
			String value = (String) params.get(key);
			content.append((index == 0 ? "" : "&") + key + "=" + value);
			index++;
		}
		return content.toString();
	}
	
}
