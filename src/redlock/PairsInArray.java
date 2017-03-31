package redlock;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PairsInArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if (n >= 1 && n <= 100000) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				int num = sc.nextInt();
				a[i] = num;
			}
			int k = sc.nextInt();
			System.out.println(numberOfPairs(a, k));
		}
		sc.close();
	}

	static int numberOfPairs(int[] a, long k) {
		Map<Long, Boolean> map = new HashMap<Long, Boolean>();
		long diff;
		int count = 0;
		Boolean is_unique;
		for (int i = 0; i < a.length; i++) {
			diff = k - a[i];
			is_unique = map.get(diff);
			if (diff >= 0 && is_unique != null && is_unique) {
				count++;
				map.put(diff, false);
				map.put((long) a[i], false);
			}
			if (!map.containsKey(a[i])) {
				map.put((long) a[i], true);
			}
		}
		return count;

	}
}
