package String;

import java.util.*;

public class Ch02 {
    public static void main(String[] args) {
        String str = "aabbbccccd";
        Map<Character,Integer> freq = new HashMap<>();

        //현재 문자부터 배열 끝까지 순회하며 빈도수 계산을 진행
        for(char ch : str.toCharArray()){
            freq.put(ch, freq.getOrDefault(ch,0)+1);
        }

        //최댓값 찾기
        char maxChar =' ';
        int maxFreq= 0;
        for(Map.Entry<Character,Integer> entry : freq.entrySet()){
            if(entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
                maxChar = entry.getKey();
            }
        }
        System.out.println("Most frequent character: " + maxChar);
        System.out.println("frequency: " + maxFreq);

    }
}
