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

	// write a function that takes a String and returns the same string without the
	// first and last letter
	public static String removeEnds(String s) {
		return s.substring(1, s.length() - 1);
	}

	// write a function that takes a String and returns a new string with a star (*)
	// between each letter, so
	// addStars("STRING") -> "S*T*R*I*N*G"
	public static String addStars(String s) {
		if (s.length() < 2)
			return s;
		String res = s.charAt(0) + "";
		for (int i = 1; i < s.length(); i++) {
			res += "*" + s.charAt(i);
		}
		return res;
	}

	// write a function that takes a String and returns the same String but reversed
	// reverse("Hello") -> "olleH"
	public static String reverse(String s) {
		String res = "";
		for (int i = 0; i < s.length(); i++) {
			res = s.charAt(i) + res;
		}
		return res;
	}

	// write a function that takes a String and an int N and returns a new String
	// made of N number of the original String, so
	// multiply("Hello", 3) -> "HelloHelloHello"
	public static String multiply(String s, int N) {
		String res = "";
		for (int i = 0; i < N; i++) {
			res += s;
		}
		return res;
	}

	// write a function that takes a String and returns a new String with the first
	// 2 letters appearing twice at the beginning of the String
	// frontAgain("Hello") -> "HeHello"
	public static String frontAgain(String s) {
		if (s.length() <= 2)
			return s + s;
		return s.substring(0, 2) + s;
	}

	// write a function that takes 2 Strings and returns true if the first String
	// contains the second String in the middle
	// the second String is in the middle if the number of chars on each side
	// differs by at most one.
	// For example, XXX is considered to be in the middle for the Strings
	// "aaaXXXaaa", "aaXXXaaa", and "aaaXXXaa", but not for
	// "aaaXXXa" or "aaXXXaaaa"
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

	// write a function that takes a String and rotates it by a given int, where a
	// rotation is done by taking the first letter in the string and moving it to
	// the end of the String
	// rotateLetters("Hello", 1) -> "elloH"
	// rotateLetters("World", 2) -> "rldWo"
	public static String rotateLetters(String s, int rotations) {
		for (int i = 0; i < rotations; i++) {
			s = s.substring(1) + s.charAt(0);
		}
		return s;
	}

	// write a fuction that takes 2 Strings and returns the number of times the
	// second String appears in the first String. Include overlapping substrings in
	// the count.
	// countSubstrings("AAABAA", "AA") -> 3
	public static int countSubstrings(String str, String substr) {
		int count = 0;
		while (str.contains(substr)) {
			if (str.startsWith(substr)) {
				count++;
			}
			str = str.substring(1);
		}
		return count;
	}
}
