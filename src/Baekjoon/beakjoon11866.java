package Baekjoon;

import java.io.*;
import java.util.*;
//1-N명까지 N명의 사람이 원을 이루면서 앉아있고 , 양의정수 K에 대해서 순서대로 K번째 사람을 제거.
//원에서 사람이 제거되는 순서를 (N,K)- 요세푸스 순열
public class beakjoon11866 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] num = br.readLine().split(" ");
        int N = Integer.parseInt(num[0]); //N명의 사람  7
        int K = Integer.parseInt(num[1]); //양의 정수 K  3
        Queue<Integer> queue = new LinkedList<>(); // Queue 선언

        for(int i =0; i<N; i++){// i는 0~6 -> +1 하면 1~7
            queue.add(i+1);
        }
        List<Integer> result = new ArrayList<>(); // 순열 결과를 저장할 리스트 선언
        // K번째 사람 제거 반복
        while (!queue.isEmpty()) {
            // K-1번 앞의 사람들을 뒤로 보냄
            for (int i = 0; i < K - 1; i++) { //K가 3일때 i는 0,1
                queue.add(queue.poll());//
            }
            // K번째 사람 제거 및 결과에 추가
            result.add(queue.poll());
        }
        System.out.println(result.toString().replace("[","<").replace("]",">"));
    }
}
