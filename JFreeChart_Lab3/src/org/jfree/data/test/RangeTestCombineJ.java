package org.jfree.data.test;

import junit.framework.TestCase;
import org.jfree.data.Range;
import org.junit.*;

public class RangeTestCombineJ extends TestCase {

	private Range rangeOne, rangeTwo, rangeExpected;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Before
	protected void setUp() throws Exception {
		//Clear values of the ranges before running the tests
		rangeOne = null;
		rangeTwo = null;
		rangeExpected = null;
	}

	@After
	protected void tearDown() throws Exception {
	}

	@Test
	public void test_1_null_null()
	{
		rangeOne = null;
		rangeTwo = null;
		
		assertNull("Double Null", Range.combine(rangeOne,  rangeTwo) );
	}
	
	@Test
	public void test_2_null_valid()
	{
		rangeOne = null;
		rangeTwo = new Range(-1, 1);
		
		rangeExpected = new Range(-1, 1);
		
		assertEquals("Null one, valid two", rangeExpected, Range.combine(rangeOne,  rangeTwo) );
	}
	
	@Test
	public void test_3_valid_null()
	{
		rangeOne = new Range(-1, 1);
		rangeTwo = null;
		
		rangeExpected = new Range(-1, 1);
		
		assertEquals("Valid one, null two", rangeExpected, Range.combine(rangeOne,  rangeTwo) );
	}
	
	
	@Test
	public void test_4_oneInTwo()
	{
		rangeOne = new Range(-1, 1);
		rangeTwo = new Range(-2, 2);
		
		rangeExpected = new Range(-2, 2);
		
		assertEquals("One within two", rangeExpected, Range.combine(rangeOne,  rangeTwo) );
	}
	
	@Test
	public void test_5_twoInOne()
	{
		rangeOne = new Range(-2, 2);
		rangeTwo = new Range(-1, 1);
		
		rangeExpected = new Range(-2, 2);
		
		assertEquals("Two within one", rangeExpected, Range.combine(rangeOne,  rangeTwo) );
		//Fails because lower bound of second range must be <= lower bound of first range.
	}
	
	@Test
	public void test_6_1_intersect()
	{
		rangeOne = new Range(-1, 1);
		rangeTwo = new Range(0, 2);
		
		rangeExpected = new Range(-1, 2);
		
		assertEquals("Intersecting", rangeExpected, Range.combine(rangeOne,  rangeTwo) );
		//Fails because lower bound of second range must be <= lower bound of first range.
	}
	
	@Test
	public void test_6_2_intersect()
	{
		rangeOne = new Range(0, 2);
		rangeTwo = new Range(-1, 1);
		
		rangeExpected = new Range(-1, 2);
		
		assertEquals("Intersecting", rangeExpected, Range.combine(rangeOne,  rangeTwo) );
	}
	
	@Test
	public void test_7_1_contiguous()
	{
		rangeOne = new Range(-1, 0);
		rangeTwo = new Range(0, 1);
		
		rangeExpected = new Range(-1, 1);
		
		assertEquals("Contiguous", rangeExpected, Range.combine(rangeOne,  rangeTwo) );
		//Fails because lower bound of second range must be <= lower bound of first range.
	}
	
	@Test
	public void test_7_2_contiguous()
	{
		rangeOne = new Range(0, 1);
		rangeTwo = new Range(-1, 0);
		
		rangeExpected = new Range(-1, 1);
		
		assertEquals("Contiguous", rangeExpected, Range.combine(rangeOne,  rangeTwo) );
	}
	
	@Test
	public void test_8_1_disjoint()
	{
		rangeOne = new Range(-2, -1);
		rangeTwo = new Range(1, 2);
		
		rangeExpected = new Range(-2, 2);
		
		assertEquals("Disjointed", rangeExpected, Range.combine(rangeOne,  rangeTwo) );
		//Fails because lower bound of second range must be <= lower bound of first range.
	}
	
	@Test
	public void test_8_2_disjoint()
	{
		rangeOne = new Range(1, 2);
		rangeTwo = new Range(-2, -1);
		
		rangeExpected = new Range(-2, 2);
		
		assertEquals("Disjointed", rangeExpected, Range.combine(rangeOne,  rangeTwo) );
	}
}
