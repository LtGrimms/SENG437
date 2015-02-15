package org.jfree.data.test;

import junit.framework.TestCase;
import org.jfree.data.Range;
import org.junit.*;
//import org.jmock.integration.junit3.MockObjectTestCase;
//import org.jmock.Expectations;

public class RangeTestExpandToIncludeAndGetLowerBound extends /*MockObject*/TestCase {

	private Range exampleRange, /*nullRange,*/ secondRange;
	//private Double double1;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Before
	public void setUp() throws Exception {
		//double1 = (Double) null;
		//double null1 = double1;
		//double null2 = double1;
		exampleRange = new Range(-1, 1);
		//nullRange = new Range(null1, null2);
		secondRange = new Range(1, 2);
	}
	
	@After public void tearDown() throws Exception {
	}
	
	@Test public void testlowerBoundNegative() {
		assertEquals("The lower bound of -1 and 1 should be -1.", -1, exampleRange.getLowerBound(), .000000001d);
	}
	/*@Test public void testlowerBoundNullRange() {
		assertEquals("Invalid input should return 0.", 0, nullRange.getLowerBound(), .000000001d);
	}*/
	@Test public void testlowerBoundPositive() {
		assertEquals("IThe lower bound of 1 and 2 should be 1.", 1, secondRange.getLowerBound(), .000000001d);
	}

	
	@Test public void testexpandToIncludeUpperExtend() {
		Range.expandToInclude(exampleRange, 5);
		assertEquals("The expected lower bound should be -1.", -1, exampleRange.getLowerBound(), .000000001d);
		assertEquals("The expected upper bound should be 5.", 5, exampleRange.getLowerBound(), .000000001d);
		// cleanup
		exampleRange = new Range(-1, 1);
	}
	@Test public void testexpandToIncludeLowerExtend() {
		Range.expandToInclude(exampleRange, -5);
		assertEquals("The expected lower bound should be -5.", -5, exampleRange.getLowerBound(), .000000001d);
		assertEquals("The expected upper bound should be 1.", 1, exampleRange.getUpperBound(), .000000001d);
		// cleanup
		exampleRange = new Range(-1, 1);
	}
	@Test public void testexpandToIncludeContained() {
		Range.expandToInclude(exampleRange, 0);
		assertEquals("The expected lower bound should be -1.", -1, exampleRange.getLowerBound(), .000000001d);
		assertEquals("The expected upper bound should be 1.", 1, exampleRange.getUpperBound(), .000000001d);
	}
	/*@Test public void testexpandToIncludeNullRange() {
		Range.expandToInclude(nullRange, 5);
		assertEquals("Null range should return 0 lower bound.", 0, nullRange.getLowerBound(), .000000001d);
		assertEquals("Null range should return 0 upper bound.", 0, nullRange.getUpperBound(), .000000001d);
		// cleanup
		nullRange = new Range(new Double(null), new Double(null));
	}
	@Test public void testexpandToIncludeNullValue() {
		Range.expandToInclude(exampleRange, new Double(null));
		assertEquals("The expected lower bound should be -1.", -1, exampleRange.getLowerBound(), .000000001d);
		assertEquals("The expected upper bound should be 1.", 1, exampleRange.getUpperBound(), .000000001d);
		// cleanup
		exampleRange = new Range(-1, 1);
	}*/
	@Test public void testexpandToIncludeAtLowerBoundary() {
		Range.expandToInclude(exampleRange, -1);
		assertEquals("The expected lower bound should be -1.", -1, exampleRange.getLowerBound(), .000000001d);
		assertEquals("The expected upper bound should be 1.", 1, exampleRange.getUpperBound(), .000000001d);
		// cleanup
		exampleRange = new Range(-1, 1);
	}
	@Test public void testexpandToIncludeAtUpperBoundary() {
		Range.expandToInclude(exampleRange, 1);
		assertEquals("The expected lower bound should be -1.", -1, exampleRange.getLowerBound(), .000000001d);
		assertEquals("The expected upper bound should be 1.", 1, exampleRange.getUpperBound(), .000000001d);
		// cleanup
		exampleRange = new Range(-1, 1);
	}
}
