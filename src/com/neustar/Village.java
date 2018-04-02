package com.neustar;

/**
 * Village is a data structure which has village number and visit count
 * 
 * @see Path
 * 
 * @author Naveen
 * 
 */
public class Village {
	private int villageNumber;
	private int visitCount;
	private boolean visited;

	public Village(int number) {
		villageNumber = number;
	}

	public int getVillageNumber() {
		return villageNumber;
	}

	public void setVillageNumber(int villageNumber) {
		this.villageNumber = villageNumber;
	}

	public int getVisitCount() {
		return visitCount;
	}

	public void setVisitCount(int visitCount) {
		this.visitCount = visitCount;
	}

	public void updateVisitCount() {
		visitCount++;
	}

	public boolean isLoop() {
		return visitCount > 3;
	}

	public boolean isVisited() {
		return this.visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + villageNumber;
		result = prime * result + visitCount;
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
		Village other = (Village) obj;
		if (villageNumber != other.villageNumber)
			return false;
		if (visitCount != other.visitCount)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return villageNumber + ":" + visitCount;
	}
}
