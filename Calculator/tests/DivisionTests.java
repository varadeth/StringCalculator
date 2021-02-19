import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DivisionTests {

	Calculator calculator;
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
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
	
	@Test
	public void divisionWithAnotherDelimiter() {
		assertEquals(0, calculator.divide("2\n3"));
	}
	
	@Test
	public void divisionWithTwoDelimiter() {
		assertEquals(1, calculator.divide("4\n3,1"));
	}
	
	@Test
	public void divisionWithCustomDelimiter() {
		assertEquals(10, calculator.divide("//;\n90;9"));
	}

	@Test
	public void checkIfExceptionOccurred() {
		exceptionRule.expect(RuntimeException.class);
		exceptionRule.expectMessage("Negetive number not allowed : -1");
		calculator.divide("-1,2,3");
	}
	
	@After()
	public void tearDown() {
		calculator = null;
	}
	
}
