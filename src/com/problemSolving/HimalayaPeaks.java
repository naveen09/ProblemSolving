package com.problemSolving;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class HimalayaPeaks
{
    static int dist[][];

    // static int path[][] = {
    // { 7, 2, 3, 4, 5 },
    // { 36, 37, 38, 34, 6 },
    // { 33, 44, 46, 40, 7 },
    // { 24, 43, 42, 41, 8 },
    // { 35, 32, 47, 30, 9 } };
    static int path[][] = {};

    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner sc = new Scanner(new File("input.txt"));
        int N = sc.nextInt();
        for (int p = 0; p < N; p++)
        {
            String peak = sc.next();
            int rows = sc.nextInt();
            int cols = sc.nextInt();
            dist = new int[rows][cols];
            path = new int[rows][cols];
            int max = 0;
            for (int i = 0; i < rows; i++)
            {
                for (int j = 0; j < cols; j++)
                {
                    path[i][j] = sc.nextInt();
                }
            }
            for (int i = 0; i < rows; i++)
            {
                for (int j = 0; j < cols; j++)
                {
                    max = Math.max(max, getLongestPath(i, j));
                }
            }
            System.out.println(peak + ":" + max);
        }
        sc.close();
    }

    private static int getLongestPath(int i, int j)
    {
        int sum = 0;
        if (dist[i][j] != 0)
        {
            return dist[i][j];
        }
        if (j - 1 >= 0 && path[i][j] > path[i][j - 1])
        {
            sum = Math.max(getLongestPath(i, j - 1), sum);
        }
        if (j + 1 < path[0].length && path[i][j] > path[i][j + 1])
        {
            sum = Math.max(getLongestPath(i, j + 1), sum);
        }
        if (i + 1 < path.length && path[i][j] > path[i + 1][j])
        {
            sum = Math.max(getLongestPath(i + 1, j), sum);
        }
        if (i - 1 >= 0 && path[i][j] > path[i - 1][j])
        {
            sum = Math.max(getLongestPath(i - 1, j), sum);
        }
        dist[i][j] = sum + 1;
        return dist[i][j];
    }

}
