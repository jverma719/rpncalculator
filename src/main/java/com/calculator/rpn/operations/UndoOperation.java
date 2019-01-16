package com.calculator.rpn.operations;

import com.calculator.rpn.RPNCalculator;
import com.calculator.rpn.exceptions.InsufficientParametersException;

public class UndoOperation implements CalculatorOperation {
	@Override
	public void performOperation(RPNCalculator calculator) throws InsufficientParametersException {
		calculator.undo();
	}
}
