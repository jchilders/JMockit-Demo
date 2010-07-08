package com.initech;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ComplexClass_OldWay_Test {
	private ComplexClass _complexClass;
	
	@Before public void setup() {
		_complexClass = new ComplexClass();	// Class we're actually testing
	}
	
	@Test public void validity  () {
		// Set up supporting objects. Imagine database connections, etc.
		ASupporter aSupporter = new ASupporter();

		BSupporter newB = new BSupporter(2);
		aSupporter.addBSupporter(newB);
		_complexClass.addSupporter(aSupporter);
		
		// Do it again
		newB = new BSupporter(4);
		aSupporter.addBSupporter(newB);
		_complexClass.addSupporter(aSupporter);

		// Finally, our assertion.
		assertTrue(_complexClass.isValid());
	}
}
