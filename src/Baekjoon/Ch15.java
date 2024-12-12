package Baekjoon;

import java.io.*;

public class Ch15 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 입력받기

        int diagonal = 0; // 대각선 번호
        int count = 0;    // 누적 분수 개수

        // 대각선 번호 찾기
        while (count < n) { // 누적 분수 개수가 < 입력받은 숫자보다 작을동안
            diagonal++;           // 대각선 번호 증가
            count += diagonal;    // 대각선에 있는 분수 개수를 누적
        }

        // 대각선 내에서의 위치 계산
        int positionInDiagonal = n - (count - diagonal);

        // 분자와 분모 계산
        int numerator, denominator;
        if (diagonal % 2 == 0) { // 짝수 대각선: 위에서 아래로
            numerator = positionInDiagonal; // 분자가 커짐
            denominator = diagonal - positionInDiagonal + 1; // 분모가 작아짐
        } else { // 홀수 대각선: 아래에서 위로
            numerator = diagonal - positionInDiagonal + 1; // 분자가 작아짐
            denominator = positionInDiagonal; // 분모가 커짐
        }

        // 결과 출력
        System.out.println(numerator + "/" + denominator);
    }
}
