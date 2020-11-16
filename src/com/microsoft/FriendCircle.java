package com.microsoft;

public class FriendCircle {

    public static void main(String[] args) {
        int[][] nums = {{1, 1, 0},
                       {1, 1, 0},
                        {0, 0, 1}
        };

        System.out.println (findCicleNum (nums));
    }

    static int findCicleNum(int [][] M){
        int[] visited = new int[M.length];
        int count = 0;

        for(int i=0; i < M.length ; i++){
            if(visited[i] == 0){
                dfs(M,visited,i);
                count++;
            }
        }

        return count;
    }

    private static void dfs(int[][] M, int[] visited, int i) {

        for(int j = 0; j < M.length ; j++){

            if(M[i][j] == 1 && visited[j] == 0){
                visited[j] = 1;
                dfs (M,visited,j);
            }
        }
    }
}
