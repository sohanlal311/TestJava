package com.sohan.hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MissingAP {
	public static void main(String args[]) throws Exception {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int noOfInts = Integer.valueOf(line);
		line = br.readLine();
		String[] split = line.split(" ");
		if (split.length == noOfInts) {
			int a = 0, l = 0, s = 0, cnt = 0;
			for (String str : split) {
				int no = Integer.valueOf(str);
				if (cnt == 0)
					a = no;
				if (cnt == noOfInts - 1)
					l = no;
				s += no;
				cnt++;
			}
			int sum = (noOfInts + 1) * (a + l) / 2;
			System.out.println(sum - s);
		}
	}
}
