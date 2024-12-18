package Baekjoon;
//N개의 문자열로 이루어진 집합 S
//입력으로 주어지는 M개의 문자열 중에서 집합 S에 포함되어있는 것이 총 몇개인지 구하시오
//M개의 문자열에 총 개의 집합 S에 포함되어있는지
import java.io.*;
import java.util.*;
public class Ch29 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] num = br.readLine().split(" ");
        int N = Integer.parseInt(num[0]); //N개의 문자열로 이루어진 집합 5
        int M  = Integer.parseInt(num[1]); // 입력으로 주어지는 문자열 11

        String[] word = new String[N];
        String[] words = new String[M]; //0부터 10까지 니깐 11개

        HashSet<String> S_set = new HashSet<>();

        for(int i=0; i<N; i++){
            word[i] = br.readLine(); //N개의 문자열로 이루어진 집합S
            S_set.add(word[i]); // 해시맵 S_set에 요소 추가
        }
        int count =0;

        for(int i =0; i< M; i++){ //0부터 M까지
            words[i] = br.readLine(); //집합 S에 들어가있는 단어 입력
            if(S_set.contains(words[i])){
                count = count+1;
            }
        }
        System.out.println(count);
    }
}