package practice;

import java.util.HashMap;
import java.util.Map;

public class zalando {
    public static void main(String[] args) {
        //System.out.println(Solution("5050555550"));
        System.out.println(solution3(new int[]{5,2,4,6,3,7}));
    }

    public static int solution3(int[] A){
        int minSum= Integer.MAX_VALUE;
        for(int i=1;i<A.length-3;i++){
            for(int j=i+2;j<A.length-1;j++){
                minSum = Math.min(A[i]+A[j],minSum);
            }
        }
        return minSum;
    }
    public static int Solution(String S){
        int num =0;
        int count =0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<S.length()-1;i+=1){
            String t = S.substring(i,i+2);
            int tt = Integer.parseInt(t);
            if(map.containsKey(tt)){
                int tcount= map.get(tt) + 1;
                if(tt>=num){
                    num=tt;
                    count=tcount;
                    map.put(tt,tcount);
                }else {
                    map.put(tt,tcount);
                }
            }else{
                if(tt>=num){
                    num=tt;
                }
                map.put(tt,1);
            }
        }
        return num;

    }
}
