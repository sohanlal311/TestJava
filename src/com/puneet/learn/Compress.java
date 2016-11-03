package com.puneet.learn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Compress {
	public Compress() throws IOException {
		System.out.println("Enter the string to be compressed:- ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String s1 = " " + s.charAt(0);
		int flag, count;
		char temp;
		for (int i = 1; i < s.length(); i++) {
			flag = 0;
			for (int j = 0; j < i; j++) {
				if (s.charAt(i) == s.charAt(j)) {
					flag = 1;
				}
			}
			if (flag == 0)
				s1 = s1 + s.charAt(i);
		}
		System.out.println("Different characters are:- " + s1);
		System.out.println("compressed string is:-");
		for (int i = 0; i < s1.length(); i++) {
			count = 0;
			temp = s1.charAt(i);
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) == temp) {
					count++;
				}
			}
			System.out.print(temp);
			System.out.print(count);
		}
	}

	public static void main(String[] args) throws IOException {
		Compress cm = new Compress();
	}
}