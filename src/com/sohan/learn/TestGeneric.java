package com.sohan.learn;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class TestGeneric {
	public static void main(String[] args) {
		UnaryFunction<String> u1 = UnaryFunctions.identityFunction();
		System.out.println(u1.apply("Sohan"));
	}
}

class UnaryFunctions {
	private static final UnaryFunction<Object> IDENTITY_FUNCTION = new UnaryFunction<Object>() {
		@Override
		public Object apply(Object arg) {
			Set<Integer> set = new HashSet<Integer>();
			Set<Integer> checkedSet = Collections.checkedSet(set, Integer.class);
			Set raw = checkedSet;
			raw.add("Sohan");
			return arg;
		}
	};

	private UnaryFunctions() {
	}

	@SuppressWarnings("unchecked")
	public static <T> UnaryFunction<T> identityFunction() {
		return (UnaryFunction<T>) IDENTITY_FUNCTION;
	}
}

interface UnaryFunction<T> {
	T apply(T arg);
}