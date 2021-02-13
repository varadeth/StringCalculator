import java.util.Arrays;

public class Calculator {

	public int add(String stringOfNumbers) {
		if(stringOfNumbers.equals(""))
			return 0;
		if(stringOfNumbers.contains(",")) {
			String[] tokens = stringOfNumbers.split(",");
			int[] numbers = Arrays.stream(tokens).mapToInt(Integer::parseInt).toArray();
			return this.sumOfNumbers(numbers);
		}
		return 1;
	}
	
	public int sumOfNumbers(int[] numbers) {
		int sum = 0;
		for(int number: numbers) {
			sum += number;
		}
		return sum;
	}
}
