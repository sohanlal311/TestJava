package com.puneet.learn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class Prime1 {
	public Prime1() throws IOException {
		int n = 0;
		int flag = 0;
		int p = 3;
		System.out.println("Enter the no. of prime no.");
		InputStreamReader isa = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isa);
		n = Integer.parseInt(br.readLine());
		if (n >= 1) {
			System.out.println("2");
		}
		for (int i = 2; i <= n; i++) {
			for (int j = 2; j < p; j++) {
				if (p % j == 0) {
					flag = 1;
					break;
				}
			}
			if (flag != 1) {
				System.out.println(p);
			}
			flag = 0;
			p++;
		}
	}

	private static Random rand = new Random();

	private static int random(int n) {
		return rand.nextInt() % n;
	}

	private static void myTest() {
		Integer i = new Integer(42);
		Integer j = new Integer(42);
		int result = (i < j) ? -1 : (i == j) ? 0 : 1;
		System.out.println(result);

		int n = 2 * (Integer.MAX_VALUE / 3);
		int low = 0;
		for (int k = 0; k < 1000_000; k++) {
			if (random(n) < n / 2) {
				low++;
			}
		}
		System.out.println(n);
		System.out.println("low: " + low);
		System.out.println(Math.abs(Integer.MIN_VALUE - 1));
		int[] digits = { 1, 2, 3 };
		System.out.println(digits);
		List<int[]> asList = Arrays.asList(digits);
		System.out.println(asList);
		System.out.println(asList.get(1));
		new BigInteger("23423").add(null);
		new BigDecimal("23423").add(null);
	}

	static Integer integer;

	public static void main(String[] args) throws IOException {
		if (integer == 42) {
			System.out.println("Awesome");
		}
	}
	
	
	
	
	
	
	
	
	
	
}
