package com.neustar;

/**
 * Custom exception for Kingdom with error code and reason.
 * 
 * @author Naveen
 * 
 */
public class KingdomException extends Exception {

	private static final long serialVersionUID = 1L;
	private String msg;

	public KingdomException(String msg) {
		this.msg = msg;
	}

	/**
	 * Return error message prefixed by error code
	 * 
	 * @param ec
	 */
	public KingdomException(ErrorCode ec) {
		this.msg = ec.toString();
	}

	@Override
	public String getMessage() {
		return msg;
	}
}
