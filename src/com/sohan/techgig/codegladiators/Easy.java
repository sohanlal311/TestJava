package com.sohan.techgig.codegladiators;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Easy {
	public static void main(String[] args) {
		String[] input2 = new String[] { "Bharti", "Bharat", "Akash", "Bhavya", "Chand", "Brijesh", "Chetak", "Arvind",
				"Bhavna" };
		// String[] input2 = new String[] { null, null, "Mohan", "asd", null };
		System.out.println("Longest palindrome: " + getLongestPalindromeLength(input2));
	}

	public static int getLongestPalindromeLength(String[] input1) {
		// Write code here
		if (input1 == null || input1.length == 0) {
			return 0;
		}

		int len = input1.length;
		List<Character> list = new ArrayList<Character>();
		for (int i = 0; i < len; i++) {
			if (input1[i] != null && !input1[i].trim().isEmpty()) {
				list.add(input1[i].charAt(0));
			}
		}

		return getPalindromeLength(list, 0, list.size() - 1);
	}

	private static int getPalindromeLength(List<Character> list, int start, int end) {
		if (start > end) {
			return 0;
		}

		if (start == end) {
			return 1;
		}

		int maxLength = -1;
		Set<Character> set = new HashSet<Character>();
		for (int i = start; i <= end; i++) {
			if (set.add(list.get(i))) {
				for (int j = end; j > i; j--) {
					if (list.get(i) == list.get(j)) {
						int length = getPalindromeLength(list, i + 1, j - 1) + 2;
						if (maxLength < length) {
							maxLength = length;
						}
					}
				}
				if (maxLength == -1) {
					maxLength = 1;
				}
			}
		}

		return maxLength;
	}
}