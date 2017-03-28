package com.wxjfkg.sdk.http;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.wxjfkg.sdk.utils.CollectionUtils;

/**
 * Http请求头容器类
 * 
 * @author GuoRui
 *
 */
public class HeaderValueHolder {

	private final List<Object> values = new LinkedList<Object>();

	public void setValue(Object value) {
		this.values.clear();
		this.values.add(value);
	}

	public void addValue(Object value) {
		this.values.add(value);
	}

	public void addValues(Collection<?> values) {
		this.values.addAll(values);
	}

	public void addValueArray(Object array) {
		Object[] arr = CollectionUtils.toObjectArray(array);
		for (Object elem : arr) {
			this.values.add(elem);
		}
	}

	public List<Object> getValues() {
		return this.values;
	}

	public List<String> getStringValues() {
		List<String> stringList = new ArrayList<String>(this.values.size());
		for (Object value : this.values) {
			stringList.add(value.toString());
		}
		return stringList;
	}

	public Object getValue() {
		return (!this.values.isEmpty() ? this.values.get(0) : null);
	}

	public String getStringValue() {
		return (!this.values.isEmpty() ? this.values.get(0).toString() : null);
	}

	/**
	 * Find a HeaderValueHolder by name, ignoring casing.
	 * @param headers the Map of header names to HeaderValueHolders
	 * @param name the name of the desired header
	 * @return the corresponding HeaderValueHolder,
	 * or {@code null} if none found
	 */
	public static HeaderValueHolder getByName(Map<String, HeaderValueHolder> headers, String name) {
		if (name != null) {
			for (String headerName : headers.keySet()) {
				if (headerName.equalsIgnoreCase(name)) {
					return headers.get(headerName);
				}
			}
		}
		return null;
	}
	
}
