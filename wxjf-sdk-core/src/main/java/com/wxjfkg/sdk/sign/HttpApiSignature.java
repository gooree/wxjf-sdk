package com.wxjfkg.sdk.sign;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;

import org.apache.commons.codec.digest.DigestUtils;

import com.wxjfkg.sdk.ApiConstants;
import com.wxjfkg.sdk.http.HttpApiRequest;

/**
 * Http Api请求签名实现类
 * 
 * @author GuoRui
 *
 * @param <T>
 */
public class HttpApiSignature<T extends HttpApiRequest> implements
		ApiSignature<T> {

	public String sign(T request, String signType, String privateKey) {
		Long timestamp = System.currentTimeMillis();
        DateFormat df = new SimpleDateFormat(ApiConstants.DATE_TIME_FORMAT);
        df.setTimeZone(TimeZone.getTimeZone(ApiConstants.DATE_TIMEZONE));
        request.setParameter(ApiConstants.TIMESTAMP, df.format(new Date(timestamp)));
        
        Map<String,String> parameters = request.getParameterMap();
		Map<String, String> sortedParams = new TreeMap<String, String>();
		if (parameters != null && parameters.size() > 0) {
            sortedParams.putAll(parameters);
        }
		
		StringBuffer content = new StringBuffer();
        List<String> keys = new ArrayList<String>(sortedParams.keySet());
        Collections.sort(keys);
        int index = 0;
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = sortedParams.get(key);
            content.append((index == 0 ? "" : "&") + key + "=" + value);
            index++;
        }
        String signContent = content.toString();
        
        Signature signature = SignatureFactory.getInstance(signType, privateKey);
        return DigestUtils.md5Hex(signature.sign(signContent));
	}

}
