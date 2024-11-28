package Array;

import java.util.*;

public class Ch04_arraymethod {
    public static void main(String[] args) {
        // ArrayList 생성
        ArrayList<String> arrList = new ArrayList<>();

        // 요소 추가
        arrList.add("apple");
        arrList.add("banana");
        arrList.add("cherry");

        // 특정 위치에 삽입
        arrList.add(1, "grape"); // 인덱스 1에 "grape" 추가

        System.out.println(arrList);

        // 요소 접근
        System.out.println("Index 2: " + arrList.get(2)); // cherry

        // 정렬
        Collections.sort(arrList); // 오름차순 정렬
        System.out.println("Sorted List: " + arrList); // [apple, banana, cherry, grape]

        // 특정 요소 포함 여부 확인
        System.out.println("Contains 'banana'? " + arrList.contains("banana")); // true

        // 요소 삭제
        arrList.remove(2); // 인덱스 2의 요소 삭제
        System.out.println("After removal: " + arrList); // [apple, banana, grape]

        // 리스트 크기
        System.out.println("Size: " + arrList.size()); // 3

        // 리스트 초기화
        arrList.clear();
        System.out.println("Is empty? " + arrList.isEmpty()); // true
    }
}
