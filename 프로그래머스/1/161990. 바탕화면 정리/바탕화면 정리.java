class Solution {
    public int[] solution(String[] wallpaper) {
        //바탕화면 각 칸 격자판 왼쪽위 (0,0) (세로좌표, 가로좌표)
        //바탕화면의 상태 wallpaper -> 문자열 배열
        //빈칸은 . 파일이 있는 칸은 #
        //최소한의 이동거리를 갖는 한번의 드래그로 모든 파일을 선택해서 삭제
        //바탕화면 격자점 S(lux,luy) -> E(rdx,rdy) 점 S에서 E로 드래그한다.
        //드래그한 거리 점과 점사리의 거리
        //한번에 삭제하기 위해 최소한의 이동거리를 갖는 드래그의 시작점과 끝점을 담은 정수배열을 리턴해라
        //(0,1) -> (3,4) 드래그 하면 모든 파일 선택 -> [0,1,3,4]
        int n = wallpaper.length;//wallpaper의 세로
        int m = wallpaper[0].length(); //가로
        
        // 최소값은 MAX_VALUE로, 최대값은 MIN_VALUE로 초기화
        int lux = Integer.MAX_VALUE;
        int luy = Integer.MAX_VALUE;
        int rdx = Integer.MIN_VALUE;
        int rdy = Integer.MIN_VALUE;
        
        
        for(int i =0; i<n; i++){ 
            for(int j=0; j<m; j++){
                if(wallpaper[i].charAt(j) == '#'){
                    // 최소 좌표 갱신 (시작점)
                    lux = Math.min(lux, i);
                    luy = Math.min(luy, j);
                    // 최대 좌표 갱신 (끝점 + 1)
                    rdx = Math.max(rdx, i + 1);
                    rdy = Math.max(rdy, j + 1);
                }
            }
        }
        // 배열로 반환
        return new int[]{lux, luy, rdx, rdy};
    }
}