import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTests {

	@Test
	public void additionWithEmptyString() {
		Calculator calculator = new Calculator();
		assertEquals(0, calculator.add(""));
	}
	
	@Test
	public void additionWithOneNumber() {
		Calculator calculator = new Calculator();
		assertEquals(1, calculator.add("1"));
	}

}
