import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SubtractionTests {

	Calculator calculator;
	
	@Test
	public void test() {
		calculator = new Calculator();
		calculator.subtract("");
	}

}
