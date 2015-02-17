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

public class DataUtilitiesTestCalculateColumnTotalMethod extends DataUtilities {

	private Mockery mockingContext;
	
	public DataUtilitiesTestCalculateColumnTotalMethod() {
		//super(name);
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		mockingContext = new Mockery();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void test_1_CalculateColumnTotalForOneValue() {
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
			{
				one(values).getRowCount();
				will(returnValue(1));
				one(values).getValue(0,0);
				will(returnValue(5));
			}
		});
		
		double result = DataUtilities.calculateColumnTotal(values, 0);
		
		assertEquals(result, 5.0, 0.000000001d);
	}
	
	@Test
	public void test_2_CalculateColumnTotalForTwoValues() {
	 final Values2D values = mockingContext.mock(Values2D.class);
	 mockingContext.checking(new Expectations() {
		 {
		 		one(values).getRowCount();
		 		will(returnValue(2)); 
		 		one(values).getValue(0,0); 
		 		will(returnValue(7.5));
		 		one(values).getValue(1, 0);
		 		will(returnValue(2.5));
		 }
	 });
	 
	 double result = DataUtilities.calculateColumnTotal(values, 0);
	 
	 assertEquals(result, 10.0, .000000001d);
	 mockingContext.assertIsSatisfied();
	} 
	
	@Test
	public void test_3_CalculateComumnTotalsOnEmptyValues() {
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
			{
				one(values).getRowCount();
				will(returnValue(0));
				never(values).getValue(0, 0);
			}
		});
		
		//exercise
		double result = DataUtilities.calculateColumnTotal(values,  0);
		
		mockingContext.assertIsSatisfied();
		assertEquals("calculate column totals on a 0x0 2D array", 0.0, result, .000000001d);
	}
	
	@Test
	public void test_4_CalculateColumnTotalsWithNullColumnValue() {
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
			{
				one(values).getRowCount();
				will(returnValue(3));
				one(values).getValue(0, 0);
				will(returnValue(null));
				one(values).getValue(1, 0);
				will(returnValue(null));
				one(values).getValue(2, 0);
				will(returnValue(null));
			}
		});
		
		double result = DataUtilities.calculateColumnTotal(values, 0);
		
		mockingContext.assertIsSatisfied();
		assertEquals("tried adding three elemetns with null values, expected " + 0 + " recieved " + result, 0, result, .000000001d);
		//We cannot expect a null here, doubles can't be null
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_5_CalculateColumnTotalsWithColumnOutOfBounds() {
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
			{
				one(values).getRowCount();
				will(returnValue(1));
				one(values).getColumnCount();
				will(returnValue(1)); 
				  // This will never be called and so the Mockery wont know
				  // that column 2 is out of bounds
				one(values).getValue(0, 2);
				will(returnValue(new ArrayIndexOutOfBoundsException()));
				  // The mockery will not allow us to return anything except a number so
				  // we cannot tell it that this entry is out of bounds
			}
		});
		
		double result = DataUtilities.calculateColumnTotal(values, 2);
		
		mockingContext.assertIsSatisfied();
		assertEquals(null, result);
	}
	
	
	

}
