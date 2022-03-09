package practice;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Uber {

    /*
    static int efficientCabScheduling(int n,int cabTripTime[])
    {
        int m = cabTripTime.length;
        // base case
        if (n == 0) return 0;

        // Initialize result
        int res = Integer.MAX_VALUE;

        // Try every coin that has smaller value than V
        for (int i=0; i<m; i++)
        {
            if (cabTripTime[i] <= n)
            {
                int sub_res = efficientCabScheduling(n-cabTripTime[i],cabTripTime );

                // Check for INT_MAX to avoid overflow and see if
                // result can minimized
                if (sub_res != Integer.MAX_VALUE && sub_res + 1 < res)
                    res = sub_res + 1;
            }
        }
        return res;
    }

    */

    /*

    // m is size of coins array
    // (number of different coins)
    static int efficientCabScheduling(int n,int cabTripTime[])
    {
        int m = cabTripTime.length;
        int matrix[][] = new int[m+1][n+1];
        for(int i=0;i<n+1;i++){
            matrix[0][i]=Integer.MAX_VALUE;
        }
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                matrix[i][j] = Math.min(matrix[i-1][j],matrix[i][j-1] + cabTripTime[i-1]);
            }
        }
        for(int i=0;i<m+1;i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
        return matrix[m][n];
    }

    public static void main(String[] args) {
        int[] x = new int[]{1,3,5,7};
        System.out.println(solve(10,x ));
    }
    private static int solve(int n, int[] c) {
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        int res = 0;
        for(int t : c)
            minHeap.offer(new int[] {t, t});
        while(n > 0) {
            int[] cur = minHeap.poll();
            res = Math.max(res, cur[1]);
            cur[1] += cur[0];
            minHeap.offer(cur);
            n--;
        }
        return res;
    }

    */


    /*
    private static int solve(int n, int[] cabTripTime) {
        int l = 0;
        int h = Integer.MAX_VALUE;
        int m = h + (l - h) / 2;
        while (l < h) {
            m = h + (l - h) / 2;
            int trips = 0;
            for (int k : cabTripTime) {
                trips += (m / k);
            }
            if (trips == n) {
                break;
            } else if (trips < n) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return m;
    }
     */

    /*
    boolean solve(int arr[],int n,int k,int mid)

    {

        int trip=0;

        for(int i=0;i<k;i++)

        {
            trip+=(mid/arr[i]);
            if(trip>=n)
                return true;
        }

        return false;

    }
    private int util(int n,int cabTripTime[]){

        int ans=Integer.MAX_VALUE;

        int l=0,h=Integer.MAX_VALUE;

        while(l<=h)
        {
            int mid=l+(h-l)/2;

            if(solve(cabTripTime,n,cabTripTime.length,mid))
            {
                ans=mid;
                h=mid-1;
            }
            else
            {
                l=mid+1;
            }
        }
        return ans;
    }

     */
}
