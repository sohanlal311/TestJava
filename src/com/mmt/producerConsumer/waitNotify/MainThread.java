package com.mmt.producerConsumer.waitNotify;

public class MainThread {

		public static void main(String[] args) {

			Resource resource = new Resource(1, false, true);
			Even even = new Even(resource);
			Odd odd = new Odd(resource);
			Thread evenTh = new Thread(even);
			Thread oddTh = new Thread(odd);
			evenTh.start();
			oddTh.start();
		}
}
