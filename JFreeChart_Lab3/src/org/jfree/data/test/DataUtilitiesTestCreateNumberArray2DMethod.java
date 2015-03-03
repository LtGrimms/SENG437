package org.jfree.data.test;

/*
 * cannot bring loop coverage to %100 since it is impossible to 
 * create a 2D array with length 0
 */

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class DataUtilitiesTestCreateNumberArray2DMethod extends DataUtilities {

	private Number[][] result;
	private double[][] data;
	
	public DataUtilitiesTestCreateNumberArray2DMethod() {
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		data = new double[2][2];
		for (int i = 0; i < data.length; i++) 
			for (int j = 0; j < data[0].length; j++) {
				data[i][j] = i + j;
			}
		
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testValidAndInitiallizedDataStructure() {
		double[][] data2 = {{0,1},{1,2}};
		Number[][] result = DataUtilities.createNumberArray2D(data2);
		Number[][] expected = {{0.0,1.0},{1.0,2.0}};
		assertArrayEquals("tried a valid 2x2 double array with sums of indices as entries", expected, result);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidDataStructure() {
		data = null;
		Number[][] result = DataUtilities.createNumberArray2D(data);
		assertNull("tried to pass in a null double array", result);
	}
	
	@Test
	public void testOneElementArray() {
		data = new double[1][1];
		data[0][0] = 1;
		Number[][] expected = {{1.0}};
		result = DataUtilities.createNumberArray2D(data);
		assertArrayEquals("tried to pass in a 2D array with one element", expected, result);
	}
	
	@Test
	public void testUninitiallizedElementArray() {
		// There really is no such thing as an unititlalized primitive in java...
		data = new double[1][1];
		Number[][] expected = {{0.0}};
		result = DataUtilities.createNumberArray2D(data);
		assertArrayEquals("tried to pass in an uninitiallized 2D array", expected, result);
	}
	
	@Test
	public void testZeroElementArray() {
		double[][] data = {{}};
		result = DataUtilities.createNumberArray2D(data);
		Number[][] expected = {{}};
		assertArrayEquals("tried to pass in {{}} as input", expected, result);
	}

}
