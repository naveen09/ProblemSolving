package techgig;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Glyphs {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int output = 0;
		int ip1 = Integer.parseInt(in.nextLine().trim());
		int ip2 = Integer.parseInt(in.nextLine().trim());
		String ip3 = in.nextLine().trim();
		String ip4 = in.nextLine().trim();
		output = appearanceCount(ip1, ip2, ip3, ip4);
		System.out.println(String.valueOf(output));
	}

	public static int appearanceCount(int input1, int input2, String input3,
			String input4) {
		List<Integer> vals = new ArrayList<Integer>();
		if (input4.length() == 0 || input3.length() == 0)
			return 0;
		getPatterns(input4, vals, "", input3);
		return vals.size();
	}

	private static void getPatterns(String input4, List<Integer> vals,
			String s1, String s2) {

		if (s2.length() <= 1 && input4.contains(s1 + s2)) {
			vals.add(1);
		} else {
			for (int i = 0; i < s2.length(); i++) {
				String s3 = s2.substring(0, i)
						+ s2.substring(i + 1, s2.length());
				getPatterns(input4, vals, s1 + s2.charAt(i), s3);
			}
		}

	}

}
