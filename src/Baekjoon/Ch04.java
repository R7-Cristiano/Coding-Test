package Baekjoon;

//N개의 숫자가 공백 없이 쓰여있다. 이 숫자를 모두 합해서 출력하는 프로그램을 작성하시오.
//첫째줄 숫자의 개수, 두번째줄 숫자 -> 출력값 숫자의 합

import java.io.*;
public class Ch04 {
    public static void main(String[] args) throws IOException{
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     int num = Integer.parseInt(br.readLine());
     String num2 = br.readLine();
     int sum =0;

     StringBuilder sb = new StringBuilder(num2); //공백없이 주어진 N개의 숫자

     for(int i = 0; i<sb.length(); i++){
         sum += sb.charAt(i) - '0'; // 문자를 숫자로 변환하여 합산
     }

     System.out.println(sum);
    }
}
