package com.rays.utility;

import java.util.ResourceBundle;

/**
 * @author Aadarsh
 *
 */
public class PropertyReader {
	private static ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.project04.bundle.app");

	public static String getValue(String key) {

		String val = null;

		try {
			val = rb.getString(key);
		} catch (Exception e) {
			val = key;
		}

		return val;

	}

	/**
	 * Gets String after placing param values
	 * 
	 * @param key reads
	 * @param param reads
	 * @return values String
	 */
	public static String getValue(String key, String param) {
		String msg = getValue(key);
		msg = msg.replace("{0}", param);
		return msg;
	}

	/**
	 * Gets String after placing params values
	 * 
	 * @param key reads
	 * @param params reads
	 * @return values String
	 */
	public static String getValue(String key, String[] params) {
		String msg = getValue(key);
		for (int i = 0; i < params.length; i++) {
			msg = msg.replace("{" + i + "}", params[i]);
		}
		return msg;
	}

	/**
	 * Test method
	 **
	 * main method 
	 * @param args main method
	 */

	public static void main(String[] args) {
		String[] params = { "Roll No" };
		System.out.println(PropertyReader.getValue("error.require", params));
	}

}
