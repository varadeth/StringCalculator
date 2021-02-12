import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTests {

	@Test
	public void additionWithEmptyString() {
		Calculator calculator = new Calculator();
		assertEquals(0, calculator.add(""));
	}

}
