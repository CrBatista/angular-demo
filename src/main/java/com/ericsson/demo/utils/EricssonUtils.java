package com.ericsson.demo.utils;

import java.util.Collection;

public class EricssonUtils {

	/**
	 * Will return true if the method parameter is null or equals ""
	 * 
	 * @param value
	 * @return
	 */
	public static Boolean isNullOrBlank(Object value) {
		return value == null || "".equals(value); 
	}


	/**
	 * Will return true if the method parameter is null or empty
	 * 
	 * @param value
	 * @return
	 */
	public static Boolean isNullOrEmpty(Collection<? extends Object> values) {
		return values == null || values.isEmpty(); 
	}
}
