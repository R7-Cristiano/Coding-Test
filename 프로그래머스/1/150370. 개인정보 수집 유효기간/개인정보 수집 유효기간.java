import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        // 개인 정보 n개
        // 각 약관마다 유효기간 존재, 지나면 파기
        // A 유효기간 12달 2021년 1월5일 수집된 개인정보 2022년 1월4일까지 보관 가능, 이후 파기
        // 오늘 날짜로 파기해야할 개인정보 번호를 구하라
        // 오늘 날짜 today
        // 약관의 유효기간을 담은 1차원 배열 terms 약관종류 유효기간 split(" ");
        // privacies[i] 는 i+1번 개인정보의 수집일자와 약관 종류 날짜와 약관종류 공백 split(" ");
        // 수집된 개인정보의 정보
        // 파기해야할 개인정보의 번호를 오름차순으로 정수배열에 담아 리턴
        //모든 달은 28일까지 있다고 가정
        String[] todayArr = today.split("\\.");
        int year = Integer.parseInt(today.split(".")[0]); //오늘 년도
        int month = Integer.parseInt(today.split(".")[1]); //오늘 달수 3월
        int date = Integer.parseInt(today.split(".")[2]); //오늘 일수 1일까지
        List<Integer> result = new ArrayList<>();

        for(int i =0; i< terms.length; i++){
            String term = terms[i].split(" ")[0]; // 약관 종류 A B C
            int validMonth = Integer.parseInt(terms[i].split(" ")[1]); //해야될 달 1 2 3달
            //만료 날짜를 구하는 로직이 있어야함
            for(int j =0; j< privacies.length; j++){
                String[] privacy = privacies[j].split(" ");
                String waha = privacy[0];
                String type = privacy[1];

                if(term.equals(type)){
                    String expiryDate=CalcDate(waha, validMonth); // 2월 29일
                    if (isExpired(expiryDate, year, month, date)) {
                        result.add(i + 1);
                    }
                }
            }
        }
        // 결과 오름차순 정렬 및 배열 변환
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    //만료날짜 구하는 로직
    private String CalcDate(String validDate, int validMonth){ //유효기간 1달 부터 100달 -> 100 (8년) 96달
        String[] dateArr = validDate.split("\\.");
        int year = Integer.parseInt(dateArr[0]);
        int month = Integer.parseInt(dateArr[1]);
        int day = Integer.parseInt(dateArr[2]);
        //13달
        if(validMonth+month > 12) { //유효기간 + 약관달수가 12가 넘어가면
            year += (validMonth + month / 12);
            month += (validMonth + month % 12);
            day = day - 1;
        }else if(validMonth + month <= 12){ //유효기간 + 약관 달수가 12가 안넘는다
            month = month + validMonth;
            day = day -1;
        }
        return String.format("%04d.%02d.%02d", year, month, day);
    }
    // ✅ 만료일과 오늘 날짜 비교 함수
    private boolean isExpired(String expiryDate, int todayYear, int todayMonth, int todayDay) {
        String[] expiryArr = expiryDate.split("\\.");
        int expiryYear = Integer.parseInt(expiryArr[0]);
        int expiryMonth = Integer.parseInt(expiryArr[1]);
        int expiryDay = Integer.parseInt(expiryArr[2]);

        // 만료일이 오늘 날짜보다 이전이면 true
        if (expiryYear < todayYear) return true;
        if (expiryYear == todayYear && expiryMonth < todayMonth) return true;
        if (expiryYear == todayYear && expiryMonth == todayMonth && expiryDay < todayDay) return true;

        return false;
    }
}