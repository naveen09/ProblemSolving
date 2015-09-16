package gainsight;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Server load balancing for an array { 0, 0, 10, 0, 0, 0, 0, 0, 0, 0 }
 * 
 * @author Naveen
 * 
 */
public class GainSight
{
    public static void main(String[] args)
    {
        int[] data = { 0, 0, 10, 0, 0, 0, 0, 0, 0, 0 };
        int o = balanceLoad(data);
        System.out.println("Max: " + o);
    }

    static int balanceLoad(int[] serverLoads)
    {
        int avg = (int) Math.floor(getSum(serverLoads) / serverLoads.length);
        List<Integer> maxLeft = new ArrayList<Integer>();
        int leftsum = 0;
        for (int i = 1; i < serverLoads.length; ++i)
        {
            leftsum += serverLoads[i - 1];
            maxLeft.add(Math.max(avg * i - leftsum, 0));
        }
        List<Integer> maxRight = new ArrayList<Integer>();
        int righttsum = 0;
        for (int i = serverLoads.length - 1, j = 1; i >= 0; --i, ++j)
        {
            righttsum += serverLoads[i];
            maxRight.add(Math.max(avg * j - righttsum, 0));
        }

        int maxl = Collections.max(maxLeft);
        int maxR = Collections.max(maxRight);
        return Math.max(maxl, maxR);

    }

    private static int getSum(int[] a)
    {
        int sum = 0;
        for (int ele : a)
        {
            sum += ele;
        }
        return sum;
    }

}
