package workshops.practice_problems.general;

public class GeneralSolution {

	public static String sortChunks(String s, int chunkSize) {
		// place chunks into an array
		String[] chunks = new String[s.length() / chunkSize + 1];
		for (int i = 0, chunk = 0; i < chunks.length; i++, chunk += chunkSize) {
			chunks[i] = s.substring(chunk, Math.min(chunk + chunkSize, s.length()));
		}

		// sort the array and place results back into a String
		String res = "";
		for (int i = 0; i < chunks.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < chunks.length; j++) {
				if (chunks[j].compareTo(chunks[min]) < 0) {
					min = j;
				}
			}
			String temp = chunks[min];
			chunks[min] = chunks[i];
			chunks[i] = temp;
			res += chunks[i];
		}
		res += chunks[chunks.length - 1];
		return res;
	}

	public static double distance(int x1, int y1, int x2, int y2) {
		// distance = sqrt[ (x2-x1)^2 + (y2-y1)^2 ]
		double distSqr = (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
		return Math.sqrt(distSqr);
	}

	public static boolean circlesAreTangent(int x1, int y1, double radius1, int x2, int y2, double radius2) {
		// calculate distance between circle centers
		double dist = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));

		// if the distance is exactly equal to the combined radii, then the circles are
		// tangentially touching

		// because of some uncertainties when using floating-point arithmetic, we will
		// allow some wiggle room with the values
		double uncertainty = 0.0000001;
		return dist < (radius1 + radius2 + uncertainty) && dist > (radius1 + radius2 - uncertainty);
	}

	// For this problem, assume the array is already sorted
	public static int[] removeDuplicates(int[] arr) {
		if (arr.length == 0)
			return arr;

		// store unique vals in new array and keep track of how many unique vals were
		// stored
		int count = 1;
		int[] newArr = new int[arr.length];
		newArr[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i - 1] != arr[i]) {
				newArr[count++] = arr[i];
			}
		}

		// trim new array to fit the size of the unique data
		int[] trimmed = new int[count];
		for (int i = 0; i < count; i++) {
			trimmed[i] = newArr[i];
		}

		return trimmed;
	}

	// For this problem, assume number >= 0
	public static int sumDigits(int number) {
		int sum = 0;
		while (number > 0) {
			sum += number % 10;
			number /= 10;
		}
		return sum;
	}

	// the values in the wallet represent the number of coins / bills (USD) in the
	// following order:
	// pennies, nickels, dimes, quarters, half dollars, $1 bills, $2 bills (yes they
	// exist), $5 bills, $10 bills, $20 bills, $50 bills, and $100 bills
	public static double countMoney(int[] wallet) {
		return wallet[0] * 0.01 // pennies
				+ wallet[1] * 0.05 // nickels
				+ wallet[2] * 0.10 // dimes
				+ wallet[3] * 0.25 // quarters
				+ wallet[4] * 0.50 // half dollars
				+ wallet[5] * 1 // $1 bills
				+ wallet[6] * 2 // $2 bills
				+ wallet[7] * 5 // $5 bills
				+ wallet[8] * 10 // $10 bills
				+ wallet[9] * 20 // $20 bills
				+ wallet[10] * 50 // $50 bills
				+ wallet[11] * 100 // $100 bills
		;
	}
}
