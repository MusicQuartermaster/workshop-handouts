package workshops.practice_problems.classes_and_objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

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
	private List<String> colors = Arrays.asList(new String[] { "red", "orange", "yellow", "green", "teal", "blue",
			"indigo", "violet", "purple", "magenta", "pink", "brown", "black", "white" });

	private Class<?> testClass = Circle.class;

	private Constructor<?> defaultConstructor, constructor;

	private Method getColor, setColor, getRadius, setRadius, getArea, getCircumference, equals;
	private Method calculateArea, calculateCircumference;

	private Field color, radius;

	@Before
	public void Setup() throws NoSuchFieldException, SecurityException, NoSuchMethodException {
		// Constructors
		defaultConstructor = testClass.getConstructor();
		constructor = testClass.getConstructor(double.class, String.class);

		// Fields
		color = testClass.getDeclaredField("color");
		radius = testClass.getDeclaredField("radius");
		color.setAccessible(true);
		radius.setAccessible(true);

		// Instance Methods
		getColor = testClass.getMethod("getColor");
		setColor = testClass.getMethod("setColor", String.class);
		getRadius = testClass.getMethod("getRadius");
		setRadius = testClass.getMethod("setRadius", double.class);
		getArea = testClass.getMethod("getArea");
		getCircumference = testClass.getMethod("getCircumference");
		equals = testClass.getMethod("equals", Object.class);

		// Class (Static) Methods
		calculateArea = testClass.getMethod("calculateArea", double.class);
		calculateCircumference = testClass.getMethod("calculateCircumference", double.class);
	}

	@Test
	public void test_defaultConstructor()
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException, NoSuchFieldException {
		Object circle = defaultConstructor.newInstance();

		assertNotNull(circle);

		// Color
		assertNotNull(color.get(circle));
		assertEquals("black", color.get(circle));

		// Radius
		assertNotNull(radius.getDouble(circle));
		assertEquals(1.0, radius.getDouble(circle), 0.0);
	}

	@Test
	public void test_constructor() throws InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		for (int i = 0; i < TestUtils.NUM_OF_TESTS; i++) {
			String randColor = colors.get((int) (Math.random() * colors.size()));
			double randRadius = Math.random() * 100f + 1;

			Object circle = constructor.newInstance(randRadius, randColor);

			assertNotNull(circle);

			// Color
			assertNotNull(color.get(circle));
			assertEquals(randColor, color.get(circle));

			// Radius
			assertNotNull(radius.getDouble(circle));
			assertEquals(randRadius, radius.getDouble(circle), 0.0);
		}
	}

	@Test
	public void test_getters() throws InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		for (int i = 0; i < TestUtils.NUM_OF_TESTS; i++) {
			String randColor = colors.get((int) (Math.random() * colors.size()));
			double randRadius = Math.random() * 100f + 1;

			Object circle = constructor.newInstance(randRadius, randColor);

			assertNotNull(circle);

			// Color
			assertNotNull(color.get(circle));
			assertEquals(randColor, getColor.invoke(circle));

			// Radius
			assertNotNull(radius.getDouble(circle));
			assertEquals(randRadius, (double) getRadius.invoke(circle), 0.0);
		}
	}

	@Test
	public void test_setters() throws InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		Object circle = defaultConstructor.newInstance();
		for (int i = 0; i < TestUtils.NUM_OF_TESTS; i++) {
			String randColor = colors.get((int) (Math.random() * colors.size()));
			double randRadius = Math.random() * 100f + 1;

			setColor.invoke(circle, randColor);
			setRadius.invoke(circle, randRadius);

			// Color
			assertNotNull(color.get(circle));
			assertEquals(randColor, color.get(circle));

			// Radius
			assertNotNull(radius.getDouble(circle));
			assertEquals(randRadius, radius.getDouble(circle), 0.0);
		}
	}

	@Test
	public void test_areaAndCircumference() throws InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		for (int i = 0; i < TestUtils.NUM_OF_TESTS; i++) {
			String randColor = colors.get((int) (Math.random() * colors.size()));
			double randRadius = Math.random() * 100f + 1;

			double circumference = 2 * Math.PI * randRadius;
			double area = Math.PI * randRadius * randRadius;

			Object circle = constructor.newInstance(randRadius, randColor);

			Object actCircumference = getCircumference.invoke(circle);
			Object actArea = getArea.invoke(circle);

			// Circumference
			assertNotNull(actCircumference);
			assertEquals(circumference, (double) actCircumference, TestUtils.DOUBLE_THRESHOLD);

			// Area
			assertNotNull(actArea);
			assertEquals(area, (double) actArea, TestUtils.DOUBLE_THRESHOLD);
		}
	}

	@Test
	public void test_equals() throws InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		{
			Object circle = defaultConstructor.newInstance();
			assertFalse((boolean) equals.invoke(circle, new Object[] { null }));
			assertFalse((boolean) equals.invoke(circle, new Object()));
			assertFalse((boolean) equals.invoke(circle, "Not A Circle"));
			assertTrue((boolean) equals.invoke(circle, circle));
		}
		for (int i = 0; i < TestUtils.NUM_OF_TESTS; i++) {
			int colorIdx = (int) (Math.random() * colors.size());
			String randColor = colors.get(colorIdx);
			double randRadius = Math.random() * 100f + 1;
			Object circle = constructor.newInstance(randRadius, randColor);

			assertNotNull(circle);

			String otherColor = colors.get((colorIdx + 1) % colors.size());
			double otherRadius = randRadius * (Math.random() * 10f + 1);
			Object other = constructor.newInstance(otherRadius, otherColor);

			assertNotNull(other);
			assertNotNull(color.get(circle));
			assertNotNull(radius.getDouble(circle));

			assertFalse((boolean) equals.invoke(circle, other));
		}

		for (int i = 0; i < TestUtils.NUM_OF_TESTS; i++) {
			int colorIdx = (int) (Math.random() * colors.size());
			String randColor = colors.get(colorIdx);
			double randRadius = Math.random() * 100f + 1;
			Object circle = constructor.newInstance(randRadius, randColor);

			assertNotNull(circle);

			Object other = constructor.newInstance(randRadius, randColor);

			assertNotNull(other);
			assertNotNull(color.get(circle));
			assertNotNull(radius.getDouble(circle));

			assertTrue((boolean) equals.invoke(circle, other));
		}
	}

	@Test
	public void test_staticMethods() throws InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		for (int i = 0; i < TestUtils.NUM_OF_TESTS; i++) {
			double randRadius = Math.random() * 100f + 1;

			double circumference = 2 * Math.PI * randRadius;
			double area = Math.PI * randRadius * randRadius;

			// Circumference
			assertEquals(circumference, (double) calculateCircumference.invoke(testClass, randRadius),
					TestUtils.DOUBLE_THRESHOLD);

			// Area
			assertEquals(area, (double) calculateArea.invoke(testClass, randRadius), TestUtils.DOUBLE_THRESHOLD);
		}
	}
}
