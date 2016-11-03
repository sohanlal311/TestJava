package com.sohan.learn;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.WeakHashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class IntegerCacheDemo {
	public static void main(String[] args) {

		Integer a1 = 100;
		Integer a2 = 100;
		Integer a3 = new Integer(100);

		System.out.println(a1 == a2);
		System.out.println(a1 == a3);
		Set<Integer> set1 = new HashSet<Integer>() {
			{
				add(10);
			}
		};
		Set<Integer> set2 = new HashSet<Integer>();
		set2.add(10);
		System.out.println(set1.equals(set2));
		Map<Integer, Integer> m = new HashMap<Integer, Integer>(23);
		ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
		int availableProcessors = Runtime.getRuntime().availableProcessors();
		System.out.println("availableProcessors: " + availableProcessors);
		ForkJoinPool forkJoinPool = new ForkJoinPool(availableProcessors);
		ForkJoinTask recursiveAction = new RecursiveAction() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected void compute() {
				// TODO Auto-generated method stub

			}
		};
		m.put(2, 3);
		Map<Integer, Integer> map = new ConcurrentHashMap<Integer, Integer>(50, 0.75f, 2);
		map.put(1, 3);
		Collection<Integer> c = new ArrayList<Integer>();
		Sink<Object> sink = new Sink<Object>() {
			public void flush(Object o) {

			}
		};
		Integer i = flushAll(c, sink);
		new TreeSet<Integer>();
		Integer max = Collections.max(c);
		Arrays.sort(new int[] {});
		Collections.sort(null);
		new WeakHashMap<Integer, String>().put(3, "f");
		ReferenceQueue<Integer> refQueue = new ReferenceQueue<Integer>();
		WeakReference<Integer> weakReference = new WeakReference<Integer>(1, refQueue);
		SoftReference<Integer> softReference = new SoftReference<Integer>(1, refQueue);
		PhantomReference<Integer> phantomReference = new PhantomReference<Integer>(1, refQueue);
		Reference<? extends Integer> ref = refQueue.poll();
		ref.get();
		new CopyOnWriteArrayList<Integer>().listIterator();
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(20);
		
	}

	class Sohan<T extends Comparable<? super T>> {

	}

	private static <T> T flushAll(Collection<T> coll, Sink<? super T> sink) {
		T last = null;
		for (T t : coll) {
			last = t;
			sink.flush(t);
		}
		return last;
	}

	interface Sink<T> {
		void flush(T t);
	}
}

enum DIRECTION {
	EAST;
}