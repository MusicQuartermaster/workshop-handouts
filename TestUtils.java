package workshops.practice_problems;

public abstract class TestUtils {

	public static boolean coinFlip() {
		return Math.random() > .5;
	}

	public static boolean coinFlip(int flips) {
		for (int i = 0; i < flips; i++) {
			if (!coinFlip())
				return false;
		}
		return true;
	}

	public static String randString(int length) {
		String s = "";
		for (int i = 0; i < length; i++) {
			char c;
			if (i > 0 && i < length - 1 && coinFlip(3)) {
				c = ' ';
			} else {
				c = (char) ((Math.random() * 26) + (coinFlip() ? 'A' : 'a'));
			}
			s += c;
		}
		return s;
	}

	public static void fillArray(int[] arr, int min, int max) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * (max + 1 - min) + min);
		}
	}

	public static void fillArray(double[] arr, double min, double max) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Math.random() * (max - min) + min;
		}
	}

	public static void fillArray(char[] arr, char min, char max) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (char) (Math.random() * (max + 1 - min) + min);
		}
	}

	public static void fillArray(String[] arr, int minLen, int maxLen) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = randString((int) (Math.random() * (maxLen - minLen)) + minLen);
		}
	}

	public static int sumArray(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}

	public static double sumArray(double[] arr) {
		double sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}
}
