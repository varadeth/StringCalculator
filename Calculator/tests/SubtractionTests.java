import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SubtractionTests {

	Calculator calculator;
	
	@Before
	public void setup() {
		calculator = new Calculator();
	}
	
	@Test
	public void test() {
		calculator.subtract("");
	}

	@Test
	public void additionWithOneNumber() {
		assertEquals(1, calculator.subtract("1"));
	}
	
	@Test
	public void additionWithTwoNumbers() {
		assertEquals(1, calculator.subtract("2,1"));
	}
	
	@Test
	public void additionWithThreeNumber() {
		assertEquals(-6, calculator.subtract("3,4,5"));
	}
	
	@Test
	public void additionWithAnyNumber() {
		assertEquals(-19, calculator.subtract("1,2,3,4,5,6"));
	}
	
	@Test
	public void additionWithAnotherDelimiter() {
		assertEquals(-1, calculator.subtract("2\n3"));
	}
	
	@After
	public void tearDown() {
		calculator = null;
	}
}
