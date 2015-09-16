package com.problemSolving;

/**
 * pow(x,n) in O(long) complexity
 */
public class powerxn
{
    public static void main(String[] args)
    {
        System.out.println(Power(3, 2));
    }

    static int Power(int x, int n)
    {
        if (n == 0)
        {
            return 1;
        }
        int result = Power(x, n / 2);
        if (n % 2 == 0)
        {
            return result * result;
        } else
        {
            return result * result * x;
        }
    }

}
