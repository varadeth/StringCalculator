import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTests {
	
	Calculator calculator;
	
	@Before()
	public void setup() {
		calculator = new Calculator();
	}

	@Test
	public void additionWithEmptyString() {
		assertEquals(0, calculator.add(""));
	}
	
	@Test
	public void additionWithOneNumber() {
		assertEquals(1, calculator.add("1"));
	}
	
	@Test
	public void additionWithTwoNumber() {
		assertEquals(5, calculator.add("2,3"));
	}
	
	@Test
	public void additionWithThreeNumber() {
		assertEquals(12, calculator.add("3,4,5"));
	}

	@After()
	public void tearDown() {
		calculator = null;
	}
}
