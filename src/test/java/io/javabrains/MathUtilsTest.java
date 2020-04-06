package io.javabrains;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestInstance.Lifecycle;

//@TestInstance(Lifecycle.PER_CLASS)
@DisplayName("When running MathUtils")
class MathUtilsTest {
	
	MathUtils mathUtils; //member varaible
	
	@BeforeAll
	static void beforeAllInit() {
		System.out.println("This needs to run before all");
	}
	
	/*@BeforeAll
	void beforeAllInit() {  //when u use @TestInstance(Lifecycle.PER_CLASS)
		System.out.println("This needs to run before all");
	}*/
	
	@BeforeEach
	void init() {
		mathUtils = new MathUtils(); //Instance is created
	}
	
	@AfterEach
	void cleanup() {
		System.out.println("Clenaing up...");
	}

	@Nested
	@DisplayName("add method")
	class AddTest{
		
		@Test
		@DisplayName("when adding two positive numbers")
		void testAddPositive() {
			assertEquals(2, mathUtils.add(1, 1), "should return the right sum");
		}
		
		@Test
		@DisplayName("when adding two negative numbers")
		void testAddNegative() {
			assertEquals(-2, mathUtils.add(-1, -1), "should return the right sum");
		}
	}
	
	@Test
	@DisplayName("multiple method")
	void testMultiply() {
		//In one shot we passing 3 asserts
		assertAll(
				() -> assertEquals(4, mathUtils.multiply(2, 2)),
				() -> assertEquals(0, mathUtils.multiply(2, 0)),
				() -> assertEquals(-2, mathUtils.multiply(2, -1))
			);
	}
	
	@Test
	@DisplayName("when adding two positive numbers")
	void testAddPositive() {
		int expectedVal = 2;
		int actualVal = mathUtils.add(1, 1);
		assertEquals(expectedVal, actualVal, "The add method should add two numbers");
	}
	
	@Test
	void testComputeCircleRadius() {
		//Area of circle for radius 10 is 314.1592653589793
		assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), "Should return right circle area");
	}
	
	@Test
	void testdivide() {
		boolean isServerUp = false;
		assumeTrue(isServerUp);
		//assertThrows(NullPointerException.class, () -> mathUtils.divide(1, 0), "Divide by zero show throw"); //this will fail
		assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), "Divide by zero show throw"); // this will pass
	}
	
	@Test
	@Disabled
	@DisplayName("TDD method . should not run")
	void testDisabled() {
		fail("This test should be disabled");
	}

}
