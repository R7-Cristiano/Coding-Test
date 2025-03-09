import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        // 오늘 날짜 파싱
        String[] todayArr = today.split("\\.");
        int year = Integer.parseInt(todayArr[0]);
        int month = Integer.parseInt(todayArr[1]);
        int date = Integer.parseInt(todayArr[2]);

        // 약관 종류와 유효기간 저장 (Map 사용)
        Map<String, Integer> termMap = new HashMap<>();
        for (int i = 0; i < terms.length; i++) {
            String[] t = terms[i].split(" ");
            termMap.put(t[0], Integer.parseInt(t[1]));
        }

        List<Integer> result = new ArrayList<>();

        // 개인정보 확인 로직
        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            String collectedDate = privacy[0];
            String type = privacy[1];

            // 약관 조회 → Map에서 직접 가져오기
            int validMonth = termMap.get(type);

            // 만료 날짜 계산
            String expiryDate = calcDate(collectedDate, validMonth);

            // 만료 날짜가 오늘보다 이전이면 파기 대상
            if (isExpired(expiryDate, year, month, date)) {
                result.add(i + 1); // 인덱스는 1부터 시작하므로 i + 1
            }
        }

        // 결과 오름차순 정렬 및 배열 변환
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    // ✅ 만료일 계산 함수 수정 완료
    private String calcDate(String validDate, int validMonth) {
        String[] dateArr = validDate.split("\\.");
        int year = Integer.parseInt(dateArr[0]);
        int month = Integer.parseInt(dateArr[1]);
        int day = Integer.parseInt(dateArr[2]);

        // 유효기간 추가
        month += validMonth;

        // 12월 초과 시 연도 처리
        if (month > 12) {
            year += (month - 1) / 12;
            month = (month - 1) % 12 + 1;
        }

        // 만료일 하루 전 설정
        day -= 1;
        if (day == 0) {
            month -= 1;
            if (month == 0) {
                month = 12;
                year -= 1;
            }
            day = 28; // 모든 달은 28일까지 있다고 가정
        }

        // YYYY.MM.DD 형식으로 리턴
        return String.format("%04d.%02d.%02d", year, month, day);
    }

    // ✅ 만료일과 오늘 날짜 비교 함수 수정 완료
    private boolean isExpired(String expiryDate, int todayYear, int todayMonth, int todayDay) {
        String[] expiryArr = expiryDate.split("\\.");
        int expiryYear = Integer.parseInt(expiryArr[0]);
        int expiryMonth = Integer.parseInt(expiryArr[1]);
        int expiryDay = Integer.parseInt(expiryArr[2]);

        // 만료일이 오늘보다 이전이면 true 반환
        if (expiryYear < todayYear) return true;
        if (expiryYear == todayYear && expiryMonth < todayMonth) return true;
        if (expiryYear == todayYear && expiryMonth == todayMonth && expiryDay < todayDay) return true;

        return false;
    }
}
