package org.jfree.data.test;

import junit.framework.TestCase;

import org.jfree.data.Range;

public class RangeTestExpandMethod extends TestCase {
	
	private Range range;
	private double lowerMargin;
	private double upperMargin;
	
	public RangeTestExpandMethod(String name) {
		super(name);
	}
	
	public void setUp() throws Exception {
		super.setUp();
		range = new Range(1,2);
		lowerMargin = 0.5;
		upperMargin = 0.5;
	}

	public void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testCentralValueShouldBeOnePointFive() {
		assertEquals("the center of 1 and 2 should be 1.5", 1.5, range.getCentralValue(), .000000001d);
	}

	
	//Expand
	public void testNullRange() {
		range = null;
		// what should I put in the expected column here?
		assertEquals("tried to pass in nulll range", Range.expand(null, 1, 2), Range.expand(range, 1, 2));
	}
	
	public void testZeroUpper() {
		upperMargin = 0;
		range = Range.expand(range, lowerMargin, upperMargin);
		assertEquals("Called expand with upperMargin = 0, lowerMargin = 0.5 on Range(1,2)", new Range(0.5,2), range);
	}
	
	public void testZeroLower() {
		lowerMargin = 0;
		assertEquals("Tried to pass in a 0 lower margin", new Range(1,2.5), Range.expand(range, lowerMargin, upperMargin));
	}
	
	public void testOneUpper() {
		upperMargin = 1;
		assertEquals("Tried to pass 1 in for upper margin", new Range(.5, 3), Range.expand(range, lowerMargin, upperMargin));
	}
	
	public void testOneLower() {
		lowerMargin = 1;
		assertEquals("Tried to pass 1 in for lower margin", new Range(0, 2.5), Range.expand(range, lowerMargin, upperMargin));
	}
	
	public void testCloseToOneUpper() {
		upperMargin = .999999;
		assertEquals("Tried to pass .999999 in for upper margin", new Range(0.5, 2.999999), Range.expand(range, lowerMargin, upperMargin));
	}
	
	public void testJustOverOneUpper(){
		upperMargin = 1.0000001;
		assertEquals("Tried to pass in a value just over 1 for upper margin", new Range(0.5, 3.0000001), Range.expand(range, lowerMargin, upperMargin));
	}
	
	public void testCloseToOneLower() {
		lowerMargin = .9;
		assertEquals("Tried to pass in 0.9 in for lower margin", new Range(0.1, 2.5), Range.expand(range, lowerMargin, upperMargin));
	}
	
	public void testJustOverOneLower() {
		lowerMargin = 1.0000001;
		assertEquals("Tried to pass in 1.0000001 in for lower margin", new Range(-0.0000001, 2.5), Range.expand(range, lowerMargin, upperMargin));
	}
	
	public void testCloseToZeroUpper() {
		upperMargin = 0.0000001;
		assertEquals("Tried to pass in 0.0000001 in for upper margin", new Range(0.5, 2.0000001), Range.expand(range, lowerMargin, upperMargin));
	}
	
	public void testJustUnderZeroUpper() {
		upperMargin = -0.0000001;
		assertEquals("Tried to pass in a very small negative number for upper margin", new Range(0.5, 1.9999999), Range.expand(range, lowerMargin, upperMargin));
	}
	
	public void testCloseToZeroLower() {
		lowerMargin = 0.0000001;
		assertEquals("Tried to pass in 0.0000001 in for lower margin", new Range(0.9999999, 2.5), Range.expand(range, lowerMargin, upperMargin));
	}
	
	public void testJustUnderZeroLower() {
		lowerMargin = -0.0000001;
		assertEquals("Tried to pass in -0.0000001 in for lower margin", new Range(1.0000001, 2.5), Range.expand(range, lowerMargin, upperMargin));
	}
	
	public void testLessThanZeroLower() {
		lowerMargin = -0.5;
		assertEquals("Tried to pass in negative value for lower margin", new Range(1.5, 2.5), Range.expand(range, lowerMargin, upperMargin));
	}
	
	public void testLessThanZeroUpper() {
		upperMargin = -0.5;
		assertEquals("Tried to pass in nagative value for upper margin", new Range(0.5, 1.5), Range.expand(range, lowerMargin, upperMargin));
	}
	
	public void testGreaterThanOneLower() {
		lowerMargin = 2;
		assertEquals("Tried to pass in a value greater than one for lower margin", new Range(-1, 2.5), Range.expand(range, lowerMargin, upperMargin));
	}
	
	public void testGreaterThanOneUpper() {
		upperMargin = 2;
		assertEquals("Tried to pass in a value greater than one to upper margin", new Range (0.5, 4), Range.expand(range, lowerMargin, upperMargin));
	}
	

}
