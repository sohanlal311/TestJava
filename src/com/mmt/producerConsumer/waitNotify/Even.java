/**
 * 
 */
package com.mmt.producerConsumer.waitNotify;

/**
 * @author MMT3966
 *
 */
public class Even implements Runnable {

	private Resource resource;

	@Override
	public void run() {
		printEven();
	}

	private synchronized void printEven() {
		while (true) {
			if (!resource.isEven()) {
				synchronized (resource) {
					while (!resource.isEven()) {
						try {
							resource.wait();
						} catch (InterruptedException e) {
							// swallow
						}
					}
				}
			}

			System.out.println("Printing even Number : " + resource.getNumber());
			resource.setEven(false);
			resource.setNumber(resource.getNumber() + 1);
			resource.setOdd(true);

			synchronized (resource) {
				resource.notifyAll();
			}
		}
	}

	public Even(Resource resource) {
		super();
		this.resource = resource;
	}
}
