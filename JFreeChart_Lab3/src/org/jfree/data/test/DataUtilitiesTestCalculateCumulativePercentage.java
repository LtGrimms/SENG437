package org.jfree.data.test;


import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.KeyedValues;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
//import org.jmock.Mockery;
import org.junit.BeforeClass;
//import org.jmock.integration.junit3.MockObjectTestCase;
//import org.jmock.Expectations;
import org.junit.Test;

public class DataUtilitiesTestCalculateCumulativePercentage {
	
	private DefaultKeyedValues values;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Before
	public void setUp() throws Exception {
		values = new DefaultKeyedValues();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test 
	public void testcalculateCumulativePercentage() {
		
		Comparable<Integer> thing0 = 0;
		Comparable<Integer> thing1 = 1;
		Comparable<Integer> thing2 = 2;
		values.addValue(thing0, 5);
		values.addValue(thing1, 9);
		values.addValue(thing2, 2);
		
		/*Mockery mockingContext = new Mockery();
		final KeyedValues values = mockingContext.mock(KeyedValues.class);
		mockingContext.checking(new Expectations()
		{
			{
				one(values).getKey(0);
				will(returnValue(5));
				one(values).getKey(1);
				will(returnValue(9));
				one(values).getKey(2);
				will(returnValue(2));
			}
		});*/
		KeyedValues result = DataUtilities.getCumulativePercentages(values);
		assertEquals("The expected value of row 1 should be 0.3125.", 0.3125, (Double) result.getValue(thing0), .000000001d);
		assertEquals("The expected value of row 2 should be 0.875.", 0.875, (Double) result.getValue(thing1), .000000001d);
		assertEquals("The expected value of row 3 should be 1.0.", 1.0, (Double) result.getValue(thing2), .000000001d);
		// cleanup
		values = new DefaultKeyedValues();
	}
	@Test public void testcalculateCumulativePercentageAllNegValues1() {
		
		Comparable<Integer> thing0 = 0;
		Comparable<Integer> thing1 = 1;
		Comparable<Integer> thing2 = 2;
		values.addValue(thing0, -5);
		values.addValue(thing1, -9);
		values.addValue(thing2, -2);
		
		/*Mockery mockingContext = new Mockery();
		final KeyedValues values = mockingContext.mock(KeyedValues.class);
		mockingContext.checking(new Expectations()
		{
			{
				one(values).getKey(0);
				will(returnValue(-5));
				one(values).getKey(1);
				will(returnValue(-9));
				one(values).getKey(2);
				will(returnValue(-2));
			}
		});*/
		KeyedValues result = DataUtilities.getCumulativePercentages(values);
		assertEquals("The expected value of row 1 should be 0.3125.", 0.3125, (Double) result.getValue(thing0), .000000001d);
		assertEquals("The expected value of row 2 should be 0.875.", 0.875, (Double) result.getValue(thing1), .000000001d);
		assertEquals("The expected value of row 3 should be 1.0.", 1.0, (Double) result.getValue(thing2), .000000001d);
		// cleanup
		values = new DefaultKeyedValues();
	}
	@Test public void testcalculateCumulativePercentageSomeNegValues() {
		
		Comparable<Integer> thing0 = 0;
		Comparable<Integer> thing1 = 1;
		Comparable<Integer> thing2 = 2;
		values.addValue(thing0, -5);
		values.addValue(thing1, 9);
		values.addValue(thing2, -2);
		
		/*Mockery mockingContext = new Mockery();
		final KeyedValues values = mockingContext.mock(KeyedValues.class);
		mockingContext.checking(new Expectations()
		{
			{
				one(values).getKey(0);
				will(returnValue(-5));
				one(values).getKey(1);
				will(returnValue(9));
				one(values).getKey(2);
				will(returnValue(-2));
			}
		});*/
		KeyedValues result = DataUtilities.getCumulativePercentages(values);
		assertEquals("The expected value of row 1 should be 0.3125.", 0.3125, (Double) result.getValue(thing0), .000000001d);
		assertEquals("The expected value of row 2 should be 0.875.", 0.875, (Double) result.getValue(thing1), .000000001d);
		assertEquals("The expected value of row 3 should be 1.0.", 1.0, (Double) result.getValue(thing2), .000000001d);
		// cleanup
		values = new DefaultKeyedValues();
	}
}
