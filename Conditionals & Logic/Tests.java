package workshops.practice_problems.conditionals_and_logic;

import static org.junit.Assert.assertEquals;

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

	private Class<?> testClass = ConditionalsAndLogic.class;

	private Method sample1, sample2, problem1, problem2, problem3, problem4;

	@Before
	public void Setup() throws NoSuchMethodException, SecurityException {
		sample1 = testClass.getMethod("sample1", int.class);
		sample2 = testClass.getMethod("sample2", int.class);
		problem1 = testClass.getMethod("problem1", int.class);
		problem2 = testClass.getMethod("problem2", int.class);
		problem3 = testClass.getMethod("problem3", int.class, int.class);
		problem4 = testClass.getMethod("problem4", int.class, int.class);
	}

	@Test
	public void test_sample1() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for (int i = 0; i < TestUtils.NUM_OF_TESTS; i++) {
			int n = (int) (Math.random() * 100 - 50);
			assertEquals(ConditionalsAndLogicSolution.sample1(n), (int) sample1.invoke(testClass, n));
		}
	}

	@Test
	public void test_sample2() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for (int i = 0; i < TestUtils.NUM_OF_TESTS; i++) {
			int n = (int) (Math.random() * 100 - 50);
			assertEquals(Math.abs(n), (int) sample2.invoke(testClass, n));
		}
	}

	@Test
	public void test_problem1() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for (int i = 0; i < TestUtils.NUM_OF_TESTS; i++) {
			int n = (int) (Math.random() * 100 - 50);
			assertEquals(n % 2 == 0 ? n : -2, (int) problem1.invoke(testClass, n));
		}
	}

	@Test
	public void test_problem2() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for (int i = 0; i < TestUtils.NUM_OF_TESTS; i++) {
			int n = (int) (Math.random() * 100 - 50);
			assertEquals(ConditionalsAndLogicSolution.problem2(n), (int) problem2.invoke(testClass, n));
		}
	}

	@Test
	public void test_problem3() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for (int i = 0; i < TestUtils.NUM_OF_TESTS; i++) {
			int num1 = (int) (Math.random() * 100 - 50);
			int num2 = (int) (Math.random() * 100 - 50);
			assertEquals(Math.max(num1, num2), (int) problem3.invoke(testClass, num1, num2));
		}
	}

	@Test
	public void test_problem4() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for (int i = 0; i < TestUtils.NUM_OF_TESTS; i++) {
			int num1 = (int) (Math.random() * 100 - 50);
			int num2 = (int) (Math.random() * 100 - 50);
			assertEquals(ConditionalsAndLogicSolution.problem4(num1, num2),
					(int) problem4.invoke(testClass, num1, num2));
		}
	}
}
