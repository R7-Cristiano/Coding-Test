package Baekjoon;

import java.io.*;
import java.util.*;
public class beckjoon2108 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // N개의 수 입력받음 대신 홀수 개수만
        ArrayList<Integer> nums = new ArrayList<>();
        int sum =0; // 평균내기 위한 더하는 변수

        for(int i =0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            nums.add(num); // nums ArrayList에 num 숫자 넣음
        }
        for(int i=0; i<nums.size(); i++){
            sum += nums.get(i);
        }

        Collections.sort(nums);

        double avg = (double) sum / N;
        System.out.println((int) Math.round(avg)); // 반올림하여 정수로 출력
        System.out.println(nums.get((int)Math.floor(nums.size()/2))); //중앙값
        System.out.println(modeFunction(nums)); // 최빈값
        System.out.println((nums.get(nums.size()-1)-nums.get(0)));
    }
    public static int modeFunction(ArrayList<Integer> nums){ //최빈값(여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다) -2 1 2 3 8
        //HashMap을 사용해 숫자와 그 빈도를 저장
        HashMap<Integer,Integer> frequencyMap = new HashMap<>();
        for(int i =0; i<nums.size(); i++){
            int num = nums.get(i);
            if(frequencyMap.containsKey(num)){
                frequencyMap.put(num, frequencyMap.get(num) + 1);
            }else{
                // 처음 등장하면 1로 초기화
                frequencyMap.put(num, 1);
            }
        }
        //최대 빈도 찾기
        int maxFrequency = 0;
        List<Integer> values = new ArrayList<>(frequencyMap.values());
        for (int i = 0; i < values.size(); i++) {
            int value = values.get(i); // 현재 빈도 값
            if (value > maxFrequency) {
                maxFrequency = value; // 최대 빈도 업데이트
            }
        }

        // 3. 최대 빈도를 가진 숫자들 추출
        ArrayList<Integer> modeList = new ArrayList<>();
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(frequencyMap.entrySet());
        for (int i = 0; i < entries.size(); i++) {
            Map.Entry<Integer, Integer> entry = entries.get(i);
            if (entry.getValue() == maxFrequency) {
                modeList.add(entry.getKey()); // 최대 빈도의 숫자 추가
            }
        }

        // 4. 최빈값 정렬
        Collections.sort(modeList);

        // 5. 최빈값 반환 (두 번째로 작은 값 또는 유일한 값)
        if (modeList.size() > 1) {
            return modeList.get(1); // 두 번째로 작은 값
        }
        return modeList.get(0); // 유일한 값
    }
}
