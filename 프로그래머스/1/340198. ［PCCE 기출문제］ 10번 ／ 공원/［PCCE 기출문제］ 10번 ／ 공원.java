import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] mats, String[][] park) {
        //지민이가 가진 돗자리들의 한 변의 길이들이 담긴 정수리스트 mats mat.length는 10까지 matd은 20까지
        //현재 공원 자리 배치도를 의미하는 2차원 문자열 리스트 park park.length 50까지
        //지민이 깔수있는 가장 큰 돗자리의 한변의 길이를 return해라
        //park[i].length 50까지
        //park[i][j]에 돗자리를 깐 사람이 없다면 -1 있다면 알파벳으로 한 글작로 된 값을 갖는다.
        //그리디 + 완전탐색 ?
        
        //가장 큰 돗자리 부터 탐색하게 함.
        List<Integer> matList = Arrays.stream(mats)
            .boxed()
            .collect(Collectors.toList());
        Collections.sort(matList,Collections.reverseOrder()); //지민이가 가진 돗자리 내림차순 정렬
        
        int n =park.length; //park 세로
        int m =park[0].length; //park 가로
        
        for(int k=0; k<matList.size(); k++){
            int size = matList.get(k); //지민이가 가진 돗자리 (큰 숫자들부터)
            for(int i=0; i<=n-size; i++){ //세로 초과 방지
                for(int j=0; j<=m-size; j++){
                    if(canPlaceMat(park,i,j,size)){
                        return size; //가장 큰 돗자리 찾으면 리턴
                    }
                }
            }
        }
        return -1; //깔수 있는 돗자리가 없는경우 -1 리턴
    }
    // 돗자리를 특정 위치에 놓을 수 있는지 확인하는 함수
    private boolean canPlaceMat(String[][] park, int x, int y, int size) {
        // ✅ 경계 체크 추가 → 돗자리가 공원을 벗어나면 false 반환
        if (x + size > park.length || y + size > park[0].length) {
            return false;
        }
        
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                // ✅ 빈 공간이 아니면 false 반환
                if (park[i][j] == null || !park[i][j].equals("-1")) {
                    return false;
                }
            }
        }
        return true;
    }
}