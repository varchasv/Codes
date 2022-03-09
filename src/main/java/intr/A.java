package intr;

import java.util.ArrayList;
import java.util.List;

public class A {
   static int[] row = {-3,-2,0,2,3,2,0,-2};
    static int[] col = {0,2,3,2,0,-2,-3,-2};
    public static void main(String[] args) {
        boolean[][] matrix = new boolean[5][5];
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                List<List<Integer>> result = new ArrayList<>();
                System.out.println(solve(i,j,matrix,result,1));
            }
        }

    }
    public static boolean solve(int i, int j , boolean[][] matrix,List<List<Integer>> result, int totalMoves ){
        int r = matrix.length;
        int c = matrix[0].length;
        if(totalMoves >= r * c ){
            System.out.println(-1);
            return  false;
        }
        if(result.size()== r * c ){
            System.out.println("i : "+i+" === j"+j);
            for(List<Integer> temp : result){
                System.out.print("("+temp.get(0)+","+temp.get(1)+")"+"--->");
            }
            System.out.println();
            return true;
        }
        if(isSafe(i,j,matrix)){
            matrix[i][j] = true;
            List<Integer> a = new ArrayList<>();
            a.add(i);
            a.add(j);
            result.add(a);
            for(int k=0;k<row.length;k++){
                int ro = i+row[k];
                int co = j+col[k];
                if(solve(ro,co,matrix,result, totalMoves+1)){
                    return true;
                }
            }
            matrix[i][j] = false;
            result.remove(result.size()-1);
        }
        return false;
    }

    private static boolean isSafe(int i, int j, boolean[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        if(i>=0 && j>=0 && i<r && j<c && !matrix[i][j]){
            return  true;
        }
        return false;
    }
}
