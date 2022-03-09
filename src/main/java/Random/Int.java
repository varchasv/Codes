package Random;

import com.sun.source.tree.BreakTree;

import java.text.SimpleDateFormat;
import java.util.*;

/*
* Neha , Female, 21 , Singing, dancing
Pooja, Female, 23, painting, badminton
Vikas, Male, 32, bowling, cricket
Kiran, Male, 29, badminton, chess
Uday, Male, 23, cricket, programming
Nikita, Female, 26, ludo, chess

Design a dating system with the following requirements:

-> User profile will have the following attributes:
	Name
	Gender
	Age
	Hobbies (list of hobbies , maximum 3)
-> On giving a user name , the output should be the list of profiles in the following matching order.
First preference should be given to opposite gender
Second preference should be the minimum age difference
Third preference should be the maximum hobbies should match

Sample Input:

Neha , Female, 21 , Singing, dancing
Pooja, Female, 23, painting, badminton
Vikas, Male, 32, bowling, cricket
Kiran, Male, 29, badminton, chess
Uday, Male, 23, cricket, programming
Nikita, Female, 26, ludo, chess


Expected output:

Input user name:
Nikita

The following matches have been found:
Kiran, Male, 29, badminton, chess
Uday, Male, 23, cricket, programming
Vikas, Male, 32, bowling, cricket
Pooja, Female, 23, painting, badminton
Neha , Female, 21 , Singing, dancing


   profiles.add(new User("Neha" , "Female", 21 , Arrays.asList( "Singing", "dancing")));
        profiles.add(new User("Pooja" , "Female", 23 , Arrays.asList( "painting", "badminton")));
        profiles.add(new User("Vikas" , "Male", 32 , Arrays.asList( "bowling", "cricket")));
        profiles.add(new User("Kiran" , "Male", 29 , Arrays.asList( "badminton", "chess")));
        profiles.add(new User("Uday" , "Male", 23 , Arrays.asList( "cricket", "programming")));
        profiles.add(new User("Nikita" , "Female", 26 , Arrays.asList( "ludo", "chess")));

* List<User> profiles = new ArrayList<>();
        profiles.add(new User("Neha" , Gender.FEMALE, 21 , new HashSet<>(Arrays.asList( "Singing", "dancing"))));
        profiles.add(new User("Pooja" , Gender.FEMALE, 23 , new HashSet<>(Arrays.asList( "painting", "badminton"))));
        profiles.add(new User("Vikas" , Gender.MALE, 32 , new HashSet<>(Arrays.asList( "bowling", "cricket"))));
        profiles.add(new User("Kiran" , Gender.MALE, 29 , new HashSet<>(Arrays.asList( "badminton", "chess"))));
        profiles.add(new User("Uday" , Gender.MALE, 23 , new HashSet<>(Arrays.asList( "cricket", "programming"))));
        //profiles.add(new User("Nikita" , Gender.FEMALE, 26 , new HashSet<>(Arrays.asList( "ludo", "chess"))));

        List<Criteria> criteriaList = new ArrayList<>();
        criteriaList.add(new OppositeGenderCriteria());
        criteriaList.add(new AgeDifferenceCriteria());
        criteriaList.add(new HobbiesMatchingCriteria());

        User u = new User("Nikita" , Gender.FEMALE, 26 , new HashSet<>(Arrays.asList( "ludo", "chess")));

        Collections.sort(profiles, new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                int sum =0;
                for(Criteria x : criteriaList) {
                    int resulOne = x.compare(u, u1);// 1
                    int resultTwo = x.compare(u, u2); //

                    if (resulOne != resultTwo) {
                        return resulOne - resultTwo;
                    }

                }
                return  0;

            }

        });

        for(User x : profiles){
            System.out.println(x.name+" "+x.age+" "+x.gender+" "+x.hobbies.toString());
        }
*
* */




