import java.util.Arrays;

public class Calculator {

	public int add(String stringOfNumbers) {
		if(stringOfNumbers.equals(""))
			return 0;
		int[] numbers = convertToIntArray(stringOfNumbers);
		return this.sumOfNumbers(numbers);
	}

	private int[] convertToIntArray(String stringOfNumbers) {
		String[] tokens = stringOfNumbers.split(",|\n");
		int[] numbers = Arrays.stream(tokens).mapToInt(Integer::parseInt).toArray();
		return numbers;
	}
	
	public int sumOfNumbers(int[] numbers) {
		int sum = 0;
		for(int number: numbers) {
			sum += number;
		}
		return sum;
	}
}
