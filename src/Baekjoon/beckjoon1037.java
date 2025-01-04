package Baekjoon;

import java.io.*;
import java.util.*;

public class beckjoon1037 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //N의 약수의 개수
        //둘째줄에는 진짜 약수가 주어짐
        //양수 A가 N의 진짜 약수가 되려면, N이 A의 배수이고, A가 1과 N이 아니어야 한다 N을 구해야함.
        String[] num = br.readLine().split(" "); // N의 약수를 입력받는다
        int intArr[] = new int[num.length];

        for(int i=0; i<num.length; i++){
            intArr[i] = Integer.parseInt(num[i]);
        }

        Arrays.sort(intArr);

        int A = intArr[intArr.length-1] * intArr[0];

        System.out.println(A);

    }
}
