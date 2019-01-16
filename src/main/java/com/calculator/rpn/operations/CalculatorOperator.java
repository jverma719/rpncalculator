package com.calculator.rpn.operations;

import com.calculator.rpn.RPNCalculator;
import com.calculator.rpn.Input;
import com.calculator.rpn.exceptions.InsufficientParametersException;
import com.calculator.rpn.operations.arithmatic.Add;
import com.calculator.rpn.operations.arithmatic.Divide;
import com.calculator.rpn.operations.arithmatic.Multiply;
import com.calculator.rpn.operations.arithmatic.Sqrt;
import com.calculator.rpn.operations.arithmatic.Subtract;

public enum CalculatorOperator implements Input {
	// @formatter:off
	ADD("+", new Add()),
	SUBTRACT("-", new Subtract()),
	MULTIPLY("*", new Multiply()),
	DIVIDE("/", new Divide()),
	SQRT("sqrt", new Sqrt()),
	UNDO("undo", new UndoOperation()),
	CLEAR("clear", new ClearOperation());
	// @formatter:on

	private final CalculatorOperation calculatorOperation;
	private final String operatorValue;

	CalculatorOperator(String operator, CalculatorOperation calculatorOperation) {
		this.operatorValue = operator;
		this.calculatorOperation = calculatorOperation;
	}

	public String getOperator() {
		return operatorValue;
	}

	@Override
	public boolean isOperator() {
		return true;
	}

	public void operate(RPNCalculator calculator) throws InsufficientParametersException {
		calculatorOperation.performOperation(calculator);
	}

	@Override
	public String toString() {
		return getOperator();
	}
}
