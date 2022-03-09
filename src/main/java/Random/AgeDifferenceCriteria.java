package Random;

public class AgeDifferenceCriteria extends Criteria<User>{

    @Override
    public int compare(User a, User b) {
        return Math.abs(a.age-b.age);
    }
}
