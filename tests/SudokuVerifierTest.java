import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class SudokuVerifierTest {

//implement tests to test Sudokuverifier with boundary values.  Use templates from Task 1 to derive and document test cases.
	
SudokuVerifier v = new SudokuVerifier();

Map<String,String> testCaseInputs = new HashMap<String,String>();

{
	testCaseInputs.put("TC1","417369825632158947958724316825437169791586432346912758289643571573291684164875293");
	testCaseInputs.put("TC2","1417369825632158947958724316825437169791586432346912758289643571573291684164875293");
	testCaseInputs.put("TC3","41736982563215894795872431682543716979158643234691275828964357157329168416487529");
	testCaseInputs.put("TC4","a17369825632158947958724316825437169791586432346912758289643571573291684164875293");
	testCaseInputs.put("TC5","017369825632158947958724316825437169791586432346912758289643571573291684164875293");
	testCaseInputs.put("TC6","447369825632158947958724316825437169791586432346912758289643571573291684164875293");
	testCaseInputs.put("TC7","417469825632158947958723316825437169791586432346912758289643571573291684164875293");
	testCaseInputs.put("TC8","417369825632158947958724316825437169791586432346912758289643571573291684461875293");
	testCaseInputs.put("TC9","4ı7369825632158947958724316825437169791586432346912758289643571573291684461875293");
}

	
	@Test
	public void testCorrectString() {
		int a = v.verify(testCaseInputs.get("TC1"));
		assertEquals("correct string", a, 0);
	}
	
	@Test
	public void TestTooLongString() {
		int a = v.verify(testCaseInputs.get("TC2"));
		assertEquals("correct string", a, -1);
	}
	
	@Test
	public void TestTooShortString() {
		int a = v.verify(testCaseInputs.get("TC3"));
		assertEquals("correct string", a, -1);
	}
	
	@Test
	public void testNonNumericCharString() {
		int a = v.verify(testCaseInputs.get("TC4"));
		assertEquals("correct string", a, 1);
	}
	
	@Test
	public void testZeroInString() {
		int a = v.verify(testCaseInputs.get("TC5"));
		assertEquals("correct string", a, -1);
	}
	
	@Test
	public void testDoublicateInSubGrid() {
		int a = v.verify(testCaseInputs.get("TC6"));
		assertEquals("correct string", a, -2);
	}
	
	@Test
	public void testDoublicateInGlobalRow() {
		int a = v.verify(testCaseInputs.get("TC7"));
		assertEquals("correct string", a, -3);
	}
	
	@Test
	public void testDoublicateInGlobalColumn() {
		int a = v.verify(testCaseInputs.get("TC8"));
		assertEquals("correct string", a, -4);
	}

	@Test
	public void testSpecialUnicodeInString() {
		int a = v.verify(testCaseInputs.get("TC9"));
		assertEquals("correct string", a, 1);
	}
}
