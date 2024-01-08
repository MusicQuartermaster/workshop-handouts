package workshops.practice_problems.methods_and_functions;

public class MethodsAndFunctionsSolution {

	public static double multiply(double a, double b) {
		return a * b;
	}

	public static int integerDivision(int dividend, int divisor) {
		return dividend / divisor;
	}

	public static int divisionRemainder(int divident, int divisor) {
		return divident % divisor;
	}

	public static double calculateRectanglePerimeter(double length, double width) {
		return 2 * length + 2 * width;
	}

	public static int findMax(int a, int b, int c) {
		return Math.max(a, Math.max(b, c));
	}

	public static boolean isPalindrome(String phrase) {
		phrase = phrase.toLowerCase().replaceAll(" ", "");
		for (int i = 0; i < phrase.length() / 2; i++) {
			if (phrase.charAt(i) != phrase.charAt(phrase.length() - 1 - i))
				return false;
		}
		return true;
	}

	public static boolean isPrime(int num) {
		if (num <= 1)
			return false;
		int upperBound = (int) (Math.sqrt(num) + 1);
		for (int i = 2; i <= upperBound; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

	public static double calculateHypotenuse(double a, double b) {
		return Math.sqrt(a * a + b * b);
	}

	public static int findGCD(int num1, int num2) {
		for (int i = Math.min(num1, num2); i > 1; i--) {
			if (num1 % i == 0 && num2 % i == 0)
				return i;
		}
		return 1;
	}

	public static boolean isPerfectSquare(int num) {
		int sqrt = (int) Math.sqrt(num);
		return sqrt * sqrt == num;
	}

	public static long factorial(int n) {
		long res = 1;
		for (int i = 1; i <= n; i++) {
			res *= i;
		}
		return res;
	}

	public static String convertDecToBin(int decimal) {
		String binary = "";
		while (decimal > 0) {
			binary = (decimal % 2) + "" + binary;
			decimal /= 2;
		}
		return binary;
	}

	public static int convertBinToDec(String binary) {
		int decimal = 0;
		for (int i = binary.length() - 1, j = 0; i >= 0; i--, j++) {
			decimal += binary.charAt(i) == '1' ? ((int) Math.pow(2, j)) : 0;
		}
		return decimal;
	}
}