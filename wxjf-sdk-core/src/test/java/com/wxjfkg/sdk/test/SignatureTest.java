package com.wxjfkg.sdk.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.wxjfkg.sdk.sign.Signature;
import com.wxjfkg.sdk.sign.SignatureFactory;

public class SignatureTest {
	
	private String privateKey;
	
	private String signType;
	
	@Before
	public void setup() {
		privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBALAzleFpdAc16ISHnntd//lxtGCC+5tGKf0XD2QSKHnBbHV5QDKoOggMh8pNWcNx9BTeJPug10u1xr3fZxVINmQ6kNyCACDRePVxhS3KTmCEQrKxqw2i3hNxwE/l0y+nyNgcGWO5js6giC6TnUdzKQ7KEznEb6REKTDNhvBrthFVAgMBAAECgYBTmUYFWrkYKrWVG5tPwPuP6CjCmaKyuwl08Rn2Sr81dVX2Ln8NCc/uvbM3gpeSKWC6/eLiGB/N5gLTV0lbSZW0Ep+PjnTpk02Pu5uKPJPqd6d5zUN67xujKgnqNmVi9jFJ9TbxxG1rNwyYGSbXLwgrW1cQn21InbIKL521lp8LQQJBANdJ97YnovDaJq6PB3EJw95RwS+1SbKuBephUGEdvpsNwQZ4MidNl4Tc7xBwbikRQj2yisMrjhJ1CXl+Jf4m+OkCQQDRhWoXCv5HcUDttrkpDcEf10btnzeoaCakdT3sN/U+bHqzavZdMN4Fp7s5nOo79C3u+UrrWag1Vlz2JRpJS5GNAkEAv1xrB4lxxt5RlcVimvJQHLPUoOBmUqFmdq/rL3et7cqq8WIzSkYo0RtEj/svn+dMVuT1fIehb/yB4HDlumPPyQJAWzKFIQ6J67LiHhZAthvkieV8XAXHhif/WeomT+Fzf/5b0iimn52bpj6CAevJENuR+sjL0XEvBDhZMlKoBGs+KQJBAIfwOi8GPQzbb4brAIhzMwqJ6qWqLhQ+QQcfMUe50ax4ia3ZD0klI/NO/mXKUtMyAS8Ku4RlUcCHLpNrFjTGKTQ=";
	}
	
	@Test
	public void testRsaSignature() {
		signType = "RSA";
		Signature signature = SignatureFactory.getInstance(signType, privateKey);
		String result = signature.sign("app_id=2183&method=alipay.user.info.auth&sign_type=RSA&timestamp=2017-02-04 08:08:08&version=1.0");
		String sign = "ZEPoGQCnXAouyNKYhrtef2bMZJpXXGtVeGQZUH7vA/oZkG9LEZV0/BZmjd4WhjBkNtXyt3bqg3EWrCWm0UZH5kOQwtSez1pj/pjHoVnPEPKBQrqJOyH7d5hrsu6fwQxCDJa5FN1DUXl75zLGWngJVkSqbxD9q9pXpU2jHIVAfIQ=";
		Assert.assertEquals(sign, result);
	}
	
	@Test
	public void testRsa256Signature() {
		signType = "RSA2";
		Signature signature = SignatureFactory.getInstance(signType, privateKey);
		String result = signature.sign("app_id=2183&method=alipay.user.info.auth&sign_type=RSA2&timestamp=2017-02-04 08:08:08&version=1.0");
		String sign = "Tjh6JpkvxQbGzYLIrRBe9CzobsMfr+M/lVpESmcCDbBH+zxwxglAlaSc+VSEdZDIql5A9ik1KEWCQYcO0iiRuHi1s8ZmEconkn6ziQY5xUhAKfIv62mQHd5Jp68Nr0jiF7+buuvbq/pexZPbtoctcETSFE2WpSVI2PCMwVcqWkM=";
		Assert.assertEquals(sign, result);
	}
	
	@Test
	public void testHmacSha1Signature() {
		privateKey = "4fdO2fTDDnZPU/L7CHNdemB2Nsk=";
		signType = "HMAC";
		Signature signature = SignatureFactory.getInstance(signType, privateKey);
		String result = signature.sign("GET\n\n\nMon, 09 Nov 2015 06:11:16 GMT\nx-log-apiversion:0.6.0\nx-log-signaturemethod:hmac-sha1\n/logstores?logstoreName=&offset=0&size=1000");
		String sign = "jEYOTCJs2e88o+y5F4/S5IsnBJQ=";
		Assert.assertEquals(sign, result);
	}
	
}
