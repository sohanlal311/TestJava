package com.sohan.learn;

public class UBS {
	final static short x = 2;

	public static void main(String[] args) {
		for (int z = 0; z < 4; z++) {
			switch (z) {
			case x:
				System.out.print("0 ");
			default:
				System.out.print("def ");
			case x - 1:
				System.out.print("1 ");
				break;
			case x - 2:
				System.out.print("2 ");
			}
		}
	}

}
