package techgig;

import java.io.IOException;
import java.util.Scanner;

public class Jumping {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int output = 0;
		int ip1 = Integer.parseInt(in.nextLine().trim());
		int ip2 = Integer.parseInt(in.nextLine().trim());
		int ip3_size = 0;
		ip3_size = Integer.parseInt(in.nextLine().trim());
		int[] ip3 = new int[ip3_size];
		int ip3_item;
		for (int ip3_i = 0; ip3_i < ip3_size; ip3_i++) {
			ip3_item = Integer.parseInt(in.nextLine().trim());
			ip3[ip3_i] = ip3_item;
		}
		output = GetJumpCount(ip1, ip2, ip3);
		System.out.println(String.valueOf(output));
	}

	public static int GetJumpCount(int input1, int input2, int[] input3) {
		int count = 0;
		int JUMP = input1;
		int SLIDES = input2;
		for (int wall : input3) {
			int jump_till = JUMP;
			while (wall > 0) {
				if (JUMP >= wall) {
					wall = 0;
					count++;
				} else {
					wall -= jump_till;
					if (wall != 0) {
						wall += SLIDES;
					}
					count++;
				}
			}
		}
		return count;
	}

}
