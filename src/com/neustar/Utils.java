package com.neustar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Utility class, used all over
 * 
 * @author Naveen
 * 
 */
public class Utils implements IConstant {

	/**
	 * Show user choice list
	 */
	public static void showUserOptions() {
		Log.info("\n*********** Enter the choice ***********");
		Log.info("\n 1 : Find number of paths to reach destination.");
		Log.info("\n 2 : Find the farthest path from first village.");
		Log.info("\n-1 : To Exit.");
	}

	/**
	 * Get all villages who have only outgoing paths
	 * 
	 * @param paths
	 * @return
	 */
	public static Set<Integer> getVillagesWithOutBounds(List<Path> paths) {
		Set<Integer> villages = new HashSet<>();
		for (Path p : paths) {
			villages.add(p.getFrom().getVillageNumber());
		}
		return villages;
	}

	/**
	 * Format list to path like structure 1 -> 2 -> 3 -> 4
	 * 
	 * @param path
	 * @return
	 */
	public static String listToPath(List<Integer> path) {
		StringBuffer sb = new StringBuffer();
		for (Iterator<Integer> iterator = path.iterator(); iterator.hasNext();) {
			sb.append(iterator.next());
			if (iterator.hasNext())
				sb.append(ARROW_R);
		}
		return sb.toString();
	}

	/**
	 * Build an adjacency list of villages
	 * <li>V1 - > V2, V3</li>
	 * <li>V2 - > V4 , V5</li>
	 * 
	 * @param paths
	 * @return
	 */
	public static Map<Village, List<Village>> buildVillageAdjList(List<Path> paths) {
		Map<Village, List<Village>> villageMapAdjList = new LinkedHashMap<>();
		for (Path p : paths) {
			if (villageMapAdjList.containsKey(p.getFrom())) {
				villageMapAdjList.get(p.getFrom()).add(p.getTo());
			} else {
				List<Village> vList = new ArrayList<Village>();
				vList.add(p.getTo());
				villageMapAdjList.put(p.getFrom(), vList);
			}
		}
		return villageMapAdjList;
	}

	/**
	 * Build Village name object mapping.
	 * <li>1, Village1Object</li>
	 * <li>2, Village2Object</li>
	 * 
	 * @param paths
	 * @return
	 */
	public static Map<Integer, Village> buildVillageMap(List<Path> paths) {
		Map<Integer, Village> villageMap = new LinkedHashMap<>();
		for (Path p : paths) {
			if (!villageMap.containsKey(p.getFrom().getVillageNumber()))
				villageMap.put(p.getFrom().getVillageNumber(), p.getFrom());

			if (!villageMap.containsKey(p.getTo().getVillageNumber()))
				villageMap.put(p.getTo().getVillageNumber(), p.getTo());
		}
		return villageMap;
	}

	/**
	 * Given a village, find the next move based on visit count
	 * 
	 * @param villagePathMap
	 * @param source
	 * @return
	 */
	public static Village getNextMove(Map<Integer, List<Path>> villagePathMap, Village source) {
		boolean left = moveLeft(source.getVisitCount());
		Direction nextDir = left ? Direction.LEFT : Direction.RIGHT;
		List<Path> pList = villagePathMap.get(source.getVillageNumber());
		for (Path p : pList) {
			if (p.getDirection() == nextDir)
				return p.getTo();
		}
		return null;
	}

	/**
	 * return size of path or INFINITY depending on size.
	 * 
	 * @param path
	 * @return
	 */
	public static String getFormattedPath(List<Integer> path) {
		if (path.isEmpty())
			return INFINITY;
		Log.debug(listToPath(path));
		return path.size() + "";
	}

	/**
	 * Check if visit count is odd or even
	 * 
	 * @param visit_count
	 * @return
	 */
	public static boolean moveLeft(int visit_count) {
		return visit_count % 2 != 0;
	}

}
