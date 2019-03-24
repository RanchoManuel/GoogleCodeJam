import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

public class Main {
	private static final String TOO_SMALL = "TOO_SMALL";
	private static final String TOO_BIG = "TOO_BIG";
	private static final String CORRECT = "CORRECT";
	public static void main(String[] args) throws Exception {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int T = Integer.parseInt(br.readLine()); // T: test cases 1 <= T <= 20
			for (int i = 0; i < T; i++)
				playGame();
		}
	}

	private static void playGame() {
		int N = Integer.parseInt(br.readLine().trim()); // maximum number of guesses you can make, N = 30
		int A = 0, B = Math.pow(10,9);
		int low = A, high = B;

		while (N--!=0) {
			int g = getRandomNumberInRange(low, high);
			System.out.println(g);
			String answer = br.readLine().trim();
			
			if(answer.equals(TOO_SMALL)) {
				low = g;
			} else if (answer.equals(TOO_BIG)) {
				high = g;
			} else if (answer.equals(CORRECT)) {
				return; // :D
			}
		}

	}

	private static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
}
