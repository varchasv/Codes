// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public static int solution(int A, int B) {
        // write your code in Java SE 8
        int left = 1 ;
        int right = (A+B) / 4;
        int res = 0;

        while(left <=right){
            int mid = (left+right)/2;

            if(((A/mid) + (B/mid)) >=4){
                res = mid;
            }

            if(((A/mid) + (B/mid)) >=4){
                left = mid +1;
            }else{
                right = mid-1;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(solution(40,20));
    }
}
