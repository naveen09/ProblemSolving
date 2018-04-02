/**
 * 
 */
package zalando;

/**
 * @author Naveen
 *
 */
public class Pr2 {
	int max = 0;

	public static void main(String[] args) {
		Pr2 p = new Pr2();
		System.out.println(p.solution(18, 2));
	}

	public int solution(int N, int K) {
		if (N == 0) return N;
		if (K == 0) return N - 1;
		while (K > 0) {
			if (N == 2)	break;
			
			if (N % 2 == 0) {
				N = N / 2;
				--K;
			} else	{
				--N;
			}
			max++;
		}
		max = max + N - 1;
		return max;
	}
}
