package Baekjoon;

//단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램을 작성하시오.

import java.io.*;
import java.util.HashSet;
public class Ch09 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int groupWordCount = 0;

        int num = Integer.parseInt(br.readLine()); // 단어의 개수 N

        for(int i=0; i<num; i++){ //N개의 줄에 단어가 들어옴 (N=3이면 3개의 단어)
            String str = br.readLine();
            if(isGroupWord(str)){ // 그룹단어이면
                groupWordCount++; //그룹단어 카운트 증가
            }
        }
        System.out.println(groupWordCount);
    }
    public static boolean isGroupWord(String str){ // boolean 타입 함수
        HashSet<Character> seen = new HashSet<>(); // 이미 등장한 문자 저장
        char prevChar = '\0'; // 이전 문자 저장

        for (int j = 0; j < str.length(); j++) { // j는 0부터 단어 끝까지 순회
            char currentChar = str.charAt(j); // 현재의 문자가 단어의 j 인덱스
            // 문자가 연속적이지 않고 이전에 등장한 적이 있으면 그룹 단어가 아님
            if (currentChar != prevChar && seen.contains(currentChar)) { //현재 단어가 이전단어와 같지 않고 이전에 등장한적이 있을때
                return false; //그룹함수가 아님
            }
            // 문자 기록
            seen.add(currentChar); //현재의 문자에 추가
            prevChar = currentChar;
        }
        return true;
    }
}
