package BackTracking;

public class BacktrackingExample {
    static int[][] board = {
            {2, 4, 3},
            {1, 3, 7},
            {6, 5, 6}
    };
    static boolean[] visited; // 열 선택 여부를 나타내는 배열
    static int N = 3; // 행렬 크기 (3×3)
    static int[] result; // 현재 경로에서 선택된 숫자를 저장

    public static void main(String[] args) {
        visited = new boolean[N]; // 열 방문 여부 초기화
        result = new int[N]; // 선택된 숫자를 저장할 배열

        backtrack(0); // 백트래킹 시작 (첫 번째 행부터)
    }

    static void backtrack(int row) {
        // 기저 조건: 모든 행에서 숫자를 선택한 경우
        if (row == N) {
            printResult(); // 현재 경로 출력
            return;
        }

        // 현재 행(row)의 가능한 열 탐색
        for (int col = 0; col < N; col++) {
            if (!visited[col]) { // 해당 열이 선택되지 않았다면
                visited[col] = true; // 열 선택
                result[row] = board[row][col]; // 숫자 선택
                backtrack(row + 1); // 다음 행으로 이동
                visited[col] = false; // 열 선택 해제 (백트래킹)
            }
        }
    }

    static void printResult() {
        // 현재 선택된 숫자 출력
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
