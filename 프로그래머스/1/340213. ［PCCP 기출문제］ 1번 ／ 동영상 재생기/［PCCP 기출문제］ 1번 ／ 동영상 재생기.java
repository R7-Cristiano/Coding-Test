import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        // 문자열 시간을 초(second)로 변환
        int videoLength = toSeconds(video_len);
        int position = toSeconds(pos);
        int opStart = toSeconds(op_start);
        int opEnd = toSeconds(op_end);

        // 오프닝 구간 체크 (초기 위치가 오프닝 범위 안에 있는 경우)
        if (opStart <= position && position <= opEnd) {
            position = opEnd;
        }

        // 명령어 처리
        for (String command : commands) {
            if (command.equals("prev")) {
                position = Math.max(0, position - 10); // 10초 전 이동 (0초 이하 방지)
            } else if (command.equals("next")) {
                position = Math.min(videoLength, position + 10); // 10초 후 이동 (비디오 길이 초과 방지)
            }

            // 이동 후 오프닝 구간 체크
            if (opStart <= position && position <= opEnd) {
                position = opEnd;
            }
        }

        // 최종 위치를 "mm:ss" 형식으로 변환 후 반환
        return toTimeFormat(position);
    }

    // "mm:ss" → 초(second) 변환
    private int toSeconds(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    // 초(second) → "mm:ss" 변환
    private String toTimeFormat(int seconds) {
        int minutes = seconds / 60;
        int sec = seconds % 60;
        return String.format("%02d:%02d", minutes, sec);
    }
}
