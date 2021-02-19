import java.util.ArrayList;
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
	
	public int subtract(String stringOfNumbers) { 
		if(stringOfNumbers.equals("")) {
			return 0;
		}
		if(stringOfNumbers.contains(",")) {
			String[] numbers = stringOfNumbers.split(",");
			return Integer.parseInt(numbers[0]) - Integer.parseInt(numbers[1]);
		}
		return Integer.parseInt(stringOfNumbers);
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
			return tokensFromAnyLengthDelimiter(stringOfNumbers);
		}
		if(stringOfNumbers.startsWith("//")) {
			return tokenFromAnyDelimiter(stringOfNumbers);
		}
		String[] tokens = stringOfNumbers.split(",|\n");
		return tokens;
	}

	private String[] tokensFromAnyLengthDelimiter(String stringOfNumbers) {
		ArrayList<String> delimiters = getDelimiter(stringOfNumbers);
		int delimiterLength = getDelimiterLength(delimiters);
		String numbers = getNumbersFromString(stringOfNumbers, delimiterLength);
		numbers = replaceDelimiterByHash(delimiters, numbers);
		return numbers.split("#");
	}

	private int getDelimiterLength(ArrayList<String> delimiters) {
		int delimiterLength = 0;
		boolean isMultipleDelimitersPresent = delimiters.size() > 1? true : false;
		for(String delimiter: delimiters) {
			delimiterLength += delimiter.length();
		}
		delimiterLength = isMultipleDelimitersPresent ? delimiterLength + 2 : delimiterLength;
		return delimiterLength;
	}

	private String getNumbersFromString(String stringOfNumbers, int delimiterLength) {
		return stringOfNumbers.substring(5 +  delimiterLength);
	}

	private String replaceDelimiterByHash(ArrayList<String> delimiters, String numbers) {
		for(String delimiter: delimiters) {
			while(numbers.contains(delimiter)) {
				numbers = numbers.replace(delimiter, "#");
			}
			numbers.replace(delimiter, ""+'#');
		}
		return numbers;
	}

	private String[] tokenFromAnyDelimiter(String stringOfNumbers) {
		Pattern pattern = Pattern.compile("//(.)\n(.*)");
		Matcher match = pattern.matcher(stringOfNumbers);
		if(match.matches()) {
			String customDelimiter = match.group(1);
			String listOfNumbers = match.group(2);
			return listOfNumbers.split(customDelimiter);
		}
		return new String[] {""};
	}
	
	private ArrayList<String> getDelimiter(String numbers) {
		String delimiter = "";
		ArrayList<String> delimiters = new ArrayList();
		char[] chrs = numbers.toCharArray();
		int i = 0;
		boolean flg = false;
		for(i = 0; i < chrs.length; i++) {
			if(chrs[i] == '[') {
				flg = true;
			}
			else if(chrs[i] == ']') {
				flg = false;
				delimiters.add(delimiter);
				delimiter = "";
			}
			else if(flg == true) {
				delimiter += chrs[i];
			}
		}
		return delimiters;
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
