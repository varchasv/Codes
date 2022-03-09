package Random;

import java.util.Set;

//Neha , Female, 21 , Singing, dancing

public class User {
    String name ;
    Gender gender;
    int age;
    Set<String> hobbies;

    public User(String name, Gender gender, int age, Set<String> hobbies) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.hobbies = hobbies;
    }
}
