package com.calculator.rpn.operations.arithmatic;


import java.util.EmptyStackException;

import com.calculator.rpn.RPNCalculator;
import com.calculator.rpn.Input;
import com.calculator.rpn.CalculatorNumberInput;
import com.calculator.rpn.exceptions.InsufficientParametersException;
import com.calculator.rpn.operations.CalculatorOperation;

abstract class NumberOperation implements CalculatorOperation
{
    CalculatorNumberInput popInputNumber(RPNCalculator calculator) throws InsufficientParametersException
    {
        try {
            Input input = calculator.pop();
            return (CalculatorNumberInput) input;
        }
        catch (EmptyStackException exception) {
            throw new InsufficientParametersException();
        }
    }
}
