package Baekjoon;

import java.io.*;

public class Ch12 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int rows =5; //입력 받을 단어의 개수
        int maxCols = 15; // 최대 열 개수
        char[][] array = new char[rows][maxCols]; //5개의 행 최대 15개

        //2차원 배열 초기화 및 입력
        for(int i=0; i<rows; i++){
            String line = br.readLine();
            for(int j=0; j<line.length(); j++){ //엻의 개수는 행의 단어의 길이개수 까지!
                array[i][j]= line.charAt(j);
            }
        }
        //세로로 읽기 결과 저장
        StringBuilder result = new StringBuilder();
        for(int col=0; col<maxCols; col++){
            for(int row=0; row< rows; row++){
                // 배열 값이 초기값('\0')이 아닌 경우에만 추가
                if(array[row][col]!='\0'){
                    result.append(array[row][col]);
                }
            }
        }

        System.out.println(result.toString());
    }
}
