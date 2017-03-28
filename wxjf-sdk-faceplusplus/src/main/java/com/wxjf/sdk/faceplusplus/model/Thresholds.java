package com.wxjf.sdk.faceplusplus.model;

import com.alibaba.fastjson.annotation.JSONField;

public class Thresholds {

	@JSONField(name = "1e-3")
	private String e3;
	
	@JSONField(name = "1e-4")
	private String e4;
	
	@JSONField(name = "1e-5")
	private String e5;
	
	@JSONField(name = "1e-6")
	private String e6;

	public String getE3() {
		return e3;
	}

	public void setE3(String e3) {
		this.e3 = e3;
	}

	public String getE4() {
		return e4;
	}

	public void setE4(String e4) {
		this.e4 = e4;
	}

	public String getE5() {
		return e5;
	}

	public void setE5(String e5) {
		this.e5 = e5;
	}

	public String getE6() {
		return e6;
	}

	public void setE6(String e6) {
		this.e6 = e6;
	}

}
