package com.sohan.learn;

public class LCA {

	public static void main(String[] args) {
		Node n = new Node(6);
		n.left = new Node(4);
		n.right = new Node(3);
		n.left.left = new Node(9);
		n.left.right = new Node(7);
		n.right.left = new Node(2);
		n.right.right = new Node(8);
		n.left.left.left = new Node(25);
		n.left.left.right = new Node(17);
		n.left.right.right = new Node(11);
		n.left.right.right.right = new Node(3);
		System.out.println(lca(n, n.left.left, n.left.right.right).data);
	}

	private static Node lca(Node head, Node a, Node b) {
		if (head == null) {
			return null;
		}
		if (head.data == a.data || head.data == b.data) {
			return head;
		}
		Node left = lca(head.left, a, b);
		Node right = lca(head.right, a, b);
		return (left != null && right != null) ? head : (left != null) ? left : right;
	}
}

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
	}
}
