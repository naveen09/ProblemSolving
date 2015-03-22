package com.problemSolving;

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
            int QQ = 1;
            if (Q >= 1 && Q <= MAX)
            {
                sc.nextLine();
                for (int qq = 0; qq < Q; qq++)
                {
                    int D = Integer.parseInt(sc.nextLine());
                    if (D >= 1 && D <= MAX)
                    {
                        QQ *= D;
                    }
                }
                for (int i = 0; i < sData.length; i++)
                {
                    int number = Integer.parseInt(sData[i]);
                    if (number >= 1 && number <= MAX)
                    {
                        System.out.print(number / QQ);
                    }
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
