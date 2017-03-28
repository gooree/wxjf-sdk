package com.wxjfkg.sdk.http;

/**
 * <pre>
 * HttpApiConstants
 * 
 * Http Api公用常量类
 * </pre>
 * 
 * @author GuoRui
 *
 */
public final class HttpApiConstants {

	/**
	 * http协议
	 */
	public static final String HTTP_PROTOCOL = "http";
	
	/**
	 * https协议
	 */
	public static final String HTTPS_PROTOCOL = "http";
	
	/**
	 * 默认协议类型
	 */
	public static final String DEFAULT_PROTOCOL = HTTP_PROTOCOL;
	
	/**
	 * Http GET方法
	 */
	public static final String GET_METHOD = "GET";
	
	/**
	 * Http POST方法
	 */
	public static final String POST_METHOD = "POST";
	
	/**
	 * 默认请求方法
	 */
	public static final String DEFAULT_METHOD = GET_METHOD;
	
	/**
	 * 默认编码方式
	 */
	public static final String DEFAULT_CHARACTER_ENCODING = "UTF-8";
	
	/**
	 * 默认加密方式（默认不加密）
	 */
	public static final String DEFAULT_ENCRYPT_TYPE = "NONE";
	
	/**
	 * 默认请求内容类型
	 */
	public static final String DEFAULT_CONTENT_TYPE = "application/x-www-form-urlencoded";
	
	/**
	 * 上传文件请求内容类型
	 */
	public static final String MULTIPART_CONTENT_TYPE = "multipart/form-data";
	
	/**
	 * 缺省MIME类型
	 */
	public static final String APPLICATION_OCTET_STREAM_VALUE = "application/octet-stream";
	
}
