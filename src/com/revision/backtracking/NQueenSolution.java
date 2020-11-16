package com.revision.backtracking;

public class NQueenSolution {

    int[][] box;

    public static void main(String[] args) {
        NQueenSolution nQueenSolution = new NQueenSolution ();
        nQueenSolution.initialize();
    }

    private void initialize() {

        box = genenateBox(10);

        if(findSolution(box, 0) == false){
            System.out.println ("No Solution Exists");
        }
        printBox(box);
    }

    private int[][] genenateBox(int number) {

        box = new int[number][number];
        for(int i=0;i<number;i++){
            for (int j=0;j<number;j++){
                box[i][j] = 0;
            }
        }
        return box;
    }

    private boolean findSolution(int[][] box, int col) {

        if(col >= box.length){
            return true;
        }

        for(int i=0;i<box[0].length;i++){

            if(placeQueen(box, i, col)){
                box[i][col] = 1;
                if(findSolution (box,col+1)){
                    return true;
                }
                box[i][col] = 0;
            }
        }

        return false;
    }

    private boolean placeQueen(int[][] box, int row, int col) {

        //Checking the column of the Same Row
        for(int i=0;i<col;i++){
            if(box[row][i]==1){
                return false;
            }
        }

        //Left Top Diagonal Check
        for(int i=row, j=col;i>=0 && j>=0;i--,j--){
            if(box[i][j]==1){
                return false;
            }
        }

        //Left Bottom Diagonal Check
        for(int i=row, j=col;j>0 && i<box.length;i++,j--){
            if(box[i][j]==1){
                return false;
            }
        }
        return true;
    }

    private void printBox(int[][] box) {

        for(int i=0;i<box.length;i++){
            for(int j=0;j<box[i].length;j++){
                System.out.print (box[i][j] + " ");
            }
            System.out.println (" ");
        }
    }
}
