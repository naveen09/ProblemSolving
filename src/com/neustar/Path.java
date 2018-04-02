package com.neustar;

/**
 * Each path holds information related to, from and to villages, direction and
 * distance to cover
 * 
 * @see Village
 * 
 * @author Naveen
 * 
 */
public class Path {
	private int distance;
	private Direction direction;
	private Village from;
	private Village to;

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public Village getFrom() {
		return from;
	}

	public void setFrom(Village from) {
		this.from = from;
	}

	public Village getTo() {
		return to;
	}

	public void setTo(Village to) {
		this.to = to;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public boolean isLeftPath() {
		return this.direction == Direction.LEFT;
	}

	public boolean isRightPath() {
		return !isLeftPath();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((direction == null) ? 0 : direction.hashCode());
		result = prime * result + distance;
		result = prime * result + ((from == null) ? 0 : from.hashCode());
		result = prime * result + ((to == null) ? 0 : to.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Path other = (Path) obj;
		if (direction != other.direction)
			return false;
		if (distance != other.distance)
			return false;
		if (from == null) {
			if (other.from != null)
				return false;
		} else if (!from.equals(other.from))
			return false;
		if (to == null) {
			if (other.to != null)
				return false;
		} else if (!to.equals(other.to))
			return false;
		return true;
	}

}
