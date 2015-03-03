package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class RangeTestGetLowerJ extends Range {

	public RangeTestGetLowerJ() {
		super(1,1);
	}
	
	private Range testRange;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Before
	public void setUp() throws Exception {
		testRange = null;
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test(expected = NullPointerException.class)
	public void test_1_null()
	{	
		assertNull("Null", testRange.getLowerBound());
	}
	
	@Test
	public void test_2_positive()
	{
		testRange = new Range(5.0, 10.0);
		double expectedValue = 5.0;
		
		assertEquals("Positive upper", expectedValue, testRange.getLowerBound(), .000000001d);
	}
	
	@Test
	public void test_2_negative()
	{
		testRange = new Range(-5.0, 0);
		double expectedValue = -5.0;
		
		assertEquals("Negative upper", expectedValue, testRange.getLowerBound(), .000000001d);
	}
}
