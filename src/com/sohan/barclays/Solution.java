package com.sohan.barclays;

public class Solution {
	public int solution(int[] A, int M) {
		// write your code in Java SE 8
		if (A == null || A.length == 0) {
			return -1;
		}

		int cnt = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = i + 1; j < A.length; j++) {
				if (Math.abs(A[i] - A[j]) % 4 == 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}
}
