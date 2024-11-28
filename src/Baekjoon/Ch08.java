package Baekjoon;
//알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 단, 대문자와 소문자를 구분하지 않는다.
import java.io.*;
public class Ch08 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toUpperCase(); // 문자열을 모두 대문자로 변환 -> 대소문자를 구분하지 않도록 하기 위한 처리
        int[] count = new int[26]; // 알파벳 빈도를 저장하기 위한 배열
        // 같은 문자열일 경우 count +1 더함
        // 각 문자의 빈도 계산
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'A' && c <= 'Z') { // 알파벳만 처리
                count[c - 'A']++;
            }
        }
        // 최대 빈도와 해당 문자 찾기
        int max = -1; // 최대 빈도
        char mostChar = '?'; // 가장 많이 사용된 문자
        for (int i = 0; i < 26; i++) {
            if (count[i] > max) {
                max = count[i];
                mostChar = (char) (i + 'A'); // 인덱스를 문자로 변환
            } else if (count[i] == max) {
                mostChar = '?'; // 동일한 최대 빈도 발생
            }
        }
        System.out.println(mostChar);
    }
}
