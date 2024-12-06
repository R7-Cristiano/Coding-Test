package Baekjoon;

import java.io.*;
import java.util.*;
public class Ch11 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 배열 크기 입력
        String[] size = br.readLine().split(" "); // 첫 줄: 행과 열의 크기
        int rows = Integer.parseInt(size[0]); // 가로 (행의 개수)
        int cols = Integer.parseInt(size[1]); // 세로 (열의 개수)

        // 첫 번째 2차원 배열 입력받기
        int[][] array1 = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            String[] row1 = br.readLine().split(" ");
            for (int j = 0; j < cols; j++) {
                array1[i][j] = Integer.parseInt(row1[j]); // 각 값을 저장
            }
        }

        int[][] array2 = new int[rows][cols];
        for(int i =0; i< rows; i++){
            String[] row2 = br.readLine().split(" ");
            for(int j=0; j<cols; j++){
                array2[i][j] = Integer.parseInt(row2[j]);
            }
        }

        // 결과 배열 생성 (두 배열의 합)
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = array1[i][j] + array2[i][j]; // 두 배열의 값을 더함
            }
        }

        // 결과 출력
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println(); // 줄바꿈
        }
    }
}
