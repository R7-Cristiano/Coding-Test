package Baekjoon;

import java.io.*;
import java.util.*;

// 좌표를 x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.
public class Ch25 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //평면위 점 N의 개수 입력

        //점들을 저장할 리스트 생성
        List<int[]> points = new ArrayList<>();


        for(int i=0; i<N; i++){ //0,1,2,3,4
            String[] arr = br.readLine().split(" ");
            int x = Integer.parseInt(arr[0]);
            int y = Integer.parseInt(arr[1]);
            points.add(new int[]{x, y});
        }

        // 정렬: x좌표를 기준으로 오름차순, x좌표가 같으면 y좌표 기준 오름차순
        points.sort((a, b) -> {
            if (a[0] == b[0]) { //x좌표가 같으면
                return Integer.compare(a[1], b[1]); // y좌표 비교
            } else { //x좌표가 다르면
                return Integer.compare(a[0], b[0]); // x좌표 비교
            }
        });

        // 일반 for문으로 출력
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < points.size(); i++) {
            int[] point = points.get(i); // i번째 점 가져오기
            sb.append(point[0]).append(" ").append(point[1]).append("\n");
        }

        System.out.print(sb);

    }
}
