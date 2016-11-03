package com.sohan.techgig.codegladiators;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Medium {

	public static void main(String[] args) {
		// String[] input1 = new String[] { "1#2", "2#3", "1#11", "3#11",
		// "4#11", "4#5", "5#6", "5#7", "6#7", "4#12",
		// "8#12", "9#12", "8#10", "9#10", "8#9" };
		String[] input1 = new String[] { "1#2", "2#3", "1#4", "3#4", "1#3" };
		System.out.println("Maximum cities are: " + maxno_city(input1));
	}

	public static int maxno_city(String[] input1) {
		if (input1 == null || input1.length == 0) {
			return -1;
		}
		Map<Integer, Integer> map = getNodesMapping(input1);
		if (map.size() == 0) {
			return -1;
		}

		boolean[][] bGraph = getGraph(input1, map);

		int maxCities = Integer.MIN_VALUE;
		for (int key : map.keySet()) {
			Integer from = map.get(key);
			int k = from + 1;
			int[] to = new int[map.size() - k];
			for (int j = 0; j < to.length; j++) {
				to[j] = k++;
			}
			maxCities = Math.max(maxCities, getLongestPath(0, 1, bGraph));
		}
		return maxCities;
	}

	public static int getLongestPath(int from, int to, boolean[][] graph) {
		int n = graph.length;
		boolean[][] hasPath = new boolean[1 << n][n];
		hasPath[1 << from][from] = true;
		for (int mask = 0; mask < (1 << n); mask++)
			for (int last = 0; last < n; last++)
				for (int curr = 0; curr < n; curr++)
					if (graph[last][curr] && (mask & (1 << curr)) == 0)
						hasPath[mask | (1 << curr)][curr] |= hasPath[mask][last];
		int result = 0;
		for (int mask = 0; mask < (1 << n); mask++)
			if (hasPath[mask][to])
				result = Math.max(result, Integer.bitCount(mask));
		return result;
	}

	public static int getLongestPathBackup(int from, int[] to, boolean[][] graph) {
		int n = graph.length;
		boolean[][] hasPath = new boolean[1 << n][n];
		hasPath[1 << from][from] = true;
		for (int mask = 0; mask < (1 << n); mask++)
			for (int last = 0; last < n; last++)
				for (int curr = 0; curr < n; curr++)
					if (graph[last][curr] && (mask & (1 << curr)) == 0)
						hasPath[mask | (1 << curr)][curr] |= hasPath[mask][last];
		int result = 0;
		for (int mask = 0; mask < (1 << n); mask++)
			for (int toMask = 0; toMask < to.length; toMask++)
				if (hasPath[mask][to[toMask]])
					result = Math.max(result, Integer.bitCount(mask));
		return result;
	}

	private static Map<Integer, Integer> getNodesMapping(String[] input) {
		Set<Integer> set = new TreeSet<Integer>();
		int idx = -1;
		for (String s : input) {
			idx = s.indexOf('#');
			if (isValid(idx, s.length() - 1)) {
				String[] split = s.split("#");
				if (split.length == 2) {
					try {
						set.add(Integer.valueOf(split[0]));
						set.add(Integer.valueOf(split[1]));
					} catch (NumberFormatException e) {
						// swallow exception and skip
					}
				}
			}
		}

		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		int count = 0;
		for (int key : set) {
			map.put(key, count++);
		}
		return map;
	}

	private static boolean[][] getGraph(String[] input, Map<Integer, Integer> map) {
		boolean[][] bGraph = new boolean[map.size()][map.size()];
		int idx = -1;
		for (String s : input) {
			idx = s.indexOf('#');
			if (isValid(idx, s.length() - 1)) {
				String[] split = s.split("#");
				if (split.length == 2) {
					try {
						Integer i = map.get(Integer.valueOf(split[0]));
						Integer j = map.get(Integer.valueOf(split[1]));
						bGraph[i][j] = true;
						bGraph[j][i] = true;
					} catch (NumberFormatException e) {
						// swallow exception and skip
					}
				}
			}
		}
		return bGraph;
	}

	private static boolean isValid(int idx, int endIdx) {
		return idx > 0 && idx < endIdx;
	}

}
