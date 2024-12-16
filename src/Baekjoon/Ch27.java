package Baekjoon;

import java.io.*;
import java.util.*;
public class Ch27 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());//입력받을 수


        List<String[]> arr = new ArrayList<>();
        for(int i=0; i<N; i++){
            String[] str = br.readLine().split(" ");
            String age = str[0]; // 0번째 인덱스 나이
            String name = str[1]; //1번째 인덱스 이름
            arr.add(new String[]{age,name});
        }

        //나이가 증가하는 (오름차순), 나이가 같으면 먼저 가입한순
        arr.sort((a,b)->{
            if(a[0] != b[0]){ // 나이가 같지않으면 -> 나이순으로 정렬(오름차순)
                return Integer.compare(Integer.parseInt(a[0]), Integer.parseInt(b[0]));
            }else{ // 나이가 같으면 -> 먼저 가입한순
                return 0;
            }

        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.size(); i++) {
            String[] word = arr.get(i);
            sb.append(word[0]).append(" ").append(word[1]).append("\n");
        }
        System.out.println(sb);

    }
}
