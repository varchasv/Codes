package Random;

import java.util.Set;

public class HobbiesMatchingCriteria extends Criteria<User>{
    @Override
    public int compare(User a, User b) {
        return match(a.hobbies,b.hobbies);
    }
    private  int match(Set<String> a , Set<String> b){
        int count =0;
        for(String x : a){
            if(b.contains(x)){
                count++;
            }
        }
        return  count * -1;
    }
}
