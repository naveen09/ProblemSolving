package com.neustar;

public enum Choice {
	ONE("1"), TWO("2"), M_ONE("-1"), DEFAULT("999");
	private String val;

	private Choice(String val) {
		this.val = val;
	}

	public String getValue() {
		return this.val;
	}

	public String toString() {
		return this.val;
	}

	public static Choice getValue(String next) {
		for (Choice c : Choice.values()) {
			if (c.getValue().equals(next))
				return c;
		}
		return DEFAULT;
	}
}
