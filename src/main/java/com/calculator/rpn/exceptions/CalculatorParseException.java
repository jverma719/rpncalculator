package com.calculator.rpn.exceptions;

public class CalculatorParseException extends Exception
{
    public CalculatorParseException(String input)
    {
        super("Unable to parse: " + input);
    }
}
