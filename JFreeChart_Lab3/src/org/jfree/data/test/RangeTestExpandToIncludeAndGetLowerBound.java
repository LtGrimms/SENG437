package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class RangeTestExpandToIncludeAndGetLowerBound extends Range {

	public RangeTestExpandToIncludeAndGetLowerBound() {
		super(1,1);
	}
	
	private Range exampleRange, nullRange, secondRange;
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
		nullRange = null;
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
		exampleRange = Range.expandToInclude(exampleRange, 5);
		assertEquals("The expected lower bound should be -1.", -1, exampleRange.getLowerBound(), .000000001d);
		assertEquals("The expected upper bound should be 5.", 5, exampleRange.getUpperBound(), .000000001d);
		// cleanup
		exampleRange = new Range(-1, 1);
	}
	@Test public void testexpandToIncludeLowerExtend() {
		exampleRange = Range.expandToInclude(exampleRange, -5);
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
	@Test public void testexpandToIncludeNullRange() {
		nullRange = Range.expandToInclude(nullRange, 5);
		assertEquals("Null range should return 5 lower bound.", 5, nullRange.getLowerBound(), .000000001d);
		assertEquals("Null range should return 5 upper bound.", 5, nullRange.getUpperBound(), .000000001d);
		// cleanup
		// nullRange = new Range(new Double(null), new Double(null));
	}/*
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
