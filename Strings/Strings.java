package workshops.practice_problems.strings;

public class Strings {

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
		return null;
	}

	// write a function that takes a String and returns a new string with a star (*)
	// between each letter, so
	// addStars("STRING") -> "S*T*R*I*N*G"
	public static String addStars(String s) {
		return null;
	}

	// write a function that takes a String and returns the same String but reversed
	// reverse("Hello") -> "olleH"
	public static String reverse(String s) {
		return null;
	}

	// write a function that takes a String and an int N and returns a new String
	// made of N number of the original String, so
	// multiply("Hello", 3) -> "HelloHelloHello"
	public static String multiply(String s, int number) {
		return null;
	}

	// write a function that takes a String and returns a new String with the first
	// 2 letters appearing twice at the beginning of the String
	// frontAgain("Hello") -> "HeHello"
	public static String frontAgain(String s) {
		return null;
	}

	// write a function that takes 2 Strings and returns true if the first String
	// contains the second String in the middle
	// the second String is in the middle if the number of chars on each side
	// differs by at most one.
	// For example, XXX is considered to be in the middle for the Strings
	// "aaaXXXaaa", "aaXXXaaa", and "aaaXXXaa", but not for
	// "aaaXXXa" or "aaXXXaaaa"
	public static boolean containsInTheMiddle(String s, String word) {
		return false;
	}

	// write a function that takes a String and rotates it by a given int, where a
	// rotation is done by taking the first letter in the string and moving it to
	// the end of the String
	// rotateLetters("Hello", 1) -> "elloH"
	// rotateLetters("World", 2) -> "rldWo"
	public static String rotateLetters(String s, int rotations) {
		return null;
	}

	// write a fuction that takes 2 Strings and returns the number of times the
	// second String appears in the first String. Include overlapping substrings in
	// the count.
	// countSubstrings("AAABAA", "AA") -> 3
	public static int countSubstrings(String str, String substr) {
		return -1;
	}
}
