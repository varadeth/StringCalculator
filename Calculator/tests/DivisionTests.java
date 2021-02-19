import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DivisionTests {

	Calculator calculator;
	
	@Before()
	public void setup() {
		calculator = new Calculator();
	}
	
	@Test
	public void divisionWithEmptyString() {
		assertEquals(0 ,calculator.divide(""));
	}
	
	@Test
	public void divisionWithOneNumberString() {
		assertEquals(1 ,calculator.divide("1"));
	}
	
	@After()
	public void tearDown() {
		calculator = null;
	}
	
}
