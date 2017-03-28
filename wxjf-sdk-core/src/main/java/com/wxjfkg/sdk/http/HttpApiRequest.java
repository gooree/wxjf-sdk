package com.wxjfkg.sdk.http;

import java.util.Enumeration;
import java.util.Map;

import com.wxjfkg.sdk.ApiRequest;

/**
 * <pre>
 * HttpApiRequest
 * 
 * Http Api请求接口
 * </pre>
 * 
 * @author GuoRui
 *
 */
public interface HttpApiRequest extends ApiRequest {

	/**
	 * 获取请求参数Map
	 * 
	 * @return
	 */
	public Map<String, String> getParameterMap();
	
	/**
	 * 设置请求参数Map
	 * 
	 * @param params
	 */
	public void setParameters(Map<String, String> params);
	
	/**
	 * 设置请求参数值
	 * 
	 * @param name
	 * @param value
	 */
	public void setParameter(String name, String value);
	
	/**
	 * 获取请求参数
	 * 
	 * @return
	 */
	public String getParameter(String name);
	
	/**
	 * 获取请求头参数的值
	 * 
	 * @return
	 */
	public String getHeader(String name);
	
	/**
	 * 获取请求头参数的值
	 * 
	 * @return
	 */
	public Enumeration<String> getHeaders(String name); 
	
	/**
	 * 获取全部的请求头
	 * 
	 * @return
	 */
	public Enumeration<String> getHeaderNames();
	
	/**
	 * 判断是否文件上传请求
	 * 
	 * @return
	 */
	public boolean isMultipartRequest();
	
}
