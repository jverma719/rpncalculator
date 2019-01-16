package com.calculator.rpn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.calculator.rpn.exceptions.CalculatorParseException;
import com.calculator.rpn.exceptions.InsufficientParametersException;
import com.calculator.rpn.operations.CalculatorOperator;

public class RPNCalculator {
	private Stack<CalculatorNumberInput> currentInputStack = new Stack<>();
	private LinkedList<Input> inputHistory = new LinkedList<>();

	public void clear() {
		currentInputStack = new Stack<>();
	}

	private void handleInput(Input inputToken) throws InsufficientParametersException {

		inputHistory.add(inputToken);
		if (inputToken.isOperator()) {
			CalculatorOperator operator = (CalculatorOperator) inputToken;
			operator.operate(this);
		} else {
			currentInputStack.push((CalculatorNumberInput) inputToken);
		}

	}

	public void input(String input) throws CalculatorParseException, InsufficientParametersException {
		CalculatorParser inputParser = new CalculatorParser();

		Queue<Input> inputQueue = inputParser.parse(input.trim());
		int currentInputSize = inputQueue.size();
		try {
			while (!inputQueue.isEmpty()) {
				Input inputToken = inputQueue.poll();
				handleInput(inputToken);
			}
		} catch (InsufficientParametersException exception) {
			int offset = 2 * (currentInputSize - inputQueue.size()) - 1;
			CalculatorOperator operator = (CalculatorOperator) inputHistory.removeLast();
			String warning = String.format("WARNING: operator %s (position: %s ): insufficient parameters.\n",
					operator.getOperator(), offset);
			if (inputQueue.size() > 0) {
				String error = String.format("The %s were not pushed to stack due to previous error",
						inputQueue.toString());
				warning = warning + error;
			}
			throw new InsufficientParametersException(warning);
		}
	}

	public Input pop() {
		return currentInputStack.pop();
	}

	public void printStack() {
		String stack = currentInputStack.toString().replace("[", "").replace("]", "").replaceAll(",", "");
		System.out.println("Stack:" + stack);
	}

	public void push(CalculatorNumberInput inputToken) throws InsufficientParametersException {
		currentInputStack.push(inputToken);
	}

	public String getStack() {
		return currentInputStack.toString().replace("[", "").replace("]", "").replaceAll(",", "");

	}

	public void undo() throws InsufficientParametersException {

		if (inputHistory.size() > 1) {
			currentInputStack = new Stack<>();

			inputHistory.removeLast();
			inputHistory.removeLast();

			LinkedList<Input> input = (LinkedList<Input>) inputHistory.clone();

			inputHistory = new LinkedList<>();
			for (Input inputToken : input) {
				handleInput(inputToken);
			}
		} else if (inputHistory.size() == 1) {
			inputHistory.removeLast();
			System.out.println("No more operations to undo:");
			printStack();
		}
	}
}
