package zalando;

public class Pr1 {
	int max = 0;
	int lCount = 0;
	int rCount = 0;

	public static void main(String[] args) {
		Pr1 p = new Pr1();
		System.out.println(p.solution("LRLRLRLRLR"));
	}

	public int solution(String S) {
		S.chars().mapToObj(i -> (char) i).forEach(shoe -> {
			if (shoe == 'L') {
				lCount++;
			}
			if (shoe == 'R') {
				rCount++;
			}
			if (lCount == rCount) {
				max++;
				lCount = rCount = 0;
			}
		});
		return max;
	}
}