package com.calculator.rpn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

import com.calculator.rpn.exceptions.CalculatorParseException;
import com.calculator.rpn.operations.CalculatorOperator;

public class CalculatorParser {
	public Queue<Input> parse(String inputParse) throws CalculatorParseException {
		String[] inputs = inputParse.split("\\s+");
		Queue<Input> inputQueue = new LinkedList<>();

		for (String input : inputs) {
			inputQueue.add(parseValue(input.trim()));
		}

		return inputQueue;
	}

	Optional<CalculatorNumberInput> parseNumber(String number) {
		try {
			return Optional.of(new CalculatorNumberInput(number));
		} catch (NumberFormatException numberFormatException) {
			return Optional.empty();
		}
	}

	Optional<CalculatorOperator> parseOperator(String inputOperator) {
		return Arrays.stream(CalculatorOperator.values())
				.filter(operator -> operator.getOperator().equalsIgnoreCase(inputOperator)).findAny();
	}

	Input parseValue(String inputToken) throws CalculatorParseException {
		Input input = null;
		Optional<CalculatorNumberInput> number = parseNumber(inputToken);

		if (inputToken.matches("-?\\d+(\\.\\d+)?") && number.isPresent()) {
			input = number.get();
		} else {
			Optional<CalculatorOperator> operator = parseOperator(inputToken);

			if (operator.isPresent()) {
				input = operator.get();
			} else {
				throw new CalculatorParseException(inputToken);
			}
		}

		return input;
	}
}
