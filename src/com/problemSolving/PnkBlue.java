package com.problemSolving;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 Pink and Blue
 Max. Marks 100

 Xenny was a teacher and he had N students. The N children were sitting in a room. Each child was wearing a white T-shirt, with a unique number from the range 1 to N written on it. T-Shirts of pink and blue color were to be distributed among the students by Xenny. This made the students very happy.

 Xenny felt that a random distribution of T-Shirts would be very uninteresting. So, he decided to keep an interesting condition:

 Every student would get a T-Shirt that is of a different color than his/her friends. That is, if X and Y are friends and X has a Pink T-Shirt, then Y should compulsorily have a Blue T-Shirt, and vice-versa.

 Also, Xenny had a belief that Boys should wear blue T-Shirts and Girls should wear pink T-Shirts. If a boy was given a pink T-Shirt or a girl was given a Blue T-Shirt, he called it an inversion.

 So, Xenny wanted to distribute T-Shirts in the above-mentioned interesting manner and also wanted to minimize "inversions". Help him solve the task.

 Note: There are no disjoint groups of friends in the room. That is, 2 distinct groups with finite number of students do not exist, but exactly 1 group of students exists in the given situation.

 Input Format:
 First line contains 2 space-separated integers - N and M - number of students and number of friendships present respectively.

 Second line consists of N space-separated characters, where ith character denotes the gender of the ith student. B: Boy, G: Girl.

 M lines follow. Each line consists of 2 space-separated integers, u and v, showing that u is a friend of v and vice-versa.

 Output Format:
 If Xenny could distribute the T-Shirts in the desired way, print the minimum number of inversions required.
 Else, print "Not possible".

 Constraints:
 1 ≤ N ≤ 105
 1 ≤ M ≤ 105
 1 ≤ u, v ≤ N

 Colours of T-Shirt are represented by uppercase characters 'B' and 'G'
 Sample Input (Plaintext Link)

 3 2
 B G B
 1 2
 1 3

 Sample Output (Plaintext Link)

 1

 Explanation
 Student 1 can be given a Blue T-Shirt. Hence, Student 2 and 3 would receive Pink T-Shirts.

 Since, Student 3 is a Boy and has received a Pink T-Shirt, number of inversions = 1.
 */
public class PnkBlue
{
    static int MAX = 1000000;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        if ((N >= 1 && N <= MAX) && (M >= 1 && M <= MAX))
        {
            sc.nextLine();
            String[] genderList = sc.nextLine().split(" ");
            int[] tShirtList = new int[N + 1];
            Map<Integer, ArrayList<Integer>> friendShip = new HashMap<Integer, ArrayList<Integer>>();
            for (int i = 0; i < M; i++)
            {
                String[] friends = sc.nextLine().split(" ");
                int f1 = Integer.parseInt(friends[0]);
                int f2 = Integer.parseInt(friends[1]);
                if ((f1 >= 1 && f1 <= N) && (f2 >= 1 && f2 <= N))
                {
                    if (friendShip.get(f1) == null)
                    {
                        ArrayList<Integer> value = new ArrayList<Integer>();
                        value.add(f2);
                        friendShip.put(f1, value);
                    } else
                    {
                        friendShip.get(f1).add(f2);
                    }
                    if (friendShip.get(f2) == null)
                    {
                        ArrayList<Integer> value = new ArrayList<Integer>();
                        value.add(f1);
                        friendShip.put(f2, value);
                    } else
                    {
                        friendShip.get(f2).add(f1);
                    }
                }
            }
            // B = 10 P = 11
            int inversions = 0;
            for (int i = 0; i < genderList.length; i++)
            {
                int current = i + 1;
                if (genderList[i].equals("B"))
                {
                    tShirtList[current] = 10;
                    boolean invB = false;
                    ArrayList<Integer> frnds = friendShip.get(current);
                    for (Integer f : frnds)
                    {
                        if (tShirtList[f] == 10)
                        {
                            tShirtList[current] = 11;
                            invB = true;
                        }
                    }
                    if (invB)
                    {
                        inversions++;
                    }
                } else
                {
                    tShirtList[current] = 11;
                    ArrayList<Integer> frnds = friendShip.get(current);
                    boolean invP = false;
                    for (Integer f : frnds)
                    {
                        if (tShirtList[f] == 11)
                        {
                            tShirtList[current] = 10;
                            invP = true;
                        }
                    }
                    if (invP)
                    {
                        inversions++;
                    }
                }
            }
            System.out.println(inversions);
        }
        sc.close();
    }
}
