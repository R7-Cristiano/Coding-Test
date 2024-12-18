package Baekjoon;
// 정수가 0 일경우는 가장 최근 쓴 수를 지우고, 아닐경우 해당 수를 씀.
// 재민이가 최종적으로 적어낸 수의 합을 구하는 프로그램을 짜라
import java.io.*;
import java.util.*;

public class Ch31 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());// 입력 받을 값 N
        Stack<Integer> st = new Stack<>(); // 스택 st 생성 LIFO 구조 가장 마지막으로 들어온 값이 가장 처음에 나간다,,,

        int[] num = new int[N];
        int sum =0;
        for(int i=0; i<N; i++){ // N줄
            num[i] = Integer.parseInt(br.readLine());
            if(num[i] !=0 ){
                st.add(num[i]);
            }else{
                st.pop();
            }
        }

        for(int i=0; i<st.size(); i++){
            sum = sum + st.get(i);
        }
        System.out.println(sum);

    }
}
