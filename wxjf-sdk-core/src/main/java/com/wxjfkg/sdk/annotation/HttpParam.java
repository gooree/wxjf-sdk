package com.wxjfkg.sdk.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Http请求参数
 * 
 * @author GuoRui
 *
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface HttpParam {

	/**
	 * 参数名称
	 * 
	 * @return
	 */
	String value() default "";
	
}
