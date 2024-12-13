package Baekjoon;

import java.io.*;
import java.util.Arrays;
public class Ch23 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());//입력받을 숫개수
        int[] score = new int[num];

        for(int i =0; i<num; i++){
            score[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(score);

        for(int i=0; i<num; i++){
            System.out.println(score[i]);
        }
    }
}
