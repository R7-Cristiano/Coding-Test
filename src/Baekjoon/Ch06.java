package Baekjoon;

//상수는 수를 다른 사람과 다르게 거꾸로 읽는다.

import java.util.*;
import java.io.*;

public class Ch06 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" "); // 입력을 공백으로 구분하여 배열에 저장

        // 첫 번째 숫자 뒤집기
        String num1 = new StringBuilder(input[0]).reverse().toString();
        // 두 번째 숫자 뒤집기
        String num2 = new StringBuilder(input[1]).reverse().toString();

        // 두 숫자 중 더 큰 값 출력
        System.out.println(Math.max(Integer.parseInt(num1), Integer.parseInt(num2)));
    }
}
