package com.problemSolving;

import java.util.Scanner;

public class ModifySequence{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			int n = sc.nextInt();
			if (n >= 0 && n <= 109) {
				min = Math.min(min, n);
				max = Math.max(max, n);
			}
		}
		if (min == 0 && max == 0 && min == max) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
		sc.close();
	}
}
