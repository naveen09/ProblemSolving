package com.problemSolving;

/*
 Given a 2D board and a word, find if the word exists in the grid.
 The word can be constructed from letters of sequentially adjacent cell, where "adjacent" 
 cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 */
public class WordSearchIn2DArray
{
    String word     = "naveen";

    char   path[][] = {
            { 'p', 'q', 'r', 's' },
            { 'n', 'n', 'w', 't' },
            { 'e', 'a', 'x', 'u' },
            { 'e', 'v', 'y', 'v' } };

    public static void main(String[] args) throws Exception
    {
        WordSearchIn2DArray snpt = new WordSearchIn2DArray();
        System.out.println(snpt.process());
    }

    private boolean process()
    {
        for (int i = 0; i < path.length; i++)
        {
            for (int j = 0; j < path[0].length; j++)
            {
                if (helper(path, i, j, 0, word))
                    return true;
            }
        }
        return false;
    }

    private boolean helper(char[][] path, int i, int j, int n, String word)
    {
        if (n == word.length())
            return true;
        if (i < 0 || i >= path.length)
            return false;
        if (j < 0 || j >= path[0].length)
            return false;

        char charAt = word.charAt(n);
        char c = path[i][j];
        System.out.println(c + " : " + charAt);
        if (c == charAt)
        {
            /* you can even take an auxiliary boolean array to keep track */
            path[i][j] = '#';

            if (helper(path, i - 1, j, n + 1, word)
                || helper(path, i + 1, j, n + 1, word)
                || helper(path, i, j - 1, n + 1, word)
                || helper(path, i, j + 1, n + 1, word))
            {
                return true;
            }
            path[i][j] = word.charAt(n);
        }
        return false;
    }
}
