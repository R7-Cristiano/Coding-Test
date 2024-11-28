package Array;

import java.util.ArrayList;

public class Ch02 {
    public static void main(String[] args) {
                int n = 5; // 정점 개수
                ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

                // 정점별 리스트 초기화
                for (int i = 0; i <= n; i++) {
                    graph.add(new ArrayList<>());
                }

                // 간선 추가 (무방향 그래프)
                graph.get(1).add(2);
                graph.get(2).add(1);
                graph.get(2).add(3);
                graph.get(3).add(2);

                System.out.println(graph);

    }
}
