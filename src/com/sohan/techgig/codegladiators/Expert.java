package com.sohan.techgig.codegladiators;

public class Expert {

	public static void main(String[] args) {
		String input1 = "0,-1,0,-1,0";
		System.out.println(sequences(input1));
	}

	public static String sequences(String input1) {
		if (input1 == null || input1.isEmpty() || input1.length() == 1) {
			return input1;
		}

		String[] split = input1.split(",");
		int[] input = new int[split.length];
		int idx = 0;
		for (String s : split) {
			input[idx++] = Integer.valueOf(s);
		}

		int end = input.length - 1;
		while (end > 0) {
			for (int i = 1; i <= end; i++) {
				input[i - 1] = input[i] - input[i - 1];
			}
			end--;
		}

		return input[0] + "";
	}
}
