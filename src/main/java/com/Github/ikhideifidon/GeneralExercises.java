package com.Github.ikhideifidon;


public class GeneralExercises {

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
}
