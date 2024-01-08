package workshops.practice_problems.conditionals_and_logic;

public class ConditionalsAndLogicSolution {

	/* SAMPLE PROBLEM 1 */
	// This code takes a number and returns it if it is odd (remainder = 1)
	// Else, it returns -1
	public static int sample1(int num) {
		if (num % 2 == 1) {
			return num;
		} else {
			return -1;
		}
	}

	/* SAMPLE PROBLEM 2 */
	// This code takes a number, returns it if it is positive, or returns its
	// opposite if it is negative
	public static int sample2(int num) {
		if (num > 0) {
			return num;
		} else {
			return num * -1;
		}
	}

	// TODO: Write code that takes a number and returns it if it is even (remainder
	// = 0)
	// Else, it returns -2
	public static int problem1(int num) {
		if (num % 2 == 0) {
			return num;
		} else {
			return -2;
		}
	}

	// TODO: Write code that takes a number and returns it if it's equal to 4
	// Else, if it is divisible by 4, then return num/4
	// Else, return the remainder of num/4
	public static int problem2(int num) {
		if (num == 4) {
			return 4;
		} else if (num % 4 == 0) {
			return num / 4;
		} else {
			return num % 4;
		}
	}

	// TODO: Write code that takes two numbers and returns the larger one
	// you cannot use Math.max()
	// if num1 = num2, return either one
	public static int problem3(int num1, int num2) {
		if (num1 > num2) {
			return num1;
		} else {
			return num2;
		}
	}

	// TODO: Write code that takes two numbers and returns the first number if it is
	// larger than the second number, unless the second number is negative, then
	// return the opposite of the first number. Else, return the second number.
	public static int problem4(int num1, int num2) {
		if (num2 < 0) {
			return -num1;
		} else if (num1 > num2) {
			return num1;
		} else {
			return num2;
		}
	}
}