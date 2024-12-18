package Baekjoon;

import java.io.*;
import java.util.*;
//12345 -> 2345 -> 3452 -> 452 -> 542 -> 42 -> 2
//123456 -> 23456 -> 34562 -> 4562 -> 5624 -> 624 -> 246 -> 46 -> 64 -> 4
//큐는 가장 먼저 들어오는것이 가장 늦게 나간다. 1-N까지의 번호가 붙어있음.
public class Ch34 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 카드의 개수 N이 6이면 1~6까지의 카드가 존재
        Queue<Integer> queue = new LinkedList<>();

        int[] card = new int[N]; //카드 배열 선언

        for(int i =0; i<N; i++){ //i는 0부터 5까지  i[0]=1 i[1]=2 i[2]=3 i[3]=4 i[4]=5 i[5]=6
            card[i] = i+1;
            queue.add(card[i]); //큐에 카드 번호 추가.
        }
        //queue: [1,2,3,4,5,6] //6장의 카드
        //i[0]=1 i[1]=2 i[2]=3 i[3]=4 i[4]=5 i[5]=6
        while(queue.size()>1){ //카드의 개수가 1보다 클 동안 계속 반복
            if(N>1) {
                queue.remove();
                queue.add(queue.remove());
            }else{
                break;
            }
        }
        System.out.println(queue.peek());
    }
}
