package com.wxjfkg.sdk.test;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.wxjfkg.sdk.http.OkHttpTemplate;

public class OkHttpTemplateTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	private final OkHttpTemplate template = new OkHttpTemplate();
	
	@Test
	public void testGet() {
		String content;
		try {
			content = template.get("http://www.baidu.com");
			System.out.println(content);
			Assert.assertNotNull(content);
		} catch (Exception e) {
			Assert.assertTrue(e instanceof IOException);
		}
	}
	
}
