package home;/*
You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.

You can either start from the step with index 0, or the step with index 1.

Return the minimum cost to reach the top of the floor.



        Example 1:

Input: cost = [10,15,20]
Output: 15
Explanation: You will start at index 1.
        - Pay 15 and climb two steps to reach the top.
The total cost is 15.
*/

public class MinCostClimbingStairs {
    public int findMinCostClimbStairs(int[] cost) {
        int first = cost[0];
        int second = cost[1];
        int curr = 0;
        if (cost.length == 2) return Math.min(first, second);
        for(int i =2; i < cost.length; i++) {
            curr = cost[i] + Math.min(first, second);
            first = second;
            second = curr;
        }
        return Math.min(first, second);
    }

    public static void main(String[] args) {
        MinCostClimbingStairs  mcs = new MinCostClimbingStairs();
        System.out.println(mcs.findMinCostClimbStairs(new int[] {10,15,20}));

    }
}
