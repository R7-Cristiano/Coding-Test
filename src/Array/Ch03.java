package Array;

import java.util.ArrayList;
import java.util.Collections;

public class Ch03 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(2);

        Collections.sort(list); // 오름차순 정렬
        System.out.println(list); // 출력: [1, 2, 3]

        Collections.sort(list, Collections.reverseOrder()); // 내림차순 정렬
        System.out.println(list); // 출력: [3, 2, 1]
    }
}
