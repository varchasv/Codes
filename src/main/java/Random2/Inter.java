package Random2;

import java.util.*;
import java.util.stream.Stream;

/*
*  private static void printMatrix(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        boolean flag=true;
        for(int i=0;i<r;i++){

            if(i % 2 ==0){
                if(flag){
                    for(int j=0;j<c;j++) {
                        System.out.print(matrix[i][j] + " ");
                    }
                }else{
                    for(int j=c-1;j>=0;j--){
                        System.out.print(matrix[i][j] + " ");
                    }
                }
            }else {
                if(flag){
                    System.out.print(matrix[i][c-1] + " ");

                }else{
                    System.out.print(matrix[i][0] + " ");
                }
                flag = !flag;
            }
            System.out.println();


        }
    }
    * */

/*
    private static void calculateOptimumLength(int[] arr,int k){

        int max = Integer.MIN_VALUE;
        for(int x : arr){
            max = Math.max(x,max);
        }

        int low = 0;
        int high=max;


        int s = cal(arr,0);

        if(s<k){
            System.out.println("Not possible");
        }

        int latestIndex=0;

        while(low<high){
            int mid = (low +high)/2;

            int curr = cal(arr,mid);

            if(curr>=k){
               low=mid ;
               latestIndex =mid;
            }else{
                high=mid;
            }
        }

        System.out.println(latestIndex);

    }
    private static int cal(int[] arr,int index){
        int sum =0;

        for(int a : arr){
            if((a-index) >= 0 ){
                sum += a-index;
            }
        }
        return sum;
    }

    private static String getStringKey(String x) {
        int[] arr = new int[26];
        for (char ch : x.toCharArray()) {
            arr[ch - 'a']++;
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (arr[i] > 0) {
                char ch = (char) (97 + i);
                str.append(ch);
                str.append(arr[i]);
            }
        }
        return str.toString();
    }

    private static void convert(int[][] matrix) {

        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (row.contains(i) || col.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }


    private static void check(int[] arr) {

        int count = 0;
        for (int x : arr) {
            if (x <= 0) {
                count++;
            }
        }
        int i = 0, j = arr.length - 1;
        while (i < j) {
            if (arr[i] <= 0) {
                swap(arr, i, j);
                j--;
            }
            i++;
        }
        for (int k = 0; k < arr.length - count; k++) {
            int x = arr[k];
            if (Math.abs(x) < arr.length - count) {
                arr[Math.abs(x)] *= (-1);
            }
        }
        for (int k = 0; k < arr.length - count; k++) {
            if (arr[k] >= 0) {
                System.out.println(k + 1);
            }
        }
        System.out.println(arr.length - count);
    }

    private static void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }*/

/*
compass interview



1) A Customer wants to invest in Real Estate and has S millions of revenue for investment

The Property_List contains the List of available property prices in millions

Find the possible combination of all properties that the customer can invest in.


Property_List=[10, 8, 9, 7, 6, 1, 5, 4, 3]

s = 8




//. TC : exponential O(2^n)
// SC : O(n)



class Solution {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("Hello, World!");
        strings.add("Welcome to CoderPad.");
        strings.add("This pad is running Java " + Runtime.version().feature());

        for (String string : strings) {
            System.out.println(string);
        }

        List<Integer> input = Arrays.asList(10, 8, 9, 7, 6, 1, 5, 4, 3);
        int sum = 8;

        Set<List<Integer>> result = getAllCombinations(input,sum);

        for(List<Integer> list : result){

            System.out.println(list.toString());
        }

    }

    private static  Set<List<Integer>> getAllCombinations(List<Integer> list, int sum){

        Set<List<Integer>> result = new HashSet<>();
        for(int i=0;i<list.size();i++){
            List<Integer> currList = new ArrayList<>();
            util(0,currList,result,sum,0,list);
        }

        return result;
    }


    private static void util(int index,List<Integer> currList,Set<List<Integer>> result,int sum,int currSum,List<Integer> list){


        if(currSum == sum){
            result.add(currList);
            return;
        }


        if(index>=list.size() || currSum > sum){
            return ;
        }




        List<Integer> first = new ArrayList<>();
        first.addAll(currList);
        first.add(list.get(index));

        util(index+1,first,result,sum, currSum + list.get(index),list);


        List<Integer> anotherList = new ArrayList<>();

        anotherList.addAll(currList);
        util(index+1,anotherList,result,sum,currSum,list);



    }
}




 */

/*
Atlassian

// 1 ) total file size
// 2 ) top k collections by collection size

//collection1 , 0

file1.txt (size: 100)
file2.txt (size: 200) in collection "collection1"
file3.txt (size: 200) in collection "collection1"
file4.txt (size: 300) in collection "collection2"
file5.txt (size: 10)



        int totalFilesize=0;
        int k =3;// input from user
        Map<String,Node> collectionToSizeMap = new HashMap<>();
        List<List<String>> allInputs = new ArrayList<>();

        List<String> input0 = new ArrayList<>();
        input0.add("dummy"); // collection name
        input0.add("100"); // size
        allInputs.add(input0);


        List<String> input = new ArrayList<>();
        input.add("collection 1");
        input.add("200");
        allInputs.add(input);

        List<String> input1 = new ArrayList<>();
        input1.add("collection 1");
        input1.add("200");
        allInputs.add(input1);

        List<String> input2 = new ArrayList<>();
        input2.add("collection 2");
        input2.add("300");
        allInputs.add(input2);

        List<String> input3 = new ArrayList<>();
        input3.add("dummy");
        input3.add("300");
        allInputs.add(input3);

        for(List<String> inputx : allInputs ){

            String collectionName = inputx.get(0);
            int size = Integer.parseInt(inputx.get(1));

            if(collectionName.equals("dummy")){
                totalFilesize += size;
            }else{
                totalFilesize += size;
                calculate(collectionToSizeMap,collectionName,size);
            }

        }

        Queue<Node> queue = new PriorityQueue<>(k, new Comparator<Node>() {
            @Override
            public int compare(Node one, Node two) {
                return two.size - one.size;
            }
        });

        List<List<String>> result = new ArrayList<>();
        queue.addAll(collectionToSizeMap.values());

        while(!queue.isEmpty() && k>0){
            Node node = queue.poll();
            List<String> list = new ArrayList<>();
            list.add(node.collectionName);
            String s = String.valueOf(node.size);
            list.add(s);
            result.add(list);
            k--;
        }

        System.out.println("total file size : "+totalFilesize);
        for(int i=0;i<result.size();i++){
            System.out.println("Collection Name "+result.get(i).get(0)+" size : "+result.get(i).get(1));
        }

    }
    private static void calculate(Map<String,Node> collectionToSizeMap,String collectionName,int size){
        if(collectionToSizeMap.containsKey(collectionName)){
            Node node = collectionToSizeMap.get(collectionName);
            node.size += size;
            collectionToSizeMap.put(collectionName,node);
        }else{
            Node node = new Node(collectionName,size);
            collectionToSizeMap.put(collectionName,node);
        }
    }
    class Node {
    String collectionName;
    int size;
    Node(String collectionName , int size){
        this.collectionName=collectionName;
        this.size=size;
    }
}
 */

public class Inter {
    public static void main(String[] args) {



    }
}
