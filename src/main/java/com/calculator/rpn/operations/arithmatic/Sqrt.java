package com.calculator.rpn.operations.arithmatic;

import java.math.BigDecimal;

import com.calculator.rpn.RPNCalculator;
import com.calculator.rpn.CalculatorNumberInput;
import com.calculator.rpn.exceptions.InsufficientParametersException;

public class Sqrt extends NumberOperation {
	@Override
	public void performOperation(RPNCalculator calculator) throws InsufficientParametersException {
		CalculatorNumberInput inputNumber = popInputNumber(calculator);
		calculator.push(new CalculatorNumberInput(new BigDecimal(Math.sqrt(inputNumber.doubleValue()))));
	}
}
