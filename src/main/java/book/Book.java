package book;

import java.util.*;

public class Book {


 /*
    '''
We want to implement a feature to suggest to users the cheapest hotel that is more popular than the one they are looking at.

Write a function that given an array of hotels, sorted by their popularity returns a map from the hotel ids that associates each hotel with the cheapest hotel that is more popular than the one in question.

if there is no hotel that is cheaper and more popular than the one with that id, then it shouldn't be put in the map.

You can assume that hotel ids and prices are integers and that hotels have the following format:

struct hotel{
int id;
int price;
}

Example 1:

input = {
{ id => 123, price => 200 }, # Most popular
{ id => 55, price => 150 }, # Second most popular
{ id => 17, price => 70 }, # Third most popular
{ id => 18, price => 500 }, # ...
{ id => 27, price => 270 },
{ id => 101, price => 230 } # Least popular
}

output = {
18 : 17,
27 : 17,
101 : 17
}


the answer is, save a global variable which contains the less popular and cheapest so far.
always save the cheapest hotel.
while iterating over the hotels if the current hotel is cheaper than the global one, save this one
else add this hotel to the otuput


        public static void main(String args{}) {
        Hotel{} hotels = new Hotel{6};
        hotels{0} = new Hotel(123, 200);
        hotels{1} = new Hotel(55, 150);
        hotels{2} = new Hotel(17, 70);
        hotels{3} = new Hotel(18, 500);
        hotels{4} = new Hotel(27, 270);
        hotels{5} = new Hotel(101, 230);

        findPrintMorePopularAndCheaper(hotels);
        }

        public static Map findPrintMorePopularAndCheaper(Hotel{} array) {
        Map map = new HashMap();
        if (array.length == 0) {
        return map;
        }

        Hotel cheapestHotelSoFar = array{0};
        for (int i = 1; i cheapestHotelSoFar.price) {
        map.put(currentHotel.id, cheapestHotelSoFar.id);
        } else if (currentHotel.price < cheapestHotelSoFar.price) {
        cheapestHotelSoFar = currentHotel;
        }
        }
        return map;
        }

        static class Hotel {
        int id;
        int price;

        public Hotel(int id, int price) {
        this.id = id;
        this.price = price;
        }
        }

*/

/*

-- Design a system with zero single points of failure.
-- Describe algorithms for peak data handling
-- Describe acceptable Turn Around Time and fault tolerance.

It needs basic knowledge of Load Balancers, DB Sharding, In-Memory Caches and products like Redis,
fast-config lookup such as ZooKeeper, and of-course the ability to knit them altogether.

 */



