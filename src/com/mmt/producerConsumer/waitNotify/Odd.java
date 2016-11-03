/**
 * 
 */
package com.mmt.producerConsumer.waitNotify;

/**
 * @author MMT3966
 *
 */
public class Odd implements Runnable {

	private Resource resource;

	@Override
	public void run() {
		printOdd();
	}

	private synchronized void printOdd() {
		while (true) {
			if (!resource.isOdd()) {
				synchronized (resource) {
					while (!resource.isOdd()) {
						try {
							resource.wait();
						} catch (InterruptedException e) {
							// swallow
						}
					}
				}
			}

			System.out.println("Printing odd Number : " + resource.getNumber());
			resource.setOdd(false);
			resource.setNumber(resource.getNumber() + 1);
			resource.setEven(true);

			synchronized (resource) {
				resource.notifyAll();
			}
		}

	}

	public Odd(Resource resource) {
		super();
		this.resource = resource;
	}
}
