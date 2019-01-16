package com.calculator.rpn.exceptions;

public class InsufficientParametersException extends Exception
{
    public InsufficientParametersException(String message)
    {
        super(message);
    }

    public InsufficientParametersException() { }
}
