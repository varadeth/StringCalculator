import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

	public int add(String stringOfNumbers) {
		if(stringOfNumbers.equals(""))
			return 0;
		int[] numbers = CalculatorUtils.convertToIntArray(stringOfNumbers);
		CalculatorUtils.throwExceptionForNegetiveNumbers(numbers);
		return this.sumOfNumbers(numbers);
	}
	
	public int subtract(String stringOfNumbers) { 
		if(stringOfNumbers.equals("")) {
			return 0;
		}
		int[] numbers = CalculatorUtils.convertToIntArray(stringOfNumbers);
		CalculatorUtils.throwExceptionForNegetiveNumbers(numbers);
		return this.differenceOfNumbers(numbers);
	}
	
	public int multiply(String stringOfNumbers) {
		if(stringOfNumbers.equals("")) {
			return 0;
		}
		if(stringOfNumbers.contains(",") || stringOfNumbers.contains("\n")) {
			int[] numbers = CalculatorUtils.convertToIntArray(stringOfNumbers);
			return this.multiplyNumbers(numbers);
		}
		return Integer.parseInt(stringOfNumbers);
	}

	private int multiplyNumbers(int[] numbers) {
		int result = 1;
		for(int number: numbers) {
			result *= number;
		}
		return result;
	}

	private int differenceOfNumbers(int[] numbers) {
		int diff = numbers[0];
		for(int i=1; i < numbers.length; i++) {
			if(numbers[i] < 1000) 
				diff -= numbers[i];
		}
		return diff;
	}

	public int sumOfNumbers(int[] numbers) {
		int sum = 0;
		for(int number: numbers) {
			if(number < 1000)
				sum += number;
		}
		return sum;
	}
}
