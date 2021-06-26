package DP;

public class HouseRob2 {

    public int rob(int[] nums) {
        // 2 options:
        // 1. do not rob first house, then the last house is free to rob [1, last]
        // 2. do not rob the last house, then the first house can be free to rob [0, last-1]
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] rob_first = new int[nums.length-1];
        int[] rob_last = new int[nums.length];
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
           rob_first[i] = nums[i];
        }
        for (int i = 1; i< len; i++) {
            rob_last[i-1] = nums[i];
        }
        return Math.max(rob_help(rob_first), rob_help(rob_last));
    }

    int rob_help(int[] arr) {
        int len =arr.length;
        int[][] dp = new int[len][2];
        dp[0][0] = arr[0]; // rob
        dp[0][1] = 0; // not rob
        for (int i = 1;i < len; i++) {
            dp[i][0] = dp[i-1][1] + arr[i];
            dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1]);
        }
        return Math.max( dp[len-1][0], dp[len-1][1]);
    }
}
