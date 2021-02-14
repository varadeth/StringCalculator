import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

	public int add(String stringOfNumbers) {
		if(stringOfNumbers.equals(""))
			return 0;
		int[] numbers = convertToIntArray(stringOfNumbers);
		return this.sumOfNumbers(numbers);
	}

	private int[] convertToIntArray(String stringOfNumbers) {
		if(stringOfNumbers.startsWith("//")) {
			Pattern pattern = Pattern.compile("//(.)\n(.*)");
			Matcher match = pattern.matcher(stringOfNumbers);
			if(match.matches()) {
				String customDelimiter = match.group(1);
				String listOfNumbers = match.group(2);
				return Arrays.stream(listOfNumbers.split(customDelimiter)).mapToInt(Integer::parseInt).toArray();
			}
		}
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
