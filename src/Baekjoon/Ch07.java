package Baekjoon;

import java.io.*;

public class Ch07 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        String oven = br.readLine();
        int hour = Integer.parseInt(input[0]); //시간
        int minute = Integer.parseInt(input[1]); //분
        int ovenMinute = Integer.parseInt(oven); //오븐시계
        int totalMinute = minute + ovenMinute; //분 + 오븐시계 더한 시간  30+40 -> 10    70-60 =10  60 + 300 = 350 - (60*5)300 = 50분
        //600/60 =10 시간 1000분

        if(totalMinute > 59){ // 만약 분 + 오븐시간이 59보다 크면 시간이 올라가야함
            int i = totalMinute / 60;
            totalMinute = totalMinute-(60*i); // 분수
            if(hour+i <24) { // 시간이
                hour = hour + i;
            }else{
                hour = (hour+i) - 24;
            }
        }
        System.out.println(hour + " " + totalMinute); // 시와 분을 공백으로 구분하여 출력
    }
}
