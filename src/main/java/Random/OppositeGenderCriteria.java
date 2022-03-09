package Random;

public class OppositeGenderCriteria extends Criteria<User>{
    @Override
    public int compare(User a, User b) {
        if((a.gender == b.gender)){
            return  1;
        }
        return  -1;
    }
}
