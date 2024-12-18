package Baekjoon;
// 첫째줄에 상근이가 가지고 있는 카드의 수 두번째 줄에 상근이 가지고 있는 카드
// 3번쨰 줄에 M 주어지고.M개의 카드중에 이 수가 적혀있는 숫자 카드를 상근이가 몇 개 가지고 있는지 구하시오.
import java.io.*;
import java.util.*;
public class Ch30 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] N_Cards = br.readLine().split(" ");
        HashSet<Integer> cards = new HashSet<>();
        for(int i=0; i<N_Cards.length; i++){
            cards.add(Integer.parseInt(N_Cards[i]));
        }
        int M = Integer.parseInt(br.readLine());
        String[] M_Cards = br.readLine().split(" ");
        int count =0;

        StringBuilder sb = new StringBuilder();
        for(int i =0; i<M_Cards.length; i++){
            int prev = 0;
            if(cards.contains(Integer.parseInt(M_Cards[i]))){ // M_card[i]번째 값이 card 해시셋에 포함되어 있으면
                int num = Integer.parseInt(M_Cards[i]);
                if(num == Integer.parseInt(M_Cards[prev])){
                    count = count +1;
                    sb.append(count).append(" ");
                }else{
                    sb.append(1).append(" ");
                }
            }else{
                sb.append(0).append(" ");
            }
        }
        System.out.println(sb);
    }
}
