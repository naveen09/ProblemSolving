package com.problemSolving;

import java.util.Scanner;

/**
 * All permutations of a string
 * 
 * 
 */
public class StringPermutations
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        process("", input);
        sc.close();
    }

    private static void process(String s1, String s2)
    {
        if (s2.length() <= 1)
        {
            System.out.println(s1 + s2);
        } else
        {
            for (int i = 0; i < s2.length(); i++)
            {
                String s3 = s2.substring(0, i)
                            + s2.substring(i + 1, s2.length());
                process(s1 + s2.charAt(i), s3);
            }
        }
    }
}
