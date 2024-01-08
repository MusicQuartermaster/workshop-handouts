package workshops.practice_problems.loops_and_arrays;

public class LoopsAndArraysSolution {
	// TODO: Create a method that constructs an double array with the given length
	public static double[] CreateArray(int arrayLength) {
		return new double[arrayLength];
	}

	// TODO: Create a method that takes a double[] and fills it with random values
	// with a minimum of minValue and a range of valueRange
	public static void FillArray(double[] array, double minValue, double valueRange) {
		for (int i = 0; i < array.length; i++) {
			array[i] = Math.random() * valueRange + minValue;
		}
	}

	// TODO: Create and return an exact copy of the given array
	// Do not use the clone() method
	public static String[] CopyArray(String[] array) {
		String[] copy = new String[array.length];
		for (int i = 0; i < copy.length; i++) {
			copy[i] = array[i];
		}
		return copy;
	}

	// TODO: Loop through the array and print each value on one line
	public static void PrintArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

	// TODO: Create a method that takes an int[] and returns the sum of its values
	public static int ArraySum(int[] array) {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		return sum;
	}

	// TODO: Create a method that takes a double[] and returns the sum of only the
	// positive values
	public static double PositiveSum(double[] array) {
		double sum = 0f;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > 0)
				sum += array[i];
		}
		return sum;
	}

	// TODO: Create a method that takes an int[] and an int and returns true if the
	// array contains the value, false otherwise
	public static boolean ContainsValue(int[] array, int value) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == value)
				return true;
		}
		return false;
	}

	// TODO: Loop through the given array and double each value
	public static void DoubleValues(int[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] *= 2;
		}
	}

	// TODO: Loop through the array and print the array in reverse on one line
	public static void PrintReverse(String[] array) {
		for (int i = array.length - 1; i >= 0; i--) {
			System.out.print(array[i] + " ");
		}
	}

	// TODO: Reverse the given array: [1, 2, 3, 4] => [4, 3, 2, 1]
	public static void ReverseArray(int[] array) {
		for (int i = 0; i < array.length / 2; i++) {
			int otherIndex = array.length - 1 - i;
			int temp = array[i];
			array[i] = array[otherIndex];
			array[otherIndex] = temp;
		}
	}
}