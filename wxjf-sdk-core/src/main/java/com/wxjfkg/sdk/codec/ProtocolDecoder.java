package com.wxjfkg.sdk.codec;

/**
 * <pre>
 * ProtocolDecoder
 * 
 * 解码器接口
 * </pre>
 * 
 * @author GuoRui
 *
 */
public interface ProtocolDecoder {

	public Object decode(String value);
	
}
