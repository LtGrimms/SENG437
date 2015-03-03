package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class RangeTestExpandMethod extends Range {
	
	public RangeTestExpandMethod() {
		super(0,0);
		//Why does this need to be here?
	}

	private Range range;
	private double lowerMargin;
	private double upperMargin;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Before
	public void setUp() throws Exception {
		range = new Range(1,2);
		lowerMargin = 0.5;
		upperMargin = 0.5;
	}

	@After
	public void tearDown() throws Exception {
	}

	
	@Test(expected = IllegalArgumentException.class)
	public void testNullRange() {
		range = null;
		Range expected = Range.expand(range, 1, 2);
		assertNull("tried to pass in nulll range", expected);
	}
	
	@Test
	public void testZeroUpper() {
		upperMargin = 0;
		range = Range.expand(range, lowerMargin, upperMargin);
		assertEquals("Called expand with upperMargin = 0, lowerMargin = 0.5 on Range(1,2)", new Range(0.5,2), range);
	}
	
	@Test
	public void testZeroLower() {
		lowerMargin = 0;
		assertEquals("Tried to pass in a 0 lower margin", new Range(1,2.5), Range.expand(range, lowerMargin, upperMargin));
	}
	
	@Test
	public void testOneUpper() {
		upperMargin = 1;
		assertEquals("Tried to pass 1 in for upper margin", new Range(.5, 3), Range.expand(range, lowerMargin, upperMargin));
	}
	
	@Test
	public void testOneLower() {
		lowerMargin = 1;
		assertEquals("Tried to pass 1 in for lower margin", new Range(0, 2.5), Range.expand(range, lowerMargin, upperMargin));
	}
	
	@Test
	public void testCloseToOneUpper() {
		upperMargin = .999999;
		assertEquals("Tried to pass .999999 in for upper margin", new Range(0.5, 2.999999), Range.expand(range, lowerMargin, upperMargin));
	}
	
	@Test
	public void testJustOverOneUpper(){
		upperMargin = 1.0000001;
		assertEquals("Tried to pass in a value just over 1 for upper margin", new Range(0.5, 3.0000001), Range.expand(range, lowerMargin, upperMargin));
	}
	/*
	@Test
	public void testCloseToOneLower() {
		lowerMargin = .9;
		Range expected = Range.expand(range, lowerMargin, upperMargin);
		assertEquals("Tried to pass in 0.9 in for lower margin", new Range(0.1, 2.5), Range.expand(range, lowerMargin, upperMargin));
	}
	*/
	
	@Test
	public void testCloseToOneLower_dependentOnOtherMethods() {
		lowerMargin = .9;
		range = Range.expand(range, lowerMargin, upperMargin);
		assertEquals("Tried to pass in 0.9 in for lower margin. Lower margin getter: ", 0.1, range.getLowerBound(), .000000001d);
		assertEquals("Tried to pass in " + lowerMargin + " in for lower margin. Upper margin getter: ", 2.5, range.getUpperBound(), .000000001d);
	}
	
	/*
	@Test
	public void testJustOverOneLower() {
		lowerMargin = 1.1;
		assertEquals("Tried to pass in 1.0000001 in for lower margin", new Range(-0.1, 2.5), Range.expand(range, lowerMargin, upperMargin));
	}*/
	
	@Test 
	public void testJustOverOneLower_dependentOnOtherMethods() {
		lowerMargin = 1.1;
		range = Range.expand(range, lowerMargin, upperMargin);
		assertEquals("Tried to pass in 1.1 in for lower margin, uppermargin getter: ", 2.5, range.getUpperBound(), .000000001d);
		assertEquals("Tried to pass in 1.1 in for lower margin, lowermargin getter: ", -0.1, range.getLowerBound(), .000000001d);
	}
	
	@Test
	public void testCloseToZeroUpper() {
		upperMargin = 0.0000001;
		assertEquals("Tried to pass in 0.0000001 in for upper margin", new Range(0.5, 2.0000001), Range.expand(range, lowerMargin, upperMargin));
	}
	
	@Test
	public void testJustUnderZeroUpper() {
		upperMargin = -0.0000001;
		assertEquals("Tried to pass in a very small negative number for upper margin", new Range(0.5, 1.9999999), Range.expand(range, lowerMargin, upperMargin));
	}
	
	@Test
	public void testCloseToZeroLower() {
		lowerMargin = 0.0000001;
		assertEquals("Tried to pass in 0.0000001 in for lower margin", new Range(0.9999999, 2.5), Range.expand(range, lowerMargin, upperMargin));
	}
	
	@Test
	public void testJustUnderZeroLower() {
		lowerMargin = -0.0000001;
		assertEquals("Tried to pass in -0.0000001 in for lower margin", new Range(1.0000001, 2.5), Range.expand(range, lowerMargin, upperMargin));
	}
	
	@Test
	public void testLessThanZeroLower() {
		lowerMargin = -0.5;
		assertEquals("Tried to pass in negative value for lower margin", new Range(1.5, 2.5), Range.expand(range, lowerMargin, upperMargin));
	}
	
	@Test
	public void testLessThanZeroUpper() {
		upperMargin = -0.5;
		assertEquals("Tried to pass in nagative value for upper margin", new Range(0.5, 1.5), Range.expand(range, lowerMargin, upperMargin));
	}
	
	@Test
	public void testGreaterThanOneLower() {
		lowerMargin = 2;
		assertEquals("Tried to pass in a value greater than one for lower margin", new Range(-1, 2.5), Range.expand(range, lowerMargin, upperMargin));
	}
	
	@Test
	public void testGreaterThanOneUpper() {
		upperMargin = 2;
		assertEquals("Tried to pass in a value greater than one to upper margin", new Range (0.5, 4), Range.expand(range, lowerMargin, upperMargin));
	}
	

}
