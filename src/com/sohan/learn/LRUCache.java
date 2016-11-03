package com.sohan.learn;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int capacity; // Maximum number of items in the cache.

	public LRUCache(int capacity) {
		super(capacity + 1, 1.0f, true); // Pass 'true' for accessOrder.
		this.capacity = capacity;
	}

	protected boolean removeEldestEntry(Entry<K, V> entry) {
		return (size() > this.capacity);
	}

	public static void main(String[] args) {
		LRUCache<Integer, String> lruCache = new LRUCache<Integer, String>(4);
		lruCache.put(1, "Sohan");
		print(lruCache);
		lruCache.put(2, "Amit");
		print(lruCache);
		lruCache.put(12, "Ajay");
		print(lruCache);
		lruCache.get(1);
		print(lruCache);
		lruCache.put(6, "Sonu");
		print(lruCache);
		lruCache.get(2);
		print(lruCache);
		lruCache.put(16, "Sonam");
		print(lruCache);
	}

	private static void print(LRUCache<Integer, String> lruCache) {
		System.out.println("-----------");
		System.out.println(lruCache);
	}
}