package com.Github.ikhideifidon;


public class GeneralExercises {
    // 0/1 Knapsack Problem and Dynamic Programming
    // Medium 416: Partition Equal Subset Sum
    public static boolean canPartition(int[] nums) {
        if (nums == null)
            return false;

        if (nums.length <= 1)
            return false;

        if (nums.length == 2)
            return nums[0] == nums[1];


        int total = 0;
        for (int num : nums)
            total += num;

        Boolean[][] table = new Boolean[nums.length][total / 2 + 1];

        if (total % 2 != 0)
            return false;

        return dp(nums, total / 2,0, table);

    }

    private static boolean dp(int[] nums, int total, int start, Boolean[][] table) {
        if (start == nums.length && total != 0)
            return false;

        if (total == 0)
            return true;

        if (table[start][total] == null) {
            if (nums[start] <= total) {
                if (dp(nums, total - nums[start], start + 1, table)) {
                    table[start][total] = true;
                    return true;
                }
            }
            table[start][total] = dp(nums, total, start + 1, table);
        }
        return table[start][total];
    }

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums == null)
            return false;

        if (nums.length == 1 && k == 1)
            return true;

        if (k > nums.length)
            return false;

        boolean[] visited = new boolean[nums.length];
        int total = 0;
        for (int num : nums)
            total += num;

        if (total % k != 0)
            return false;

        return helper(nums, 0, k, nums.length - 1, visited, total / k);

    }

    private static boolean helper(int[] nums, int total, int round, int start, boolean[] visited, int target) {
        if (round == 0)
            return true;

        if (total == target && helper(nums, 0, round - 1, nums.length - 1, visited, target))
            return true;

        for (int i = start; i < nums.length; i++) {
            if (!visited[i] && total + nums[i] <= target) {
                visited[i] = true;
                if (helper(nums, total + nums[i], round, i - 1, visited, target))
                    return true;
                visited[i] = false;
            }
        }
        return false;
    }

    public static long fib(int n) {
        if (n <= 1)
            return n;

        int result = 0;
        int first = 0;
        int second = 1;
        for (int i = 2; i <= n; i++) {
            result = first + second;
            first = second;
            second = result;
        }
        return result;
    }

    // 0/1 Knapsack Problem
    // Memoized
    public static int solveKnapsack(int[] profits, int[] weights, int capacity) {
        if (profits == null || weights == null)
            throw new NullPointerException("Either or Both arrays cannot be null.");

        int n = profits.length;   // Number of items given. n = weights.length is also correct.
        if (n == 0)
            return 0;

        if (n == 1)
            return weights[0] <= capacity ? profits[0] : 0;

        // For n >= 2.
        // For the recursive function, the only changing state variables are capacity and start.
        // Both variables can be memoized.
        int[][] memo = new int[n + 1][capacity + 1];
        return knapsack(profits, weights, capacity, 0, memo);
    }

    private static int knapsack(int[] profits, int[] weights, int capacity, int start, int[][] memo) {
        if (start >= profits.length)            // Recursive base case
            return 0;

        if (capacity <= 0)          // Backtracking
            return 0;

        // Check if the current start and capacity has been processed.
        if (memo[start][capacity] != 0)
            return memo[start][capacity];

        // Decision to take
        int profit1 = 0;
        if (weights[start] <= capacity)
            profit1 = profits[start] + knapsack(profits, weights, capacity - weights[start], start + 1, memo);

        // Decision NOT to take
        int profit2 = knapsack(profits, weights, capacity, start + 1, memo);

        // Add the maximum between profit1 and profit2 to the memo
        memo[start][capacity] = Math.max(profit1, profit2);

        return memo[start][capacity];
    }

    public static int tabularKnapsack(int[] profits, int[] weights, int capacity) {
        if (profits == null || weights == null)
            throw new NullPointerException("Either or Both arrays cannot be null.");

        int n = profits.length;   // Number of items given. n = weights.length is also correct.

        if (capacity <= 0 || n == 0)
            return 0;

        if (n == 1)
            return weights[0] <= capacity ? profits[0] : 0;

        // n >= 2
        int[][] dp = new int[n][capacity + 1];

        // populate the capacity = 0 columns, with '0' since capacity we have '0' profit
        for(int i = 0; i < n; i++)
            dp[i][0] = 0;

        // If we have only one weight, we will take it if it is not more than the given capacity.
        for (int j = 0; j <= capacity; j++) {
            if (weights[0] <= j)
                dp[0][j] = profits[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= capacity; j++) {
                int takeProfit = 0, notTakeProfit = 0;
                if (weights[i] <= j)
                    takeProfit = profits[i] + dp[i - 1][j - weights[i]];
                else
                    notTakeProfit = dp[i - 1][j];
                dp[i][j] = Math.max(takeProfit, notTakeProfit);
            }
        }
        return dp[n - 1][capacity];
    }
}
