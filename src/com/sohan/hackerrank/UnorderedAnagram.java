package com.sohan.hackerrank;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Problem Statement
 * <p>
 * Given a string S, find the number of unordered anagramic pairs of substrings.
 * <p>
 * Input Format
 * <p>
 * First line contains T, the number of testcases. Each testcase consists of
 * string S in one line.
 * <p>
 * Constraints
 * <p>
 * 1≤T≤10
 * <p>
 * 2≤length(S)≤100
 * <p>
 * String S contains only the lowercase letters of the English alphabet.
 * <p>
 * Output Format
 * <p>
 * For each testcase, print the required answer in one line.
 * <p>
 * Sample Input
 * <p>
 * 2
 * <p>
 * abba
 * <p>
 * abcd
 * <p>
 * Sample Output
 * <p>
 * 4
 * <p>
 * 0
 * <p>
 * Explanation
 * <p>
 * Let's say S[i,j] denotes the substring Si,Si+1,⋯,Sj.
 * <p>
 * testcase 1:
 * <p>
 * For S=abba, anagramic pairs are: {S[1,1],S[4,4]}, {S[1,2],S[3,4]},
 * {S[2,2],S[3,3]} and {S[1,3],S[2,4]}.
 * <p>
 * testcase 2:
 * <p>
 * No anagramic pairs.
 */
public class UnorderedAnagram {
	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			int noOfcases = Integer.parseInt(sc.nextLine());
			for (int i = 0; i < noOfcases; i++) {
				System.out.println(pairs(sc.nextLine()));
			}
		} finally {
			if (sc != null) {
				sc.close();
			}
		}
	}

	private static Integer pairs(String str) {

		return null;
	}

	private static void pairs2(String str) {
		Set<String> set = new HashSet<String>();
		int cnt = 0;
		for (int i = 1; i <= str.length(); i++) {
			for (int j = 0; j + i <= str.length(); j++) {
				char cArr[] = str.substring(j, j + i).toCharArray();
				Arrays.sort(cArr);
				if (set.remove(String.copyValueOf(cArr))) {
					cnt++;
				} else {
					set.add(String.copyValueOf(cArr));
				}
			}
		}
		System.out.println(cnt);
	}
}
