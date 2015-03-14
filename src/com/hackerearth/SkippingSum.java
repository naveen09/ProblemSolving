package com.hackerearth;

import java.util.Scanner;

/*
 Skipping Sum
 Max. Marks 100

 You are given an array of N integers A[1] , A[2] , ... , A[N] . You have to answer Q queries. Each query consists of 3 integers L, R and K. For each query, you have to find the value of the Skipping Sum in the following manner :

 def skipping_sum(L,R,K) :
 sum = 0
 while L <= R :
 sum = sum + A[L]
 L = L + K 
 return sum

 Input
 The first line consists of 2 space separated integers N and Q. The next line consists of N space separated integers, the ith integer being A[i]. Then, Q lines follow, each line consisting of 3 space separated integers L, R and K.

 Output
 Print the answer to each query on a new line.

 Constraints
 1 ≤ N ≤ 105
 1 ≤ Q ≤ 105
 0 ≤ A[i] ≤ 105
 1 ≤ L ≤ R ≤ N
 1 ≤ K ≤ 10

 NOTE:
 We are using 1-based indexing for array A.
 Sample Input (Plaintext Link)

 8 6
 5 4 2 1 7 9 10 9
 1 8 1
 1 8 2
 4 8 9
 3 7 2
 3 7 3
 3 7 4

 Sample Output (Plaintext Link)

 47
 24
 1
 19
 11
 12

 Explanation
 For query 1 : A[1] + A[2] + A[3] + A[4] + A[5] + A[6] + A[8] = 47
 For query 2 : A[1] + A[3] + A[5] + A[7] = 24
 For query 3 : A[4] = 1
 For query 4 : A[3] + A[5] + A[7] = 19
 For query 5 : A[3] + A[6] = 11
 For query 6 : A[3] + A[7] = 12
 * */
public class SkippingSum
{
    static int     MAX  = 1000000;

    static int[]   data;

    static boolean fail = false;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Q = sc.nextInt();
        if ((N >= 1 && N <= MAX) && (Q >= 1 && Q <= MAX))
        {
            sc.nextLine();
            data = getIntegerArray(sc.nextLine().split(" "));
            if (!fail)
            {
                for (int i = 0; i < Q; i++)
                {
                    int L = sc.nextInt();
                    int R = sc.nextInt();
                    int K = sc.nextInt();
                    if ((L >= 1 && L <= R)
                        && (R >= L && R <= N)
                        && (K >= 1 && K <= 10))
                    {
                        int sum = skipping_sum(L - 1, R - 1, K);
                        System.out.println(sum);
                    }
                }
            }
        }
        sc.close();
    }

    private static int[] getIntegerArray(String[] split)
    {
        int[] vals = new int[split.length];
        for (int i = 0; i < split.length; i++)
        {
            int parseInt = Integer.parseInt(split[i]);
            if (parseInt >= 0 && parseInt <= MAX)
            {
                vals[i] = parseInt;
            } else
            {
                fail = true;
                break;
            }
        }
        return vals;
    }

    private static int skipping_sum(int l, int r, int k)
    {
        int sum = 0;
        while (l <= r)
        {
            sum += data[l];
            l += k;
        }
        return sum;
    }
}
