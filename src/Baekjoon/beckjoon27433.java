package Baekjoon;

import java.io.*;
import java.util.*;
//0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성
public class beckjoon27433 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.print(Factorial(N));
    }
    public static long Factorial(int num){
        if(num==0){
            return 1;
        }else{
            return num * Factorial(num-1);
        }
    }
}
