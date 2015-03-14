package com.hackerearth;

import java.util.Scanner;

/*

 Its all about magic!
 Max. Marks 100

 Recently Oz has found a magical string consisting of single digit "1". After experimenting on the string, Oz found a weird magical property of the string that is whenever he touches the string then each digit "1" of string changed to digit "0" and each digit "0" of string changed to "01". Oz found this property interesting and immediately asked a question to RK : "How many 1's and 0's will be in the magical string if he touches the string M times ?"

 Input :

 The first line contains the number of test cases T . Each test case consists of a positive integer - M .

 Output :

 For each test case output two space-separated integers, number of 1's and number of 0's in the magical string if Oz touches the string M times.

 Constraints :

 1<= T <=20

 1<= M <=90
 Sample Input (Plaintext Link)

 2
 1
 2

 Sample Output (Plaintext Link)

 0 1
 1 1



 */
public class ItsAllAboutMagic
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        if (T >= 1 && T <= 20)
        {
            for (int i = 0; i < T; i++)
            {
                int M = sc.nextInt();
                if (M >= 1 && M <= 90)
                {
                    if (M % 2 == 0)
                    {
                        System.out.println("1 1");
                    } else
                    {
                        System.out.println("0 1");
                    }
                }
            }
        }
        sc.close();
    }
}
