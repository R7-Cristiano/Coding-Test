package Baekjoon;

import java.io.*;
import java.util.*;
//아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성
//1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
//중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력
//수열은 사전 순으로 증가하는 순서로 출력
public class beckjoon15649 {
    static int N,M;
    static boolean[] visited;
    static List<Integer> sequence = new ArrayList<>(); // 현재 수열 저장
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        N = Integer.parseInt(nums[0]); //1부터 N까지 자연수
        M = Integer.parseInt(nums[1]); //중복없이 M개를 고른 수열

        visited = new boolean[N+1];
        backtrack(0);//탐색 시작
    }
    public static void backtrack(int depth){
        if(depth == M){ //길이가 M인 수열이 완성된 경우
            for(int i =0; i<M; i++){
                int num = sequence.get(i);
                System.out.print(num + " ");
            }
            System.out.println();
        }
        for(int i=1; i<=N; i++){
            if(!visited[i]){//숫자 i가 아직 사용되지 않은 경우
                visited[i] = true;// 방문처리
                sequence.add(i);//수열에 추가
                backtrack(depth+1);//재귀호출
                visited[i] = false;
                sequence.remove(sequence.size()-1);//수열에서 제거
            }
        }
    }

}
