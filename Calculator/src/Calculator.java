import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

	public int add(String stringOfNumbers) {
		if(stringOfNumbers.equals(""))
			return 0;
		int[] numbers = convertToIntArray(stringOfNumbers);
		throwExceptionForNegetiveNumbers(numbers);
		return this.sumOfNumbers(numbers);
	}

	private void throwExceptionForNegetiveNumbers(int[] numbers) {
		String negetiveNumbers = "";
		for(int x : numbers) {
			if(x < 0) {
				negetiveNumbers += x + " ";
			}
		}
		if(!negetiveNumbers.equals("")) {
			throw new RuntimeException("Negetive number not allowed : " + negetiveNumbers);
		}
	}

	private int[] convertToIntArray(String stringOfNumbers) {
		String[] tokens = getStringTokens(stringOfNumbers);
		int[] numbers = Arrays.stream(tokens).mapToInt(Integer::parseInt).toArray();
		return numbers;
	}

	private String[] getStringTokens(String stringOfNumbers) {
		if(stringOfNumbers.startsWith("//[")) {
			String delimiter = getDelimiter(stringOfNumbers);
			String numbers = stringOfNumbers.substring(5 + delimiter.length());
			while(numbers.contains(delimiter)) {
				numbers = numbers.replace(delimiter, "#");
			}
			return numbers.split("#");
		}
		if(stringOfNumbers.startsWith("//")) {
			Pattern pattern = Pattern.compile("//(.)\n(.*)");
			Matcher match = pattern.matcher(stringOfNumbers);
			if(match.matches()) {
				String customDelimiter = match.group(1);
				String listOfNumbers = match.group(2);
				return listOfNumbers.split(customDelimiter);
			}
		}
		String[] tokens = stringOfNumbers.split(",|\n");
		return tokens;
	}
	
	private String getDelimiter(String numbers) {
		String delimiter = "";
		char[] chrs = numbers.toCharArray();
		int i = 0;
		boolean flg = false;
		for(i = 0; i < chrs.length; i++) {
			if(chrs[i] == '[') {
				flg = true;
			}
			else if(chrs[i] == ']') {
				flg = false;
				break;
			}
			else if(flg == true) {
				delimiter += chrs[i];
			}
		}
		return delimiter;
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
