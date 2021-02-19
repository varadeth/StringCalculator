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
	
	@Test
	public void divisionWithTwoNumberString() {
		assertEquals(2 ,calculator.divide("5,2"));
	}
	
	@Test
	public void divisionWithThreeNumberString() {
		assertEquals(1 ,calculator.divide("5,2,2"));
	}
	
	@Test
	public void divisionWithAnyNumberString() {
		assertEquals(1 ,calculator.divide("10,2,2,2"));
	}
	
	@After()
	public void tearDown() {
		calculator = null;
	}
	
}
