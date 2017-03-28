package com.wxjfkg.sdk.http;

import java.io.File;

/**
 * <pre>
 * FileItem
 * 
 * 上传文件类
 * </pre>
 * 
 * @author GuoRui
 *
 */
public class FileItem {

	/**
	 * 文件名
	 */
	private String fileName;
	
	/**
	 * MIME类型
	 */
	private String mimeType;
	
	/**
	 * 文件字节内容
	 */
	private byte[] content;
	
	/**
	 * 本地文件
	 */
	private File file;
	
	public FileItem(String name, File file) {
		this.fileName = name;
		this.file = file;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

}
