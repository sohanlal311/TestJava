package com.sohan.symantec;

public class Problem2 {

	public static void main(String[] args) {
		String[] input = new String[] { "YYNN", "YYYN", "NYYN", "NNNY" };
		// String[] input = new String[] { "YNNN", "NYNN", "NNYN", "NNNY" };
		// String[] input = new String[] { "YYNN", "YYNY", "NNYY", "YNYY" };
		// String[] input = new String[] { "YYYY", "YYYY", "YYYY", "YYYY" };
		System.out.println(friendCircles(input));
	}

	static int friendCircles(String[] friends) {
		if (friends == null || friends.length == 0) {
			return -1;
		}

		boolean isIncrement = false;
		int checker = 0;
		int counter = 0;
		int len = friends.length;
		for (int i = 0; i < len; i++) {
			String str = friends[i];
			if (str == null || str.length() != len) {
				return -1;
			}
			if ((checker & 1 << i) == 0) {
				counter++;
				checker |= 1 << i;
				isIncrement = true;
			}
			for (int j = i + 1; j < len; j++) {
				if (str.charAt(j) == 'Y') {
					if ((checker & 1 << j) == 0) {
						checker |= 1 << j;
					} else if (isIncrement) {
						counter--;
						isIncrement = false;
					}
				}
			}
			isIncrement = false;
		}

		return counter;
	}
}
