package Baekjoon;

import java.io.*;

public class Ch16 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String[] str = br.readLine().split(" ");
            int num1 = Integer.parseInt(str[0]); //첫번째 숫자
            int num2 = Integer.parseInt(str[1]); // 두번째 숫자
            String result = "";
            if(num1==0 ||num2==0){
                break;
            } else if(num2%num1 ==0 && num2>num1){
                result = "factor";
                System.out.println(result);
            }else if(num1%num2==0 && num1>num2){
                result = "multiple";
                System.out.println(result);
            }else if(num1 % num2 !=0){
                result="neither";
                System.out.println(result);
            }
        }

    }
}
