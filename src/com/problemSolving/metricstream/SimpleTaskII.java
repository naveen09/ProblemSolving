package com.problemSolving.metricstream;

import java.util.Scanner;

public class SimpleTaskII
{
    private static final int _1000000 = 1000000;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        if (T >= 1 && T <= 100)
        {
            for (int ii = 0; ii < T; ii++)
            {
                int A = sc.nextInt();
                int B = sc.nextInt();
                int C = sc.nextInt();
                if ((A >= 0 && A <= _1000000)
                    && (B >= 0 && B <= _1000000)
                    && (C >= 0 && C <= _1000000))
                {
                    if (A == 0 && B == 0 && C == 0)
                    {
                        System.out.println(0);
                    } else if ((A == 0 && B == 0)
                               || (A == 0 && C == 0)
                               || (B == 0 && C == 0))
                    {
                        System.out.println(1);
                    } else if (A == 0 || B == 0 || C == 0)
                    {
                        if ((A != B) && (B != C) && (C != A))
                        {
                            int MAX = getMin(A, B, C);
                            System.out.println(2 * MAX + 1);
                        } else
                        {
                            int MIN = getMin(A, B, C);
                            System.out.println(2 * MIN);
                        }
                    } else if (allEqual(A, B, C))
                    {
                        System.out.println(2 * A);
                    } else
                    {
                        int S_MAX = secondHighest(A, B, C);
                        System.out.println(2 * S_MAX + 1);
                    }
                }
            }
        }
        sc.close();
    }

    private static boolean allEqual(int a, int b, int c)
    {
        if (a == b)
        {
            return a == c;
        }
        return false;
    }

    private static int secondHighest(int... nums)
    {
        int high1 = Integer.MIN_VALUE;
        int high2 = Integer.MIN_VALUE;
        for (int num : nums)
        {
            if (num > high1)
            {
                high2 = high1;
                high1 = num;
            } else if (num > high2)
            {
                high2 = num;
            }
        }
        return high2;
    }

    private static int getMin(int a, int b, int c)
    {
        if (a == 0)
        {
            return Math.min(b, c);
        }
        if (b == 0)
        {
            return Math.min(a, c);
        }
        if (c == 0)
        {
            return Math.min(a, b);
        }
        return 0;
    }
}
