package com.neustar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Starting point of execution.
 * <li>Responsible for creating Kingdom object</li>
 * 
 * @see Kingdom
 * @see KingdomPathFinder
 * 
 * @author Naveen
 * 
 */
public class Problem implements IConstant {
	// Helper map to hold all villages
	private Map<Integer, Village> villageMap = new HashMap<>();
	// List of villages
	private List<Village> villages;
	// List of paths between two villages
	private List<Path> paths;

	public static void main(String[] args) {
		Problem problem = new Problem();
		try (Scanner sc = new Scanner(System.in)) {// auto close resource
			Kingdom kingdom = problem.buildKingdom(sc);
			problem.processChoice(sc, kingdom);
		} catch (NoSuchElementException | KingdomException e) {
			if (e instanceof KingdomException) {
				Log.info(INFINITY);
			}
			Log.error(e.getMessage());
		}
	}

	/**
	 * #1 Find path between source and destination
	 * 
	 * @param kingdom
	 */
	private void findPath(Kingdom kingdom) {
		IKingdomPathFinder pathFinder = KingdomPathFinder.get(kingdom);
		String path = pathFinder.findPathToDestination();
		Log.info(path);
	}

	/**
	 * #2 Find the farthest village from source
	 * 
	 * @param kingdom
	 * @throws KingdomException
	 */
	private void findFarthestVillage(Kingdom kingdom) throws KingdomException {
		IKingdomPathFinder pathFinder = KingdomPathFinder.get(kingdom);
		String path = pathFinder.findFarthestPath();
		Log.info(path);
	}

	/**
	 * Show different input choices to user for selection.
	 * 
	 * @param sc
	 * @param kingdom
	 * @throws KingdomException
	 */
	private void processChoice(Scanner sc, Kingdom kingdom) throws KingdomException {
		// Show user choice list
		Utils.showUserOptions();
		boolean exit = false;
		do {
			Choice choice = Choice.getValue(sc.next());
			switch (choice) {
			case ONE:
				Log.debug("********** Computing paths **********");
				findPath(kingdom);
				Utils.showUserOptions();
				break;
			case TWO:
				Log.debug("********** Computing farthest distance **********");
				findFarthestVillage(kingdom);
				Utils.showUserOptions();
				break;
			case M_ONE:
				exit = true;
				Log.info("Exit !!");
				break;
			default:
				Log.info("\nEnter valid choice among 1,2 & -1.\n");
			}
		} while (!exit);
	}

	/**
	 * Read user inputs to build the kingdom object
	 * 
	 * @param sc
	 * @return
	 * @throws KingdomException
	 */
	private Kingdom buildKingdom(Scanner sc) throws KingdomException {
		villages = new ArrayList<Village>();
		paths = new ArrayList<Path>();

		System.out.println(ENTER_TOTAL_ENTRIES);
		int TOTAL = sc.nextInt();
		System.out.println("Enter data in the format VILLAGE1 VILLAGE2 DISTANCE1 VILLAGE3 DISTANCE3");
		for (int i = 0; i < TOTAL; i++) {
			int from = sc.nextInt();
			int leftVillage = sc.nextInt();
			int leftDistance = sc.nextInt();
			int rightVillage = sc.nextInt();
			int rightDistance = sc.nextInt();
			Log.debug("\nFrom:" + from + " ,To:" + leftVillage + ", Distance:" + leftDistance + ", Left");
			addPath(from, leftVillage, leftDistance, true);
			Log.debug("From:" + from + " ,To:" + rightVillage + ", Distance:" + rightDistance + ", Right");
			addPath(from, rightVillage, rightDistance, false);
		}
		Kingdom kingdom = new Kingdom(villages, paths);
		return kingdom;
	}

	/**
	 * Add path between two villages
	 * 
	 * @param from
	 * @param to
	 * @param distance
	 * @param isLeft
	 */
	private void addPath(int from, int to, int distance, boolean isLeft) {
		Path p = new Path();
		if (villageMap.containsKey(from)) {
			p.setFrom(villageMap.get(from));
		} else {
			Village v = new Village(from);
			p.setFrom(v);
			villages.add(v);
			villageMap.put(from, v);
		}
		if (villageMap.containsKey(to)) {
			p.setTo(villageMap.get(to));
		} else {
			Village v = new Village(to);
			p.setTo(v);
			villages.add(v);
			villageMap.put(to, v);
		}
		if (isLeft) {
			p.setDirection(Direction.LEFT);
		} else {
			p.setDirection(Direction.RIGHT);
		}
		p.setDistance(distance);
		paths.add(p);
	}
}