 /*
    Recruiter phone screen:
Mainly questions around my experiences and past projects.
Why I want to join booking.com etc.

Coding phone screen:
Find the top K largest files when you are given three apis and root path:

boolean isFolder();
List<String> listFiles(String path);
double size(String path);

// function to complete
List<String> topKLargestFiles(String root){

}
Returns final output as ["a/b","a/b/d"]

Onsite:
System design: Design a scalable system to create a feature where a user looking at a property on booking.com can see how many other users are also looking at the same property.
Coding: Find the top K closest hotels within a price range. In the input grid 0 means a blocker which you can't pass through, 1 means road which you can use to navigate, any value above 1 is the price of the hotel located at x,y. You will be given this grid, price range and origin coordinates. You should return K hotels within price range and closest to the given origin.

Input:
[[1,2,0,1],
 [1,3,0,1],
 [0,2,5,1]
]
Fit/Commerical awareness interview: Questions around past experience, motivation to join booking.com, mentorship experience, disagreement with peers/leads, metrics used to measure the success of a feature, situational questions like of amazon leadership principles with lot of follow ups etc.

 */

/*
Amsterdam -> Paris on August 10, Price - 300 euros
London -> Paris on August 15, Price - 410 euros
Paris -> London on August 13, Price - 300 euros
London -> Amsterdam on August 17, Price - 400 euros
Paris -> Amsterdam on August 21, Price - 500 euros

Hotel cost per night:
Amsterdam - 400 euros
Paris - 500 euros
London - 300 euros

Find the longest itinerary possible with in a given budget 5000 and time

Lets say we start from amsterdam on 10th Aug. now we can go paris. from paris we have two options.
either we can go to london again or back to amsterdam.

Option 1:

Amsterdam -> Paris {flight} 300
Paris -> London {flight} 300
London -> Paris {flight} 410
Paris -> Amsterdam {flight} 400

Total Flight code : 1410

Hotel paris : 3 days {10 to 13} 1500
Hotel London : 2 days {13 to 15} 600
Hotel Paris : 6 days {15 to 21} 3000

Total cost is going above 5000 so user cant use this path

Option 2:

Amsterdam -> Paris {flight} 300
Paris -> London {flight} 300
London -> Amsterdam {flight} 400

Total Flight code : 1000

Hotel paris : 3 days {10 to 13} 1500
Hotel London : 4 days {13 to 17} 1200

Total cost = 1500 + 1200 + 1000 = 3700

So this itin is possbile in the given budget and date . So output will be Amsterdam -> Paris -> London -> Amsterdam
 */


/*
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String args[] ) throws Exception {


    Map<Integer, List<Room>>  map = new HashMap<>(); // all the datastore

    int checkIn = 176;
    int checkOut = 178;
    Set<String> requiredFeatures = new HashSet<>();
    int requiredRooms = 1;
    List<Room> result = new ArrayList<>();
        for(int i=checkIn ; i<checkOut;i++){
        result = check(i,requiredFeatures,requiredRooms,result,map);
        if(result.size()==0){
            return result;
        }
    }

}

    TC : diff days ( checout - checkin) * n (no of rooms ) * n (no of rooms)



//
private static List<Room>  check(int currentDate, Set<String> requiredFeatures, int requiredRooms, List<Room> result,Map<Integer, List<Room>> map){

        List<Room> allRooms = map.get(currentDate);
        List<Room> currentRoomList = new ArrayList<>();
        for(Room room : allRooms){ // 3
        if(checkValidation(room , requiredFeatures, requiredRooms)){
        if(result.size()==0){
        Room newRoom = new Room (room.price,room.features,room.availiblity);
        currentRoomList.add(newRoom);
        }else{
        for(Room currentRoom : result){ // 5
        int price = currentRoom.price += room.price;
        int availabilty = Math.min(currentRoom.availiblity, room.availiblity);
        Set<String> currentFeatures = getMatchingFeatures(currentRoom.features, room.features);
        Room newRoom = new Room (price,currentFeatures,availabilty);
        currentRoomList.add(newRoom);
        }
        }
        }
        }
        return currentRoomList;

        }
// interesection of the two sets ( features interesection)
private static Set<String> getMatchingFeatures(Set<String> currentRoomFeatures , Set<String> roomFeatures ){
        Set<String> featuresSet = new HashSet<>();

        for(String feature : currentRoomFeatures){
        if(roomFeatures.contains(feature)){
        featuresSet.add(feature);
        }
        }
        return featuresSet;
        }

// validating the requirements of the room
private static boolean checkValidation(Room room, Set<String> requiredFeatures ,  int requiredRooms ){

        // checking the required feature match
        for(String feature : requiredFeatures){

        if(!room.features.contains(feature)){
        return false;
        }
        }

        if(room.availiblity < requiredRooms ){
        return false;
        }

        return true;
        }

        }
class Room {

    int price;
    Set<String> features;
    int availiblity;

    Room(int price , Set<String> features, int availiblity){
        this.price = price;
        this.features = features;
        this.availiblity = availiblity;
    }
}
/*

condition -> feature and required availbility

New Node (price =0 , set =empty )
    price --< 120 . features : breakfast , refundable
176 --->
117

*/



    static Folder root = new Folder("");
    static Map<String, Integer> keys = new HashMap<>();

    public static void main(String[] args) {

        String[][] arr  = new String[][]{{"a"},{"c"},{"a","b"},{"c","b"},{"a","b","x"},{"a","b","x","y"},{"w"},{"w","y"}};

        List<List<String>> input = new ArrayList<>();
        for( String[] a : arr){
            input.add(Arrays.asList(a));
        }
        List<List<String>> res =  deleteDuplicateFolder(input);
    }

    public static List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        for (List<String> path : paths){
            addPath(path);
        }

        for (Folder f : root.list){
            generateKey(f);
        }

        for (Folder f : root.list){
            updateDeleteStatus(f);
        }

        List<List<String>> results = new ArrayList<>();

        for (List<String> path : paths){
            if (isValid(path))
                results.add(path);
        }

        return results;
    }

    private static boolean isValid(List<String> path){
        Folder current = root;

        for (String f : path){
            current = current.map.get(f);

            if (current.del)
                return false;
        }

        return true;
    }

    private static void updateDeleteStatus(Folder f){
        if (f.list.size() > 0 && keys.get(f.key) > 1){
            f.del = true;
            return;
        }

        for (Folder fold : f.list){
            updateDeleteStatus(fold);
        }
    }

    private static String generateKey(Folder fold){
        StringBuilder sb = new StringBuilder();

        if (fold.list.size() == 0)
            return sb.toString();

        // sort to order matches
        Collections.sort(fold.list, (a, b) -> a.name.compareTo(b.name));

        for (Folder f : fold.list){
            sb.append('(');
            sb.append(f.name + generateKey(f));
            sb.append(')');
        }

        String key = sb.toString();
        fold.key = key;
        keys.put(key, keys.getOrDefault(key, 0) + 1);

        return key;
    }

    private static void addPath(List<String> path){
        Folder current = root;

        for (String f : path){
            if (!current.map.containsKey(f)){
                Folder fold = new Folder(f);
                current.map.put(f, fold);
                current.list.add(fold);
            }

            current = current.map.get(f);
        }
    }
}
class Folder{
    String name;
    Map<String, Folder> map;
    List<Folder> list;
    String key;
    boolean del;

    Folder(String name){
        this.name = name;
        map = new HashMap<>();
        list = new ArrayList<>();
        key = "";
        del = false;
    }
}
