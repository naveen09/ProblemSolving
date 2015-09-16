package com.problemSolving;

public class StringRotation
{
    public static void main(String[] args)
    {
        StringRotation rotation = new StringRotation();
        int[] a = { 3, 4, 5, 6, 1, 2 };
        int p = rotation.find(a, 3, 0, a.length - 1);
        System.out.println(p);
    }

    private int find(int[] a, int key, int l, int h)
    {
        if (l > h)
        {
            if (a[l] == key)
            {
                return l;
            } else if (a[h] == key)
            {
                return h;
            }
        }
        int mid = (l + h) / 2;
        if (a[mid] == key)
        {
            return mid;
        }
        int first = a[l];
        int last = a[h];
        int midEle = a[mid];
        if (first < midEle)
        {
            if (key <= midEle && key > first)
            {
                return find(a, key, l, mid - 1);
            } else
            {
                return find(a, key, mid + 1, h);
            }

        } else
        {
            if (key > midEle && key <= last)
            {
                return find(a, key, mid + 1, h);
            } else
            {
                return find(a, key, l, mid - 1);
            }
        }
    }
}
