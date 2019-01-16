package com.calculator.rpn.operations.arithmatic;

import com.calculator.rpn.CalculatorNumberInput;

public class Add extends ArithmeticOperation {
	@Override
	public CalculatorNumberInput compute(CalculatorNumberInput x, CalculatorNumberInput y) {
		return new CalculatorNumberInput(x.add(y));
	}
}
