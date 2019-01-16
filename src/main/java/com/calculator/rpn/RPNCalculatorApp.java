package com.calculator.rpn;

import java.io.IOException;
import java.util.Scanner;

import com.calculator.rpn.exceptions.CalculatorParseException;
import com.calculator.rpn.exceptions.InsufficientParametersException;

public class RPNCalculatorApp {
	public static void main(String[] args) throws IOException {
		RPNCalculator calculator = new RPNCalculator();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input the expression or enter exit to quit");

		while (true) {
			System.out.print("Enter next input:");
			String inputString = scanner.nextLine();
			if ("exit".equals(inputString)) {
				scanner.close();
				System.exit(0);
			} else {
				try {
					calculator.input(inputString);
				} catch (CalculatorParseException | InsufficientParametersException ex) {
					System.out.println(ex.getMessage());
				}
				calculator.printStack();
			}
		}
	}
}
