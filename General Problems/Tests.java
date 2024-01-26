package workshops.practice_problems.general;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

	Class<?> testClass = General.class;

	Method sortChunks, distance, circlesAreTangent, removeDuplicates, sumDigits, countMoney;

	@Before
	public void Setup() throws NoSuchFieldException, SecurityException, NoSuchMethodException {
		sortChunks = testClass.getMethod("sortChunks", String.class, int.class);
		distance = testClass.getMethod("distance", int.class, int.class, int.class, int.class);
		circlesAreTangent = testClass.getMethod("circlesAreTangent", int.class, int.class, double.class, int.class,
				int.class, double.class);
		removeDuplicates = testClass.getMethod("removeDuplicates", int[].class);
		sumDigits = testClass.getMethod("sumDigits", int.class);
		countMoney = testClass.getMethod("countMoney", int[].class);
	}

	@Test
	public void test_sortChunks() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for (int i = 0; i < TestUtils.NUM_OF_TESTS; i++) {
			int stringLength = (int) (Math.random() * 20f + 2);
			int chunkSize = (int) (Math.random() * stringLength - 1) + 1;
			String s = TestUtils.randString(stringLength);
			assertEquals(GeneralSolution.sortChunks(s, chunkSize), sortChunks.invoke(testClass, s, chunkSize));
		}
	}

	@Test
	public void test_distance() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for (int i = 0; i < TestUtils.NUM_OF_TESTS; i++) {
			int x1 = (int) (Math.random() * 100f - 50f);
			int y1 = (int) (Math.random() * 100f - 50f);
			int x2 = (int) (Math.random() * 100f - 50f);
			int y2 = (int) (Math.random() * 100f - 50f);
			assertEquals(GeneralSolution.distance(x1, y1, x2, y2), distance.invoke(testClass, x1, y1, x2, y2));
		}
	}

	@Test
	public void test_circlesAreTangent()
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for (int i = 0; i < TestUtils.NUM_OF_TESTS; i++) {
			int x1 = (int) (Math.random() * 100f - 50f);
			int y1 = (int) (Math.random() * 100f - 50f);
			double radius1 = Math.random() * 50f + 0.1f;
			int x2 = (int) (Math.random() * 100f - 50f);
			int y2 = (int) (Math.random() * 100f - 50f);
			double radius2 = Math.random() * 50f + 0.1f;
			assertEquals(GeneralSolution.circlesAreTangent(x1, y1, radius1, x2, y2, radius2),
					circlesAreTangent.invoke(testClass, x1, y1, radius1, x2, y2, radius2));
		}

		for (int i = 0; i < TestUtils.NUM_OF_TESTS; i++) {
			int x1 = (int) (Math.random() * 100f - 50f);
			int y1 = (int) (Math.random() * 100f - 50f);
			double radius1 = Math.random() * 50f + 0.1f;
			int x2 = (int) (Math.random() * 100f - 50f);
			int y2 = (int) (Math.random() * 100f - 50f);
			double radius2 = GeneralSolution.distance(x1, y1, x2, y2) - radius1;
			assertTrue((boolean) circlesAreTangent.invoke(testClass, x1, y1, radius1, x2, y2, radius2));
		}
	}

	@Test
	public void test_removeDuplicates()
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for (int i = 0; i < TestUtils.NUM_OF_TESTS; i++) {
			int[] arr = new int[(int) (Math.random() * 50f + 1)];
			arr[0] = (int) (Math.random() * 100f);
			for (int j = 1; j < arr.length; j++) {
				int p = arr[j - 1];
				arr[j] = p + (int) (Math.random() * 3f);
			}
			assertTrue(Arrays.equals(GeneralSolution.removeDuplicates(arr),
					(int[]) removeDuplicates.invoke(testClass, arr)));
		}
	}

	@Test
	public void test_sumDigits() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for (int i = 0; i < TestUtils.NUM_OF_TESTS; i++) {
			int num = (int) (Math.random() * 10_000f);
			assertEquals(GeneralSolution.sumDigits(num), sumDigits.invoke(testClass, num));
		}
	}

	@Test
	public void test_countMoney() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for (int i = 0; i < TestUtils.NUM_OF_TESTS; i++) {
			int[] arr = new int[12];
			TestUtils.fillArray(arr, 0, 20);
			assertEquals(GeneralSolution.countMoney(arr), countMoney.invoke(testClass, arr));
		}
	}
}
