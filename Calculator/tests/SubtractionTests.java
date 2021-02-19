import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class SubtractionTests {

	Calculator calculator;
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
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
	
	@Test
	public void subtractionWithCustomDelimiter() {
		assertEquals(-8, calculator.subtract("//;\n1;9"));
	}
	
	@Test
	public void checkIfExceptionOccurred() {
		exceptionRule.expect(RuntimeException.class);
		exceptionRule.expectMessage("Negetive number not allowed : -1");
		calculator.subtract("-1,2,3");
	}

	@Test
	public void subtractionWithNumberGreaterThan1000() {
		assertEquals(2, calculator.subtract("2,1002"));
	}
	
	@Test
	public void multipleLengthDelimiter() {
		assertEquals(5, calculator.add("//[***]\n2***3"));
	}
	
	@Test
	public void multipleDelimiters() {
		assertEquals(6, calculator.add("//[*][%]\n1*2%3"));
	}
	
	@After
	public void tearDown() {
		calculator = null;
	}
}
