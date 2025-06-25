class Solution {
    
    int[] coins;
    int amount;
    Integer[] memo;
    
    public int combinationSum4(int[] nums, int target) {
        this.coins = nums;
        this.amount = target;

        this.memo = new Integer[amount + 1];

        return dp(amount); 
    }

    private int dp(int amount) {
        if (amount == 0) return 1;
        if (amount < 0) return 0;
        if (memo[amount] != null) return memo[amount];

        int sum = 0;

        for (int i = 0; i < coins.length; i++) {
            sum += dp(amount - coins[i]);
        }

        return memo[amount] = sum;
    }
}