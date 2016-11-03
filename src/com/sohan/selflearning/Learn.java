package com.sohan.selflearning;

public class Learn {
	public static void main(String[] args) {
		Thread t = new Thread(new Runnable() {
			public void run() {
				Thread currentThread = Thread.currentThread();
				System.out.println("another thread : " + currentThread);
				currentThread.start();
			}
		});
		t.start();
 		System.out.println("main : " + Thread.currentThread());
	}
}
