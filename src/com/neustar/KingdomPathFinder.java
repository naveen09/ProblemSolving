package com.neustar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Helper class, used to find
 * <li>path between two villages</li>
 * <li>Farthest path in a Kingdom</li>
 * 
 * @author naveen.aechan
 *
 */
public class KingdomPathFinder implements IKingdomPathFinder, IConstant {

	private static IKingdomPathFinder pathFinder;
	private Map<Integer, List<Path>> villagePathMap;
	private Map<Village, List<Village>> villageMapAdjList;
	private Kingdom kingdom;

	public static IKingdomPathFinder get(Kingdom kingdom) {
		if (pathFinder == null) {
			synchronized (KingdomPathFinder.class) {
				if (pathFinder == null) {
					pathFinder = new KingdomPathFinder(kingdom);
				}
			}
		}
		return pathFinder;
	}

	private KingdomPathFinder(Kingdom k) {
		kingdom = k;
		villagePathMap = kingdom.getVillagePathMap();
	}

	/**
	 * #1 Find path to destination
	 */
	@Override
	public String findPathToDestination() {
		Village source = kingdom.getSource();
		Village destination = kingdom.getDestination();
		List<Integer> routeList = new ArrayList<Integer>();
		findPath0(source, destination, routeList);
		kingdom.clearVisits();
		return Utils.getFormattedPath(routeList);
	}

	/**
	 * #1.1 find the path between source and destination
	 * 
	 * @param source
	 * @param destination
	 * @param routeList
	 * @return INFINITY or size of paths
	 */
	private List<Integer> findPath0(Village source, Village destination, List<Integer> routeList) {

		source.updateVisitCount();
		if (source.isLoop()) {
			routeList.clear();
			return routeList;
		}
		routeList.add(source.getVillageNumber());
		Village nextMove = Utils.getNextMove(villagePathMap, source);
		if (nextMove == null) {
			routeList.clear();
			return routeList;
		}
		if (nextMove.getVillageNumber() == destination.getVillageNumber()) {
			routeList.add(nextMove.getVillageNumber());
			return routeList;
		} else {
			findPath0(nextMove, destination, routeList);
		}
		return routeList;
	}

	/**
	 * #2 Find farthest village from source
	 * <li>Do a topological sorting of whole Kingdom (Graph)</li>
	 * <li>Find distance to each node by backtracking</li>
	 */
	@Override
	public String findFarthestPath() throws KingdomException {
		// You have sorted villages here.
		LinkedList<Village> tSortedVillageList = topologicalSort();
		// maintain a distance map
		Map<Village, Integer> distanceMap = new HashMap<Village, Integer>();
		// maintain a parent-child map
		Map<Village, Village> parentMap = new HashMap<Village, Village>();
		// initialize all distances to 0
		for (Village v : kingdom.getVillages()) {
			distanceMap.put(v, 0);
		}
		kingdom.clearVisits();
		Village pivot_village = kingdom.getSource();
		for (Village villageIndex : tSortedVillageList) {
			for (Village neighbour : villageMapAdjList.get(villageIndex)) {
				int distV = distanceMap.get(villageIndex) + getDistanceBetween(villageIndex, neighbour);
				if (distanceMap.get(neighbour) < distV) {
					distanceMap.put(neighbour, distV);
					parentMap.put(neighbour, villageIndex);
					if (distanceMap.get(neighbour) > distanceMap.get(pivot_village))
						pivot_village = neighbour;
				}
			}
		}
		// I know this should be removed for submittion, but just in case
		// TODO : need to work on this
		// List<Integer> path = new ArrayList<>();
		// path.add(kingdom.getDestination().getVillageNumber());
		// Village village;
		// do {
		// Village temp = pivot_village;
		// village = parentMap.get(pivot_village);
		// if (village != null) {
		// path.add(village.getVillageNumber());
		// pivot_village = village;
		// parentMap.remove(temp);
		// }
		//
		// } while (village != null);
		// path.add(kingdom.getSource().getVillageNumber());
		// Collections.reverse(path);
		// Log.debug(Utils.listToPath(path));

		for (Map.Entry<Village, Integer> entry : distanceMap.entrySet()) {
			Log.debug(entry.getKey().getVillageNumber() + " : " + entry.getValue() + "\n");
		}
		return distanceMap.get(pivot_village) + " " + kingdom.getSource().getVillageNumber() + " "
				+ kingdom.getDestination().getVillageNumber();
	}

	/**
	 * Find distance between two villages
	 * 
	 * @param villageIndex
	 * @param neighbour
	 * @return
	 */
	private Integer getDistanceBetween(Village villageIndex, Village neighbour) {
		List<Path> paths = villagePathMap.get(villageIndex.getVillageNumber());
		for (Path p : paths) {
			if (p.getTo().getVillageNumber() == neighbour.getVillageNumber()) {
				return p.getDistance();
			}
		}
		return 0;
	}

	/**
	 * Build village, list<village> map, similar to a adj list
	 * 
	 * @return
	 * @throws KingdomException
	 */
	private LinkedList<Village> topologicalSort() throws KingdomException {
		LinkedList<Village> res = new LinkedList<Village>();
		villageMapAdjList = Utils.buildVillageAdjList(kingdom.getPaths());
		villageMapAdjList.put(kingdom.getDestination(), new ArrayList<Village>());
		for (Entry<Village, List<Village>> entry : villageMapAdjList.entrySet()) {
			List<Village> adjVillages = entry.getValue();
			for (Village v : adjVillages) {
				if (!v.isVisited())
					_topologicalSort(entry.getKey(), adjVillages, res);
			}
		}
		return res;
	}

	/*
	 * Do a recursive sorting. Sort internal list, again.
	 */
	private void _topologicalSort(Village villageFrom, List<Village> adjVillages, LinkedList<Village> res) {
		villageFrom.setVisited(true);

		for (Village node : adjVillages) {
			if (!node.isVisited()) {
				List<Village> neighbors = villageMapAdjList.get(node);
				if (neighbors != null)
					_topologicalSort(node, neighbors, res);
			}
		}

		res.addFirst(villageFrom);
	}

}
