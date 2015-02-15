package org.jfree.data.test;

import junit.framework.TestCase;
import org.jfree.data.Range;
import org.junit.*;

public class RangeTestConstrain extends TestCase {

	private Range testRange;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Before
	protected void setUp() throws Exception {
		testRange = new Range(-5.0, 5.0);
	}

	@After
	protected void tearDown() throws Exception {
	}

	@Test
	public void test_1_null()
	{
		double expectedValue = 5.0;
		
		assertEquals("Null value", expectedValue, testRange.constrain(6.0), .000000001d);
	}
	
	@Test
	public void test_2_above()
	{
		double expectedValue = 5.0;
		
		assertEquals("Above range", expectedValue, testRange.constrain(6.0), .000000001d);
	}
	
	@Test
	public void test_3_below()
	{
		double expectedValue = -5.0;
		
		assertEquals("Below range", expectedValue, testRange.constrain(-6.0), .000000001d);
	}
	
	@Test
	public void test_4_within()
	{
		double expectedValue = 0.0;
		
		assertEquals("Within range", expectedValue, testRange.constrain(0.0), .000000001d);
	}
	
	@Test
	public void test_5_upperBound()
	{
		double expectedValue = 5.0;
		
		assertEquals("Upper Bound", expectedValue, testRange.constrain(5.0), .000000001d);
	}
	
	@Test
	public void test_6_lowerBound()
	{
		double expectedValue = -5.0;
		
		assertEquals("Lower bound", expectedValue, testRange.constrain(-5.0), .000000001d);
	}
	
	@Test
	public void test_7_overflow()
	{
		double expectedValue = 5.0;
		
		assertEquals("Overflow", expectedValue, testRange.constrain(Double.MAX_VALUE * 1.5), .000000001d);
	}
}
