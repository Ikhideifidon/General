package com.Github.ikhideifidon;

public class Main {
    public static void main(String[] args) {
        int[] nums = {14, 18, 2};
        int[] nums2 = {2, 2, 2, 2, 3, 4, 5};
        int k = 4;
        System.out.println(GeneralExercises.canPartition(nums));
        System.out.println(GeneralExercises.canPartitionKSubsets(nums2, k));
        System.out.println(GeneralExercises.fib(19));

        int[] profits = {10, 20, 30};
        int[] weights = {2, 5, 9};

        int[] w = {80, 82, 85, 70, 72, 70, 66, 50, 55, 25, 50, 55, 40, 48, 59, 32, 22, 60, 30,
                32, 40, 38, 35, 32, 25, 28, 30, 22, 50, 30, 45, 30, 60, 50, 20, 65, 20, 25, 30,
                10, 20, 25, 15, 10, 10, 10, 4, 4, 2, 1};

        int[] p = {220, 208, 198, 192, 180, 180, 165, 162, 160, 158, 155, 130, 125, 122, 120,
                118, 115, 110, 105, 101, 100, 100, 98, 96, 95, 90, 88, 82, 80, 77, 75, 73, 72,
                70, 69, 66, 65, 63, 60, 58, 56, 50, 30, 20, 15, 10, 8, 5, 3, 1};

        int C = 1000;
        long startTime = System.currentTimeMillis();
        System.out.println(GeneralExercises.solveKnapsack(profits, weights, 12));
        long endTime = System.currentTimeMillis();

        System.out.println("This operation took " + (endTime - startTime) + " milliseconds");
        System.out.println(GeneralExercises.tabularKnapsack(profits, weights, 12));
    }
}