/*
*
----------------------------------------------------------

An edit operation is defined as one of the following cases:

    Adding a character to a string
    Removing a character from a string
    Replacing a character in a string with another character

The edit distance between two strings is the number of operations needed to transform one string to the other. Given two strings, write a function is_one_edit_distance to determine if they have an edit distance of one.

Input Limitations:
Only lowercase letters will be present in the string. No other special characters.
String length will not exceed 10000.

# Input:
is_one_edit_distance("fog", "foo")

# Output:
True

# Input:
is_one_edit_distance("grab", "grab")

# Output:
False

----------------------------------------------------------

public boolean isOneEditDistance(String s1, String s2) {
    //" foo", "fog"
    if(Math.abs(s1.length()-s2.length()) <= 1){
        int[] count = new int[26];
        for(char ch : s1.toCharArray()){
            count[ch-'a']++;
        }

        for(char ch : s2.toCharArray()){
            if(count[ch-'a'] > 1)
               count[ch-'a']--;
        }
        int sum =0;
        for(int i=0;i<26;i++){
            sum += count[i];
        }
        if(sum==1){
            return true;
        }
    }
    return false;
}


----------------------------------------------------------

Given a table with the columns name and emails where:

    Names with the same email are the same user.
    Emails with the same name are the same user.

Count the number of actual unique users. The data is provided in a two-dimensional array format.


Examples:
 # Input:
John Doe, john.doe@gmail.com // 0 --> 1
John Walter Doe, john.doe@gmail.com  // 1 --> 0
Peter Watson, peter@example.com // 2 --> 3
Peter Watson, peter.watson@gmail.com // 3 --> 2

# Output:
2

# Input:
John Doe, john.doe@gmail.com /// 0 --> 1 --4
John Walter Doe, john.doe@gmail.com // 1--> 0 --4
Peter Watson, peter@example.com  // 2--> 3-->4
Peter Watson, peter.watson@gmail.com // 3--> 2 --> 4
Peter Watson, john.doe@gmail.com // 4 -- 0 --1-->2--> 3

# Output:
1

John Doe - { john.doe@gmail.com  }
John Walter Doe - { john.doe@gmail.com }
Peter Watson - { peter@example.com, peter.watson@gmail.com, john.doe@gmail.com }

----------------------------------------------------------
class Node {
    int index;
    String name ;
    String email ;

    Node(int i, String name, String email) // Node constructor with index, name and email
}



public int uniqueUsers(String[n][2] users) {

    Map<Integer, List<Node>> vertexToEdgeMap = new HashMap<>();

    List<Node> list = new ArrayList<>(); // all nodes

    for(int i=0;i<users.length;i++){
        Node node = new Node(i,users[0],users[1]);
        list.add(node);
    }

    // creating Adjacency list for nodes

    for(int i=0;i<list.size();i++){
        for(int j=0;j<list.size();j++){
            if(i==j){
                continue; // checking same node
            }
            Node one = list.get(i);
            Node two = list.get(j);
            if(one.name.equals(two.name) || one.email.equals(two.email)){

                // connecting one ---> two
                if(vertexToEdgeMap.containsKey(one.index)){
                    List<Nodes> edges = vertexToEdgeMap.get(one);
                    edges.add(two);
                    vertexToEdgeMap.put(one.index,edges);
                }else{
                    List<Nodes> edges = new LinkedList<>();
                    edges.add(two);
                    vertexToEdgeMap.put(one.index,edges);
                }

                // connecting two --> one

                if(vertexToEdgeMap.containsKey(two.index)){
                    List<Nodes> edges = vertexToEdgeMap.get(two);
                    edges.add(one);
                    vertexToEdgeMap.put(two.index,edges);
                }else{
                    List<Nodes> edges = new LinkedList<>();
                    edges.add(one);
                    vertexToEdgeMap.put(two,edges);
                }
            }
        }
    }

    boolean[] visited = new boolean[list.size()]; // all false
    int count=0;
    for(int i=0;i<listNodes.size();i++){
        if(!visited[i]){

            dfs(0,vertexToEdgeMap,visited)
            count++;
        }
    }
    System.out.println(count);

}



# Input:
John Doe, john.doe@gmail.com /// 0 --> 1 --4
John Walter Doe, john.doe@gmail.com // 1--> 0 --4
Peter Watson, peter@example.com  // 2--> 3-->4
Peter Watson, peter.watson@gmail.com // 3--> 2 --> 4
Peter Watson, john.doe@gmail.com // 4 -- 0 --1-->2--> 3

void dfs(int index, Map<Integer, List<Node>>  vertexToEdgeMap , boolean[] visited){
    visited[index]=true;

    List<Nodes> edges = vertexToEdgeMap.get(index);

    for(Node edge : edges){
        if(!visited[edge.index]){
            dfs(edge.index,vertexToEdgeMap,visited);
        }
    }
}
*
* */


/*Create an airport system which has :-

        1.Multiple Flights (FightNo, departureTime,destination).
        2.Write addFlight(Flight),
        3.deleteFlight(FLightNo),
        3.GetClosestFlight(source, destination) methods for the airport.

         Date date1 = new Date();
        date1.setHours(7);
        Date date2 = new Date();
        date2.setHours(8);
        Flight one = new Flight(1,"delhi","mumbai",date1,date2);


         date1 = new Date();
        date1.setHours(8);
         date2 = new Date();
        date2.setHours(9);
        Flight two = new Flight(2,"delhi","mumbai",date1,date2);

        date1 = new Date();
        date1.setHours(9);
        date2 = new Date();
        date2.setHours(10);
        Flight three = new Flight(3,"delhi","mumbai",date1,date2);


        date1 = new Date();
        date1.setHours(10);
        date2 = new Date();
        date2.setHours(11);
        Flight four = new Flight(4,"delhi","mumbai",date1,date2);
       // Flight five = new Flight(5,"delhi","mumbai",date1,date2);

        FlightService flightService = new FlightService();
        flightService.addFlight(four);
        flightService.addFlight(one);
        flightService.addFlight(three);
        flightService.addFlight(two);


        //flightService.addFlight(five);



        List<Flight> result = flightService.getFLightInOrderByStartTime("delhi","mumbai");

        for(Flight f : result){
            System.out.println("id : "+ f.flightId+"  startTime "+ f.startTime+"  endTime: "+f.endTime);
        }

 */


