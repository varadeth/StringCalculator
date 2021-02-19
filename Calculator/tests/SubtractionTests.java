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
	public void subtractionWithOneNumber() {
		assertEquals(1, calculator.subtract("1"));
	}
	
	@Test
	public void subtractionWithTwoNumbers() {
		assertEquals(1, calculator.subtract("2,1"));
	}
	
	@Test
	public void subtractionWithThreeNumber() {
		assertEquals(-6, calculator.subtract("3,4,5"));
	}
	
	@Test
	public void subtractionWithAnyNumber() {
		assertEquals(-19, calculator.subtract("1,2,3,4,5,6"));
	}
	
	@Test
	public void subtractionWithAnotherDelimiter() {
		assertEquals(-1, calculator.subtract("2\n3"));
	}
	
	@Test
	public void subtractionWithCommaAndNewlineDelimiter() {
		assertEquals(-4, calculator.subtract("1,2\n3"));
	}
	
	@After
	public void tearDown() {
		calculator = null;
	}
}
