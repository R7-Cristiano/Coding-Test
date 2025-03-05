class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        //이진 탐색을 통하여 최소한의 숙련도를 찾는 케이스
        int left = 1, right = 100000, answer = right;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canSolve(diffs, times, limit, mid)) {
                answer = mid; // 가능한 경우, 더 작은 숙련도를 탐색
                right = mid - 1; 
            } else {
                left = mid + 1; //불가능한 경우 더 큰 숙련도를 탐색
            }
        }

        return answer;
    }

    private boolean canSolve(int[] diffs, int[] times, long limit, int level) {
        long totalTime = 0; //총 문제를 푸는데 걸리는 시간
        int prevTime = 0; //이전 문제를 푸는데 걸리는 시간

        for (int i = 0; i < diffs.length; i++) {
            int curDiff = diffs[i]; // 현재 난이도
            int curTime = times[i]; //현재 시간

            if (curDiff <= level) { //숙련도가 현재 난이도 보다 크거나 같을 경우
                totalTime += curTime; // 틀리지 않고 바로 해결
            } else { // 숙련도가 현재 난이도 보다 낮을경우
                int failCount = curDiff - level; // 틀리는 횟수
                totalTime += failCount * (curTime + prevTime) + curTime; // 전체 소요 시간 계산
            }

            if (totalTime > limit) return false; // 제한 시간을 초과하면 false 반환

            prevTime = curTime; // 이전 퍼즐의 시간 업데이트
        }

        return true;
    }
}