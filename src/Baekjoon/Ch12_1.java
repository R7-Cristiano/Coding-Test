package Baekjoon;

import java.io.*;
public class Ch12_1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int rows = 5; //행
        int maxCols= 15; //최대 15개의 문자
        char[][] words = new char[rows][maxCols];//행이 5행이고 열이 최대 15열인 2차원 문자 배열 생성

        for(int i=0; i<rows; i++){
            String line = br.readLine();
            for(int j=0; j<line.length(); j++){
                words[i][j] = line.charAt(j);
            }
        }

        //세로로 읽기 결과 저장
        StringBuilder result = new StringBuilder();
        for(int col=0; col<maxCols; col++){
            for(int row=0; row<rows; row++){
                if(words[row][col] != '\0'){
                    result.append(words[row][col]);
                }
            }
        }
        System.out.println(result.toString());
    }
}
