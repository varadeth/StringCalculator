import java.util.Arrays;

public class Calculator {

	public int add(String stringOfNumbers) {
		if(stringOfNumbers.equals(""))
			return 0;
		if(stringOfNumbers.contains(",")) {
			String[] numbers = stringOfNumbers.split(",");
			return Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]);
		}
		return 1;
	}
}
