package com.sohan.symantec;

public class Problem1 {

	public static void main(String[] args) {
		int[] x = new int[] { 0, 4352345 };
		int[] y = new int[] { -1, 3 };
		System.out.println(minarea(x, y, 2));
	}

	static int minarea(int[] x, int[] y, int k) {
		if (x == null || y == null || x.length != y.length || x.length != k) {
			return -1;
		}

		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, minTemp, maxTemp;
		for (int i = 0; i < k; i++) {
			maxTemp = Math.max(x[i], y[i]);
			minTemp = Math.min(x[i], y[i]);

			if (maxTemp == Integer.MAX_VALUE || minTemp == Integer.MIN_VALUE) {
				return -1;
			}

			if (maxTemp > max) {
				max = maxTemp;
			}

			if (minTemp < min) {
				min = minTemp;
			}
		}

		int side = (max + 1) - (min - 1);
		long area = side * side;
		return area > Integer.MAX_VALUE ? -1 : (int) area;
	}
}
