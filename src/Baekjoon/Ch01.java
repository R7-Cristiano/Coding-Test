package Baekjoon;

//S의 i 번째 글자 출력
import java.util.*;
import java.io.*;

public class Ch01 {
    public static void main(String[] args) throws IOException {
        BufferedReader st = new BufferedReader(new InputStreamReader(System.in));
        String str = st.readLine(); //문자로 입력
        int num = Integer.parseInt(st.readLine());

        System.out.println(str.charAt(num-1));
    }
}