package com.wxjfkg.sdk.codec;

public interface ProtocolCodecFactory {

	public ProtocolDecoder getDecoder();
	
	public ProtocolEncoder getEncoder();
	
}
