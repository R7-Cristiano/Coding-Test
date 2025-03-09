import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        //report -> 각 이용자가 신고한 이용자의 ID 정보가 담긴 문자열 배열(각 이용자의 신고목록)
        //reporter 신고자 reported 신고 당한 사람 K번 이상 신고당하면 정지
        //reporter가 신고한 reported가 정지당하면, 메일로 정지당한 사람 알려줌
        //이때 reporter의 신고로 인해 정지된 reported의 횟수가 담긴 일차원 배열 출력
        
        Map<String,HashSet<String>> reportMap = new HashMap<>(); // 신고자와 신고당한 사람의 HashMap
        Map<String,Integer> reportCount = new HashMap<>(); //신고 당한 이용자의 신고 횟수를 저장
        int n = id_list.length; //이용자 ID가 담긴 문자열 배열의 길이
        
        for(int i =0; i<report.length; i++){
            String rep = report[i]; // 한 사용자의 신고목록
            String[] split = rep.split(" ");// 한 사용자의 신고 목록에서 각 신고당한 사람의 공백으로 나눔
            String reporter = split[0]; //신고자
            String reported = split[1]; //신고당한사람

            reportMap.putIfAbsent(reported,new HashSet<>()); //신고당한 기록이 없으면 새로 생성
            //신고당한 유저에 대해 이미 신고자가 신고를 했는지 존재하지않으면 true 아니면 false
            if(!reportMap.get(reported).contains(reporter)){
                reportMap.get(reported).add(reporter);
                //신고 당한 유저의 횟수증가
                //신고당한 적인 없으면 기본값 0
                reportCount.put(reported, reportCount.getOrDefault(reported,0)+1);
            }
        }
        //해당 사용자가 정지당하면 메일발송(신고자에게 메일 발송 처리)
        Map<String,Integer> MailCount = new HashMap<>();
        for(int i =0; i<id_list.length; i++){
            String id = id_list[i]; //각 사용자
            MailCount.put(id,0);
        }
        List<String> reportedList = new ArrayList<>(reportCount.keySet()); //신고 당한 사람의 리스트
        for (int i =0; i< reportedList.size(); i++){
            String reported = reportedList.get(i);
            if(reportCount.get(reported) >= k){ //신고 당한 횟수가 k번 이상이라면
                // 신고한 사람의 리스트
                List<String> reporterList = new ArrayList<>(reportMap.get(reported));
                for(int j =0; j<reporterList.size(); j++){
                    String reporter = reporterList.get(j); //신고 당한 횟수의 k번 이상 사용자의 신고자 리스트
                    MailCount.put(reporter, MailCount.getOrDefault(reporter,0)+1);
                }
            }
        }
        
        int[] answer = new int[n];
        for(int i=0; i<n; i++){
            answer[i] = MailCount.get(id_list[i]);
        }
        
        return answer;
        
    }
}