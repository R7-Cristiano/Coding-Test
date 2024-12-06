package Baekjoon;

import java.io.*;
//이 단어가 팰린드롬인지 아닌지 확인하는 프로그램을 작성
//앞으로 읽을때와 뒤로 읽을때 같은 숫자-> 팰린드롬 -> 맞으면 1 아니면 0
public class Ch10 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine(); //level noon 5/2 = 2 10/5 waaaaaaaaw
        if(isStringEqual(str)){
            System.out.println(1);
        }else {
            System.out.println(0);
        }
    }

    public static boolean isStringEqual(String str){ //level
        int left = 0;
        int right = str.length()-1;

        while(left<right){
            if(str.charAt(left)!=str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
