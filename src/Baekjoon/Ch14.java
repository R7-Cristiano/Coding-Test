package Baekjoon;
//벌집-> 13까지는 3개의 방을 거침 58까지는 5개의 방을 거침
// 6각형으로 생김 이웃하는 방을 돌아가면서 1씩 증가하는 번호를 주소로 매김. 1개   2번째 줄 6개방 생성 3번째 줄 3번째 줄 12개방 생성
import java.io.*;
import java.nio.Buffer;

//13이면 3개의 방  58이면 5개의 방 -> 그말은 즉슨 1 6(1*6) 12(2*6) 18(3*6,37) 24(4*6,61)

public class Ch14 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine()); //13
        int count = 1; // 시작 방(1번)은 1계층
        int range = 1; // 현재 범위의 마지막 방 번호

        while (range < num) {
            range += count * 6; // 다음 계층의 범위 끝 방 번호
            count++; // 계층 수 증가
        }
        System.out.println(count);
    }
}
