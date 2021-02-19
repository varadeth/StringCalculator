import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorUtils {
	public static void throwExceptionForNegetiveNumbers(int[] numbers) {
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

	public static int[] convertToIntArray(String stringOfNumbers) {
		String[] tokens = getStringTokens(stringOfNumbers);
		int[] numbers = Arrays.stream(tokens).mapToInt(Integer::parseInt).toArray();
		return numbers;
	}

	public static String[] getStringTokens(String stringOfNumbers) {
		if(stringOfNumbers.startsWith("//[")) {
			return tokensFromAnyLengthDelimiter(stringOfNumbers);
		}
		if(stringOfNumbers.startsWith("//")) {
			return tokenFromAnyDelimiter(stringOfNumbers);
		}
		String[] tokens = stringOfNumbers.split(",|\n");
		return tokens;
	}

	public static String[] tokensFromAnyLengthDelimiter(String stringOfNumbers) {
		ArrayList<String> delimiters = getDelimiter(stringOfNumbers);
		int delimiterLength = getDelimiterLength(delimiters);
		String numbers = getNumbersFromString(stringOfNumbers, delimiterLength);
		numbers = replaceDelimiterByHash(delimiters, numbers);
		return numbers.split("#");
	}

	public static int getDelimiterLength(ArrayList<String> delimiters) {
		int delimiterLength = 0;
		boolean isMultipleDelimitersPresent = delimiters.size() > 1? true : false;
		for(String delimiter: delimiters) {
			delimiterLength += delimiter.length();
		}
		delimiterLength = isMultipleDelimitersPresent ? delimiterLength + 2 : delimiterLength;
		return delimiterLength;
	}

	public static String getNumbersFromString(String stringOfNumbers, int delimiterLength) {
		return stringOfNumbers.substring(5 +  delimiterLength);
	}

	public static String replaceDelimiterByHash(ArrayList<String> delimiters, String numbers) {
		for(String delimiter: delimiters) {
			while(numbers.contains(delimiter)) {
				numbers = numbers.replace(delimiter, "#");
			}
			numbers.replace(delimiter, ""+'#');
		}
		return numbers;
	}

	public static String[] tokenFromAnyDelimiter(String stringOfNumbers) {
		Pattern pattern = Pattern.compile("//(.)\n(.*)");
		Matcher match = pattern.matcher(stringOfNumbers);
		if(match.matches()) {
			String customDelimiter = match.group(1);
			String listOfNumbers = match.group(2);
			return listOfNumbers.split(customDelimiter);
		}
		return new String[] {""};
	}
	
	public static ArrayList<String> getDelimiter(String numbers) {
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
}
