package com.neustar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Kingdom is a graph like data structure which holds list of villages and paths
 * between each village.
 * 
 * @see Village
 * @see Path
 * 
 * @author Naveen
 * 
 */
public class Kingdom implements IConstant {
	private List<Village> vList;
	private List<Path> paths;
	private Village destination;
	private Village source;

	/**
	 * Build kingdom with list of villages and paths
	 * <li>We compute the destination too</li>
	 * 
	 * @param v
	 * @param p
	 * @throws KingdomException
	 */
	public Kingdom(List<Village> v, List<Path> p) throws KingdomException {
		vList = v;
		paths = p;
		computeDestinationAndSource();
	}

	public List<Village> getVillages() {
		return vList;
	}

	public void setvList(List<Village> vList) {
		this.vList = vList;
	}

	public List<Path> getPaths() {
		return paths;
	}

	public void setPaths(List<Path> paths) {
		this.paths = paths;
	}

	public Village getDestination() {
		return destination;
	}

	public Village getSource() {
		return source;
	}

	/**
	 * Get Village with ID
	 * 
	 * @param vid
	 * @return
	 */
	public Village getVillageWithId(int vid) {
		for (Village v : vList) {
			if (v.getVillageNumber() == vid)
				return v;
		}
		return null;
	}

	/**
	 * Throw exception if
	 * <li>We have empty villages or paths</li>
	 * <li>We have multiple destinations</li> else compute the destination.
	 * 
	 * @throws KingdomException
	 */
	private void computeDestinationAndSource() throws KingdomException {
		if (vList.isEmpty() || paths.isEmpty())
			throw new KingdomException(ErrorCode.KINGDOM_ERROR);

		Set<Integer> villages = Utils.getVillagesWithOutBounds(paths);
		Map<Integer, Village> villageMap = Utils.buildVillageMap(paths);

		Set<Integer> totalVillages = new HashSet<>();
		totalVillages.addAll(villageMap.keySet());

		totalVillages.removeAll(villages);

		if (totalVillages.isEmpty())
			throw new KingdomException(ErrorCode.NO_DESTINATION_ERROR);

		if (totalVillages.size() > 1)
			throw new KingdomException(ErrorCode.MULTIPLE_DESTINATIONS_ERROR);

		source = villageMap.entrySet().iterator().next().getValue();
		destination = villageMap.get(totalVillages.iterator().next());
	}

	/**
	 * Return village and list of paths mapping
	 * <li>V1, &lt;P1, P2&gt;</li>
	 * <li>V2, &lt;P3, P4&gt;</li>
	 * 
	 * @return
	 */
	public Map<Integer, List<Path>> getVillagePathMap() {
		Map<Integer, List<Path>> villagePathMap = new HashMap<>();
		for (Path p : paths) {
			if (villagePathMap.containsKey(p.getFrom().getVillageNumber())) {
				List<Path> pList = villagePathMap.get(p.getFrom().getVillageNumber());
				pList.add(p);
			} else {
				List<Path> pList = new ArrayList<>();
				pList.add(p);
				villagePathMap.put(p.getFrom().getVillageNumber(), pList);
			}
		}
		return villagePathMap;
	}

	/**
	 * Clear all visits
	 */
	public void clearVisits() {
		for (Village v : vList) {
			v.setVisitCount(0);
			v.setVisited(false);
		}
	}
}
