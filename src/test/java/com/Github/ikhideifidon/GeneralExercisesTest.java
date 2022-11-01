package com.Github.ikhideifidon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

class GeneralExercisesTest {

    @Test
    void canPartition() {
    }

    @Test
    void canPartitionKSubsets() {
    }

    @Test
    void fib() {
    }

    @Test
    void solveKnapsack() {
        int[] w = {54, 95, 36, 18, 4, 71, 83, 16, 27, 84, 88, 45, 94, 64, 14, 80, 4, 23, 75, 36,
                90, 20, 77, 32, 58, 6, 14, 86, 84, 59, 71, 21, 30, 22, 96, 49, 81, 48, 37, 28, 6,
                84, 19, 55, 88, 38, 51, 52, 79, 55, 70, 53, 64, 99, 61, 86, 1, 64, 32, 60, 42, 45,
                34, 22, 49, 37, 33, 1, 78, 43, 85, 24, 96, 32, 99, 57, 23, 8, 10, 74, 59, 89, 95,
                40, 46, 65, 6, 89, 84, 83, 6, 19, 45, 59, 26, 13, 8, 26, 5, 9};

        int[] p = {297, 295, 293, 292, 291, 289, 284, 284, 283, 283, 281, 280, 279, 277, 276,
                275, 273,264, 260, 257, 250, 236, 236, 235, 235, 233, 232, 232, 228, 218, 217,
                214, 211, 208, 205, 204, 203, 201, 196, 194, 193, 193, 192, 191, 190, 187, 187,
                184, 184, 184, 181, 179, 176, 173, 172, 171, 160, 128, 123, 114, 113, 107, 105,
                101, 100, 100, 99, 98, 97, 94, 94, 93, 91, 80, 74, 73, 72, 63, 63, 62, 61, 60, 56,
                53, 52, 50, 48, 46, 40, 40, 35, 28, 22, 22, 18, 15, 12, 11, 6, 5};

        int C = 3818;


        long startTime = System.currentTimeMillis();
        int maxProfit = GeneralExercises.solveKnapsack(p, w, C);
        Assertions.assertEquals(15170, maxProfit);
        long endTime = System.currentTimeMillis();

        System.out.println("Maximum Obtainable Profit is: " + maxProfit +"\nThis operation took " + (endTime - startTime) + " milliseconds");
    }

    @Test
    public void knapsack() {
        int[] w = {80,82,85,70,72,70,66,50,55,25,50,55,40,48,59,32,22, 60, 30, 32, 40, 38, 35,
                32, 25, 28, 30, 22, 50, 30, 45, 30, 60, 50, 20, 65, 20, 25, 30, 10, 20, 25, 15,
                10, 10, 10, 4, 4, 2, 1};

        int[] p = {220, 208, 198, 192, 180, 180, 165, 162, 160, 158, 155, 130, 125, 122, 120,
                118, 115, 110, 105, 101, 100, 100, 98, 96, 95, 90, 88, 82, 80, 77, 75, 73, 72,
                70, 69, 66, 65, 63, 60, 58, 56, 50, 30, 20, 15, 10, 8, 5, 3, 1};

        int C = 1000;
        long startTime = System.currentTimeMillis();
        int maxProfit = GeneralExercises.solveKnapsack(p, w, C);
        Assertions.assertEquals(3103, maxProfit);
        long endTime = System.currentTimeMillis();

        System.out.println("Maximum Obtainable Profit is: " + maxProfit +"\nThis operation took " + (endTime - startTime) + " milliseconds");

        Random rand = new Random(0);
        int upperbound = 100;
        int[] profits = new int[10000];
        for (int i = 0; i < profits.length; i++)
            profits[i] = rand.nextInt(500);
        System.out.println(Arrays.toString(profits));
    }

    @Test
    public void generateParenthesis() {
        int n = 3;
        String[] expected = {"((()))","(()())","(())()","()(())","()()()"};
        List<String> output = List.of(expected);
        List<String> result = GeneralExercises.generateParenthesis(n);
        Assertions.assertEquals(output, result);
    }

    @Test
    public void jumpGame() {
        Random rand = new Random(0);
        int upperbound = 10_000;
        int[] nums = new int[upperbound];
        for (int i = 0; i < upperbound; i++)
            nums[i] = rand.nextInt(0, upperbound * 10);
        boolean expected = true;
        Assertions.assertEquals(expected, GeneralExercises.jumpGame(nums));

    }

    @Test
    public void jump() {
        int[] nums = {2, 1, 1, 5, 2, 4};
        System.out.println(GeneralExercises.jump(nums));
    }

    @Test
    public void findMedianSortedArray() {
        int[] nums1 = {1, 3};
        int[] nums2 = null;
        System.out.println(GeneralExercises.findMedianSortedArrays(nums1, nums2));
    }
}