/*
We have some clickstream data that we gathered on our client's website. Using cookies, we collected snippets of users' anonymized URL histories while they browsed the site. The histories are in chronological order, and no URL was visited more than once per person.

Write a function that takes two users' browsing histories as input and returns the longest contiguous sequence of URLs that appears in both.

Sample input:

user0 = ["/start", "/green", "/blue", "/pink", "/register", "/orange", "/one/two"]
user1 = ["/start", "/pink", "/register", "/orange", "/red", "a"]
user2 = ["a", "/one", "/two"]
user3 = ["/pink", "/orange", "/yellow", "/plum", "/blue", "/tan", "/red", "/amber", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow", "/BritishRacingGreen"]
user4 = ["/pink", "/orange", "/amber", "/BritishRacingGreen", "/plum", "/blue", "/tan", "/red", "/lavender", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow"]
user5 = ["a"]
user6 = ["/pink","/orange","/six","/plum","/seven","/tan","/red", "/amber"]

Sample output:

findContiguousHistory(user0, user1) => ["/pink", "/register", "/orange"]
findContiguousHistory(user0, user2) => [] (empty)
findContiguousHistory(user0, user0) => ["/start", "/green", "/blue", "/pink", "/register", "/orange", "/one/two"]
findContiguousHistory(user2, user1) => ["a"]
findContiguousHistory(user5, user2) => ["a"]
findContiguousHistory(user3, user4) => ["/plum", "/blue", "/tan", "/red"]
findContiguousHistory(user4, user3) => ["/plum", "/blue", "/tan", "/red"]
findContiguousHistory(user3, user6) => ["/tan", "/red", "/amber"]

n: length of the first user's browsing history
m: length of the second user's browsing history



*/


public class Int {

    /*
    static final Long timeWindow = 100L;
    static  final long MAX_HIT = 5;
    static Map<String,Queue<Long>> clientToTimestampMap = new HashMap<>();
    public static void main(String[] args) {
        List<Input> inputs = new ArrayList<>();

        inputs.add(new Input("A", 1000));
        inputs.add(new Input("A", 1002));
        inputs.add(new Input("A", 1020));
        inputs.add(new Input("A", 1030));
        inputs.add(new Input("A", 1050));
        inputs.add(new Input("A", 1051));
        inputs.add(new Input("A", 1099));
        inputs.add(new Input("A", 1100));
        inputs.add(new Input("A", 1101));

        for(Input input : inputs){
            checkHit(input.clientId,input.hitTime);
        }
    }
    private static boolean checkHit(String clientId, long currentHitTimestamp){
        boolean result = isAllowed(clientId,currentHitTimestamp);
        if(result){
            System.out.println("clientId : "+clientId+" currentTimestamp : "+currentHitTimestamp + " is hit");
        }else{
            System.out.println("clientId : "+clientId+" currentTimestamp : "+currentHitTimestamp + " is blocked");
        }

        return result;
    }
    private static boolean isAllowed(String clientId,long currentHitTimestamp){

        if(clientToTimestampMap.containsKey(clientId)){
            Queue<Long> list = clientToTimestampMap.get(clientId);
            while(!list.isEmpty() && (currentHitTimestamp - list.peek() > timeWindow)){
                list.poll();
            }
            if(list.size()<MAX_HIT){
                list.add(currentHitTimestamp);
                return true;
            }
            return false;
        }else{
            Queue<Long> queue = new LinkedList<>();
            queue.add(currentHitTimestamp);
            clientToTimestampMap.put(clientId,queue);
            return true;
        }
    }

     */

    public static void main(String[] args) {
        int[] A= {2,3,3,4};
        int[] B = {1,1,0,0};

        System.out.println(Grabsolution(A,B));
    }
    private static int Grabsolution(int[] A,int[] B){
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<A.length;i++){
            set.add(A[i]);
            set.add(B[i]);
        }
        int nodes = set.size();
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<B.length;i++){
            if(map.containsKey(B[i])){
                List<Integer> list = map.get(B[i]);
                list.add(A[i]);
                map.put(B[i],list);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(A[i]);
                map.put(B[i],list);
            }
        }
       int vertex =  checkMotherVertex(map,nodes);
        return vertex;
    }
    static int checkMotherVertex(Map<Integer,List<Integer>> map,int nodes){
        int v = -1;
        for(int i=0;i<nodes;i++){
            boolean[] visited = new boolean[nodes];
            dfsUtil(i,map,visited);
            if(checkAllVisited(visited)){
                v=i;
                return v;
            }
        }
        return -1;
    }
    private static boolean checkAllVisited(boolean[] visited){
        for(boolean x : visited){
            if(!x){
                return false;
            }
        }
        return true;
    }
    private static void dfsUtil(int vertex,Map<Integer,List<Integer>> map, boolean[] visited){
        visited[vertex]=true;
        if(map.containsKey(vertex)){
            for(int x : map.get(vertex)){
                if(!visited[x]){
                    dfsUtil(x,map,visited);
                }
            }
        }

    }
}
class Input{
    String clientId;
    long hitTime;
    Input(String clientId,long hitTime){
        this.clientId=clientId;
        this.hitTime=hitTime;
    }
}