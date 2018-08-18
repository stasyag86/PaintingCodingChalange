package org.springerNature.example;

import org.springerNature.cordinates.InputCordinates;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AppTest extends TestCase
{
	public void testGetInputCordinatesForCanvas(){
    	String [] splitedInput = {"C","20","4"};
    	InputCordinates inputCordinates = App.getInputCordinates(splitedInput);
    	assertEquals(20, inputCordinates.getX1());
    	assertEquals(4, inputCordinates.getY1());
    }
	
    public void testGetInputCordinatesForLine(){
    	String [] splitedInput = {"L","1","2","6","2"};
    	InputCordinates inputCordinates = App.getInputCordinates(splitedInput);
    	assertEquals(0, inputCordinates.getX1());
    	assertEquals(1, inputCordinates.getY1());
    	assertEquals(5, inputCordinates.getX2());
    	assertEquals(1, inputCordinates.getY2());
    }
    
    public void testGetInputCordinatesForFillArea(){
    	String [] splitedInput = {"B","10","3","o"};
    	InputCordinates inputCordinates = App.getInputCordinates(splitedInput);
    	assertEquals(9, inputCordinates.getX1());
    	assertEquals(2, inputCordinates.getY1());
    	assertEquals("o", inputCordinates.getColor());
    }
    
    public void testIsExitProgram(){
    	boolean exitProgram = App.isExitProgram("Q");
    	assertTrue(exitProgram);
    }
}
