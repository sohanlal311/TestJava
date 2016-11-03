package com.sohan.techgig.codegladiators;

import java.util.HashMap;
import java.util.Map;

public class Practice {

	public static void main(String[] args) {
		int[] input1 = new int[] { 1, 3, 4, 8, 2, 6, 7, 8, 4 };
		System.out.println("Cost: " + getStairCost(input1));
	}

	public static int getStairCost(int[] input1) {
		// Write code here
		if (input1 == null || input1.length == 0) {
			return -1;
		}

		int len = input1.length;
		if (len == 1) {
			return 0;
		}

		Map<Integer, Integer> steps = new HashMap<Integer, Integer>(len);
		for (int k = 0; k < len; k++) {
			steps.put(k, -1);
		}

		for (int i = len - 2; i >= 0; i--) {
			if (input1[i] < 0 || input1[i] > 100) {
				return -1;
			}
			if (input1[i] >= len - 1 - i) {
				steps.put(i, 1);
			} else if (input1[i] != 0) {
				for (int j = 1; j <= input1[i]; j++) {
					Integer next = steps.get(i + j);
					Integer current = steps.get(i);
					if (next != -1 && ((next + 1) < current || current == -1)) {
						steps.put(i, next + 1);
					}
				}
			}
		}
		return steps.get(0);
	}

}
