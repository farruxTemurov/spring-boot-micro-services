package com.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class OperationTest {

	@Test
	public void testAdd() {
		Operation op = new Operation();
		int result = op.add(10, 40);
		assertEquals(50, result);
	}

	@Test
	public void testSubtract() {
		Operation op = new Operation();
		int result = op.subtract(30, 20);
		assertEquals(10, result);
	}

}
