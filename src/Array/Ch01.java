package Array;


import java.util.ArrayList;

public class Ch01 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);

        // 전통적인 for문
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        // 향상된 for문
        for (int num : list) {
            System.out.println(num);
        }
    }
}
