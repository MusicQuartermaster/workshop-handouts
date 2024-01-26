package workshops.practice_problems.strings;

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

	Class<?> testClass = Strings.class;

	Method removeEnds, addStars, reverse, multiply, frontAgain, containsInTheMiddle, rotateLetters, countSubstrings;

	@Before
	public void Setup() throws NoSuchFieldException, SecurityException, NoSuchMethodException {
		removeEnds = testClass.getMethod("removeEnds", String.class);
		addStars = testClass.getMethod("addStars", String.class);
		reverse = testClass.getMethod("reverse", String.class);
		multiply = testClass.getMethod("multiply", String.class, int.class);
		frontAgain = testClass.getMethod("frontAgain", String.class);
		containsInTheMiddle = testClass.getMethod("containsInTheMiddle", String.class, String.class);
		rotateLetters = testClass.getMethod("rotateLetters", String.class, int.class);
		countSubstrings = testClass.getMethod("countSubstrings", String.class, String.class);
	}

	@Test
	public void test_removeEnds() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for (int i = 0; i < TestUtils.NUM_OF_TESTS; i++) {
			int stringLength = (int) (Math.random() * TestUtils.STRING_LENGTH + 2);
			String s = TestUtils.randString(stringLength);
			assertEquals(StringsSolution.removeEnds(s), removeEnds.invoke(testClass, s));
		}
	}

	@Test
	public void test_addStars() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for (int i = 0; i < TestUtils.NUM_OF_TESTS; i++) {
			int stringLength = (int) (Math.random() * TestUtils.STRING_LENGTH + 2);
			String s = TestUtils.randString(stringLength);
			assertEquals(StringsSolution.addStars(s), addStars.invoke(testClass, s));
		}
	}

	@Test
	public void test_reverse() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for (int i = 0; i < TestUtils.NUM_OF_TESTS; i++) {
			int stringLength = (int) (Math.random() * TestUtils.STRING_LENGTH + 2);
			String s = TestUtils.randString(stringLength);
			assertEquals(StringsSolution.reverse(s), reverse.invoke(testClass, s));
		}
	}

	@Test
	public void test_multiply() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for (int i = 0; i < TestUtils.NUM_OF_TESTS; i++) {
			int stringLength = (int) (Math.random() * TestUtils.STRING_LENGTH + 2);
			String s = TestUtils.randString(stringLength);
			int factor = (int) (Math.random() * 10f);
			assertEquals(StringsSolution.multiply(s, factor), multiply.invoke(testClass, s, factor));
		}
	}

	@Test
	public void test_frontAgain() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for (int i = 0; i < TestUtils.NUM_OF_TESTS; i++) {
			int stringLength = (int) (Math.random() * TestUtils.STRING_LENGTH + 2);
			String s = TestUtils.randString(stringLength);
			assertEquals(StringsSolution.frontAgain(s), frontAgain.invoke(testClass, s));
		}
	}

	@Test
	public void test_containsInTheMiddle()
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for (int i = 0; i < TestUtils.NUM_OF_TESTS; i++) {
			int stringLength = (int) (Math.random() * TestUtils.STRING_LENGTH + 4);
			String s = TestUtils.randString(stringLength);
			int wordLength = stringLength - (int) (Math.random() * 2 + 1);
			String word = TestUtils.randString(wordLength);
			assertEquals(StringsSolution.containsInTheMiddle(s, word), containsInTheMiddle.invoke(testClass, s, word));
		}

		for (int i = 0; i < TestUtils.NUM_OF_TESTS; i++) {
			int stringLength = (int) (Math.random() * TestUtils.STRING_LENGTH + 4);
			String s = TestUtils.randString(stringLength);
			int wordLength = stringLength - (int) (Math.random() * 2 + 1);
			int wordLocation = (stringLength - wordLength) / 2;
			String word = s.substring(wordLocation, wordLocation + wordLength);
			assertEquals(StringsSolution.containsInTheMiddle(s, word), containsInTheMiddle.invoke(testClass, s, word));
		}
	}

	@Test
	public void test_rotateLetters()
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for (int i = 0; i < TestUtils.NUM_OF_TESTS; i++) {
			int stringLength = (int) (Math.random() * TestUtils.STRING_LENGTH + 2);
			String s = TestUtils.randString(stringLength);
			int rotation = (int) (Math.random() * stringLength);
			assertEquals(StringsSolution.rotateLetters(s, rotation), rotateLetters.invoke(testClass, s, rotation));
		}
	}

	@Test
	public void test_countSubstrings()
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for (int i = 0; i < TestUtils.NUM_OF_TESTS; i++) {
			int stringLength = (int) (Math.random() * TestUtils.STRING_LENGTH + 2);
			String s = TestUtils.randString(stringLength);
			int substrLength = (int) (Math.random() * 2 + 1);
			String substr = TestUtils.randString(substrLength);
			assertEquals(StringsSolution.countSubstrings(s, substr), countSubstrings.invoke(testClass, s, substr));
		}

		for (int i = 0; i < TestUtils.NUM_OF_TESTS; i++) {
			int stringLength = (int) (Math.random() * TestUtils.STRING_LENGTH + 2);
			String s = TestUtils.randString(stringLength);
			int substrLength = (int) (Math.random() * 2 + 1);
			int substrIdx = (int) (Math.random() * (stringLength - substrLength));
			String substr = s.substring(substrIdx, substrIdx + substrLength);
			assertEquals(StringsSolution.countSubstrings(s, substr), countSubstrings.invoke(testClass, s, substr));
		}
	}
}
