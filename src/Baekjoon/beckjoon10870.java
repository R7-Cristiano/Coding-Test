package Baekjoon;

import java.io.*;
public class beckjoon10870 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(Fibonacci(N));
    }
    public static int Fibonacci(int num){//첫째 줄에 n번째 피보나치 수를 출력한다
        if(num==0){
            return 0;
        }else if(num==1){
            return 1;
        }else{
            return Fibonacci(num-1)+ Fibonacci(num-2);
        }
    }
}
