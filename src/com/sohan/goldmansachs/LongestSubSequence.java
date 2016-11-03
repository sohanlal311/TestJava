package com.sohan.goldmansachs;

import java.util.HashSet;
import java.util.Set;

public class LongestSubSequence {
	static int[] longestSequence(int[] seq) {
		if (seq == null || seq.length == 0) {
			return new int[] { 0 };
		}

		if (seq.length == 1) {
			return seq;
		}

		Set<Integer> set = new HashSet<Integer>();
		for (int i : seq) {
			set.add(i);
		}

		int start = 0, left, right, count, max = 0;
		for (int i : seq) {
			count = 1;

			left = i - 1;
			while (set.contains(left)) {
				count++;
				set.remove(left);
				left--;
			}

			right = i + 1;
			while (set.contains(right)) {
				count++;
				set.remove(right);
				right++;
			}

			if (count > max) {
				max = count;
				start = left + 1;
			}
		}

		int[] result = new int[max];
		for (int i = 0; i < max; i++, start++) {
			result[i] = start;
		}
		return result;
	}

}
