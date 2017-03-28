package com.wxjfkg.sdk;

/**
 * Api异常类
 * 
 * @author GuoRui
 *
 */
public class ApiException extends RuntimeException {

	private static final long serialVersionUID = 8621877913965635821L;

	public ApiException(String message) {
		super(message);
	}

	public ApiException(Throwable cause) {
		super(cause);
	}

	public ApiException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
