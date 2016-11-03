package com.sohan.medilife;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Que9 {
	public static void main(String args[]) throws Exception {
		/*
		 * Read input from stdin and provide input before running
		 */
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			String line = br.readLine();
			int n = Integer.parseInt(line);

			int[] speed = new int[n];
			int[] fuel = new int[n];

			line = br.readLine();
			String[] speedStr = line.split(" ");
			for (int i = 0; i < n; i++) {
				speed[i] = Integer.parseInt(speedStr[i]);
			}

			line = br.readLine();
			String[] fuelStr = line.split(" ");
			for (int i = 0; i < n; i++) {
				fuel[i] = Integer.parseInt(fuelStr[i]);
			}

			line = br.readLine();
			int fuelAvailable = Integer.parseInt(line);

			if (n > 0) {
				System.out.println(getMaxDistance(n, speed, fuel, fuelAvailable));
			} else {
				System.out.println(0 + "");
			}
		} catch (NumberFormatException nfe) {
			System.out.println(0 + "");
		} finally {
			if (br != null) {
				br.close();
			}
		}
	}

	private static double getMaxDistance(int n, int[] speed, int[] fuel, int fuelAvailable) {
		double maxDistance = 0.0, dis;
		for (int i = 0; i < n; i++) {
			if (fuel[i] != 0) {
				dis = (speed[i] * 1.0) / fuel[i];
				if (Double.compare(dis, maxDistance) > 0) {
					maxDistance = dis;
				}
			}
		}
		maxDistance *= fuelAvailable;
		return ((long) (maxDistance * 1000)) / 1000.0;
	}
}
