package Baekjoon;


//첫째 줄에는 평균을 출력하고, 둘째 줄에는 중앙값을 출력
import java.io.*;
import java.util.Arrays;

public class Ch21 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int leng = 5;
        int numbers[] = new int[leng];
        int sum = 0;
        int result =0;
        for(int i =0; i<leng; i++){ //1 ,2 ,3, 4
            numbers[i] = Integer.parseInt(br.readLine());
            sum += numbers[i];
        }

        result = sum / leng;
        // 배열 정렬
        Arrays.sort(numbers);

        // 중앙값 계산
        int middle = numbers[leng / 2]; // 정렬된 배열에서 중간 위치 값

        System.out.println(result);
        System.out.println(middle);
    }
}
