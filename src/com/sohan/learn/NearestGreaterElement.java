package com.sohan.learn;

import java.util.Arrays;
import java.util.Stack;

public class NearestGreaterElement {
	public static void main(String[] args) {
		int[] num = { 6, 4, 8, -1, 3, 1, 9, 5 };
		System.out.println(Arrays.toString(num));
		nearestGreaterElement(num);
		new A(new Object());
		new A(new int[] {});
		new A(null);
		A a = new B();
		a.method1(new Object());
		a.method1(new int[] {});
		a.method1("str");
		a.method1(null);
	}

	private static void nearestGreaterElement(int[] num) {
		if (num == null || num.length == 0) {
			return;
		}
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(num[0]);
		int currNum, popNum;
		for (int i = 1; i < num.length; i++) {
			currNum = num[i];
			if (currNum <= stack.peek()) {
				stack.push(currNum);
			} else {
				while (!stack.isEmpty() && stack.peek() < currNum) {
					popNum = stack.pop();
					System.out.println("Nearest greater for " + popNum + " is " + currNum);
				}
				stack.push(currNum);
			}
		}
		while (!stack.isEmpty()) {
			popNum = stack.pop();
			System.out.println("Nearest greater for " + popNum + " is " + -1);
		}
	}
}

class A {
	A(Object obj) {
		System.out.println("A.obj");
	}

	A(int[] arr) {
		System.out.println("A.arr");
	}

	A() {
	}

	public void method1(Object obj) {
		System.out.println("classA.method1(Object)");
	}

	public void method1(int[] arr) {
		System.out.println("classA.method1(int[])");
	}
}

class B extends A {

	public void method1(int[] arr) {
		System.out.println("classB.method1(int[])");
	}
}