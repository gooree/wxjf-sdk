package com.wxjfkg.sdk.http;

import java.io.IOException;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Http请求异常类
 * 
 * @author GuoRui
 *
 */
public class HttpException extends IOException {

	private static final long serialVersionUID = 6004251711066319994L;

	/**
	 * 异常状态码
	 */
	private int status;

	/**
	 * 异常消息
	 */
	private String reason;

	public HttpException(int status) {
		this.status = status;
		this.reason = null;
		initCause(null);
	}

	public HttpException(int status, String reason) {
		this.status = status;
		this.reason = reason;
		initCause(null);
	}

	public HttpException(int status, String reason, Throwable rootCause) {
		this.status = status;
		this.reason = reason;
		initCause(rootCause);
	}
	
	public HttpException(Throwable rootCause) {
		this.status = 500;
		this.reason = "Internal Server Error";
		initCause(rootCause);
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String toString() {
		return new ToStringBuilder(this).append("status", status)
				.append("reason", reason).append("cause", super.getCause())
				.toString();
	}

}
