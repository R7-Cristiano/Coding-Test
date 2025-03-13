import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        //[코드 번호(code)", "제조일(date)", "최대 수량(maximum)", "현재 수량(remain)"] data 2차원배열
        // 어떤 정보를 기준으로 데이터를 뽑아야할지 정하는 문자열 ext
        // 뽑아낼 정보의 기준값을 나타내는 정수 val_ext
        //정보를 정렬할 기준이 되는 문자열 sort_by
        //ext 값이 val_ext 보다 작은 데이터만 뽑은 후, sort_by에 해당하는 값을 기준으로 오름차순으로 정렬하여 리턴
        int extIndex = getIndex(ext);
        int sortIndex = getIndex(sort_by);
        
        List<int[]> filteredList = new ArrayList<>();
        for(int i=0; i< data.length; i++){
            if(data[i][extIndex] < val_ext){
                filteredList.add(data[i]);
            }
        }
        
        filteredList.sort(Comparator.comparingInt(arr -> arr[sortIndex]));
        
        int[][] result = new int[filteredList.size()][4];
        for(int i=0; i<filteredList.size(); i++){
            result[i] = filteredList.get(i);
        }
        return result;
    }
    
    private int getIndex(String key){
        switch(key) {
            case "code": return 0;
            case "date": return 1;
            case "maximum": return 2;
            case "remain": return 3;
            default: return -1;
        }
    }
}