package com.citrus.test;

import java.util.Arrays;
import java.util.LinkedList;

public class C {

	public static int getShortestPath(int[][] input, Point start, Point end) {
		int[] x = { 0, 0, 1, -1 };
		int[] y = { 1, -1, 0, 0 };
		LinkedList<Point> q = new LinkedList<Point>();
		q.add(start);

		int n = input.length;
		int m = input[0].length;
		int[][] distance = new int[n][m];
		for (int[] arr : distance) {
			Arrays.fill(arr, -1);
		}

		distance[start.x][start.y] = 0;
		while (!q.isEmpty()) {
			Point p = q.removeFirst();
			for (int i = 0; i < 4; i++) {
				int a = p.x + x[i];
				int b = p.y + y[i];
				if (a >= 0 && b >= 0 && a < n && b < m && distance[a][b] == -1 && input[a][b] != 1) {
					distance[a][b] = 1 + distance[p.x][p.y];
					q.add(new Point(a, b));
				}
			}
		}
		for (int[] arr : distance)
			System.out.println(Arrays.toString(arr));
		return distance[end.x][end.y];
	}

	private static class Point {
		private final int x;
		private final int y;

		Point(final int x, final int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

	}

}