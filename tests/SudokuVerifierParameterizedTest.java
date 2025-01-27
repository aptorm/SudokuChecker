import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

@RunWith(Parameterized.class)
public class SudokuVerifierParameterizedTest {
	//Voluntary - implement tests as Parameterized tests:
	
	//text tutorial: https://www.tutorialspoint.com/junit/junit_parameterized_test.htm
	//video tutorial: https://www.youtube.com/watch?v=ryBetrexwt4
	
	
	//implement and document tests to test Sudokuverifier with boundary values. Use templates from Task 1 to derive and document test cases.
	
	// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
	// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891
	
	private SudokuVerifier verifier = new SudokuVerifier();
	private String testString;
	private int expectedResult;
	
	
	//collection of test data with inputs (testString) and expected results
	@Parameters
	   public static Collection<Object[]> data() {
	      return Arrays.asList(new Object[][] {
	         { "417369825632158947958724316825437169791586432346912758289643571573291684164875293", 0},		// base truth
	         { "1417369825632158947958724316825437169791586432346912758289643571573291684164875293", -1},	// too long string
	         { "41736982563215894795872431682543716979158643234691275828964357157329168416487529", -1},		// too short string
	         { "a17369825632158947958724316825437169791586432346912758289643571573291684164875293", 1},		// non-numberic char
	         { "017369825632158947958724316825437169791586432346912758289643571573291684164875293", -1},	// 0 not in [1,9]
	         { "447369825632158947958724316825437169791586432346912758289643571573291684164875293", -2},	// doublicate in sub grid
	         { "417469825632158947958723316825437169791586432346912758289643571573291684164875293", -3},	// global row
	         { "417369825632158947958724316825437169791586432346912758289643571573291684461875293", -4},	// global column
	         { "4ı7369825632158947958724316825437169791586432346912758289643571573291684461875293", 1},  	// special unicode character ı
	      });
	   }
	
	//test class constructor
	public SudokuVerifierParameterizedTest(String testString, int expectedResult) {
	      this.testString = testString;
	      this.expectedResult = expectedResult;
	   }
	
	
	@Test
	public void returnCorrect() {
		int returnNumber = verifier.verify(testString);
		System.out.println(returnNumber + ":::" + expectedResult);
		assertEquals(returnNumber, expectedResult);
	}

}
