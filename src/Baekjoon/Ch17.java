package Baekjoon;

import java.io.*;

public class Ch17 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int num1 = Integer.parseInt(arr[0]); // 첫번째수
        int num2 = Integer.parseInt(arr[1]);  //두번째 수
        int count =0;
        int factor = 0;
        //두번째수는 첫번째 수의 약수

        while(true){ // num2가 num1의 약수일 동안 반복
            if(num1 % num2 ==0){

            } else{
                break;
            }
        }

        System.out.println(count);





    }

}
