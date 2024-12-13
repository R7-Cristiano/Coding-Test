package Baekjoon;

import java.io.*;
import java.util.Arrays;
public class Ch22 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" "); //입력받은 두개의 숫자
        int num = Integer.parseInt(arr[0]); //N명 5
        int cut = Integer.parseInt(arr[1]); // 커트라인 2


        String[] score = br.readLine().split(" ");
        int stu[]= new int[num];

        for(int i=0; i<num; i++){
            stu[i] = Integer.parseInt(score[i]);
        }

        Arrays.sort(stu);

        System.out.println(stu[num-cut]);
    }
}
