package Baekjoon;

import java.io.*;
//주어진 n개의 소수중에서 소수가 몇개인지 출력하는 코드
//1과 자기 자신 만을 약수로 가지는 수-> 소수
public class Ch19 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String[] waha = br.readLine().split(" ");//주어진 수
        int count =0;

        for(int i=0; i< num; i++){
            int ab = Integer.parseInt(waha[i]); //주어진 수 정수로 변환
            if(isPrime(ab)){
                count = count + 1;
            }
        }
        System.out.println(count);
    }
    public static boolean isPrime(int num) {
        if (num < 2) {
            return false; // 0과 1은 소수가 아님
        }
        for (int i = 2; i <= Math.sqrt(num); i++) { // 2부터 √num까지 확인
            if (num % i == 0) {
                return false; // 나누어 떨어지면 소수가 아님
            }
        }
        return true; // 위 조건을 모두 통과하면 소수
    }
}
