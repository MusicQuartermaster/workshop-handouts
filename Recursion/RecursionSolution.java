package workshops.practice_problems.recursion;

public class RecursionSolution {

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
		// base case 1
		if (a == 0)
			return b;
		// base case 2
		if (b == 0)
			return a;

		// recursive case
		return 1 + add(a - 1, b);
	}

	/* PROBLEM 2 */
	// TODO: Write code to return the nth term of the fibonacci sequence
	// Note: each term is calculated by summing the previous two terms
	// 0 1 1 2 3 5 8 13 21 34 55...
	public static int fibonacci(int n) {
		// base case
		if (n == 0 || n == 1)
			return n;

		// recursive case
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	/* PROBLEM 3 */
	// TODO: Write code to calculate the factorial of a number
	// Note 1: factorial is calculated as...n! = n * (n-1) * (n-2) * ... * 1
	// 5! = 5 * 4 * 3 * 2 * 1
	// Note 2: 0! = 1
	public static long factorial(int n) {
		// base case
		if (n == 0 || n == 1)
			return 1;

		// recursive case
		return n * factorial(n - 1);
	}

	/* PROBLEM 4 */
	// TODO: Write code to recursively calculate a^b
	public static int power(int a, int b) {
		// 0^0 is undefined, but here you can just return 0
		// base case 1
		if (a == 0)
			return 0;
		// base case 2
		if (b == 0 || a == 1)
			return 1;

		// recursive case
		return a * power(a, b - 1);
	}

	/* PROBLEM 5 */
	// TODO: Write code that counts the number of 'L's in a given string
	public static int countLs(String s) {
		// base case
		if (s.length() == 0)
			return 0;

		char next = s.toLowerCase().charAt(0);

		// recursive case 1
		if (next == 'l')
			return 1 + countLs(s.substring(1));
		// recursive case 2
		return countLs(s.substring(1));
	}

	/* PROBLEM 6 */
	// TODO: Write code that loops through an array and returns the sum
	// Note: this method requires a helper method that takes a double[] and an int
	public static double sumArray(double[] arr) {
		// initial function call
		return sumArray(arr, 0);
	}

	// helper method
	private static double sumArray(double[] arr, int index) {
		// base case
		if (index >= arr.length)
			return 0.0;

		// recursive case
		return arr[index] + sumArray(arr, index + 1);
	}

	/* PROBLEM 7 */
	// TODO: Write code that takes a String and recursively replaces every vowel
	// (case insensitive)
	// with '@'
	public static String replaceVowels(String s) {
		// base case
		if (s.length() == 0)
			return "";

		char lowerNext = s.toLowerCase().charAt(0);
		char next = s.charAt(0);

		// recursive case 1
		if (lowerNext == 'a' || lowerNext == 'e' || lowerNext == 'i' || lowerNext == 'o' || lowerNext == 'u')
			return "@" + replaceVowels(s.substring(1));
		// recursive case 2
		return next + replaceVowels(s.substring(1));
	}

	/* PROBLEM 8 */
	// TODO: Write code that takes an int[] and returns true if the array contains
	// the number 6
	// Note: this method requires a helper method that takes an int[] and an int
	public static boolean contains6(int[] arr) {
		// initial function call
		return contains6(arr, 0);
	}

	// helper method
	private static boolean contains6(int[] arr, int index) {
		// base case 1
		if (index >= arr.length)
			return false;
		// base case 2
		if (arr[index] == 6)
			return true;

		// recursive case
		return contains6(arr, index + 1);
	}

	/* PROBLEM 9 */
	// TODO: Write code that takes a String and returns a new String with a '*'
	// between each letter
	public static String addStar(String s) {
		// base case
		if (s.length() <= 1)
			return s;

		// recursive case
		return s.charAt(0) + "*" + addStar(s.substring(1));
	}

	/* PROBLEM 10 */
	// TODO: Write code that takes a lowercase String and returns a new String where
	// all the 'x's have been moved to the end of the String
	public static String endX(String s) {
		// base case
		if (s.length() <= 1)
			return s;

		char next = s.charAt(0);

		// recursive case 1
		if (next == 'x')
			return endX(s.substring(1)) + next;
		// recursive case 2
		return next + endX(s.substring(1));
	}
}