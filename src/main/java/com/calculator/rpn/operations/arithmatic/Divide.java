package com.calculator.rpn.operations.arithmatic;

import com.calculator.rpn.CalculatorNumberInput;

public class Divide extends ArithmeticOperation {
	@Override
	public CalculatorNumberInput compute(com.calculator.rpn.CalculatorNumberInput x, CalculatorNumberInput y) {
		return new CalculatorNumberInput(y.divide(x));
	}
}
