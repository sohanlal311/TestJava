package com.sohan.learn;

import java.util.LinkedList;
import java.util.Queue;

public class UglyNumbers {
	public static void main(String[] args) {
		printUglyNumbers(15);
	}

	private static void printUglyNumbers(int n) {
		if (n < 1) {
			return;
		}

		Queue<Integer> q2 = new LinkedList<Integer>();
		Queue<Integer> q3 = new LinkedList<Integer>();
		Queue<Integer> q5 = new LinkedList<Integer>();
		q2.add(1);

		for (int i = 0; i <= n; i++) {
			int val2 = q2.isEmpty() ? Integer.MAX_VALUE : q2.peek();
			int val3 = q3.isEmpty() ? Integer.MAX_VALUE : q3.peek();
			int val5 = q5.isEmpty() ? Integer.MAX_VALUE : q5.peek();

			int min = Math.min(val2, Math.min(val3, val5));
			if (i > 0) {
				System.out.println(min + " ");
			}

			if (min == val2) {
				q2.remove();
				q2.add(min * 2);
				q3.add(min * 3);
			} else if (min == val3) {
				q3.remove();
				q3.add(min * 3);
			} else {
				q5.remove();
			}
			q5.add(min * 5);
		}
	}
}
