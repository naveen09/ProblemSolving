package com.problemSolving;

public class PrintMatrixSpiral
{
    public static void main(String[] args)
    {
        int[][] matrix = { { 1, 2, 3 }, { 8, 9, 4 }, { 7, 6, 5 } };

        printSpiral(matrix);
    }

    public static void printSpiral(int[][] matrix)
    {
        printSpiral(matrix, 0);
    }

    private static void printSpiral(int[][] matrix, int depth)
    {
        if (matrix == null && matrix.length == 0)
            return;
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (2 * depth > Math.min(rows, cols))
            return;
        for (int i = depth; i < cols - depth - 1; ++i)
        {
            System.out.print(matrix[depth][i] + ",");
        }
        for (int i = depth; i < rows - depth - 1; ++i)
        {
            System.out.print(matrix[i][cols - depth - 1] + ",");
        }
        for (int i = rows - depth - 1; i > depth; --i)
        {
            System.out.print(matrix[rows - depth - 1][i] + ",");
        }
        for (int i = rows - depth - 1; i > depth; --i)
        {
            System.out.print(matrix[i][depth] + ",");
        }
        printSpiral(matrix, ++depth);
    }
}