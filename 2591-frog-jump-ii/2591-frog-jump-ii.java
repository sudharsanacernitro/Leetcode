class Solution {
    public int maxJump(int[] stones) {
        int n = stones.length;
        int maxJump = stones[1] - stones[0];

        for (int i = 2; i < n; i++) {
            maxJump = Math.max(maxJump, stones[i] - stones[i - 2]);
        }

        return maxJump;
    }
}
