import java.util.*;

class Solution {
    public int solution(String[][] board, int h, int w) {
        //한 칸을 골랐을때, 위 아래 왼쪽 오른쪽 같은 색깔로 칠해진 칸의 개수를 구해라
        //각 칸에 칠해진 색깔 이름이 담긴 이차원 문자 리스트 board
        //고른 칸에 위치를 나타내는 두 정수 h w board[h][w] 이웃한 칸
        //중에 같은 색으로 칠해져 있는 칸의 개수를 return해라.
        int n = board.length; //보드의 세로 길이
        int m = board[0].length; // 보드의 가로 길ㅇ이
        int sameColor = 0; //같은 색으로 색칠된 칸의 개수를 저장할 변수
        
        //h와 w의 변화량을 저장한 정수리스트 dh dw [0 -1 -1 0] [1 0 0 -1]
        int[] dh = new int[]{0,1,-1,0}; //높이 변화량(위아래)
        int[] dw = new int[]{1,0,0,-1}; // 넓이 변화량(왼 오)
        
        String targetColor = board[h][w]; //j w 타겟 컬러
        
        for(int i=0; i<4; i++){
            int nh = h + dh[i];
            int nw = w + dw[i];
            if(nh >=0 && nh <n && nw >=0 && nw <m){// 영역을 벗어나는지 확인
                if(board[nh][nw].equals(targetColor)){ //목표 칸수와 위아래 양옆 색깔이 같다면
                    sameColor++; //sameColor 카운트 늘림
                }
            }
        }
        return sameColor;  
    }
}