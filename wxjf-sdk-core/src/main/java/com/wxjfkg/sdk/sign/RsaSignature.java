package com.wxjfkg.sdk.sign;

import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wxjfkg.sdk.ApiConstants;
import com.wxjfkg.sdk.ApiException;

/**
 * RSA签名算法实现类
 * 
 * @author GuoRui
 *
 */
public class RsaSignature extends AbstractSignature {
	
	private static final Logger logger = LoggerFactory.getLogger(RsaSignature.class);

	public RsaSignature(String privateKey, String charset) {
		super(privateKey, charset);
	}

	public String sign(String content) {
		try {
			PrivateKey priKey = getPrivateKeyFromPKCS8(
					ApiConstants.SIGN_TYPE_RSA, privateKey.getBytes());

            java.security.Signature signature = java.security.Signature
                .getInstance(ApiConstants.SIGN_ALGORITHMS);

            signature.initSign(priKey);

            if (StringUtils.isEmpty(charset)) {
                signature.update(content.getBytes());
            } else {
                signature.update(content.getBytes(charset));
            }

            byte[] signed = signature.sign();

            return new String(Base64.encodeBase64(signed));
        } catch (InvalidKeySpecException ie) {
        	logger.error("RSA私钥格式不正确，请检查是否正确配置了PKCS8格式的私钥", ie);
            throw new ApiException("RSA私钥格式不正确，请检查是否正确配置了PKCS8格式的私钥", ie);
        } catch (Exception e) {
			logger.error("Rsa signature error,RSAcontent:{},charset:{}", content, charset);
            throw new ApiException("RSAcontent = " + content + "; charset = " + charset, e);
        }
	}

}
