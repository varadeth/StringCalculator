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
	
	@After
	public void tearDown() {
		calculator = null;
	}
}
