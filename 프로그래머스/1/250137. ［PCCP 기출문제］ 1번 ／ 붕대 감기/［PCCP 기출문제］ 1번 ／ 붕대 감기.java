class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxHealth = health; // 최대 체력 저장
        int time = bandage[0]; // 시전 시간
        int second = bandage[1]; // 초당 회복량
        int plus = bandage[2]; // 추가 회복량
        int lastAttackTime = 0; // 마지막 공격 시간
        int successTime = 0; // 연속 붕대감기 성공 시간 누적

        for (int i = 0; i < attacks.length; i++) {
            int attackTime = attacks[i][0]; // 몬스터 공격 시간
            int damage = attacks[i][1]; // 몬스터 피해량
            
            // 이전 공격과 현재 공격 사이의 회복 가능 시간 계산
            int healTime = attackTime - lastAttackTime - 1;
            
            if (healTime > 0) {
                // 회복 시간 동안 체력 회복
                health += healTime * second;
                successTime += healTime;

                // 연속 성공 시 추가 회복 처리
                while (successTime >= time) {
                    health += plus;
                    successTime -= time;
                }

                // 최대 체력 초과 방지
                if (health > maxHealth) {
                    health = maxHealth;
                }
            }

            // 몬스터 공격 처리
            health -= damage;

            // 체력이 0 이하가 되면 즉시 종료
            if (health <= 0) {
                return -1;
            }

            // 마지막 공격 시간 갱신
            lastAttackTime = attackTime;

            // ✅ 공격 발생 시 연속 시전 시간 초기화
            successTime = 0;
        }

        // 모든 공격이 끝난 후 남은 체력 반환
        return health;
    }
}
