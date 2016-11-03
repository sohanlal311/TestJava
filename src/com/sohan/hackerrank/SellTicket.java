package com.sohan.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class SellTicket {
	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			int noOfTktWindows = sc.nextInt();
			int noOfTktsToBeSold = sc.nextInt();

			int[] tktsAvailable = new int[noOfTktWindows];
			for (int i = 0; i < tktsAvailable.length; i++) {
				tktsAvailable[i] = sc.nextInt();
			}

			Arrays.sort(tktsAvailable);

			int m = 0, revenue = 0;
			for (int i = tktsAvailable.length - 1; i >= 0 && m < noOfTktsToBeSold;) {
				m++;
				revenue += tktsAvailable[i];
				tktsAvailable[i]--;
				i = nextMax(tktsAvailable, i);
			}

			System.out.println("revenue: " + revenue);
		} finally {
			if (sc != null) {
				sc.close();
			}
		}
	}

	private static int nextMax(int[] arr, int idx) {
		if (idx == arr.length - 1) {
			if (arr[idx] >= arr[idx - 1]) {
				return idx;
			} else {
				return idx - 1;
			}
		}

		if (idx == 0) {
			if (arr[idx + 1] >= arr[idx]) {
				return nextMax(arr, idx + 1);
			} else {
				return idx;
			}
		}

		if (arr[idx] > arr[idx + 1]) {
			return idx;
		} else {
			if (arr[idx - 1] > arr[idx]) {
				return idx - 1;
			} else {
				return idx + 1;
			}
		}
	}
}
