package practice;

import java.util.Arrays;
import java.util.List;

public class Test {
    static int [] row = {-1,-1,-1,0,1,1,1,0};
    static  int [] col = {-1,0,1,1,1,0,-1,-1};
    public static void main(String[] args) {

        String[] input = new String[]  {"X.....>","..v..X.",".>..X..","A......"}; // {"...Xv","AX..^",".XX.."};

        System.out.println(Solution(input));



    }
    private static void printMatrix(char[][] in){
       for(char[] x : in){
           System.out.println(Arrays.toString(x));
       }
    }

    public static boolean Solution(String[] input){
        char[][] in = new char[input.length][input[0].length()];

        for(int i=0;i<in.length;i++){
            in[i]= input[i].toCharArray();
        }
        printMatrix(in);
        System.out.println();

        int[] start = createMatrix(in);
        printMatrix(in);
        if(start[0]==-1 || start[1]==-1){
            return false;
        }
        if(in[start[0]][start[1]]!='A' || in[in.length-1][in[0].length-1]!='.'){
            return false;
        }
        boolean visited[][] = new boolean[in.length][in[0].length];
        if(startDfs(start[0],start[1],in,visited)){
            return true;
        }
        return false;
    }

    private static boolean startDfs(int i, int j, char[][] in, boolean[][] visited) {
        visited[i][j]=true;
        if(i==in.length-1 && j==in[0].length-1){
            return true;
        }
        for(int k=0;k<8;k++){
            int r = i+row[k];
            int c = j + col[k];
            if(isSafe(r,c,in) && !visited[r][c]){
                if(startDfs(r,c,in,visited)){
                    return true;
                }
            }
        }
        return  false;
    }

    private static boolean isSafe(int i, int j, char[][] in) {
        int r = in.length;
        int c= in[0].length;
        if(i>=0 && i<r && j>=0 && j<c && in[i][j]!='W'){
            return true;
        }
        return false;
    }

    private static int[] createMatrix(char[][] in){
        int r = in.length;
        int c = in[0].length;
        int[] start = new int[]{-1,-1};

        for(int i=0;i<r;i++ ){
            for(int j=0;j<c;j++){
                if(in[i][j]=='A'){
                    start[0]=i;
                    start[1]=j;
                }else if(in[i][j]=='>'){
                    updateRightMatrix(in,i,j);

                }else if(in[i][j]=='<'){
                    updateLeftMatrix(in,i,j);
                }else if(in[i][j]=='^'){
                    updateUpMatrix(in,i,j);
                }else if(in[i][j]=='v'){
                    updateDownMatrix(in,i,j);
                }
            }
        }
    return start;

    }

    private static void updateRightMatrix(char[][] in, int i, int j) {

        for(int col=j;col<in[0].length ;col++){
            if(in[i][col]!='.'){
                break;
            }else{

                System.out.println();
                printMatrix(in);
                in[i][col]='W';
            }

        }

    }

    private static void updateLeftMatrix(char[][] in, int i, int j) {

        for(int col=j;col>=0 ;col--){
            if(in[i][col]!='.'){
                break;
            }else{
                System.out.println();
                printMatrix(in);
                in[i][col]='W';
            }

        }

    }

    private static void updateUpMatrix(char[][] in, int i, int j) {

        for(int row=i;row>=0 ;row--){
            if(in[row][j]!='.'){
                break;
            }else{
                System.out.println();
                printMatrix(in);
                in[row][j]='W';
            }

        }

    }

    private static void updateDownMatrix(char[][] in, int i, int j) {

        for(int row=i;row<in.length ;row++){
            if(in[row][j]!='.'){
                break;
            }else{
                System.out.println();
                printMatrix(in);
                in[row][j]='W';
            }

        }

    }



    private static void leftToRightMax2Frog(int[] block) {
        int [] right = new int[block.length];
        //Arrays.fill(right,1);
        for(int i=1;i<block.length;i++){
            if(block[i]>=block[i-1]){
                right[i]= right[i-1] + 1;
            }
        }

        int [] left = new int[block.length];
       // Arrays.fill(left,1);

        for(int i=block.length-2;i>=0;i--){
            if(block[i] >= block[i+1]){
                left[i]= left[i+1] +1;
            }
        }

        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
    }

    /*
    private static void leftToRightMax2Frog(int[] block) {

    /*
     int[] block = new int[]{2,6,8,5};//2  // 2,6,8,5-->3 // 1,5,5,2,6 --> 4

        leftToRightMax2Frog(block);

        */
    /*
        int max =0;
        for(int i=0;i<block.length;i++){
            int j=i;
            int k=i;

            while(j>0 && block[j-1] >=block[j]){
                j--;
            }
            while(k<block.length-1 && block[k] <=block[k+1]){
                k++;
            }
            int ans = k-j+1;
            max = Math.max(max,ans);
        }
        System.out.println(max);
    }
    */

    public static int largestArea(List<List<Integer>> samples) {
        int rows = samples.size();
        int cols = samples.get(0).size();

        int[][] dp = new int[rows + 1][cols + 1];
        int maxsqlen = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (samples.get(i-1).get(j-1) == 1){
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[i][j]);
                }
            }
        }
        return maxsqlen * maxsqlen;

    }
    public static int minimum (int x, int y, int z) {
        return Integer.min(Integer.min(x, y), z);
    }
    public static int checksquare(List<List<Integer>> samples){
        // base case


        // `T[i][j]` stores the size of maximum square
        // submatrix ending at `mat[i][j]`
        int[][] T = new int[samples.size()][samples.get(0).size()];

        // `max` stores the size of the largest square submatrix of 1's
        int max = 0;

        // fill in a bottom-up manner
        for (int i = 0; i < samples.size(); i++)
        {
            for (int j = 0; j < samples.get(0).size(); j++)
            {
                T[i][j] = samples.get(i).get(j);

                // if we are not at the first row or first column and the
                // current cell has value 1
                if (i > 0 && j > 0 && samples.get(i).get(j) == 1)
                {
                    // the largest square submatrix ending at `mat[i][j]` will be
                    // 1 plus minimum of largest square submatrix
                    // ending at `mat[i][j-1]`, `mat[i-1][j]` and `mat[i-1][j-1]`

                    T[i][j] = minimum(T[i][j - 1], T[i - 1][j],
                            T[i - 1][j - 1]) + 1;
                }

                // update maximum size found so far
                if (max < T[i][j]) {
                    max = T[i][j];
                }
            }
        }

        // return size of the largest square matrix
        return max;
    }
}
