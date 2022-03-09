package practice;

import java.util.ArrayList;
import java.util.List;

public class JPMorgan {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(60);
        list.add(60);
        list.add(60);

        System.out.println(playlist(list));
    }

    public static long playlist(List<Integer> movies){
        long count =0;
        for(int i=0;i<movies.size();i++){
            for(int j=i+1;j<movies.size();j++){
                long sum = movies.get(i)+movies.get(j);
                if(sum % 60 == 0){
                    count++;
                }
            }
        }
        return count;
    }
}
