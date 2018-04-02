package com.neustar;

/**
 * Error codes which represent the reason of failures
 * <ol>Make sure to set SUPRESS_ERROR to false to see the errors</ol>
 * @see {@link IConstant}
 * @author Naveen
 * 
 */
public enum ErrorCode implements IErrorCode {
	MULTIPLE_DESTINATIONS_ERROR(101, "Multiple destinations."), NO_DESTINATION_ERROR(
			102, "No destination found."), KINGDOM_ERROR(103,
			"Failed to construct a kingdom."), CYCLIC(104,
			"Cycle exists in the path.");

	private String description;
	private int code;

	private ErrorCode(int code, String description) {
		this.code = code;
		this.description = description;
	}

	@Override
	public String toString() {
		return "[ " + code + " ]" + " : " + description;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public int getCode() {
		return code;
	}

}
