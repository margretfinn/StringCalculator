package is.ru.stringcalc;

import static org.junit.Assert.assertEquals;
import org.junit.Test; 

public class CalculatorTest {

	@Test 
	public void testEmptyString () {
		assertEquals(0, Calculator.add("")); 
	}

	@Test 
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1")); 
	}

	@Test 
	public void testTwoNumber() {
		assertEquals(3, Calculator.add("1,2")); 
	}

	@Test 
	public void testMuliplesNumbers() {
		assertEquals(6, Calculator.add("1,2,3")); 
	}

	@Test 
	public void testingLines() {
		assertEquals(3, Calculator.add("1\n2")); 
	}

	@Test 
	public void testingLinesAndCommas() {
		assertEquals(6, Calculator.add("1\n2,3")); 
	}


	@Test (expected = RuntimeException.class) 
	public void testingNegNumbers() {
		assertEquals("Negatives not allowed: -1", Calculator.add("-1,2"));; 
	}

	@Test (expected = RuntimeException.class) 
	public void testingMultipleNegNumbers() {
		assertEquals("Negatives not allowed: -4,-5", Calculator.add("-2,-4,3,-5"));; 
	}

	@Test
	public void ignoringThousand() {
		assertEquals( 2, Calculator.add("1001,2"));; 
	}

	@Test
	public void testingDelimters() {
		assertEquals( 3, Calculator.add("//;\n1;2")); 
	}



} 