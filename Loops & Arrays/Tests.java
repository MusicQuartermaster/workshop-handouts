package workshops.practice_problems.loops_and_arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

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
	static final int NUM_OF_TESTS = 20;
	static final int ARRAY_SIZE = 50;

	static final Class<?> testClass = LoopsAndArrays.class;
	Method createArray, fillArray, copyArray, printArray, arraySum, positiveSum, containsValue, doubleValues,
			printReverse, reverseArray;

	@Before
	public void Setup() throws NoSuchFieldException, SecurityException, NoSuchMethodException {
		createArray = testClass.getMethod("CreateArray", int.class);
		fillArray = testClass.getMethod("FillArray", double[].class, double.class, double.class);
		copyArray = testClass.getMethod("CopyArray", String[].class);
		printArray = testClass.getMethod("PrintArray", int[].class);
		arraySum = testClass.getMethod("ArraySum", int[].class);
		positiveSum = testClass.getMethod("PositiveSum", double[].class);
		containsValue = testClass.getMethod("ContainsValue", int[].class, int.class);
		doubleValues = testClass.getMethod("DoubleValues", int[].class);
		printReverse = testClass.getMethod("PrintReverse", String[].class);
		reverseArray = testClass.getMethod("ReverseArray", int[].class);
	}

	@Test
	public void test_createArray() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException {
		for (int i = 0; i < NUM_OF_TESTS; i++) {
			double[] arr = (double[]) createArray.invoke(testClass, (Integer) i);
			assertNotNull("Array must not be null", arr);
			assertEquals("Array length must be equal to value specified", i, arr.length);
			for (int j = 0; j < arr.length; j++) {
				assertEquals("Array values must be the default value (0.0 for double[])", 0.0, arr[j], 0.0);
			}
		}
	}

	@Test
	public void test_fillArray() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException {
		for (int i = 0; i < NUM_OF_TESTS; i++) {
			double[] arr = new double[ARRAY_SIZE];
			double minVal = Math.random() * 10f + 1f;
			double valueRange = Math.random() * 100f + 1f;
			double maxVal = minVal + valueRange;
			fillArray.invoke(testClass, arr, minVal, valueRange);
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] < minVal || arr[j] >= maxVal) {
					fail("Value outside of expected range");
				}
			}
		}
	}

	@Test
	public void test_copyArray() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException {
		for (int i = 0; i < NUM_OF_TESTS; i++) {
			String[] thisArr = new String[ARRAY_SIZE];
			TestUtils.fillArray(thisArr, 2, 10);
			assertTrue(Arrays.deepEquals(thisArr, (String[]) copyArray.invoke(testClass, new Object[] { thisArr })));
		}
	}

	@Test
	public void test_printArray() throws IOException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		PrintStream stdOut = System.out;
		for (int i = 0; i < NUM_OF_TESTS; i++) {
			ByteArrayOutputStream redirectedOut = new ByteArrayOutputStream();
			System.setOut(new PrintStream(redirectedOut));
			int[] arr = new int[ARRAY_SIZE];
			TestUtils.fillArray(arr, -50, 50);
			printArray.invoke(testClass, arr);
			assertEquals(toString(arr).trim(), redirectedOut.toString().trim());
		}
		System.setOut(stdOut);
	}

	@Test
	public void test_arraySum() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException {
		for (int i = 0; i < NUM_OF_TESTS; i++) {
			int[] arr = new int[ARRAY_SIZE];
			int sum = 0;
			TestUtils.fillArray(arr, -50, 50);
			for (int integer : arr) {
				sum += integer;
			}
			assertEquals(sum, arraySum.invoke(testClass, arr));
		}
	}

	@Test
	public void test_positiveSum() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException {
		for (int i = 0; i < NUM_OF_TESTS; i++) {
			double[] arr = new double[ARRAY_SIZE];
			double sum = 0;
			TestUtils.fillArray(arr, -50, 50);
			for (double d : arr) {
				sum += d > 0 ? d : 0;
			}
			assertEquals(sum, (double) positiveSum.invoke(testClass, arr), 0.01);
		}
	}

	@Test
	public void test_containsValue() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException {
		for (int i = 0; i < NUM_OF_TESTS; i++) {
			int[] arr = new int[ARRAY_SIZE];
			TestUtils.fillArray(arr, -50, 50);
			int value = (int) (Math.random() * 150f - 75f);
			assertEquals(LoopsAndArraysSolution.ContainsValue(arr, value), containsValue.invoke(testClass, arr, value));
		}
	}

	@Test
	public void test_doubleValues() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException {
		for (int i = 0; i < NUM_OF_TESTS; i++) {
			int[] arr = new int[i];
			TestUtils.fillArray(arr, -50, 50);
			int[] clone = arr.clone();
			LoopsAndArraysSolution.DoubleValues(arr);
			doubleValues.invoke(testClass, clone);
			assertTrue(Arrays.equals(arr, clone));
		}
	}

	@Test
	public void test_printReverse() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException {
		PrintStream stdOut = System.out;
		for (int i = 0; i < NUM_OF_TESTS; i++) {
			ByteArrayOutputStream redirectedOut = new ByteArrayOutputStream();
			System.setOut(new PrintStream(redirectedOut));
			String[] arr = new String[ARRAY_SIZE];
			TestUtils.fillArray(arr, 'A', 'Z');
			printReverse.invoke(testClass, new Object[] { arr });
			assertEquals(toReverseString(arr).trim(), redirectedOut.toString().trim());
			System.setOut(stdOut);
		}
	}

	@Test
	public void test_reverseArray() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException {
		for (int i = 0; i < NUM_OF_TESTS; i++) {
			int[] arr = new int[ARRAY_SIZE];
			TestUtils.fillArray(arr, -50, 50);
			int[] clone = arr.clone();
			LoopsAndArraysSolution.ReverseArray(arr);
			reverseArray.invoke(testClass, clone);
			assertTrue(Arrays.equals(arr, clone));
		}
	}

	private String toString(int[] arr) {
		String s = "";
		for (int i : arr) {
			s += i + " ";
		}
		return s;
	}

	private String toReverseString(String[] arr) {
		String s = "";
		for (int i = arr.length - 1; i >= 0; i--) {
			s += arr[i] + " ";
		}
		return s;
	}
}
