package amazonaft;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContinousSubArrayNonSubarray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		if (N >= 1 && N <= 10) {
			for (int i = 0; i < N; i++) {
				List<Integer> items = new ArrayList<Integer>();
				int SUM = 0;
				int NSUM = 0;
				int MAX_SUM = Integer.MIN_VALUE;
				int P = sc.nextInt();
				if (P >= 1 && P <= 1000000) {
					for (int j = 0; j < P; j++) {
						int item = sc.nextInt();
						if (item >= -100000 && item < 100000) {
							items.add(item);
							if (item > 0) {
								NSUM += item;
							}
							SUM = SUM + item;
							if (SUM > 0) {
								if (SUM > MAX_SUM) {
									MAX_SUM = SUM;
								}
							} else {
								SUM = 0;
							}
							if (MAX_SUM == 0 && NSUM == 0) {
								int max = items.get(0);
								for (int l = 1; l < N; l++) {
									if (items.get(l) > max) {
										max = items.get(l);
									}
								}
								MAX_SUM = max;
								NSUM = max;
							}
						}
					}
					System.out.println(MAX_SUM + " " + NSUM);
				}

			}
		}
		sc.close();
	}
}
//2  
//4  
//1 2 3 4 
//6 
//2 -1 2 3 4 -5 
