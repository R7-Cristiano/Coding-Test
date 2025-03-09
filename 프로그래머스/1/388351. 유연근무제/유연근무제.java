class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;

        for (int i = 0; i < schedules.length; i++) {
            int[] timelog = timelogs[i];
            int schedule = getSchedule(schedules[i]);
            int day = startday;
            int successCount = 0;

            for (int t : timelog) {
                // 요일 변환: 0 -> 일요일, 6 -> 토요일
                int currentDay = day % 7;
                if (currentDay == 0) currentDay = 7;

                // 주말 제외
                if (currentDay == 6 || currentDay == 7) {
                    day++;
                    continue;
                }

                // 출근 기록이 없거나 지각한 경우 실패 처리
                if (t == -1 || t > schedule) {
                    break;
                }

                successCount++;
                day++;

                // 평일 5일 연속 성공 시 성공 처리
                if (successCount == 5) {
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }

    private int getSchedule(int schedule) {
        schedule += 10;

        if (schedule % 100 >= 60) {
            int h = (schedule / 100) + 1;
            int m = (schedule % 100) - 60;
            schedule = (h * 100) + m;
        }
        return schedule;
    }
}
