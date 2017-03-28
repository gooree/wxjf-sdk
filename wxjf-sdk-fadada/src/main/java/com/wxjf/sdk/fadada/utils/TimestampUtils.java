package com.wxjf.sdk.fadada.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimestampUtils {

	public static String getCurrentTimestamp() {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		return format.format(new Date());
	}
	
}
