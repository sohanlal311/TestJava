package com.sohan.hackerrank;

import java.util.Arrays;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class Romanizer {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(romanizer(new int[] { 75, 80, 99, 100, 50 })));
		System.out.println(Arrays.toString(romanizer(new int[] {})));
	}

	static String[] romanizer(int[] num) {
		if (num == null) {
			return null;
		}

		String[] result = new String[num.length];
		if (num.length > 0) {
			for (int i = 0; i < num.length; i++) {
				result[i] = Roman.constructRoman(num[i]);
			}
		}
		return result;
	}

	private enum Roman {
		I(1), IV(4), V(5), IX(9), X(10), XL(40), L(50), XC(90), C(100), CD(400), D(500), CM(900), M(1000);

		private static final NavigableMap<Integer, Roman> map = new TreeMap<Integer, Roman>();

		static {
			for (Roman r : values())
				map.put(r.getValue(), r);
		}

		private final int value;

		private Roman(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}

		public static String constructRoman(int num) {
			StringBuilder sb = new StringBuilder();
			constructRoman(num, sb);
			return sb.toString();
		}

		public static void constructRoman(int num, StringBuilder sb) {
			if (num == 0) {
				return;
			}
			Map.Entry<Integer, Roman> floorEntry = map.floorEntry(num);
			sb.append(floorEntry.getValue());
			constructRoman(num - floorEntry.getKey(), sb);
		}

	}
}
