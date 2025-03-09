import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        //불량 이용자 신고-> 처리 -> 메일 발송 
        //각유저는 한번에 한명의 유저 신고 가능
        //신고 횟수 제한은 없음 . 동일한 유저에 대한 신고횟수는 1회
        //k번 이상 신고된 유저는 게시판 이용 정지 -> 신고한 모든 유저에게 정지 사실 메일로 발송
        //이용자 id가 담긴 문자 배열을 id_list 
        //각 이용자가 신고한 -> 이용자의 id 정보가 담긴 문자열 배열 report
        // 정지 기준이 되는 k가 매개변수로 주어질때
        // 각 유져별로 처리 결과 받은 횟수를 배열에 담는다
        int n = id_list.length;
        Map<String,HashSet<String>> reportMap = new HashMap<>(); //신고 기록 저장
        Map<String,Integer> reportCount = new HashMap<>(); //신고 당한 횟수 저장
        
        for(int i =0; i< report.length; i++){
            String rep = report[i];
            String[] split = rep.split(" ");
            String reporter = split[0]; //신고자
            String reported = split[1]; //신고당한 사람
            
            reportMap.putIfAbsent(reported,new HashSet<>());//신고 기록이 없으면 새로 생성
            //신고당한 유저에 대해 이미 신고자가 신고를 했는지 존재하지않으면 true 아니면 false
            if(!reportMap.get(reported).contains(reporter)){
                reportMap.get(reported).add(reporter);
                //신고당한 유저의 신고 횟수 증가
                //신고당한 횟수가 없으면 0으로 반환 있으면 +1
                reportCount.put(reported, reportCount.getOrDefault(reported,0)+1);
                
            }
        }
        //신고 결과 처리(신고자에게 메일 발송 처리)
        Map<String,Integer> MailCount = new HashMap<>();
        for(int i =0; i<id_list.length; i++){
            String id = id_list[i];
            MailCount.put(id,0);
        }
        List<String> reportedList = new ArrayList<>(reportCount.keySet());
        for(int i =0; i<reportedList.size(); i++){
            String reported = reportedList.get(i);
            if(reportCount.get(reported) >= k){ //신고당한 횟수가 k번 이상이라면
                List<String> reporterList = new ArrayList<>(reportMap.get(reported));
                for(int j =0; j<reporterList.size(); j++){
                    String reporter = reporterList.get(j);
                    MailCount.put(reporter, MailCount.getOrDefault(reporter, 0) + 1);
                }
            }
        }
        int[] answer = new int[n];
        for(int i =0; i<n; i++){
            answer[i] = MailCount.get(id_list[i]);
        }
        return answer;
    }
}