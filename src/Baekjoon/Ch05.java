package Baekjoon;

import java.io.*;
import java.util.*;
//문자열 S를 입력받은 후에, 각 문자를 R번 반복해 새 문자열 P를 만든 후 출력하는 프로그램을 작성
public class Ch05 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());//테스트 케이스 개수

        for(int i=0; i<num; i++){
            String[] input = br.readLine().split(" ");// input[0] 반복되는 숫자 input[1] 제시된 문자열
            int repeat = Integer.parseInt(input[0]); // 반복되는 숫자 => 총 문자열의 개수는 반복되는 숫자 * 문자열의 길이
            String str = input[1]; //문자열

            //반복하는 작업 수행
            StringBuilder result = new StringBuilder(); // 빈 결과값 선언
            for(char c : str.toCharArray()){ //[abc] -> ['a','b','c']
                for(int j=0; j<repeat; j++){
                    result.append(c); // 문자열 반복
                }
            }
            System.out.println(result);
        }
    }
}
