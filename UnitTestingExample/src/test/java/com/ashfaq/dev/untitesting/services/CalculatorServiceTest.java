package com.ashfaq.dev.untitesting.services;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorServiceTest {

	
//	Junit 4
	// sometime we want to initiliaze the varaibles in the test cases so we will use
	// @beforeclass

	@BeforeClass
	// things to know when using @BeforeClass
	// suitable for expensive setup operations that are shared across tests,
	// such as establishing a database connection. The method annotated with
	// @BeforeClass / @BeforeAll must be static, meaning it cannot access instance
	// variables directly.
	public static void init() {
		System.out.println("this function will be executed before all the below functinos class");
	}

	@AfterClass
	public static void destroy() {

		System.out.println("this function will be executed after all the below functinos class");
		// eg closing of aresources or connection
		System.out.println("Test case end ");

	}

	// testing non static functions we have to use @Before
	private CalculatorServices calculatorService;

	// executes a method before each test case
	@Before // here we could have used @BeforeClass as well
	// things to know when using @Before
//	ideal for setting up objects or conditions that are unique to each test. 
//	The method annotated with @Before / @BeforeEach is non-static and can access instance variables of the test class.
	public void setUp() {
		System.out.println("before each test case");
		calculatorService = new CalculatorServices(); // Assuming CalculatorServices has a default constructor
	}

	@After
	public void tearDown() {
		System.out.println("after each test case");
		calculatorService = null;
	}

	@Test(timeout = 2000)//if the function execution takes more then2 secs it will now throw timeout exception
	public void mulTest() throws InterruptedException {
		System.out.println("Test for mul method");
//		Thread.sleep(3000);testing
		int sum = calculatorService.mul(2, 2); // Calling non-static method
		int expectedCorrect = 4;
		assertEquals(expectedCorrect, sum);
	}

//testing our services methods and the names  should be same

	@Test
	public void addTest() {
		System.out.println("Test for add method");

		int sum = CalculatorServices.add(12, 45);

//		int expected = 50;

		// wrong scenario just to see

//		Assert.assertEquals(expected, sum);

		// correct scenario
		int expectedCorrect = 57;
		assertEquals(expectedCorrect, sum);// no need to add classname.function name as its depricated

		// actual result should match to the expected result

	}

	@Test
	public void sumAnynumbersTest() {
		System.out.println("Test for sumAnynumbers method");

		// test cases
		int sum = CalculatorServices.sumAnynumbers(12, 45, 67);
		int expected = 124;
		assertEquals(expected, sum);

	}

}
