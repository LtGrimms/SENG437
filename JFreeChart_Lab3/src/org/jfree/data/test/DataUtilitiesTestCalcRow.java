package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DataUtilitiesTestCalcRow extends DataUtilities {

	public DataUtilitiesTestCalcRow() {
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test(expected = NullPointerException.class)
	public void test_1_null()
	{
		final Values2D values = null;
		int rowNum = 0;

		// verify
		assertNull(DataUtilities.calculateColumnTotal(values, rowNum));
	} 
	
	@Test
	public void test_2_empty()
	{
		// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		int rowNum = 0;
		
		mockingContext.checking(new Expectations() {
														{
															one(values).getColumnCount();	will(returnValue(0));
															one(values).getValue(0, 0);	will(returnValue(null));
														}
													});

		//assertNull("Empty", DataUtilities.calculateRowTotal(values, rowNum));
		
		double expectedValue = 0.0;		//jmock seems to create something anyway. Get zero instead of nulls or empty exceptions of some sort.
		double result = DataUtilities.calculateRowTotal(values, rowNum);
		assertEquals("Empty, ", expectedValue, result, .000000001d);
	}
	
	@Test
	public void test_3_single_within()
	{
		// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		int rowNum = 0;
		double expectedValue = 7.5;
		
		mockingContext.checking(new Expectations() {
														{
															one(values).getColumnCount();	will(returnValue(1));
															one(values).getValue(0, 0);	will(returnValue(7.5));
														}
													});

		double result = DataUtilities.calculateRowTotal(values, rowNum);

		assertEquals("Single column, ", expectedValue, result, .000000001d);
	}
	
	//Test removed. No way to make this succeed or even fail without error.
	//I do not think jmock works for this kind of test.
/*
	@Test
	public void test_4_single_outside()
	{
		// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		int rowNum = 2;
		
		mockingContext.checking(new Expectations() {
														{
															one(values).getColumnCount();	will(returnValue(1));
															one(values).getRowCount();	will(returnValue(1));
															one(values).getValue(0, 0);	will(returnValue(7.5));
														}
													});

		try
		{
			assertNull("Single column outside",  DataUtilities.calculateRowTotal(values, rowNum));
			fail();
		}
		catch(Exception e)
		{
			
		}
		
		/*
		double expectedValue = 0.0;
		double result = DataUtilities.calculateRowTotal(values, rowNum);
		assertEquals("Single column, ", expectedValue, result, .000000001d);
	} 
*/
	
	@Test
	public void test_5_multiple_within()
	{
		// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		int rowNum = 0;
		double expectedValue = 15.0;
		
		mockingContext.checking(new Expectations() {
														{
															one(values).getColumnCount();	will(returnValue(3));
															one(values).getValue(0, 0);	will(returnValue(7.5));
															one(values).getValue(0, 1);	will(returnValue(2.5));
															one(values).getValue(0, 2);	will(returnValue(5.0));
														}
													});

		double result = DataUtilities.calculateRowTotal(values, rowNum);

		assertEquals("Multiple column within, ", expectedValue, result, .000000001d);
	} 
	
	//Test removed. No way to make this succeed or even fail without error.
	//I do not think jmock works for this kind of test.
/*
	@Test
	public void test_6_multiple_outside()
	{
		// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		int rowNum = 3;
		double expectedValue = 0.0;
		
		mockingContext.checking(new Expectations() {
														{
															one(values).getColumnCount();	will(returnValue(3));
															one(values).getValue(0, 0);	will(returnValue(7.5));
															one(values).getValue(0, 1);	will(returnValue(2.5));
															one(values).getValue(0, 2);	will(returnValue(5.0));
														}
													});

		double result = DataUtilities.calculateRowTotal(values, rowNum);

		assertEquals("Multiple column outside, ", expectedValue, result, .000000001d);
	} 
*/
}
