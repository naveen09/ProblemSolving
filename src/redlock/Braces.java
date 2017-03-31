package redlock;

import java.util.Scanner;
import java.util.Stack;

public class Braces {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] ss = { "{}[]()", "{[}]}" };
		String[] bs = braces(ss);
		for (String s : bs) {
			System.out.println(s);
		}
		sc.close();
	}

	static String[] braces(String[] values) {
		String[] res = new String[values.length];
		for (int i = 0; i < values.length; i++) {
			Stack<Character> stack = new Stack<Character>();
			String val = values[i];
			for (int j = 0; j < val.length(); j++) {
				char c = val.charAt(j);
				if (c == '{') {
					stack.push(c);
				} else if (c == '[') {
					stack.push(c);
				} else if (c == '(') {
					stack.push(c);
				} else if (c == '}') {
					if (stack.isEmpty()) {
						res[i] = "NO";
						break;
					} else if (stack.peek() == '{') {
						stack.pop();
					} else {
						res[i] = "NO";
						break;
					}
				} else if (c == ']') {
					if (stack.isEmpty()) {
						res[i] = "NO";
						break;
					} else if (stack.peek() == '[') {
						stack.pop();
					} else {
						res[i] = "NO";
						break;
					}
				} else if (c == ')') {
					if (stack.isEmpty()) {
						res[i] = "NO";
						break;
					} else if (stack.peek() == '(') {
						stack.pop();
					} else {
						res[i] = "NO";
						break;
					}
				}

			}
			if (res[i] == null && stack.isEmpty()) {
				res[i] = "YES";
			} else {
				res[i] = "NO";
			}
		}
		return res;

	}
}
