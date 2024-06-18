package com.ashfaq.dev.untitesting.services;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CalculatorServiceTest {

//	Junit 5

	private CalculatorServices calculatorService;

	// execute the logic before all the test cases

	@BeforeAll
	public static void init() {
		System.out.println("this function will be executed before all the below functinos class");
	}

//	@BeforeAll
//	public  void initObjects() {
//		//we can use beforeeach and aftereach as well
//		System.out.println("this function will be executed before all the below functinos class and for objects ini");
//		calculatorService = new CalculatorServices();
//		
////		seen error : org.junit.platform.commons.JUnitException: @BeforeAll method 'public void com.ashfaq.dev.untitesting4
////		.services.CalculatorServiceTest.initObjects()' must be static 
////		unless the test class is annotated with @TestInstance(Lifecycle.PER_CLASS).
//		
//	}

	@AfterAll
	public static void destroy() {

		System.out.println("this function will be executed after all the below functinos class");
		// eg closing of aresources or connection
		System.out.println("Test case end ");

	}

	// before each test cases to execute the method

	@BeforeEach
	public void setUp() {
		System.out.println("before each test case");
		calculatorService = new CalculatorServices(); // Assuming CalculatorServices has a default constructor
	}

	// after each test cases to execute the method

	@AfterEach
	public void tearDown() {
		System.out.println("after each test case");
		calculatorService = null;
	}

	@Test // no timout in Junit 5 timeout = 2000
	@DisplayName("Multiplication test case : This is a custom name")
	public void mulTest() throws InterruptedException {
		System.out.println("Test for mul method");
//		Thread.sleep(3000);testing
		int sum = calculatorService.mul(2, 2); // Calling non-static method
		int expectedCorrect = 4;
		Assertions.assertEquals(expectedCorrect, sum, "Failure Message : Executed the multest but failed ");// Junit 5
																											// Assertions
																											// class is
																											// used for
																											// assertions

	}

//testing our services methods and the names  should be same
	@Test
	public void addTest() {
		System.out.println("Test for add method");

		int sum = CalculatorServices.add(12, 45);

//		int expected = 50;

		// wrong scenario just to see

//		Assertions.assertEquals(expected, sum);

		// correct scenario
		int expectedCorrect = 57;
		Assertions.assertEquals(expectedCorrect, sum);// no need to add classname.function name as its depricated

		// actual result should match to the expected result

	}

	@Test
	@Disabled//to disable the test case in junit 4 its ignore
	public void sumAnynumbersTest() {
		System.out.println("Test for sumAnynumbers method");

		// test cases
		int sum = CalculatorServices.sumAnynumbers(12, 45, 67);
		int expected = 124;
		Assertions.assertEquals(expected, sum);

	}

}
