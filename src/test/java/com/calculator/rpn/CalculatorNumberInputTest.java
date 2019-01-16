package com.calculator.rpn;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorNumberInputTest {
	@Test
	public void toNumberString() {
		assertEquals("258", new CalculatorNumberInput("258").toString());
		assertEquals("500", new CalculatorNumberInput("500.00").toString());
		assertEquals("5.6", new CalculatorNumberInput("5.6000").toString());
		assertEquals("6.3001", new CalculatorNumberInput("6.3001").toString());
	}

}
