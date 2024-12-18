package Baekjoon;

import java.io.*;
import java.util.*;

public class Ch34_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 카드의 개수

        Queue<Integer> queue = new LinkedList<>();

        // 1부터 N까지 큐에 추가
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        // 큐의 크기가 1이 될 때까지 반복
        while (queue.size() > 1) {
            queue.poll(); // 맨 앞 카드를 버림
            queue.add(queue.poll()); // 그다음 카드를 맨 뒤로 이동
        }

        // 큐에 남은 마지막 카드 출력
        System.out.println(queue.peek());
    }
}
