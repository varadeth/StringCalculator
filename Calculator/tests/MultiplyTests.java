import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MultiplyTests {

	Calculator calculator;
	
	@Before
	public void setup() { 
		calculator = new Calculator();
	}
	
	@Test
	public void multipleWithEmptyString() {
		assertEquals(0, calculator.multiply(""));
	}
	
	@Test
	public void multipleWithOneNumber() {
		assertEquals(10, calculator.multiply("10"));
	}
	
	@Test
	public void multipleWithTwoNumber() {
		assertEquals(20, calculator.multiply("2,10"));
	}
	
	@Test
	public void multipleWithThreeNumber() {
		assertEquals(40, calculator.multiply("2,10,2"));
	}
	
	@Test
	public void multiplyWithAnyNumber() {
		assertEquals(720, calculator.multiply("2,3,4,5,6"));
	}
	
	@Test
	public void multiplyWithAnotherDelimiter() {
		assertEquals(6, calculator.multiply("2\n3"));
	}
	
	@Test
	public void multiplyWithCommaAndNewlineDelimiter() {
		assertEquals(6, calculator.multiply("1,2\n3"));
	}
	
	@After
	public void tearDown() {
		calculator = null;
	}
}
