package com.sohan.goldmansachs;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ParseExpressions {

	private static final String LEFT_PARENTHESIS = "(";
	private static final String RIGHT_PARENTHESIS = ")";
	private static final String MULTIPLY = "*";
	private static final String DIVIDE = "/";
	private static final String ADD = "+";
	private static final String SUBTRACT = "-";
	private static final Map<String, Integer> OPERATORS = new HashMap<String, Integer>();

	static float evaluate(String[] arr) {
		initialize();
		Stack<String> optStack = new Stack<String>();
		Stack<Float> valueStack = new Stack<Float>();
		for (String str : arr) {
			str = str.trim();
			if (LEFT_PARENTHESIS.equals(str)) {
				optStack.push(str);
			} else if (RIGHT_PARENTHESIS.equals(str)) {
				while (!LEFT_PARENTHESIS.equals(optStack.peek())) {
					applyOperator(optStack, valueStack);
				}
				optStack.pop();
			} else if (OPERATORS.containsKey(str)) {
				String opt = optStack.size() > 0 ? optStack.peek() : null;
				if (OPERATORS.containsKey(opt)) {
					if (OPERATORS.get(opt) <= OPERATORS.get(str)) {
						applyOperator(optStack, valueStack);
					}
				}
				optStack.push(str);
			} else {
				Float value = getValue(str);
				if (value != null) {
					valueStack.push(value);
				} else {
					throw new RuntimeException(str + " not expected.");
				}
			}
		}
		if (optStack.size() > 0) {
			applyOperator(optStack, valueStack);
		}
		return valueStack.pop();
	}

	private static void initialize() {
		OPERATORS.put(MULTIPLY, 1);
		OPERATORS.put(DIVIDE, 1);
		OPERATORS.put(ADD, 2);
		OPERATORS.put(SUBTRACT, 2);
	}

	private static Float getValue(String str) {
		Float result = null;
		try {
			result = Float.valueOf(str);
		} catch (NumberFormatException e) {
			// swallow it
		}
		return result;
	}

	private static void applyOperator(Stack<String> optStack, Stack<Float> valueStack) {
		String opt = optStack.pop();
		Float f2 = valueStack.pop();
		Float f1 = valueStack.pop();
		Float result = operate(f1, f2, opt);
		valueStack.push(result);
	}

	private static Float operate(Float f1, Float f2, String str) {
		switch (str) {
		case MULTIPLY:
			return f1 * f2;
		case DIVIDE:
			return f1 / f2;
		case ADD:
			return f1 + f2;
		case SUBTRACT:
			return f1 - f2;
		default:
			throw new RuntimeException(str + " operator is not supported.");
		}
	}

}
