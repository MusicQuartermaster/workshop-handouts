package workshops.practice_problems.recursion;

public class Recursion {

	/* SAMPLE PROBLEM 1 */
	// This function takes two numbers and recursively returns their product
	public static int multiply(int a, int b) {
		// base case 1
		// if either value is 0, the result is 0
		if (a == 0 || b == 0)
			return 0;
		// base case 2
		// 1 * b = b
		if (a == 1)
			return b;
		// a * 1 = a
		// base case 3
		if (b == 1)
			return a;

		// recursive case
		// a * b = b + [(a-1) * b]
		return b + multiply(a - 1, b);
	}

	/* SAMPLE PROBLEM 2 */
	// This function takes a String and removes every 'a' (case insensitive) from it
	public static String removeA(String s) {
		// base case
		// if s = "", there are no more 'a's to remove
		if (s.length() == 0)
			return "";

		char next = s.charAt(0);
		// if the next letter is an 'a', ignore it and return the rest of the string
		if (next == 'a')
			// recursive case 1
			return removeA(s.substring(1));

		// recursive case 2
		// else, return the next letter followed by the rest of the string
		return next + removeA(s.substring(1));
	}

	/* PROBLEM 1 */
	// TODO: Write code to recursively add two numbers together
	public static int add(int a, int b) {
		return -1;
	}

	/* PROBLEM 2 */
	// TODO: Write code to return the nth term of the fibonacci sequence
	// Note: each term is calculated by summing the previous two terms
	// 0 1 1 2 3 5 8 13 21 34 55...
	public static int fibonacci(int n) {
		return -1;
	}

	/* PROBLEM 3 */
	// TODO: Write code to calculate the factorial of a number
	// Note 1: factorial is calculated as...n! = n * (n-1) * (n-2) * ... * 1
	// 5! = 5 * 4 * 3 * 2 * 1
	// Note 2: 0! = 1
	public static long factorial(int n) {
		return -1;
	}

	/* PROBLEM 4 */
	// TODO: Write code to recursively calculate a^b
	public static int power(int a, int b) {
		// 0^0 is undefined, but here you can just return 0
		return -1;
	}

	/* PROBLEM 5 */
	// TODO: Write code that counts the number of 'L's (case insensitive) in a given
	// string
	public static int countLs(String s) {
		return -1;
	}

	/* PROBLEM 6 */
	// TODO: Write code that loops through an array and returns the sum
	// Note: this method requires a helper method that takes a double[] and an int
	public static double sumArray(double[] arr) {
		return -1.0;
	}

	/* PROBLEM 7 */
	// TODO: Write code that takes a String and recursively replaces every vowel
	// (case insensitive)
	// with '@'
	public static String replaceVowels(String s) {
		return null;
	}

	/* PROBLEM 8 */
	// TODO: Write code that takes an int[] and returns true if the array contains
	// the number 6
	// Note: this method requires a helper method that takes an int[] and an int
	public static boolean contains6(int[] arr) {
		return false;
	}

	/* PROBLEM 9 */
	// TODO: Write code that takes a String and returns a new String with a '*'
	// between each letter
	public static String addStar(String s) {
		return null;
	}

	/* PROBLEM 10 */
	// TODO: Write code that takes a lowercase String and returns a new String where
	// all the 'x's have been moved to the end of the String
	public static String endX(String s) {
		return null;
	}
}