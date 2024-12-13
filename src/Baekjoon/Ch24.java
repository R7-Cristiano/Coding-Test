package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
public class Ch24 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine(); //2134 길이는 4
        Integer[] number = new Integer[num.length()];

        for(int i=0; i<num.length(); i++){
            number[i] = num.charAt(i)- '0';
        }
        // 내림차순 정렬
        Arrays.sort(number, Collections.reverseOrder());

        // 정렬된 배열을 문자열로 변환하여 출력
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < number.length; i++) {
            result.append(number[i]); // 숫자를 문자열로 추가
        }
        // 배열 출력
        System.out.println(result);
    }
}
