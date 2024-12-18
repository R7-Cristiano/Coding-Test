package Baekjoon;

import java.io.*;
import java.util.*;
//괄호가 잘 닫혀있으면 YES, 아니면 NO!
public class Ch32 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 입력받을 줄의 수

        for (int i = 0; i < N; i++) {
            String input = br.readLine(); // 괄호 문자열 입력
            if (isValidParenthesis(input)) { // 올바른 괄호 문자열인지 검사
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
    // 괄호의 짝이 올바른지 검사하는 메서드
    public static boolean isValidParenthesis(String str) {
        Stack<Character> stack = new Stack<>(); // 스택 생성

        for (int j = 0; j < str.length(); j++) { // 문자열을 한 문자씩 검사
            char ch = str.charAt(j);

            if (ch == '(') {
                stack.push(ch); // 여는 괄호는 스택에 push
            } else if (ch == ')') {
                if (stack.isEmpty()) { // 스택이 비어있는데 닫는 괄호가 나오면 NO
                    return false;
                }
                stack.pop(); // 여는 괄호를 꺼냄
            }
        }

        return stack.isEmpty(); // 모든 검사가 끝난 후 스택이 비어있으면 YES
    }
}
