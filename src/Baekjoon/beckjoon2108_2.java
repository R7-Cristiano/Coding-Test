package Baekjoon;

import java.util.*;
import java.io.*;
public class beckjoon2108_2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 정수 입력
        ArrayList<Integer> waha = new ArrayList<>();
        int sum =0;

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            waha.add(num);
        }

        Collections.sort(waha);

        for(int i=0; i<waha.size(); i++){
            sum += waha.get(i);
        }

        System.out.println(Math.round((double) sum /waha.size())); // 산술평균
        System.out.println(waha.get((int) Math.ceil(waha.size()/2))); // 중앙값
        System.out.println(modeFuction(waha)); //최빈값 출력. 단, 빈도가 같을 경우 최빈값 중 두번째로 같은 값 출력
        System.out.println(waha.get(waha.size()-1)-waha.get(0));//범위
    }
    public static int modeFuction(ArrayList<Integer> nums){ //최빈값(여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다) -2 1 2 3 8
        //HashMap을 사용해 숫자와 그 빈도수를 저장
        HashMap<Integer,Integer> frequencyMap = new HashMap<>();
        for(int i=0; i<nums.size(); i++){
            int num = nums.get(i);
            if(frequencyMap.containsKey(num)){
                frequencyMap.put(num,frequencyMap.get(num)+1);
            }else{
                frequencyMap.put(num,1);
            }
        }
        //최대 빈도 찾기
        int MaxFrequency =0;
        List<Integer> values = new ArrayList<>(frequencyMap.values());
        for(int i=0; i<values.size(); i++){
            int value = values.get(i);// 현재 빈도의 값
            if(value > MaxFrequency){
                MaxFrequency = value; //최대 빈도 업데이트
            }
        }
        //최대 빈도를 가진 숫자 찾기
        ArrayList<Integer> modeList = new ArrayList<>(); //최대 빈도를 가진 숫자들을 저장할 ArrayList
        List<Map.Entry<Integer,Integer>> entries = new ArrayList<>(frequencyMap.entrySet());
        for(int i=0; i<entries.size(); i++){
            Map.Entry<Integer,Integer> entry = entries.get(i);
            if(entry.getValue() == MaxFrequency){
                modeList.add(entry.getKey());
            }
        }

        //최빈값 정렬
        Collections.sort(modeList);

        if(modeList.size() >1){
            return modeList.get(1);
        }else{
            return modeList.get(0);
        }
    }
}
