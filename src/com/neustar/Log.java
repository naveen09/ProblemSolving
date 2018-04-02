package com.neustar;

public class Log implements IConstant {
	/**
	 * Enable debug to see messages {@link #ENABLE_DEBUG}
	 * 
	 * @param msg
	 *            print any string
	 */
	public static void debug(String msg) {
		if (ENABLE_DEBUG)
			System.out.println(msg);
	}

	/**
	 * Log error message
	 * 
	 * @param msg
	 */
	public static void error(String msg) {
		if (!SUPRESS_ERRORS)
			System.err.println(msg);
	}

	/**
	 * Log messages
	 * 
	 * @param msg
	 */
	public static void info(String msg) {
		System.out.print(msg);

	}

}
