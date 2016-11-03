package com.sohan.learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OuterClass<E> {

	private static InnerClass ic = new InnerClass() {
		private static final int i = 9;

		public void m() {
			class Sohan implements I {
				private static final int k = 9;
			}
			Sohan s = new Sohan();
		}
	};

	public static void m1() {

	}

	public void m2() {
		E[] t = null; //new E[];
		List[] l = new List[5]; //new List<E>[5]; or new List<String>[5];
		List<?>[] k = new List<?>[9];
		Object[] o = k;
		List<Integer> list = Arrays.asList(43);
		o[0] = list;
		Object x = k[0].get(0);
		List<E[]> j = null;
	}

	private static class InnerClass {
		public void m() {
			OuterClass.m1();
		}
	}

	private class InnerClass2 {
		public void m() {
			OuterClass.this.m2();
		}
	}

}

interface I {

}
