package workshops.practice_problems.recursion;

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

	Class<?> testClass = Recursion.class;

	Method multiply, removeA, add, fibonacci, findMax, factorial, power, countLs, sumArray, replaceVowels, contains6,
			addStar, endX;

	@Before
	public void Setup() throws NoSuchFieldException, SecurityException, NoSuchMethodException {
		multiply = testClass.getMethod("multiply", int.class, int.class);
		removeA = testClass.getMethod("removeA", String.class);
		add = testClass.getMethod("add", int.class, int.class);
		fibonacci = testClass.getMethod("fibonacci", int.class);
		factorial = testClass.getMethod("factorial", int.class);
		power = testClass.getMethod("power", int.class, int.class);
		countLs = testClass.getMethod("countLs", String.class);
		sumArray = testClass.getMethod("sumArray", double[].class);
		replaceVowels = testClass.getMethod("replaceVowels", String.class);
		contains6 = testClass.getMethod("contains6", int[].class);
		addStar = testClass.getMethod("addStar", String.class);
		endX = testClass.getMethod("endX", String.class);
	}

	@Test
	public void test_multiply() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for (int i = 0; i < TestUtils.NUM_OF_TESTS; i++) {
			int num1 = (int) (Math.random() * 100f + 1);
			int num2 = (int) (Math.random() * 100f + 1);
			assertEquals(num1 * num2, multiply.invoke(testClass, num1, num2));
		}
		assertEquals(0, multiply.invoke(testClass, (int) (Math.random() * 100f), 0));
		assertEquals(0, multiply.invoke(testClass, 0, (int) (Math.random() * 100f)));
	}

	@Test
	public void test_removeA() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for (int i = 0; i < TestUtils.NUM_OF_TESTS; i++) {
			String s = TestUtils.randString(TestUtils.STRING_LENGTH).toLowerCase();
			assertEquals(s.replaceAll("[aA]", ""), removeA.invoke(testClass, s));
		}
	}

	@Test
	public void test_add() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for (int i = 0; i < TestUtils.NUM_OF_TESTS; i++) {
			int num1 = (int) (Math.random() * 100f + 2);
			int num2 = (int) (Math.random() * 100f + 2);
			assertEquals(num1 + num2, add.invoke(testClass, num1, num2));
		}
	}

	@Test
	public void test_fibonacci() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for (int i = 0; i < TestUtils.NUM_OF_TESTS; i++) {
			int num = (int) (Math.random() * 40f + 1);
			int resA = 0;
			int resB = 1;
			for (int j = 0; j < num; j++) {
				int temp = resA + resB;
				resA = resB;
				resB = temp;
			}
			assertEquals(resA, fibonacci.invoke(testClass, num));
		}
		assertEquals(0, fibonacci.invoke(testClass, 0));
		assertEquals(1, fibonacci.invoke(testClass, 1));
	}

	@Test
	public void test_factorial() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for (int i = 0; i < TestUtils.NUM_OF_TESTS; i++) {
			int num = (int) (Math.random() * 20);
			long res = 1;
			for (int j = 1; j <= num; j++) {
				res *= j;
			}
			assertEquals(res, (long) factorial.invoke(testClass, num));
		}
	}

	@Test
	public void test_power() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for (int i = 0; i < TestUtils.NUM_OF_TESTS; i++) {
			int base = (int) (Math.random() * 10f + 1);
			assertEquals(1, power.invoke(testClass, base, 0));
		}

		for (int i = 0; i < TestUtils.NUM_OF_TESTS; i++) {
			int pow = (int) (Math.random() * 10f + 1);
			assertEquals(0, power.invoke(testClass, 0, pow));
		}

		for (int i = 0; i < TestUtils.NUM_OF_TESTS; i++) {
			int base = (int) (Math.random() * 5f + 1);
			int pow = (int) (Math.random() * 5f + 1);
			assertEquals((int) (Math.pow(base, pow)), power.invoke(testClass, base, pow));
		}

		assertEquals(0, power.invoke(testClass, 0, 0));
	}

	@Test
	public void test_countLs() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for (int i = 0; i < TestUtils.NUM_OF_TESTS; i++) {
			String s = TestUtils.randString(TestUtils.STRING_LENGTH);
			assertEquals(Recursion.countLs(s), (int) countLs.invoke(testClass, s));
		}
	}

	@Test
	public void test_sumArray() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for (int i = 0; i < TestUtils.NUM_OF_TESTS; i++) {
			double[] arr = new double[(int) (Math.random() * 50)];
			double sum = 0f;
			for (int j = 0; j < arr.length; j++) {
				arr[j] = Math.random() * 100f;
				sum += arr[j];
			}
			assertEquals(sum, (double) sumArray.invoke(testClass, arr), TestUtils.DOUBLE_THRESHOLD);
		}
	}

	@Test
	public void test_replaceVowels()
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for (int i = 0; i < TestUtils.NUM_OF_TESTS; i++) {
			String s = TestUtils.randString(TestUtils.STRING_LENGTH);
			String res = s.replaceAll("[AEIOUaeiou]", "@");
			assertEquals(res, (String) replaceVowels.invoke(testClass, s));
		}
	}

	@Test
	public void test_contains6() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for (int i = 0; i < TestUtils.NUM_OF_TESTS; i++) {
			int[] arr = new int[(int) (Math.random() * 50)];
			TestUtils.fillArray(arr, 0, 100);
			boolean res = false;
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] == 6) {
					res = true;
					break;
				}
			}
			assertEquals(res, (boolean) contains6.invoke(testClass, arr));
		}
	}

	@Test
	public void test_addStar() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for (int i = 0; i < TestUtils.NUM_OF_TESTS; i++) {
			String s = TestUtils.randString((int) (Math.random() * TestUtils.STRING_LENGTH + 1));
			assertEquals(Recursion.addStar(s), (String) addStar.invoke(testClass, s));
		}
	}

	@Test
	public void test_endX() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for (int i = 0; i < TestUtils.NUM_OF_TESTS; i++) {
			String s = TestUtils.randString(TestUtils.STRING_LENGTH).toLowerCase();
			String res = "";
			int count = 0;
			for (int j = 0; j < s.length(); j++) {
				if (s.toLowerCase().charAt(j) == 'x')
					count++;
				else
					res += s.charAt(j);
			}
			for (int j = 0; j < count; j++) {
				res += "x";
			}
			assertEquals(res, (String) endX.invoke(testClass, s));
		}
	}

}
