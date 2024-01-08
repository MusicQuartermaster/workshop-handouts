package workshops.practice_problems.exception_handling;

public class ExceptionHandling {

	// SAMPLE PROBLEM 1
	// getValueOrThrow takes a String[] and an index and returns the value from the
	// array at that index. If the given index is out of bounds of the array, throw
	// an IndexOutOfBoundsException
	public static String getValueOrThrow(String[] arr, int index) {
		if (index < 0 || index >= arr.length) {
			throw new IndexOutOfBoundsException("Index " + index + " is out of bounds for array length " + arr.length);
		}
		return arr[index];
	}

	// SAMPLE PROBLEM 2
	// getValueOrNull takes a String[] and an index and returns the value from the
	// array at that index. If the given index out of bounds of the array, return
	// null instead
	public static String getValueOrNull(String[] arr, int index) {
		try {
			return arr[index];
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

	// TODO: Write a method called onlyEvenNumbers that takes an int and returns it
	// if it is even and throws an OddNumberException if it is odd

	// TODO: Write a method called containsVowel that takes a String and returns
	// whether it contains a vowel (case-insensitive); however, if the String
	// contains a number, throw a ContainsNumberException
}
