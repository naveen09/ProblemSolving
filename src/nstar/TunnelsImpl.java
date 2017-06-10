package nstar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class TunnelsImpl implements ITunnel {
	private static final String INFINITY = "infinity";
	private int fStartPt;
	private int fDestPt;
	private int totalTunnels;

	public static void main(String[] args) {
		TunnelsImpl tp = new TunnelsImpl();
		Map<Integer, Tunnel> fTunnelMap = tp.processInput();
		if (fTunnelMap != null) {
			tp.findPath(fTunnelMap, tp.getStartPt(), tp.getDestPt(),
					new ArrayList<Integer>());
		}
	}

	private void findPath(Map<Integer, Tunnel> tunnelMap, int source,
			int destination, ArrayList<Integer> path) {
		Tunnel sTunnel = tunnelMap.get(source);
		Tunnel dTunnel = tunnelMap.get(destination);
		if (sTunnel == null || dTunnel == null) {
			return;
		}
		if (sTunnel.isLoop(totalTunnels)) {
			System.out.println(INFINITY);
			tunnelMap = null;
			return;
		}
		sTunnel.incrementCount();
		path.add(sTunnel.getTunnelNumber());
		Tunnel next = null;
		if (sTunnel.isFirstVisit()) {
			next = sTunnel.getLeft();
		} else {
			next = sTunnel.getRight();
		}
		if (next != null) {
			if (next.getTunnelNumber() == destination) {
				path.add(destination);
				System.out.println("Found the path");
				printPath(path);
				return;
			} else {
				findPath(tunnelMap, next.getTunnelNumber(), destination, path);
			}
		}
		return;
	}

	private static void printPath(ArrayList<Integer> path) {
		for (Iterator<Integer> iterator = path.iterator(); iterator.hasNext();) {
			System.out.print(iterator.next());
			if (iterator.hasNext())
				System.out.print(" -> ");
		}
	}

	private Map<Integer, Tunnel> processInput() {
		boolean isDestinatoinIncluded = false;
		Map<Integer, Tunnel> tMap = new LinkedHashMap<Integer, Tunnel>();
		try (Scanner sc = new Scanner(System.in)) {
			int N = sc.nextInt();
			this.fStartPt = sc.nextInt();
			this.fDestPt = sc.nextInt();
			for (int i = 2; i < N; i++) {
				Tunnel parent = null;
				Tunnel lTunnel = null;
				Tunnel rTunnel = null;
				int tNumber = sc.nextInt();
				parent = findOrCreateTunnel(tMap, tNumber);
				int ltn = sc.nextInt();
				int rtn = sc.nextInt();
				/*
				 * Fail fast to know if destination is included in the path
				 */
				if (tNumber == fDestPt || ltn == fDestPt || rtn == fDestPt) {
					isDestinatoinIncluded = true;
				}
				lTunnel = findOrCreateTunnel(tMap, ltn);
				rTunnel = findOrCreateTunnel(tMap, rtn);
				parent.setLeft(lTunnel);
				parent.setRight(rTunnel);

			}
			if (!isDestinatoinIncluded) {
				throw new IllegalStateException(
						"Input is not valid, as destination " + fDestPt
								+ " is not included");
			}
			for (Map.Entry<Integer, Tunnel> entry : tMap.entrySet()) {
				Tunnel value = entry.getValue();
				System.out.println("Parent: " + value.getTunnelNumber());
				if (value.getLeft() != null)
					System.out.print("Left: "
							+ value.getLeft().getTunnelNumber() + "\t");
				if (value.getRight() != null)
					System.out.print("Right: "
							+ value.getRight().getTunnelNumber());
				System.out.println();
			}
		} catch (IllegalStateException e) {
			System.out.println(INFINITY);

			/**
			 * Log if required System.err.println(e.getMessage());
			 */
		}
		totalTunnels = tMap.keySet().size();
		return tMap;
	}

	/**
	 * Find existing tunnel or create a new one and return.
	 * 
	 * @param tunnelMap
	 * @param tunnelNumber
	 * @return
	 */
	private Tunnel findOrCreateTunnel(Map<Integer, Tunnel> tunnelMap,
			int tunnelNumber) {
		if (tunnelMap.containsKey(tunnelNumber)) {
			return tunnelMap.get(tunnelNumber);
		}
		Tunnel tunnel = new Tunnel(tunnelNumber);
		tunnelMap.put(tunnelNumber, tunnel);
		return tunnel;
	}

	public int getStartPt() {
		return fStartPt;
	}

	public void setStartPt(int startPt) {
		this.fStartPt = startPt;
	}

	public int getDestPt() {
		return fDestPt;
	}

	public void setDestPt(int destPt) {
		this.fDestPt = destPt;
	}
}