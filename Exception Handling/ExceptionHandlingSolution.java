package workshops.practice_problems.exception_handling;

public class ExceptionHandlingSolution {

	public static String getValueOrThrow(String[] arr, int index) {
		if (index < 0 || index >= arr.length) {
			throw new IndexOutOfBoundsException("Index " + index + " is out of bounds for array length " + arr.length);
		}
		return arr[index];
	}

	public static String getValueOrNull(String[] arr, int index) {
		try {
			return arr[index];
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

	public static int onlyEvenNumbers(int num) throws OddNumberException {
		if (num % 2 == 1)
			throw new OddNumberException(num + " is odd");
		return num;
	}

	public static boolean containsVowel(String s) throws ContainsNumberException {
		if (s.matches(".*\\d.*"))
			throw new ContainsNumberException(s + " contains a number");

		return s.matches(".*[AEIOUaeiou].*");
	}
}
