package Baekjoon;
import java.io.*;
import java.util.*;

//균형잡힌 세상
//입력의 종료조건으로 맨 마지막에 온점 하나(".")가 들어온다.
public class Ch33 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String input = br.readLine();
            // 종료 조건
            if (input.equals(".")) {
                System.out.println("yes");
                break;
            }
            // 균형 잡힌 문자열인지 확인
            if (isParenthesis(input)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
    //균형 잡힌 문자열을 판별하기 위한 isParenthesis 함수 () []
    public static boolean isParenthesis(String str){
        Stack<Character> stack = new Stack<>();
        for(int i =0; i<str.length(); i++){
            char ch = str.charAt(i);
            // ( 와 [ 가 혼용으로 쓰일때
            if(ch=='(' || ch == '['){
                stack.push(ch);
            }
            // 닫는 괄호 처리
            else if (ch == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return false; // 스택이 비어있거나 짝이 맞지 않음
                }
                stack.pop(); // 짝이 맞으면 pop
            }
            else if (ch == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    return false; // 스택이 비어있거나 짝이 맞지 않음
                }
                stack.pop(); // 짝이 맞으면 pop
            }
        }
        return stack.isEmpty();
    }
}
