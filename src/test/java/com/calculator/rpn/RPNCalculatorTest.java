package com.calculator.rpn;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.calculator.rpn.exceptions.InsufficientParametersException;

public class RPNCalculatorTest {

	RPNCalculator calculator = null;

	@Before
	public void setUp() {
		calculator = new RPNCalculator();
	}

	@Test
	public void testCaseCompareValues() throws Exception {
		calculator.input("9 18");
		assertEquals("9 18", calculator.getStack());
	}

	@Test
	public void testCaseDivMulDiv() throws Exception {
		calculator.input("5 20 10 /");

		assertEquals("5 2", calculator.getStack());

		calculator.input("*");

		assertEquals("10", calculator.getStack());

		calculator.input("4 /");

		assertEquals("2.5", calculator.getStack());
	}

	@Test
	public void testCaseInsufficientParameters() throws Exception {
		calculator.input("2 4 8 * 16");
		assertEquals("2 32 16", calculator.getStack());
		try {
			calculator.input("+ * - 2 2");
		} catch (InsufficientParametersException e) {
			System.out.println(e.getMessage());
			assertEquals(
					"WARNING: operator - (position: 5 ): insufficient parameters.\nThe [2, 2] were not pushed to stack due to previous error",
					e.getMessage());
		}

	}

	@Test
	public void testCaseInsufficientParamtersException() throws Exception {
		try {
			calculator.input("5 5 5 * 5 + * * 5 5");
		} catch (InsufficientParametersException e) {
			System.out.println(e.getMessage());
			assertEquals(
					"WARNING: operator * (position: 15 ): insufficient parameters.\nThe [5, 5] were not pushed to stack due to previous error",
					e.getMessage());
		}

	}

	@Test
	public void testCaseMul() throws Exception {
		calculator.input("2 4 6 8 10");

		assertEquals("2 4 6 8 10", calculator.getStack());

		calculator.input("* * * *");

		assertEquals("3840", calculator.getStack());
	}

	@Test
	public void testCaseMulClearSub() throws Exception {
		calculator.input("5 4 3 2 1");

		assertEquals("5 4 3 2 1", calculator.getStack());

		calculator.input("*");

		assertEquals("5 4 3 2", calculator.getStack());

		calculator.input("clear 10 5 -");

		assertEquals("5", calculator.getStack());
	}

	@Test
	public void testCaseSqrtClearSqrt() throws Exception {
		calculator.input("256 sqrt");

		assertEquals("16", calculator.getStack());

		calculator.input("clear 121 sqrt");

		assertEquals("11", calculator.getStack());
	}

	@Test
	public void testCaseSubtractionClear() throws Exception {
		calculator.input("50 2 -");

		assertEquals("48", calculator.getStack());

		calculator.input("3 -");

		assertEquals("45", calculator.getStack());

		calculator.input("clear");

		assertEquals("", calculator.getStack());
	}

	@Test
	public void testCaseUndoMulMulUndo() throws Exception {
		calculator.input("10 11 12 13");

		assertEquals("10 11 12 13", calculator.getStack());

		calculator.input("undo undo *");

		assertEquals("110", calculator.getStack());

		calculator.input("5 *");

		assertEquals("550", calculator.getStack());

		calculator.input("undo");

		assertEquals("110 5", calculator.getStack());
	}

}
