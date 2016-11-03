package com.sohan.learn;

import java.util.HashMap;
import java.util.Map;

public class LRUCache2<K, V> {
	private Map<K, DoublyLinkedList<K, V>> map = new HashMap<K, DoublyLinkedList<K, V>>();
	private DoublyLinkedList<K, V> head;
	private DoublyLinkedList<K, V> end;
	private int capacity;
	private int len;

	public static void main(String[] args) {
		LRUCache2<Integer, String> lruCache = new LRUCache2<Integer, String>(4);
		lruCache.set(1, "Sohan");
		print(lruCache);
		lruCache.set(2, "Amit");
		print(lruCache);
		lruCache.set(12, "Ajay");
		print(lruCache);
		lruCache.get(1);
		print(lruCache);
		lruCache.set(6, "Sonu");
		print(lruCache);
		lruCache.get(2);
		print(lruCache);
		lruCache.set(16, "Sonam");
		print(lruCache);
	}

	private static void print(LRUCache2<Integer, String> lruCache) {
		System.out.println("-----------");
		System.out.println(lruCache);
	}

	public LRUCache2(int capacity) {
		this.capacity = capacity;
		this.len = 0;
	}

	public V get(K key) {
		V value = null;
		if (map.containsKey(key)) {
			DoublyLinkedList<K, V> node = map.get(key);
			removeNode(node);
			setHead(node);
			value = node.value;
		}
		return value;
	}

	public V remove(K key) {
		V value = null;
		if (map.containsKey(key)) {
			DoublyLinkedList<K, V> node = map.remove(key);
			removeNode(node);
			value = node.value;
			len--;
		}
		return value;
	}

	public void set(K key, V value) {
		if (map.containsKey(key)) {
			DoublyLinkedList<K, V> node = map.get(key);
			node.value = value;
			removeNode(node);
			setHead(node);
		} else {
			DoublyLinkedList<K, V> node = new DoublyLinkedList<K, V>(key, value);
			if (this.len < this.capacity) {
				map.put(key, node);
				setHead(node);
				len++;
			} else {
				map.remove(end.key);
				end = end.prev;
				if (end != null) {
					end.next = null;
				}
				map.put(key, node);
				setHead(node);
			}
		}
	}

	private void removeNode(DoublyLinkedList<K, V> node) {
		DoublyLinkedList<K, V> prev = node.prev;
		DoublyLinkedList<K, V> next = node.next;

		if (prev != null) {
			prev.next = next;
		} else {
			head = next;
		}

		if (next != null) {
			next.prev = null;
		} else {
			end = prev;
		}
	}

	private void setHead(DoublyLinkedList<K, V> node) {
		node.next = head;
		node.prev = null;
		if (head != null) {
			head.prev = node;
		}
		head = node;
		if (end == null) {
			end = node;
		}
	}

	public String toString() {
		return map.toString();
	}

}

class DoublyLinkedList<K, V> {
	public K key;
	public V value;
	public DoublyLinkedList<K, V> prev;
	public DoublyLinkedList<K, V> next;

	public DoublyLinkedList(K data, V value) {
		this.key = data;
		this.value = value;
	}
}