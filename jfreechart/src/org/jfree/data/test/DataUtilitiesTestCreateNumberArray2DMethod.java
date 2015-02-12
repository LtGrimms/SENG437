package org.jfree.data.test;

import org.jfree.data.DataUtilities;
import org.jmock.Mockery;
import org.junit.*;

import junit.framework.TestCase;

public class DataUtilitiesTestCreateNumberArray2DMethod extends TestCase {

	private Number[][] result;
	private double[][] data;
	
	public DataUtilitiesTestCreateNumberArray2DMethod(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		data = new double[2][2];
		for (int i = 0; i < data.length; i++) 
			for (int j = 0; j < data[0].length; j++) {
				data[i][j] = i + j;
			}
		
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	@Test
	public void testValidAndInitiallizedDataStructure() {
		Number[][] result = DataUtilities.createNumberArray2D(data);
		Number[][] expected = {{0,1},{1,2}};
		assertEquals("tried a valid 2x2 double array with sums of indices as entries", expected, result);
		//Dont know why this is an error and not a failure
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidDataStructure() {
		data = null;
		Number[][] result = DataUtilities.createNumberArray2D(data);
		Number[][] expected = null;
		assertEquals("tried to pass in a null double array", expected, result);
		
		/* how do I make this test pass? We are supposed to see an Illegal argument exeption
		 * but it is failing because there is an illegal argument exception even though 
		 * I've told it to expect that
		 */
	}
	
	@Test
	public void testOneElementArray() {
		data = new double[1][1];
		data[0][0] = 1;
		Number[][] expected = {{1}};
		result = DataUtilities.createNumberArray2D(data);
		assertEquals("tried to pass in a 2D array with one element", expected, result);
		//Dont know why this is an error and not a failure
	}
	
	@Test(expected = Exception.class)
	public void testUninitiallizedElementArray() {
		data = new double[1][1];
		Number[][] expected = {{null}};
		result = DataUtilities.createNumberArray2D(data);
		assertEquals("tried to pass in an uninitiallized 2D array", expected, result);
		
		// Not really sure if the expected type should be {{null}} here
		// since it is not specified in the requirments, perhaps we are supposed
		// to see some sort of exception. It's difficult to know when we cannot
		// see the code and it is not in the docs
	}

}
