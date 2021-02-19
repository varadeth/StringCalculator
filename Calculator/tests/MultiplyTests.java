import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MultiplyTests {

	Calculator calculator;
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
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
	
	@Test
	public void multiplyWithCustomDelimiter() {
		assertEquals(9, calculator.multiply("//;\n1;9"));
	}
	
	@Test
	public void checkIfExceptionOccurred() {
		exceptionRule.expect(RuntimeException.class);
		exceptionRule.expectMessage("Negetive number not allowed : -1");
		calculator.multiply("-1,2,3");
	}
	
	@Test
	public void multiplyWithNumberGreaterThan1000() {
		assertEquals(2, calculator.multiply("2,1002"));
	}
	
	@Test
	public void multipleLengthDelimiter() {
		assertEquals(6, calculator.multiply("//[***]\n2***3"));
	}
	
	@After
	public void tearDown() {
		calculator = null;
	}
}
