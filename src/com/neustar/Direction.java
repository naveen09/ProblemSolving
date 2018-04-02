package com.neustar;

public enum Direction {
	LEFT("left"), RIGHT("right");
	private String value;

	private Direction(String val) {
		value = val;
	}

	@Override
	public String toString() {
		return this.getValue();
	}

	public String getValue() {
		return value;
	}

}
