package com.service;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bean.Employee;

public class EmployeeServiceTest {

	@Test
	public void testGetEmployee() {
		EmployeeService es = new EmployeeService();
		Employee emp = es.getEmployee();
		assertNotNull(emp);    // we expect object, not null. 
		assertEquals(10, emp.getId());
		assertEquals("Tim", emp.getName());
		assertEquals(89000, emp.getSalary(),2);
	}

//	@Test
//	public void testGetAllEmployee() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testCheckLoginDetails() {
//		fail("Not yet implemented");
//	}

}
