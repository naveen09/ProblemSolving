package com.hackerearth;

import java.util.Scanner;

public class DivideArray
{
    static int   MAX = 100000;

    static int[] data;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (N >= 1 && N <= MAX)
        {
            sc.nextLine();
            String[] sData = sc.nextLine().split(" ");
            data = new int[N];
            int Q = sc.nextInt();
            int[] QQ = new int[Q];
            if (Q >= 1 && Q <= MAX)
            {
                sc.nextLine();
                for (int qq = 0; qq < Q; qq++)
                {
                    int D = Integer.parseInt(sc.nextLine());
                    if (D >= 1 && D <= MAX)
                    {
                        QQ[qq] = D;
                    } else
                    {
                        return;
                    }
                }
                for (int i = 0; i < sData.length; i++)
                {
                    int number = Integer.parseInt(sData[i]);
                    if (number >= 1 && number <= MAX)
                    {
                        data[i] = number;
                        for (int dd = 0; dd < QQ.length; dd++)
                        {
                            data[i] = data[i] / QQ[dd];
                        }
                    } else
                    {
                        return;
                    }
                }
                for (int i = 0; i < data.length; i++)
                {
                    System.out.print(data[i]);
                    if (i != data.length - 1)
                    {
                        System.out.print(" ");
                    }
                }
            }
        }
        sc.close();
    }
}
