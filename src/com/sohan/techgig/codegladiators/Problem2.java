package com.sohan.techgig.codegladiators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem2 {
	public static void main(String[] args) {
		String[] input1 = { "M1#W2#W4", "M2#W1#W2", "M3#W1#W3#W4", "M4#W4#W5", "M5#W4" };
		String[] input2 = { "M1#W2#W4", "M2#W1#W2", "M3#W1#W3#W4", "M4#W4#W5", "M5" };
		String[] input3 = { "M1#W4", "M2#W1#W2", "M3#W1#W3#W4", "M4#W4#W5", "M5#W4" };
		String[] input4 = { "M1#W6#W10", "M2#W1#W5", "M3#W1#W3#W5#W9", "M4#W3#W4", "M5#W2#W6", "M6#W1#W2#W6",
				"M7#W1#W7#W8", "M8#W8#W10", "M9#W3#W9", "M10#W10" };
		System.out.println(totalmatching(input1));
		System.out.println(totalmatching(input2));
		System.out.println(totalmatching(input3));
		System.out.println(totalmatching(input4));
	}

	public static int totalmatching(String[] input1) {
		// Write code here
		if (input1 == null || input1.length == 0) {
			return -1;
		}

		Map<Integer, List<Integer>> men = new HashMap<Integer, List<Integer>>();
		Map<Integer, List<Integer>> women = new HashMap<Integer, List<Integer>>();
		if (!parseInput(input1, men, women)) {
			return -1;
		}
		if (women.size() == 0) {
			return 1;
		}

		boolean[] pairedMen = new boolean[men.size()];
		boolean[] pairedWomen = new boolean[women.size()];
		boolean change = true;
		while (change) {
			change = false;
			change |= processWomen(men, women, pairedMen, pairedWomen);
			change |= processMen(men, women, pairedMen, pairedWomen);
		}

		List<Integer> wlist;
		int result = 1;
		for (Integer m : men.keySet()) {
			wlist = men.get(m);
			if (wlist.size() > 1) {
				result += wlist.size() - 1;
				for (Integer i : wlist) {
					pairedMen[i - 1] = true;
					pairedWomen[i - 1] = true;
				}
				break;
			}
		}

		if (!areAllMenPaired(men, pairedMen) || !areAllWomenPaired(pairedWomen)) {
			return -1;
		}

		return result;
	}

	private static boolean processWomen(Map<Integer, List<Integer>> men, Map<Integer, List<Integer>> women,
			boolean[] pairedMen, boolean[] pairedWomen) {
		boolean found = false;
		for (Integer womanNum : women.keySet()) {
			List<Integer> m = women.get(womanNum);
			if (m.size() == 1) {
				found = true;
				Integer manNum = m.get(0);
				pairedMen[manNum - 1] = true;
				pairedWomen[womanNum - 1] = true;
				updateMaps(manNum, men, women);
			}
		}
		return found;
	}

	private static boolean processMen(Map<Integer, List<Integer>> men, Map<Integer, List<Integer>> women,
			boolean[] pairedMen, boolean[] pairedWomen) {
		boolean found = false;
		for (Integer manNum : men.keySet()) {
			List<Integer> w = men.get(manNum);
			if (w.size() == 1) {
				found = true;
				Integer womanNum = w.get(0);
				pairedMen[manNum - 1] = true;
				pairedWomen[womanNum - 1] = true;
				updateMaps(men, womanNum, women);
			}
		}
		return found;
	}

	private static boolean areAllMenPaired(Map<Integer, List<Integer>> men, boolean[] pairedMen) {
		for (int i = 0; i < pairedMen.length; i++) {
			if (!pairedMen[i] && men.get(i + 1).size() > 0) {
				return false;
			}
		}
		return true;
	}

	private static boolean areAllWomenPaired(boolean[] pairedWomen) {
		for (int i = 0; i < pairedWomen.length; i++) {
			if (!pairedWomen[i]) {
				return false;
			}
		}
		return true;
	}

	private static void updateMaps(Integer manNum, Map<Integer, List<Integer>> men, Map<Integer, List<Integer>> women) {
		for (Integer w : men.get(manNum)) {
			women.get(w).remove(manNum);
		}
		men.get(manNum).clear();
	}

	private static void updateMaps(Map<Integer, List<Integer>> men, Integer womanNum, Map<Integer, List<Integer>> women) {
		for (Integer m : women.get(womanNum)) {
			men.get(m).remove(womanNum);
		}
		women.get(womanNum).clear();
	}

	private static boolean parseInput(String[] input1, Map<Integer, List<Integer>> men,
			Map<Integer, List<Integer>> women) {
		String man, woman;
		for (int i = 0; i < input1.length; i++) {
			if (input1[i] != null && input1[i].length() > 0) {
				String[] split = input1[i].split("#");
				man = split[0];
				if (isNotMan(man)) {
					return false;
				}
				Integer manNum = getNumber(man);
				List<Integer> w = men.get(manNum);
				if (w == null) {
					w = new ArrayList<Integer>();
					men.put(manNum, w);
				}
				for (int j = 1; j < split.length; j++) {
					woman = split[j];
					if (isNotWoman(woman)) {
						return false;
					}
					Integer womanNum = getNumber(woman);
					List<Integer> m = women.get(womanNum);
					if (m == null) {
						m = new ArrayList<Integer>();
						women.put(womanNum, m);
					}
					m.add(manNum);
					w.add(womanNum);
				}
			}
		}
		return true;
	}

	private static boolean isNotMan(String str) {
		return str.length() < 2 || str.charAt(0) != 'M' || isNotNumber(str.substring(1));
	}

	private static boolean isNotWoman(String str) {
		return str.length() < 2 || str.charAt(0) != 'W' || isNotNumber(str.substring(1));
	}

	private static boolean isNotNumber(String str) {
		boolean result = false;
		try {
			Integer.parseInt(str);
		} catch (Exception e) {
			result = true;
		}
		return result;
	}

	private static Integer getNumber(String str) {
		return Integer.parseInt(str.substring(1));
	}
}
