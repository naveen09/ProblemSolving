package com.problemSolving;

/**
 * print all subsets of a set {a,b,c} I/P: a b c O/p: a,b,c,ab,ac,bc,abc
 */
public class SubSet
{

    public static void main(String[] args)
    {
        char[] input = { 'a', 'b', 'c' };
        Boolean[] ifPrint = new Boolean[input.length];
        for (int j = 0; j < ifPrint.length; j++)
        {
            process(input, ifPrint, 0, j);
        }
    }

    private static void process(char[] input, Boolean[] ifPrint, int i, int j)
    {
        if (ifPrint[i])
        {
            System.out.println(input[i]);
            ifPrint[i] = true;
        }
    }

}
