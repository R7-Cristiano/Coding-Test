package InputOutput;

import java.io.*;

public class Ch01 { // 클래스 이름을 대문자로 시작
    public static void main(String[] args) throws IOException {
        // 입력 코드
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" "); // 한 줄 입력받아 공백 기준으로 분리
        int n = Integer.parseInt(input[0]); // 첫 번째 숫자를 정수로 변환
        int m = Integer.parseInt(input[1]); // 두 번째 숫자를 정수로 변환

        int[][] graph = new int[n][m]; // 2차원 배열 초기화

        for (int i = 0; i < n; i++) { // 행 반복
            String[] input2 = br.readLine().split(" "); // 한 줄 읽고 공백 기준으로 나눔
            for (int j = 0; j < m; j++) { // 열 반복
                graph[i][j] = Integer.parseInt(input2[j]); // 정수로 변환 후 배열에 저장
            }
        }

        // 배열 출력 코드 (추가)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}
