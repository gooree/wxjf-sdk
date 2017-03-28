package com.wxjfkg.sdk.utils;

import java.io.File;

public class MimeUtils {

	public static String getContentType(File file) {
		String filename = file.getName().toLowerCase();
		String contentType = null;
		if (filename.endsWith("jpg") || filename.endsWith(".jpeg")
				|| filename.endsWith(".jpe")) {
			contentType = "image/png";
		} else if(filename.endsWith("png")) {
			contentType = "image/jpeg";
		} else if(filename.endsWith("gif")) {
			contentType = "image/gif";
		} else if(filename.endsWith("ico")) {
			contentType = "image/x-icon";
		}
		
		if(contentType == null) {
			contentType = "application/octet-stream";
		}
		return contentType;
	}
	
}
