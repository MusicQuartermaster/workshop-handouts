package workshops.practice_problems.exception_handling;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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

	Class<?> testClass = ExceptionHandling.class;

	Method getValueOrThrow, getValueOrNull, onlyEvenNumbers, containsVowel;

	@Before
	public void Setup() throws NoSuchFieldException, SecurityException, NoSuchMethodException {
		getValueOrThrow = testClass.getMethod("getValueOrThrow", String[].class, int.class);
		getValueOrNull = testClass.getMethod("getValueOrNull", String[].class, int.class);
		onlyEvenNumbers = testClass.getMethod("onlyEvenNumbers", int.class);
		containsVowel = testClass.getMethod("containsVowel", String.class);
	}

	@Test
	public void test_getValueOrThrow()
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for (int i = 0; i < TestUtils.NUM_OF_TESTS; i++) {
			String[] arr = new String[TestUtils.ARRAY_SIZE];
			TestUtils.fillArray(arr, 'A', 'Z');
			int idx = (int) ((Math.random() * TestUtils.ARRAY_SIZE * 2) - (TestUtils.ARRAY_SIZE / 2));
			try {
				assertEquals(arr[idx], (String) getValueOrThrow.invoke(testClass, arr, idx));
			} catch (IndexOutOfBoundsException e) {
				assertTrue(idx >= arr.length || idx < 0);
			}
		}
	}

	@Test
	public void test_getValueOrNull()
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for (int i = 0; i < TestUtils.NUM_OF_TESTS; i++) {
			String[] arr = new String[TestUtils.ARRAY_SIZE];
			TestUtils.fillArray(arr, 'A', 'Z');
			int idx = (int) ((Math.random() * TestUtils.ARRAY_SIZE * 2) - (TestUtils.ARRAY_SIZE / 2));
			if (idx >= 0 && idx < TestUtils.ARRAY_SIZE) {
				assertEquals(arr[idx], (String) getValueOrNull.invoke(testClass, arr, idx));
			} else {
				assertNull(getValueOrNull.invoke(testClass, arr, idx));
			}
		}
	}

	@Test
	public void test_onlyEvenNumbers()
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for (int i = 0; i < TestUtils.NUM_OF_TESTS; i++) {
			int number = (int) (Math.random() * 100);
			try {
				assertEquals(number, onlyEvenNumbers.invoke(testClass, number));
			} catch (InvocationTargetException e) {
				if (!(e.getCause() instanceof OddNumberException)) {
					fail();
				}
			}
		}
	}

	@Test
	public void test_containsVowel()
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for (int i = 0; i < TestUtils.NUM_OF_TESTS; i++) {
			String s = TestUtils.randString((int) (Math.random() * 20) + 1);
			if (s.matches(".*[AEIOUaeiou].*")) {
				assertTrue((boolean) containsVowel.invoke(testClass, s));
			} else {
				assertFalse((boolean) containsVowel.invoke(testClass, s));
			}
		}

		for (int i = 0; i < TestUtils.NUM_OF_TESTS; i++) {
			String s = TestUtils.randString((int) (Math.random() * 20) + 1);
			int idx = (int) (Math.random() * s.length());
			s = s.substring(0, idx) + ((int) (Math.random() * 10)) + s.substring(idx);
			try {
				containsVowel.invoke(testClass, s);
				fail();
			} catch (InvocationTargetException e) {
				if (!(e.getCause() instanceof ContainsNumberException)) {
					fail();
				}
			}
		}
	}
}
