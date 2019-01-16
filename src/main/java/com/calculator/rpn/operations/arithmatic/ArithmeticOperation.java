package com.calculator.rpn.operations.arithmatic;

import com.calculator.rpn.RPNCalculator;
import com.calculator.rpn.CalculatorNumberInput;
import com.calculator.rpn.exceptions.InsufficientParametersException;

public abstract class ArithmeticOperation extends NumberOperation {
    abstract CalculatorNumberInput compute(CalculatorNumberInput x, CalculatorNumberInput y);

    @Override public void performOperation(RPNCalculator calculator) throws InsufficientParametersException {
        CalculatorNumberInput x = popInputNumber(calculator);
        CalculatorNumberInput y;

        try {
            y = popInputNumber(calculator);
        } catch (InsufficientParametersException ex) {
            calculator.push(x);
            throw ex;
        }
        calculator.push(compute(x, y));
    }
}
