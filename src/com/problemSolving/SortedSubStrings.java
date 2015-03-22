package com.problemSolving;

import java.util.Scanner;

/*
 * Roy has a string S of length N. String S is made of lower case english
 * alphabets. He likes sorted strings. So he wonders how many substrings of S
 * are sorted.
 * 
 * Given the string S, your task is to count the number of sorted substrings of
 * S.
 * 
 * A string s is lexicographically sorted if si ≤ si+1 where 1 ≤ i ≤ N-1
 * (consider 1-based indexing).
 * 
 * Caution: Use 64-bit integer for count to avoid overflow.
 * 
 * Input: First line contains integer T - number of test cases. First line of
 * each test case contains N - length of string S. Second line contains S - the
 * given string.
 * 
 * Output: Print the answer for each test case in a new line.
 * 
 * Constraints: 1 ≤ T ≤ 10 1 ≤ N ≤ 1000000 S consists of only lower case english
 * alphabets [a-z].
 * 
 * Sample Input (Plaintext Link) 
 * 4 
 * 3 
 * abc 
 * 3 
 * bba 
 * 4 
 * abac 
 * 3 
 * zyx 
 * Sample Output (Plaintext Link) 
 * 6 
 * 4 
 * 6 
 * 3
 */
public class SortedSubStrings
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        if (T >= 1 && T <= 10)
        {
            for (int i = 0; i < T; i++)
            {
                int N = sc.nextInt();
                if (N >= 1 && N <= 1000000)
                {
                    String S = sc.next();
                    if (!S.isEmpty())
                    {
                        int count = getAllSortedSubsStrings(S);
                        System.out.println(count);
                    }
                }
            }
        }
        sc.close();
    }

    private static int getAllSortedSubsStrings(String s)
    {
        int count = 0;
        for (int i = 0; i <= s.length(); i++)
        {
            for (int j = i + 1; j <= s.length(); j++)
            {
                String substring = s.substring(i, j);
                if (isSorted(substring.toCharArray()))
                {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isSorted(char[] cs)
    {
        for (int i = 0; i < cs.length - 1; i++)
        {
            if (cs[i] > cs[i + 1])
                return false;
        }
        return true;
    }
}
