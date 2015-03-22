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

    private static void process(String s, String endString)
    {
        if (endString.length() <= 1)
        {
            System.out.println(s + endString);
        } else
        {
            for (int i = 0; i < endString.length(); i++)
            {
                String newString = endString.substring(0, i)
                                   + endString.substring(i + 1,
                                                         endString.length());
                process(s + endString.charAt(i), newString);
            }
        }
    }
}
