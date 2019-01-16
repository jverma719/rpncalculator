package com.calculator.rpn.operations;

import com.calculator.rpn.RPNCalculator;

public class ClearOperation implements CalculatorOperation
{
    @Override
    public void performOperation(RPNCalculator calculator)
    {
        calculator.clear();
    }
}
