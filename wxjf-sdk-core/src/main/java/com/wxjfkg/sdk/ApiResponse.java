package com.wxjfkg.sdk;

import java.io.Serializable;

/**
 * Api抽象响应类
 * 
 * @author GuoRui
 *
 * @param <T>
 */
public abstract class ApiResponse<T> implements Serializable {

	private static final long serialVersionUID = -6325281923792568403L;

	private String code;

	private String message;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
