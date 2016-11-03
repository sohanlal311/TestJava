package com.sohan.medilife;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Que8 {

	public static void main(String args[]) throws Exception {
		/*
		 * Read input from stdin and provide input before running
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int n = Integer.parseInt(line), idx = 0;
		String[] input = new String[n];
		for (int i = 0; i < n; i++) {
			input[idx++] = br.readLine();
		}

		for (int i = 0; i < n; i++) {
			System.out.println(getMaxScore(input[i]));
		}
	}

	private static int getMaxScore(String str) {
		if (str == null || str.isEmpty()) {
			return 0;
		} else if (str.length() == 1) {
			return 0;
		}

		char ch;
		int left = 0, right = 0, sum = 0, idx = 0;
		StringBuilder sb = new StringBuilder(str.length());
		sb.append(str.charAt(0));
		int[] chrCount = new int[58];
		chrCount[str.charAt(0) - 65]++;

		for (int i = 1; i < str.length(); i++) {
			ch = str.charAt(i);
			if (chrCount[ch - 65] == 1) {
				sb.insert(idx + 1, ch);
				right++;
			} else {
				idx++;
				sb.insert(idx, ch);
				left++;
			}
			sum += left + right;
			if (chrCount[ch - 65] >= 2) {
				left--;
			}
			chrCount[ch - 65]++;
		}
		return sum;
	}
	
	private static int getMaxScore2(String str) {
		if (str == null || str.isEmpty()) {
			return 0;
		} else if (str.length() == 1) {
			return 0;
		}

		char ch;
		int left = 0, right = 0, sum = 0, idx = 0;
		StringBuilder sb = new StringBuilder(str.length());
		ch = str.charAt(0);
		ch = (ch > 96 && ch <= 122) ? (char)(ch - 6) : ch;
		sb.append(ch);
		int[] chrCount = new int[52];
		chrCount[ch - 65]++;

		for (int i = 1; i < str.length(); i++) {
			ch = str.charAt(i);
			ch = (ch > 96 && ch <= 122) ? (char)(ch - 6) : ch;
			if (chrCount[ch - 65] == 1) {
				sb.insert(idx + 1, ch);
				right++;
			} else {
				idx++;
				sb.insert(idx, ch);
				left++;
			}
			sum += left + right;
			if (chrCount[ch - 65]++ >= 2) {
				left--;
			}
		}
		return sum;
	}
}