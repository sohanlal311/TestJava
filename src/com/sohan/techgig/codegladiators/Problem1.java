package com.sohan.techgig.codegladiators;

public class Problem1 {

	public static void main(String[] args) {
		int[] input = { 2, 2, 1, 1, 1 }; // G G B B G
		// int[] input = { 1, 2, 2, 1, 0 }; // B G G B B
		// int[] input = { 1, 2, 2, 2, 1 }; // invalid - multiple cases
		// int[] input = { 1, 2, 2, 1, 2, 0 }; // invalid
		// int[] input = { 1 }; // G
		// int[] input = { 0 }; // B
		System.out.println(admin_condition(input, 6));
	}

	public static int admin_condition(int[] input1, int input2) {
		// Write code here
		if (input1 == null || input1.length == 0 || input2 < 1 || input2 > input1.length) {
			return -1;
		}

		if (input1.length == 1) {
			if (input1[0] != 0 && input1[0] != 1) {
				return -1;
			} else {
				return input1[0];
			}
		}

		int[] states0 = new int[input1.length], states1 = null;
		boolean[] valid = new boolean[2];

		if (input1[0] == 1) {
			states0[0] = 1;
			valid[0] = true;
			states1 = new int[input1.length];
			states1[1] = 1;
			valid[1] = true;
		} else if (input1[0] == 2) {
			states0[0] = 1;
			states0[1] = 1;
			valid[0] = true;
		} else {
			return -1; // invalid case
		}

		for (int i = 1; i < input1.length; i++) {
			if (valid[0]) {
				valid[0] = setNextState(input1, states0, i);
			}
			if (valid[1]) {
				valid[1] = setNextState(input1, states1, i);
			}
		}

		if (valid[0] && valid[1]) {
			return -1;
		}
		return valid[1] ? states1[input2 - 1] : valid[0] ? states0[input2 - 1] : -1;
	}

	private static boolean setNextState(int[] input1, int[] states, int i) {
		int count = 0;
		if (states[i - 1] == 1)
			count++;
		if (states[i] == 1)
			count++;

		if (input1[i] - count == 1) {
			if (i == input1.length - 1) // last element
				return false; // invalid case
			else
				states[i + 1] = 1;
		} else if (input1[i] != count) {
			return false; // invalid case
		}

		return true;
	}
}