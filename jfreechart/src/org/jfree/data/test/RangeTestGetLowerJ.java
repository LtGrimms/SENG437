package org.jfree.data.test;

import junit.framework.TestCase;
import org.jfree.data.Range;
import org.junit.*;

public class RangeTestGetLowerJ extends TestCase {

	private Range testRange;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Before
	protected void setUp() throws Exception {
		testRange = null;
	}

	@After
	protected void tearDown() throws Exception {
	}

	@Test
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
