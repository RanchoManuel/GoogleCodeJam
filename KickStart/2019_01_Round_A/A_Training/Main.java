import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

class Main {

	// private static final boolean TEST = false;

	public static void main(String[] args) throws IOException {

		// BufferedReader br = new BufferedReader(new FileReader(new
		// File("./data/Training.in")));
		// if (!TEST)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine().trim()), t = 0;
		for (String aux[]; t < T; t++) {
			aux = br.readLine().trim().split("\\s+");
			// N: all athletes P: team size
			int N = Integer.parseInt(aux[0]), P = Integer.parseInt(aux[1]);

			int[] athletes = new int[N];
			aux = br.readLine().trim().split("\\s+");
			for (int i = 0; i < athletes.length; i++)
				athletes[i] = Integer.parseInt(aux[i].trim());

			int answer = s01_EvaluateCase(P, athletes);

			System.out.println("Case #" + (t + 1) + ": " + answer);
		}

		br.close();
	}

	private static int s01_EvaluateCase(int P, int[] athletes) {
		int answer = -1;
		Arrays.sort(athletes);
		int minGap = -1;
		for (int i = 0; i < athletes.length - 1; i++) {
			if (minGap == -1 || (athletes[i + 1] - athletes[i]) < minGap)
				minGap = athletes[i + 1] - athletes[i];
		}

		int[] team = new int[P];

		Set<String> atemptedTeams = new LinkedHashSet<>();
		do {
			for (int i = 0; i < team.length; i++)
				team[i] = athletes[i];

			String strOfTeam = Arrays.toString(team);
			if (!atemptedTeams.contains(strOfTeam)) {
				int neededHours = s01_aux1_EvaluateHours(team);
				if (answer == -1 || neededHours < answer)
					answer = neededHours;
				if (answer == 0 || answer == minGap)
					break;
			}
			atemptedTeams.add(strOfTeam);

		} while (utils_NextPermutation(athletes));
		return answer;
	}

	private static int s01_aux1_EvaluateHours(int[] team) {
		Arrays.sort(team);
		int refAthlete = team[team.length - 1];
		int answer = 0;
		for (int levelAthlete : team) {
			answer += (refAthlete - levelAthlete);
		}
		return answer;
	}

	public static boolean utils_NextPermutation(int[] array) {
		int i = array.length - 1;
		while (i > 0 && array[i - 1] >= array[i])
			i--;

		if (i == 0)
			return false;

		int j = array.length - 1;
		while (array[j] <= array[i - 1])
			j--;

		int temp = array[i - 1];
		array[i - 1] = array[j];
		array[j] = temp;

		j = array.length - 1;
		while (i < j) {
			temp = array[i];
			array[i] = array[j];
			array[j] = temp;
			i++;
			j--;
		}
		return true;
	}
}
