package String;

import java.util.regex.*;

public class Ch01 {
    public static void main(String[] args) {
        String str = "a1b2c3";
        int sum = 0;

        // 정규식을 사용해 숫자 추출
        Matcher matcher = Pattern.compile("\\d").matcher(str);
        while (matcher.find()) {
            sum += Integer.parseInt(matcher.group());
        }

        System.out.println("Sum of numbers: " + sum); // 결과: 6
    }
}
