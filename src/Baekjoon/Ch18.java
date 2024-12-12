package Baekjoon;

import java.io.*;
import java.util.ArrayList;

public class Ch18 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int num1 = Integer.parseInt(arr[0]); // 첫번째수
        int num2 = Integer.parseInt(arr[1]);  //두번째 수
        ArrayList<Integer> list = new ArrayList<>();
        // 약수중 Num2번째로 수를 출력 해야함
        for(int i =1; i <= num1 ; i++){
            if(num1 % i ==0){
                list.add(i);
            }
        }

        if(num2 > list.size()){ //num2가 약수의 개수보다 크다면
            System.out.println(0);
        }else{
            System.out.println(list.get(num2-1));
        }

    }

}
