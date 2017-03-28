package com.wxjfkg.sdk.codec.json;

import com.wxjfkg.sdk.codec.ProtocolCodecFactory;
import com.wxjfkg.sdk.codec.ProtocolDecoder;
import com.wxjfkg.sdk.codec.ProtocolEncoder;

public class JsonProtocolCodecFactory implements ProtocolCodecFactory {

	private static final JsonEncoder encoder = new JsonEncoder();

	private static final JsonDecoder decoder = new JsonDecoder();

	public ProtocolDecoder getDecoder() {
		return decoder;
	}

	public ProtocolEncoder getEncoder() {
		return encoder;
	}

}
