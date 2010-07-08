package com.initech;

import org.junit.*;
import mockit.*;

import static org.junit.Assert.*;

import org.junit.Test;

import com.initech.ASupporter;
import com.initech.ComplexClass;

public class ComplexClass_JMockit_Test {

	private ComplexClass _complexClass;
	
	@Mocked ASupporter _aSupporter1;
	@Mocked ASupporter _aSupporter2;
	@Mocked BSupporter _bSupporter;
	
	@Mocked Database _staticsOnly;
	
	@Before public void setup() {
		_complexClass = new ComplexClass(); // Class we're actually testing
	}
	
	// Basic expectations
	@Test public void validity() {
		new Expectations() {{
			_aSupporter1.isValid(); result = true;
			_aSupporter2.isValid(); result = true;
		}};
		
		_complexClass.addSupporter(_aSupporter1);
		_complexClass.addSupporter(_aSupporter2);
		
		// Finally, our assertion.
		assertTrue(_complexClass.isValid());
	}
	
	// Basic verifications
	@Test public void persistSupporters() {
		
		_complexClass.persist();
		
		new Verifications() {{
			Database.persist(_complexClass);
		}};
	}
	
	// Verifying private methods are called
	@Test public void persistAndNotify() {
		
		_complexClass.persist();

		new Verifications() {{
			Database.persist(_complexClass);
			invoke(ComplexClass.class, "notifyEveryone", 1);
		}};
	}
	
	// Calling private method on the object under test
	@Test public void notifier() {
		boolean result = Deencapsulation.invoke(_complexClass, "notifyEveryone", 1);
		assertFalse(result);
		
		result = Deencapsulation.invoke(_complexClass, "notifyEveryone", 2);
		assertTrue(result);
	}
	
	// Mocking constructor calls
	@Test public void buildBSupporter() {
		new Expectations(BSupporter.class) {{
			new BSupporter(anyInt).isValid(); result = true;
		}};
		assertTrue(_complexClass.bSupporterValidator(3));
		
		new Expectations(BSupporter.class) {{
			new BSupporter(anyInt).isValid(); result = false;
		}};
		assertFalse(_complexClass.bSupporterValidator(1));
	}

}
