import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTests {

	@Test
	public void additionWithEmptyString() {
		Calculator calculator = createCalculator();
		assertEquals(0, calculator.add(""));
	}
	
	@Test
	public void additionWithOneNumber() {
		Calculator calculator = createCalculator();
		assertEquals(1, calculator.add("1"));
	}
	
	@Test
	public void additionWithTwoNumber() {
		Calculator calculator = createCalculator();
		assertEquals(5, calculator.add("2,3"));
	}

	private Calculator createCalculator() {
		return new Calculator();
	}

}
