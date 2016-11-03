package com.sohan.techgig.paypal;

public class CandidateCode {

	public static void main(String[] args) {
		int[] input1 = new int[] { 6, 5 };
		String[] input2 = new String[] { "x#o#o#o#x#o", "x#o#o#o#x#x", "x#o#o#o#x#x", "x#o#x#o#o#x", "x#o#x#o#o#x" };
		// int[] input1 = new int[] { 6, 5 };
		// String[] input2 = new String[] { "x#o#o#o#x#o", "x#o#o#o#x#x",
		// "x#o#o#o#x#x", "x#o#x#o#o#x" };
		System.out.println(landingPosition(input1, input2));
	}

	public static int landingPosition(int[] input1, String[] input2) {
		if (input1 == null || input1.length != 2 || input2 == null || input2.length == 0 || input2.length != input1[1]) {
			return -1; // invalid input
		}

		int cols = input1[0];
		int rows = input1[1];
		int[][] mat = getMatrix(rows, cols, input2);
		if (mat == null) {
			return -1; // invalid input
		}

		int[][] resultMat = new int[rows][cols];
		// copy the first row of input matrix to result matrix
		for (int j = 0; j < cols; j++) {
			resultMat[0][j] = mat[0][j];
		}
		// copy the first column of input matrix to result matrix
		for (int i = 0; i < rows; i++) {
			resultMat[i][0] = mat[i][0];
		}

		int max = 1;
		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < cols; j++) {
				if (mat[i][j] == 1) {
					resultMat[i][j] = min(resultMat[i - 1][j], resultMat[i][j - 1], resultMat[i - 1][j - 1]) + 1;
				} else {
					resultMat[i][j] = 0;
				}
				if (resultMat[i][j] > max) {
					max = resultMat[i][j];
				}
			}
		}

		return max;
	}

	private static int[][] getMatrix(int rows, int cols, String[] input2) {
		int[][] mat = new int[rows][cols];
		String str;
		String split[];
		for (int i = 0; i < rows; i++) {
			str = input2[i];
			if (str == null || str.length() != (2 * cols - 1)) {
				return null; // invalid input
			}

			split = str.split("#");
			if (split.length != cols) {
				return null; // invalid input
			}

			for (int j = 0; j < split.length; j++) {
				if (split[j].equalsIgnoreCase("x")) {
					mat[i][j] = 0;
				} else if (split[j].equalsIgnoreCase("o")) {
					mat[i][j] = 1;
				} else {
					return null; // invalid input
				}
			}
		}
		return mat;
	}

	private static int min(int a, int b, int c) {
		return Math.min(Math.min(a, b), c);
	}

}
