package DP;

class HouseRob {
    public int rob(int[] nums) {
        // [i][j] = a, a stands for the jth status in ith iteration.
        // for ith iteration, the decision could be,
        // 1. rob this one, then the last one got robbed
        // 2. not rob this one, then the last one got robbed or not robbed, which ones is bigger.

        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[][] dp = new int[nums.length][2];
        dp[0][0] = nums[0];
        dp[0][1] = 0;
        for (int i = 1; i < nums.length; i++) {
            // this robs and last one cannot be robbed.
            // dp[i][0] rob this house, does not rob last one
            // dp[i][1] does not rob this house
            dp[i][0] = dp[i-1][1] + nums[i];
            dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1]);
        }
        return Math.max(dp[nums.length-1][0], dp[nums.length-1][1]);
    }
}