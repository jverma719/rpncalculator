package com.calculator.rpn;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculatorNumberInput extends BigDecimal implements Input
{
    public CalculatorNumberInput(String number)
    {
        super(number);
    }

    public CalculatorNumberInput(BigDecimal bigDecimal)
    {
        super(bigDecimal.toString());
    }

    @Override
    public boolean isOperator()
    {
        return false;
    }

    public String toString()
    {
        String string = super.toPlainString();

        if (scale() >= 1) {
            BigDecimal bigDecimal = new BigDecimal(string);
            string = bigDecimal.setScale(10, RoundingMode.DOWN).stripTrailingZeros().toPlainString();
        }

        return string;
    }
}
