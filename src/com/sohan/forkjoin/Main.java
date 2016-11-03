package com.sohan.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String[] args) {
		ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());

		FolderProcessor system = new FolderProcessor("/Users/sohan/Documents", ".log");
		FolderProcessor apps = new FolderProcessor("/Applications", ".log");
		pool.execute(system);
		pool.execute(apps);

		do {
			System.out.printf("******************************************\n");
			System.out.printf("Main: Parallelism: %d\n", pool.getParallelism());
			System.out.printf("Main: Active Threads: %d\n", pool.getActiveThreadCount());
			System.out.printf("Main: Task Count: %d\n", pool.getQueuedTaskCount());
			System.out.printf("Main: Steal Count: %d\n", pool.getStealCount());
			System.out.printf("******************************************\n");
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while ((!system.isDone()) || (!apps.isDone()));

		pool.shutdown();

		System.out.printf("System: %d files found.\n", system.join().size());
		System.out.printf("App: %d files found.\n", apps.join().size());
	}
}
