package com.wxjfkg.sdk.http;

import java.util.Iterator;
import java.util.Map;

/**
 * <pre>
 * MultipartHttpApiRequest
 * 
 * Multipart Http Api请求接口
 * </pre>
 * 
 * @author GuoRui
 *
 */
public interface MultipartHttpApiRequest {

	/**
	 * 获取所有的上传文件名
	 * 
	 * @return
	 */
	public Iterator<String> getFileNames();
	
	/**
	 * 获取指定上传文件
	 * 
	 * @return
	 */
	public FileItem getFile(String name);
	
	/**
	 * 获取所有上传文件
	 * 
	 * @return
	 */
	public Map<String, FileItem> getFileMap();
	
}
