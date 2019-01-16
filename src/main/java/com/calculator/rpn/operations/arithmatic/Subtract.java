package com.calculator.rpn.operations.arithmatic;

import com.calculator.rpn.CalculatorNumberInput;

public class Subtract extends ArithmeticOperation {
	@Override
	public CalculatorNumberInput compute(CalculatorNumberInput x, CalculatorNumberInput y) {
		return new CalculatorNumberInput(y.subtract(x));
	}
}
