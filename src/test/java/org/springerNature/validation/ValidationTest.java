package org.springerNature.validation;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import junit.framework.TestCase;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ValidationTest extends TestCase{
	
	private ValidateInput validateInput = new ValidateInput(); 
		
	@Test
	public void testIsEmptyString(){
		boolean emptyString = validateInput.isEmptyString("");
		boolean notEmtyString = validateInput.isEmptyString("some text");
		assertTrue(emptyString);
		assertFalse(notEmtyString);
	}
	
	@Test
	public void testUnValidInput(){
		boolean notValidCommand = validateInput.isValidInput("D 20 4");
		assertFalse(notValidCommand);
	}
	
	@Test
	public void testIsValidCanvas(){
		String[] splitedValidInput = getInputAsArray("C 20 4");
		boolean validCanvas = validateInput.isValidCanvas(splitedValidInput);
		assertTrue(validCanvas);
		
		String[] splitedNotValidInput_01 = getInputAsArray("C -5 4");
		boolean notValidCanvas = validateInput.isValidCanvas(splitedNotValidInput_01);
		assertFalse(notValidCanvas);
		
		String[] splitedNotValidInput_02 = getInputAsArray("C 8");
		boolean notValidCanvas_02 = validateInput.isValidCanvas(splitedNotValidInput_02);
		assertFalse(notValidCanvas_02);
		
	}
	
	@Test
	public void testIsValidLine(){
		String[] splitedValidInput = getInputAsArray("L 1 2 6 2");
		boolean validLine = validateInput.isValidLine(splitedValidInput);
		System.out.println("validLine: " + validLine);
		assertTrue(validLine);
		
		String[] splitedNotValidInput_01 = getInputAsArray("L 1 -4 6 2");
		boolean notValidLine_01 = validateInput.isValidLine(splitedNotValidInput_01);
		assertFalse(notValidLine_01);
		
		String[] splitedNotValidInput_02 = getInputAsArray("L 1 4 6");
		boolean notValidLine_02 = validateInput.isValidLine(splitedNotValidInput_02);
		assertFalse(notValidLine_02);
		
		String[] splitedNotValidInput_03 = getInputAsArray("L 1 4 6 G");
		boolean notValidLine_03 = validateInput.isValidLine(splitedNotValidInput_03);
		assertFalse(notValidLine_03);
	}
	
	@Test
	public void testIsValidFillArea(){
		String[] splitedValidInput = getInputAsArray("C 1 2 o");
		boolean validFillArea = validateInput.isValidFillArea(splitedValidInput);
		assertTrue(validFillArea);
		
		String[] splitedNotValidInput_01 = getInputAsArray("C 10 5 kkk");
		boolean notValidFillArea_01 = validateInput.isValidFillArea(splitedNotValidInput_01);
		assertFalse(notValidFillArea_01);
	}
	
	private String[] getInputAsArray(String text){
		return text.split("\\s+");
	}
}
