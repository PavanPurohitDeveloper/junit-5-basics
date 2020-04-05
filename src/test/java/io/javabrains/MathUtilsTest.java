package io.javabrains;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MathUtilsTest {

	@Test
	void testAdd() {
		MathUtils mathUtils = new MathUtils();
		int expectedVal = 2;
		int actualVal = mathUtils.add(1, 1);
		assertEquals(expectedVal, actualVal, "The add method should add two numbers");
	}
	
	@Test
	void testComputeCircleRadius() {
		MathUtils mathUtils = new MathUtils();
		//Area of circle for radius 10 is 314.1592653589793
		assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), "Should return right circle area");
	}
	
	@Test
	void testdivide() {
		MathUtils mathUtils = new MathUtils();
		//assertThrows(NullPointerException.class, () -> mathUtils.divide(1, 0), "Divide by zero show throw"); //this will fail
		assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), "Divide by zero show throw"); // this will pass
	}
	
	

}
