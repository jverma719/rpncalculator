package com.calculator.rpn;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;

import com.calculator.rpn.exceptions.CalculatorParseException;
import com.calculator.rpn.operations.CalculatorOperator;

public class CalculatorParserTest {
	private final CalculatorParser inputParser = new CalculatorParser();

	@Test
	public void failToParseNumber() {
		assertEquals(inputParser.parseNumber("as"), Optional.empty());
	}

	@Test
	public void parseAddOperator() {
		assertEquals(inputParser.parseOperator("+"), Optional.of(CalculatorOperator.ADD));
	}

	@Test
	public void parseClearOperator() {
		assertEquals(inputParser.parseOperator("clear"), Optional.of(CalculatorOperator.CLEAR));
	}

	@Test
	public void parseDivideOperator() {
		assertEquals(inputParser.parseOperator("/"), Optional.of(CalculatorOperator.DIVIDE));
	}

	@Test
	public void parseMultiplyOperator() {
		assertEquals(inputParser.parseOperator("*"), Optional.of(CalculatorOperator.MULTIPLY));
	}

	@Test
	public void parseNumber() {
		assertEquals(inputParser.parseNumber("85"), Optional.of(new CalculatorNumberInput("85")));
	}

	@Test
	public void parseSqrtOperator() {
		assertEquals(inputParser.parseOperator("sqrt"), Optional.of(CalculatorOperator.SQRT));
	}

	@Test
	public void parseSubtractOperator() {
		assertEquals(inputParser.parseOperator("-"), Optional.of(CalculatorOperator.SUBTRACT));
	}

	@Test
	public void parseUndoOperator() {
		assertEquals(inputParser.parseOperator("undo"), Optional.of(CalculatorOperator.UNDO));
	}

	@Test
	public void throwException() {
		try {
			inputParser.parseValue("x");
		} catch (CalculatorParseException exception) {
			return;
		}

		Assert.fail("Eligible for InputParseException exception");
	}
}
