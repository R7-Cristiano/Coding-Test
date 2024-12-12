package Baekjoon;

import java.io.*;
import java.util.Arrays;

public class Ch20 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine()); // 입력받을 숫자의 개수
        Integer[] numbers = new Integer[n]; // 입력된 숫자를 저장할 배열 (Integer 타입 필요)

        // 입력된 숫자를 배열에 저장
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        // 배열 내림차순 정렬
        Arrays.sort(numbers);

        // 정렬된 결과를 한 줄에 하나씩 출력
        for (int num : numbers) {
            bw.write(num + "\n");
        }
        bw.close();
    }
}
