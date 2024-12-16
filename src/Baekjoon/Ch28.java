package Baekjoon;

import java.io.*;
import java.util.*;
//집합과 맵
public class Ch28 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //상근이의 카드 갯수 입력받음
        String[] N_card = br.readLine().split(" "); // 상근이가 가지고 있는 N개의 카드 입력받음 //5개의 카드

        // 카드 확인을 위한 HashSet 생성
        HashSet<Integer> cards = new HashSet<>();
        for(int i=0; i<N_card.length; i++){
             cards.add(Integer.parseInt(N_card[i])); //HashSet cards에 N 카드 입력.
        }
        //확인할 카드 입력
        int M = Integer.parseInt(br.readLine()); //카드 갯수 M
        String[] M_card = br.readLine().split(" "); //M개의 숫자 카드 입력 //8개의 카드

        StringBuilder sb = new StringBuilder();
        // M카드 안에 상근이의 N카드 수가 존재하면 1아니면 0 출력
        // M카드 안에 상근이의 카드가 있는지 확인
        for(int i =0; i<M_card.length; i++){
            if(cards.contains(Integer.parseInt(M_card[i]))){ //카드가 HashSet에 있으면
                sb.append(1).append(" ");
            } else{
                sb.append(0).append(" ");
            }
        }

        System.out.println(sb);

    }
}
