package es.upm.grise.profundizacion2018.sudokuverifier;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class SudokuVerifierTest {
    
	private SudokuVerifier cl;
	
	@Before
	public void initiate () {
		this.cl = new SudokuVerifier();
	}
	
	@Test
	public void validSudoku() {
    	assertEquals(0, cl.verify(
		  "123"+"678"+"945"
		+ "584"+"239"+"761"
		+ "967"+"145"+"328"
		+ "372"+"461"+"589"
		+ "691"+"583"+"274"
		+ "458"+"792"+"613"
		+ "836"+"924"+"157"
		+ "219"+"857"+"436"
		+ "745"+"316"+"892"));
    }
	
	@Test
	public void tooLong() {
    	assertEquals(-1, cl.verify(
		  "123"+"678"+"945"
		+ "584"+"239"+"761"
		+ "967"+"145"+"328"
		+ "372"+"461"+"589"
		+ "691"+"583"+"274"
		+ "458"+"792"+"613"
		+ "836"+"924"+"157"
		+ "219"+"857"+"436"
		+ "745"+"316"+"8921"));
    }
	
	@Test
	public void notValidNumber() {
    	assertEquals(1, cl.verify(
		  "123"+"678"+"945"
		+ "584"+"239"+"761"
		+ "967"+"145"+"328"
		+ "372"+"461"+"589"
		+ "691"+"583"+"274"
		+ "458"+"792"+"613"
		+ "836"+"924"+"157"
		+ "219"+"857"+"436"
		+ "745"+"316"+"89a"));
    }

	@Test
	public void notValidCell() {
    	assertEquals(2, cl.verify(
		  "126"+"378"+"945"
		+ "584"+"239"+"761"
		+ "967"+"145"+"328"
		+ "372"+"461"+"589"
		+ "691"+"583"+"274"
		+ "458"+"792"+"613"
		+ "836"+"924"+"157"
		+ "219"+"857"+"436"
		+ "745"+"316"+"892"));
    }
	
	@Test
	public void notValidRow() {
    	assertEquals(3, cl.verify(
		  "623"+"678"+"945"
		+ "584"+"239"+"761"
		+ "917"+"145"+"328"
		+ "372"+"461"+"589"
		+ "691"+"583"+"274"
		+ "458"+"792"+"613"
		+ "836"+"924"+"157"
		+ "219"+"857"+"436"
		+ "745"+"316"+"892"));
    }
	
	@Test
	public void notValidColumn() {
    	assertEquals(4, cl.verify(
		  "213"+"678"+"945"
		+ "584"+"239"+"761"
		+ "967"+"145"+"328"
		+ "372"+"461"+"589"
		+ "691"+"583"+"274"
		+ "458"+"792"+"613"
		+ "836"+"924"+"157"
		+ "219"+"857"+"436"
		+ "745"+"316"+"892"));
    }
	
}
