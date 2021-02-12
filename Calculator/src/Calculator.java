public class Calculator {

	public int add(String stringOfNumbers) {
		if(stringOfNumbers.equals(""))
			return 0;
		return Integer.parseInt(stringOfNumbers);
	}
	
}
