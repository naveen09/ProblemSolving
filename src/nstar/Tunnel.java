package nstar;

public class Tunnel {

	private int count;
	private int tunnelNumber;
	private Tunnel left;
	private Tunnel right;

	public Tunnel(int tNumber) {
		this.tunnelNumber = tNumber;
	}

	public int getTunnelNumber() {
		return tunnelNumber;
	}

	public void setTunnelNumber(int tunnelNumber) {
		this.tunnelNumber = tunnelNumber;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Tunnel getLeft() {
		return left;
	}

	public void setLeft(Tunnel left) {
		this.left = left;
	}

	public Tunnel getRight() {
		return right;
	}

	public void setRight(Tunnel right) {
		this.right = right;
	}

	public void incrementCount() {
		this.count++;
	}

	public boolean isVisited() {
		return this.count % 2 == 0;
	}

	public boolean isFirstVisit() {
		return !isVisited();
	}

	/**
	 * if a tunnel is visited more than 3 times, then a loop exists in the path
	 * 
	 * @param totalTunnels
	 * 
	 * @return
	 */
	public boolean isLoop(int totalTunnels) {
		return this.count > 3;
	}

}
