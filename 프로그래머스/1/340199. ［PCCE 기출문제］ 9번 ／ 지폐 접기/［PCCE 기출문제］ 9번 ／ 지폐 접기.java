class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        int walletWidth = wallet[0];
        int walletHeight = wallet[1];
        int billWidth = bill[0];
        int billHeight = bill[1];

        // 👉 회전 고려 → 항상 작은 쪽이 가로, 큰 쪽이 세로가 되게 정렬
        walletWidth = Math.min(wallet[0], wallet[1]);
        walletHeight = Math.max(wallet[0], wallet[1]);
        billWidth = Math.min(bill[0], bill[1]);
        billHeight = Math.max(bill[0], bill[1]);
        
        // 지갑에 들어갈 때까지 반복
        while ((billWidth > walletWidth || billHeight > walletHeight) && billWidth > 0 && billHeight > 0) {
            if (billWidth > walletWidth || billHeight > walletHeight) {
                // 더 큰 쪽을 접음
                if (billHeight > billWidth) {
                    billHeight /= 2; // 세로를 접음
                } else {
                    billWidth /= 2; // 가로를 접음
                }
                answer++;
            }

            // 👉 접었을 때 회전 후 들어갈 수 있는 경우 처리
            if ((billWidth <= walletWidth && billHeight <= walletHeight) ||
                (billHeight <= walletWidth && billWidth <= walletHeight)) {
                break;
            }
        }

        return answer;
    }
}
