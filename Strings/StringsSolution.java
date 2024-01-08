package workshops.practice_problems.strings;

public class StringsSolution {

	// For all problems, assume strings are lowercase

	// SAMPLE PROBLEM
	// This function takes a String and prints out the same String with all the a's
	// removed. There are multiple ways to solve this problem, so I have included
	// all 3 in my solution:
	// 1. a loop through each letter
	// 2. a single replaceAll() call
	// 3. a loop that grabs substrings between each occurance of the letter 'a'
	// Some problems may have a particular solution that feels like it is "more
	// correct," but any and all correct solutions are valid. Please feel free to
	// explore your options and try multiple solutions, as that is the best way to
	// learn

	public static void printRemoveAs(String s) {
		// METHOD 1
		{
			String result = "";
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) != 'a')
					result += s.charAt(i);
			}
			System.out.println(result);
		}

		// METHOD 2
		{
			String result = s.replaceAll("a", "");
			System.out.println(result);
		}

		// METHOD 3
		{
			String result = "";
			while (s.contains("a")) {
				result += s.substring(0, s.indexOf('a'));
				s = s.substring(s.indexOf('a') + 1);
			}
			result += s;
			System.out.println(result);
		}
	}

	public static String removeEnds(String s) {
		return s.substring(1, s.length() - 1);
	}

	public static String addStars(String s) {
		if (s.length() < 2)
			return s;
		String res = s.charAt(0) + "";
		for (int i = 1; i < s.length(); i++) {
			res += "*" + s.charAt(i);
		}
		return res;
	}

	public static String reverse(String s) {
		String res = "";
		for (int i = 0; i < s.length(); i++) {
			res = s.charAt(i) + res;
		}
		return res;
	}

	public static String multiply(String s, int number) {
		String res = "";
		for (int i = 0; i < number; i++) {
			res += s;
		}
		return res;
	}

	public static String frontAgain(String s) {
		if (s.length() <= 2)
			return s + s;
		return s.substring(0, 2) + s;
	}

	public static boolean containsInTheMiddle(String s, String word) {
		if (!s.contains(word))
			return false;

		for (int i = 0; i < s.length(); i++) {
			int beginning = s.indexOf(word, i);
			int end = s.length() - word.length() - beginning;
			if (beginning != -1 && Math.abs(beginning - end) <= 1) {
				return true;
			}
		}
		return false;
	}

	public static String rotateLetters(String s, int rotations) {
		for (int i = 0; i < rotations; i++) {
			s = s.substring(1) + s.charAt(0);
		}
		return s;
	}

}
