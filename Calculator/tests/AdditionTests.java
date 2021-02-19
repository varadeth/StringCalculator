import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class AdditionTests {
	
	Calculator calculator;
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
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
	
	@Test
	public void additionWithAnyNumber() {
		assertEquals(21, calculator.add("1,2,3,4,5,6"));
	}

	@Test
	public void additionWithAnotherDelimiter() {
		assertEquals(5, calculator.add("2\n3"));
	}
	
	@Test
	public void additionWithCommaAndNewlineDelimiter() {
		assertEquals(6, calculator.add("1,2\n3"));
	}
	
	@Test
	public void additionWithCustomDelimiter() {
		assertEquals(10, calculator.add("//;\n1;9"));
	}
	
	@Test
	public void checkIfExceptionOccurred() {
		exceptionRule.expect(RuntimeException.class);
		exceptionRule.expectMessage("Negetive number not allowed : -1");
		calculator.add("-1,2,3");
	}
	
	@Test
	public void additionWithNumberGreaterThan1000() {
		assertEquals(2, calculator.add("2,1002"));
	}
	
	@Test
	public void multipleLengthDelimiter() {
		assertEquals(5, calculator.add("//[***]\n2***3"));
	}
	
	@Test
	public void multipleDelimiters() {
		assertEquals(6, calculator.add("//[*][%]\n1*2%3"));
	}
	
	@After()
	public void tearDown() {
		calculator = null;
	}
}
