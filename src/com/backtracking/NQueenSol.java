package com.backtracking;

public class NQueenSol {

    public static void main(String[] args) {

        NQueenSol nqs = new NQueenSol ();
        nqs.initialize ();
    }

    private void initialize() {
        int[][] box = {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        if (findSolution (box, 0) == false) System.out.println ("No Solution Exists");
        printBox (box);
    }

    private boolean findSolution(int[][] box, int col) {

        if (col >= box[0].length) return true;

        for (int i = 0; i < box[0].length; i++) {

            if (placeQueen (box, i, col) == true) {
                box[i][col] = 1;
                if (findSolution (box, col + 1)) return true;
                box[i][col] = 0;
            }
        }

        return false;

    }

    private boolean placeQueen(int[][] box, int row, int col) {

        // col
        for (int i = 0; i < col; i++) {
            if (box[row][i] == 1)
                return false;
        }

        // Left Top Diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (box[i][j] == 1) {
                return false;
            }
        }

        //Left Bottom Diagonal
        for (int i = row, j = col; i < box.length && j > 0; i++, j--) {
            if(box[i][j]==1){
                return false;
            }
        }

        return true;
    }


    private void printBox(int[][] box) {

        for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < box[i].length; j++) {
                System.out.print (box[i][j] + " ");
            }
            System.out.println (" ");
        }
    }


}
