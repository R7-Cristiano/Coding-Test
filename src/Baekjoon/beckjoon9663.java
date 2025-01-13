package Baekjoon;

import java.io.*;

//N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제
//N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램
public class beckjoon9663 {
    static int[] queen; //각 행에 놓은 퀸의 위치 저장
    static int N; //체스판 크기
    static int count = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); //퀸 N개
        queen = new int[N];

        solve(0); //0행부터 탐색 시작
        System.out.println(count); //해결 방법 갯수 출력
    }
    //row번째 행에 퀸 배치 시도
    public static void solve(int row){
        if(row ==N){ //모든 퀸을 배치한 경우
            count++; //해결 방법 증가
            return;
        }

        for(int col =0; col< N; col++){
            if(isSafe(row,col)){ //현재 위치에 퀸 배치가 가능한지 확안
                queen[row] = col;//퀸 배치
                solve(row+1); //다음 행으로 이동
                //백트래킹: 이전으로 돌아와 다른 경우 탐색
            }
        }
    }
    public static boolean isSafe(int row, int col){
        for(int i=0; i<row; i++){
            //현재 퀸을 놓으려는 위치 (row, col)가 이미 배치된 퀸들과 충돌하는지 확인하는 부분
            //같은 열 || 같은 대각선 확인
            if (queen[i] == col || Math.abs(queen[i] - col) == Math.abs(i - row)) { // Math.abs 숫자의 절댓값을 계산하는 메서드
                return false;
            }
        }
        return true;
    }
}
