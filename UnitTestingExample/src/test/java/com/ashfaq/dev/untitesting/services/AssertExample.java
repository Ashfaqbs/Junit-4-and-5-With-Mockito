package com.ashfaq.dev.untitesting.services;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;

import org.junit.Test;

public class AssertExample {
//assertion means validating actual result with expected result

	// test case
	@Test
	public void addTest() {
		System.out.println("Test for add method");
		int sum = CalculatorServices.add(12, 45);
		int expected = 57;
		assertEquals(expected, sum);// this is used for equality check
		assertNotEquals(expected, sum);// this is used for non equality check
		assertTrue(sum > 0);// this is used for true check
		assertFalse(sum > 0);// this is used for false check
		assertSame(expected, sum);// this is used for same check i.e to check if both the "Objects" are same not
		assertNotSame(expected, sum);// this is used for not same check
		assertNull(sum);// this is used for null check
		assertNotNull(sum);// this is used for not null check
		fail();// this is used for fail check
		assertArrayEquals(new int[] { 12, 45, 67 }, new int[] { 12, 45, 67 });// this is used for array check
	}

}
