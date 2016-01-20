package com.demo.hqinterviewdemo.utils;

/**
 * @author Shivang
 */

import java.util.ArrayList;
import java.util.Vector;

public class StringUtils {

	/**
	 * Replace existing chars with new chars in a string
	 * @param source
	 * @param pattern
	 * @param replacement
	 * @return String
	 */
	public static String replaceAll(String source, String pattern,	String replacement) {
		if (source == null)
			return "";
		StringBuffer sb = new StringBuffer();
		int idx = -1;
		String workingSource = source;
		while ((idx = workingSource.indexOf(pattern)) != -1) {
			sb.append(workingSource.substring(0, idx));
			sb.append(replacement);
			sb.append(workingSource.substring(idx + pattern.length()));
			workingSource = sb.toString();
			sb.delete(0, sb.length());
		}
		return workingSource;
	}

	/*  {userId} = 276
    {appSecretKey} = gvx32RFZLNGhmzYrfDCkb9jypTPa8Q
    {currencyCode} = USD
    {offerId} = 10736598
    {selectedVouchers} = []*/

	/**
	 * Method call to replace specific contet of url
	 * @param url
	 * @return String
	 */
	public static String makeValidURL(String url){
		String temp = url;

		temp = replaceAll(url, "{userId}", "276");
		temp = replaceAll(temp, "{appSecretKey}", "gvx32RFZLNGhmzYrfDCkb9jypTPa8Q");
		temp = replaceAll(temp, "{currencyCode}", "USD");
		temp = replaceAll(temp, "{offerId}", "10736598");
		temp = replaceAll(temp, "{selectedVouchers}", "[]");

		return temp;
	}
}

/**
 * @author Shivang
 */
