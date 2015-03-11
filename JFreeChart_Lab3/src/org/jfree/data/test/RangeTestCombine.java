package org.jfree.data.test;


import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RangeTestCombine extends Range {

	private Range range1;
	private Range range2 ;
	private Range expect;

	
	public RangeTestCombine() {
		super(1,1);
	} 	
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception{
		
	}
	
	@Before
	public void setUp() throws Exception {
	}
	@After
	public void tearDown() throws Exception {
	}
	
	/**
	 * Testing the Combine method
	 * the 2nd argument needs to be smaller than the 1st argument 
	 */
	
	@Test
	public void testTwoDisjoinRangesFirstTest(){
		  range1 = new Range (1,2);
		  range2 = new Range (3,4);
		expect = new Range(1,4);
		// Assertion failed, it requires the lower bound of the 2nd arg to be <= the lower bound of the 1st arg.
		assertEquals("Combining two disjoin ranges Test 1", expect, Range.combine(range1,range2));
	}
	
	@Test
	public void testTwoDisjoinRangesSecondTest(){
		  range1 = new Range (1,2);
		  range2 = new Range (3,4);
		expect = new Range(1,4);
		assertEquals("Combining two disjoin ranges Test 2", expect, Range.combine(range2,range1));
	}
	
//	@Test
//	public void testNullRangeAndNonNullRange(){
//		range1 = new Range(3,7);
//		range2 = null;
//		expect = range1;
//		assertEquals("Null Range Combines with Non-NullRange Test 1 ", expect ,Range.combine(range2, range1));
//		assertEquals("Null Range Combines with Non-NullRange Test 2 ", expect ,Range.combine(range1, range2));	
//	}
	
	@Test 
	public void testTwoNullRanges(){
		range1 = null;
		range2 = null;
		assertNull("Two Null Ranges Combine Test", Range.combine(range1,range2));
	}
	
	
	@Test
	public void testTwoRangesInteract(){
		  range1 = new Range (0,5);
		  range2 = new Range (4,10);
		expect = new Range(0,10);
		assertEquals("Two Ranges interact Combine Test",expect ,Range.combine(range2,range1));
	}

	@Test
	public void testOneRangeInsideanotherRange(){
		  range1 = new Range (0,5);
		  range2 = new Range (3,4);
		expect = range1;
		assertEquals("One range is inside another range",expect, Range.combine(range2,range1));
	}
	
	@Test
	public void testTwoRangesAreContiguous(){
		range1 = new Range (4,10);
		range2 = new Range (3,4);
		expect = new Range(3,10);
		assertEquals("Two Ranges are Contiguous", expect, Range.combine(range1,range2));
	}
	
}