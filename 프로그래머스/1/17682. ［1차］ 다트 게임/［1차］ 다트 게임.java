import java.util.*;
import java.util.regex.*;


class Solution {
    public int solution(String dartResult) {
        int[] scores = new int[3]; // 각 다트 점수 저장 배열
        int index = 0; // 현재 다트의 순서

        String regex = "(10|[0-9])([SDT])([*#]?)";
        // 보너스는 S, D, T 중 하나 → [SDT]
        // 옵션은 *, # 중 하나이거나 없을 수 있음 → [*#]?

        // 정규식을 이용한 파싱
        Matcher matcher = Pattern.compile(regex).matcher(dartResult);

        while (matcher.find()) {
            int score = Integer.parseInt(matcher.group(1)); // 점수 추출
            String bonus = matcher.group(2); // 보너스 추출
            String option = matcher.group(3); // 옵션 추출

            // 보너스 처리
            switch (bonus) {
                case "S":
                    score = (int) Math.pow(score, 1);
                    break;
                case "D":
                    score = (int) Math.pow(score, 2);
                    break;
                case "T":
                    score = (int) Math.pow(score, 3);
                    break;
            }

            // 옵션 처리
            if (option.equals("*")) {
                // 현재 점수 2배 처리
                score *= 2;
                // 이전 점수도 존재하면 2배 처리
                if (index > 0) {
                    scores[index - 1] *= 2;
                }
            } else if (option.equals("#")) {
                // 현재 점수 마이너스 처리
                score *= -1;
            }

            // 점수를 저장하고 인덱스 증가
            scores[index++] = score;
        }

        // 점수 합산
        int answer = scores[0] + scores[1] + scores[2];

        return answer;
    }
}