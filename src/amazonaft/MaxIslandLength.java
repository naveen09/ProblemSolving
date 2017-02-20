package amazonaft;

import java.util.Scanner;

public class MaxIslandLength {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int rows = sc.nextInt();
		int cols = sc.nextInt();
		int dist[][] = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				dist[i][j] = sc.nextInt();
			}
		}
		int count = 0;
		int x = 0;
		for (int i = 0; i < dist.length; i++) {
			for (int j = 0; j < dist[0].length; j++) {
				x = Math.max(x, helper(dist, i, j, 0, count));
			}
		}
		System.out.println(x);
		sc.close();
	}

	private static int helper(int[][] path, int i, int j, int n, int word) {
		if (i < 0 || i >= path.length)
			return 0;
		if (j < 0 || j >= path[0].length)
			return 0;

		int c = path[i][j];
		if (c == 1) {
			path[i][j] = -1;
			++word;
			word = Math.max(
					Math.max(helper(path, i - 1, j, n + 1, word),
							helper(path, i + 1, j, n + 1, word)),
					Math.max(helper(path, i, j - 1, n + 1, word),
							helper(path, i, j + 1, n + 1, word)));
			path[i][j] = 1;
		}
		return word;
	}
}
// 4
// 4
// 1 1 0 0
// 0 1 1 0
// 0 0 1 0
// 1 0 0 0