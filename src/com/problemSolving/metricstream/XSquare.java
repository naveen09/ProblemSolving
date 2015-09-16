package com.problemSolving.metricstream;

import java.util.Scanner;

public class XSquare
{
    private static final int  _1000000     = 1000000;

    private static final long _10000000000 = 10000000000l;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        if (T >= 1 && T < _1000000)
        {
            for (int ii = 0; ii < T; ii++)
            {
                int N = sc.nextInt();
                long K = sc.nextLong();
                if ((N >= 1 && N < _1000000) && (K >= 1 && K < _10000000000))
                {
                    long count = 0;
                    long MAX = Long.MIN_VALUE;
                    for (int i = 0; i < N; i++)
                    {
                        long stack = sc.nextLong();
                        if (stack >= 1 && stack < _10000000000)
                        {
                            if (stack <= K)
                            {
                                count += stack;
                                if (MAX < count)
                                {
                                    MAX = count;
                                }
                            } else
                            {
                                count = 0;
                            }
                        } else
                        {
                            count = 0;
                        }
                    }
                    System.out.println(MAX);
                }
            }
        }
        sc.close();
    }
}
/*
 Xsquare And Coin Collection
Max. Marks 100
Xsquare loves to play with the coins very much. Today , he has N stacks of coins . Each stack of coins has some non zero height Hi equal to the number of coins on that stack ( considering all the coins are identical and each coin has a height of 1 unit ) .

In one move, Xsquare can select any number of consecutive stacks of coins such that the height of each selected stack of coins Hi ≤ K . Once such a sequence of stacks is chosen , Xsquare can collect any number of coins from the chosen sequence of stacks .

Xsquare wonders what is the maximum number of coins that he can collect this way ?

INPUT

First line of input contains a single integer T denoting the number of test cases . First line of each test case contains two space separated integers N and K where N being the number of stacks of coins. Second line of each test case contains N space separated integers denoting the number of coins Hi on each stack .

OUTPUT

For each test case , Print the maximum number of coins Xsquare can collect following the above gaming strategy.

CONSTRAINTS

1 ≤ T ≤ 105

1 ≤ N ≤ 105

1 ≤ K ≤ 109

1 ≤ Hi ≤ 109

Note :

sum of N over all the test case will not exceed 106.

Sample Input (Plaintext Link)
2
8 1
3 2 2 3 1 1 1 3
8 2
3 2 2 3 1 1 1 3
Sample Output (Plaintext Link)
3
4

Explanation
Test 1 :
N = 8 , K = 1
3 2 2 3 1 1 1 3
We can collect coins from stacks numbered 5 , 6 and 7 .

Test 2 :
N = 8 , K = 2
3 2 2 3 1 1 1 3
We can collect coins from stacks numbered 2 and 3 .
 **/