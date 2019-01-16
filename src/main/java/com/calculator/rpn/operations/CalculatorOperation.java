package com.calculator.rpn.operations;

import com.calculator.rpn.RPNCalculator;
import com.calculator.rpn.exceptions.InsufficientParametersException;

public interface CalculatorOperation
{
    void performOperation(RPNCalculator calculator) throws InsufficientParametersException;
}
