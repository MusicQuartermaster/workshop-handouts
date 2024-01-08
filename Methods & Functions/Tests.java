package workshops.practice_problems.methods_and_functions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;

import workshops.practice_problems.TestUtils;

public class Tests {

	/*
	 * This is the test harness for the given practice problems. Make sure to
	 * include JUnit 4 in your build path for this project. If you are using
	 * eclipse, it should give you a popup asking if you'd like to include it when
	 * you try to run this class. If you are not using eclipse, you can easily find
	 * a simple guide online for the IDE you are working with
	 */

	private static final double DOUBLE_THRESHOLD = 1e-8;
	private static final int NUM_OF_TESTS = 20;

	Class<?> testClass = MethodsAndFunctions.class;

	Method multiply, integerDivision, divisionRemainder, calculateRectanglePerimeter, findMax, isPalindrome, isPrime,
			calculateHypotenuse, findGCD, isPerfectSquare, factorial, convertDecToBin, convertBinToDec;

	@Before
	public void Setup() throws NoSuchFieldException, SecurityException, NoSuchMethodException {
		multiply = testClass.getMethod("multiply", double.class, double.class);
		integerDivision = testClass.getMethod("integerDivision", int.class, int.class);
		divisionRemainder = testClass.getMethod("divisionRemainder", int.class, int.class);
		calculateRectanglePerimeter = testClass.getMethod("calculateRectanglePerimeter", double.class, double.class);
		findMax = testClass.getMethod("findMax", int.class, int.class, int.class);
		isPalindrome = testClass.getMethod("isPalindrome", String.class);
		isPrime = testClass.getMethod("isPrime", int.class);
		calculateHypotenuse = testClass.getMethod("calculateHypotenuse", double.class, double.class);
		findGCD = testClass.getMethod("findGCD", int.class, int.class);
		isPerfectSquare = testClass.getMethod("isPerfectSquare", int.class);
		factorial = testClass.getMethod("factorial", int.class);
		convertDecToBin = testClass.getMethod("convertDecToBin", int.class);
		convertBinToDec = testClass.getMethod("convertBinToDec", String.class);
	}

	@Test
	public void test_multiply() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for (int i = 0; i < NUM_OF_TESTS; i++) {
			double num1 = Math.random() * 100f + 0.1;
			double num2 = Math.random() * 100f + 0.1;
			assertEquals(num1 * num2, (double) multiply.invoke(testClass, num1, num2), DOUBLE_THRESHOLD);
		}
		assertEquals(0.0, (double) multiply.invoke(testClass, Math.random() * 100f, 0), 0.0);
	}

	@Test
	public void test_integerDivision()
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for (int i = 0; i < NUM_OF_TESTS; i++) {
			int dividend = (int) (Math.random() * 100f + 2);
			int divisor = (int) (Math.random() * 100f + 2);
			assertEquals(dividend / divisor, integerDivision.invoke(testClass, dividend, divisor));
		}
	}

	@Test
	public void test_divisionRemainder()
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for (int i = 0; i < NUM_OF_TESTS; i++) {
			int dividend = (int) (Math.random() * 100f + 2);
			int divisor = (int) (Math.random() * 100f + 2);
			assertEquals(dividend % divisor, divisionRemainder.invoke(testClass, dividend, divisor));
		}
	}

	@Test
	public void test_calculateRactanglePerimeter()
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for (int i = 0; i < NUM_OF_TESTS; i++) {
			double length = Math.random() * 100f + 1;
			double width = Math.random() * 100f + 1;
			assertEquals(2 * length + 2 * width, (double) calculateRectanglePerimeter.invoke(testClass, length, width),
					DOUBLE_THRESHOLD);
		}
	}

	@Test
	public void test_findMax() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for (int i = 0; i < NUM_OF_TESTS; i++) {
			int a = (int) (Math.random() * 100f - 50);
			int b = (int) (Math.random() * 100f - 50);
			int c = (int) (Math.random() * 100f - 50);
			assertEquals(Math.max(a, Math.max(b, c)), findMax.invoke(testClass, a, b, c));
		}
	}

	@Test
	public void test_isPalindrome() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for (int i = 0; i < NUM_OF_TESTS; i++) {
			String palindrome = "";
			int stringLength = (int) (Math.random() * 20);
			for (int j = 0; j < stringLength; j++) {
				int letter = (int) (Math.random() * 26);
				char c = (char) (TestUtils.coinFlip() ? 'A' + letter : 'a' + letter);
				palindrome = c + palindrome + c;
				if (TestUtils.coinFlip(2))
					palindrome += " ";
			}
			assertTrue((boolean) isPalindrome.invoke(testClass, palindrome));
		}

		for (int i = 0; i < NUM_OF_TESTS; i++) {
			String s = TestUtils.randString((int) (Math.random() * 20 + 2));
			assertEquals((boolean) MethodsAndFunctionsSolution.isPalindrome(s), isPalindrome.invoke(testClass, s));
		}
	}

	@Test
	public void test_isPrime() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for (int i = 0; i < NUM_OF_TESTS; i++) {
			int n = (int) (Math.random() * 100f);
			assertEquals(MethodsAndFunctionsSolution.isPrime(n), (boolean) isPrime.invoke(testClass, n));
		}
	}

	@Test
	public void test_calculateHypotenuse()
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for (int i = 0; i < NUM_OF_TESTS; i++) {
			double a = Math.random() * 100f;
			double b = Math.random() * 100f;
			assertEquals(MethodsAndFunctionsSolution.calculateHypotenuse(a, b),
					(double) calculateHypotenuse.invoke(testClass, a, b), DOUBLE_THRESHOLD);
		}
	}

	@Test
	public void test_findGCD() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for (int i = 0; i < NUM_OF_TESTS; i++) {
			int a = (int) (Math.random() * 100f);
			int b = (int) (Math.random() * 100f);
			assertEquals(MethodsAndFunctionsSolution.findGCD(a, b), (int) findGCD.invoke(testClass, a, b));
		}
	}

	@Test
	public void test_isPerfectSquare()
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for (int i = 0; i < NUM_OF_TESTS; i++) {
			int num = (int) (Math.random() * 100f);
			int sqrt = (int) (Math.sqrt(num));
			assertEquals(sqrt * sqrt == num, (boolean) isPerfectSquare.invoke(testClass, num));
		}
	}

	@Test
	public void test_factorial() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for (int i = 0; i < NUM_OF_TESTS; i++) {
			int num = (int) (Math.random() * 20);
			assertEquals(MethodsAndFunctionsSolution.factorial(num), (long) factorial.invoke(testClass, num));
		}
	}

	@Test
	public void test_convertDecToBin()
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for (int i = 0; i < NUM_OF_TESTS; i++) {
			int num = (int) (Math.random() * 256);
			assertEquals(MethodsAndFunctionsSolution.convertDecToBin(num),
					(String) convertDecToBin.invoke(testClass, num));
		}
	}

	@Test
	public void test_convertBinToDec()
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for (int i = 0; i < NUM_OF_TESTS; i++) {
			String binary = "";
			int binaryLength = (int) (Math.random() * 9 + 1);
			for (int j = 0; j < binaryLength; j++) {
				boolean one = TestUtils.coinFlip();
				binary = one ? "1" : "0" + binary;
			}
			assertEquals(MethodsAndFunctionsSolution.convertBinToDec(binary),
					(int) convertBinToDec.invoke(testClass, binary));
		}
	}
}
