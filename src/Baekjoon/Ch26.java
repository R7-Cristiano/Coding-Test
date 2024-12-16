package Baekjoon;

import java.io.*;
import java.util.*;

public class Ch26 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //단어들을 저장할 리스트 생성
        List<String> arr = new ArrayList<>();

        for(int i=0; i<N; i++){ //0부터 N-1까지 반복
            String str = br.readLine();
            arr.add(new String(str));
        }

        // 정렬: 길이가 짧은 것부터, 길이가 같으면 사전순
        arr.sort((a, b) -> { //Java의 sort 메서드는 비교 결과에 따라 리스트의 요소를 자동으로 정렬
            if (a.length() == b.length()) { //길이 같으면
                return a.compareTo(b); // compareTo를 사용해 단어순 정렬
            } else { //길이 같지 않으면
                return a.length() - b.length(); // 길이 순 정렬
            }
        });

        // 중복 제거 및 출력
        StringBuilder sb = new StringBuilder();
        String previous = ""; // 이전 단어 저장할 변수
        for (int i = 0; i < arr.size(); i++) {
            String word = arr.get(i); // 현재 단어 가져오기
            if (!word.equals(previous)) { // 이전 단어와 다를경우
                sb.append(word).append("\n"); // 결과 문자열에 추가
                previous = word; // 이전 단어를 현재 단어로 업데이트
            }
        }
        System.out.print(sb);
    }
}
