package Baekjoon;
//쿼터(Quarter, $0.25)의 개수, 다임(Dime, $0.10)의 개수, 니켈(Nickel, $0.05)의 개수, 페니(Penny, $0.01)의 개수를 구하는 프로그램
import java.io.*;
public class Ch13 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();//문자열을 반복적으로 추가하거나 수정해야할때!

        for(int i =0; i<testcase; i++){ //0부터 num 전까지
            int num = Integer.parseInt(br.readLine()); //거스름돈의 액수 입력 받음 ex) 124달
            int quarter = num / 25; //쿼터의 개수 계산
            num = num % 25;//

            int dime = num /10;
            num = num %10;

            int nickel = num/5;
            num = num % 5;

            int penny = num; // 남은 페니의 동전 개수

            // 결과를 한 줄로 저장 (쿼터, 다임, 니켈, 페니 순서)
            sb.append(quarter).append(" ").append(dime).append(" ").append(nickel).append(" ").append(penny).append("\n");
        }
        System.out.println(sb.toString()); // 모든 테스트 케이스 결과 출력
    }
}
