//Peter El-Hadad 20206705
//Mariel Avril Leano 20218008


import java.io.*;
import java.lang.*;
import java.util.*;

class Islands {

    static final int ROW = 5, COL = 5;


    boolean isSafe(int M[][], int row, int col,
                   boolean visited[][])
    {

        return (row >= 0) && (row < ROW) && (col >= 0)
                && (col < COL)
                && (M[row][col] == 1 && !visited[row][col]);
    }


    void DFS(int M[][], int row, int col, boolean visited[][])
    {
        int[] rowDir={-1,-1,-1,0,0,1,1,1};
        int[] colDir={-1,0,1,-1,1,-1,0,1};

        visited[row][col]=true;

        for(int i=0;i<8;i++){
            int newRow=row+rowDir[i];
            int newCol=col+colDir[i];
            if(isSafe(M,newRow,newCol,visited)){
                DFS(M,newRow,newCol,visited);
            }
        }


    }


    int countIslands(int M[][])
    {
        boolean visited[][]=new boolean[ROW][COL];
        for(int i=0;i<ROW;i++){
            for(int j=0;j<COL;j++){
                visited[i][j]=false;
            }
        }
        int count=0;
        for(int i=0;i<ROW;i++){
            for (int j=0;j<COL;j++){
                if(M[i][j]==1 && !visited[i][j]){
                    DFS(M,i,j,visited);
                    count++;
                }
            }
        }
        return count;
    }


    public static void main(String[] args)
            throws java.lang.Exception
    {
        int M[][] = new int[][] {{ 1, 1, 0, 0, 0 },
                { 0, 1, 0, 0, 1 },
                { 1, 0, 0, 1, 1 },
                { 0, 0, 0, 0, 0 },
                { 1, 0, 1, 0, 1 } };
        Islands I = new Islands();
        System.out.println("Number of islands is: "
                + I.countIslands(M));

        // OUTPUT: Number of islands is: 5
    }
}

