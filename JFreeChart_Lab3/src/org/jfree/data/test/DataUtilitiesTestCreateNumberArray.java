package org.jfree.data.test;

import org.junit.*;
import org.junit.rules.ExpectedException;
import org.jfree.data.DataUtilities;

import junit.framework.TestCase;

public class DataUtilitiesTestCreateNumberArray extends TestCase {
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	public DataUtilitiesTestCreateNumberArray(String name) {
		super(name);
	}

	@Before
	protected void setUp() throws Exception {
		super.setUp();
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	
	@Test//(expected = NullPointerException.class) 
	public void testValidInitializedInput(){
		double [] input = {9.3,0.4,1,4,5.5};
		Number [] expected = {9.3,0.4,1,4,5.5};
		Number [] output = DataUtilities.createNumberArray(input);
		
		Boolean result = true;		
		for(int i = 0; (i < output.length) && result; i++){
					
			if(output[i].doubleValue() != expected[i].doubleValue()){
				result = false;
			}
		}
		
		assertTrue("Test valid input", result);	
		//Dont know why this is an error and not a failure
	}
	
	@Test //(expected = IllegalArgumentException.class)
	public void testInvalidDataStructure(){
		double[] input = null;
		
		try{
			Number[] output = DataUtilities.createNumberArray(input);
			fail("should've thrown an exception");
		}catch (IllegalArgumentException expected){
			
		}

	}
	
	@Test
	public void testEmptyDataStructure(){
		double [] input = { };
		Number[] output = DataUtilities.createNumberArray(input);
		int ExpectedArrayLength = 0;
		
		assertEquals("Test empty data structure", ExpectedArrayLength, output.length);	
		
	}
	
	@Test
	public void testOneElementArray() {
		double[] input = {1};
		Number[] expected = {1};
		Number[] output = DataUtilities.createNumberArray(input);
		
		Boolean result = true;		
		for(int i = 0; (i < output.length) && result; i++){
					
			if(output[i].doubleValue() != expected[i].doubleValue()){
				result = false;
			}
		}
		
		assertTrue("Test valid input", result);	

//		assertEquals("Testing conversion of a one element Array into a Number Array", expected, output);
		//Dont know why this is an error and not a failure or pass
	}
}
