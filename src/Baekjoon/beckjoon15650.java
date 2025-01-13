package Baekjoon;

import java.io.*;
import java.util.*;

public class beckjoon15650 {
    static int N,M;
    static boolean[] visited;
    static List<Integer> sequence = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        N= Integer.parseInt(nums[0]); //1-N까지의 자연수
        M= Integer.parseInt(nums[1]); //중복없이 M를 고른 수열

        visited = new boolean[N+1];

        backtrack(0);
    }
    public static void backtrack(int depth){
        if(depth == M){
            for(int i=0; i<M; i++) {
                int num = sequence.get(i);
                System.out.print(num + " ");
            }
            System.out.println();
        }
        int start;
        if(depth == 0){
            start = 1;
        }else{
            start = sequence.get(depth-1) +1;
        }
        for(int i=start; i<=N; i++){
            if(!visited[i]){
                visited[i] = true;
                sequence.add(i);
                backtrack(depth+1);
                visited[i] = false;
                sequence.remove(sequence.size()-1);
            }
        }
    }
}
