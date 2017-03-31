package gainsight;

import java.util.Scanner;

public class SpecialMultiple {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numberOfRows = Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < numberOfRows; i++) {
			int number = Integer.parseInt(scanner.nextLine());
			boolean foundNumber = false;
			int j = 1;
			while (!foundNumber) {
				int validNumber = generateValidNumber(number * j);
				String validNumberString = String.valueOf(validNumber);
				int a = 0;
				int b = 0;
				for (int i1 = 0; i1 < validNumberString.length(); i1++) {
					if ("4".equals(validNumberString.substring(i1, i1 + 1))) {
						a = 1;
					} else if ("0".equals(validNumberString.substring(i1,
							i1 + 1))) {
						b = b + 1;
					}
				}
				if (0 != validNumber) {
					int z = 2 * a + b;
					System.out.print(z);
					foundNumber = true;
				} else {
					j++;
				}
			}
		}
		scanner.close();
	}

	public static int generateValidNumber(int number) {
		boolean found_zero = false;
		int result = 0;
		String temp = "";
		String numberString = String.valueOf(number);

		for (int i = 0; i < numberString.length(); i++) {
			if (!found_zero && numberString.substring(i, (i + 1)).equals("4")) {
				temp += "4";
			} else if (numberString.substring(i, (i + 1)).equals("0")) {
				found_zero = true;
				temp += "0";
			} else {
				temp = null;
				break;
			}
		}
		if (null != temp) {
			result = Integer.parseInt(temp.toString());
		} else {
			result = 0;
		}
		return result;
	}

}
