package home;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindMinimumCoins {

// Write it down on the paper to come up with logic... if no logic comes up then don't code.
    // learn the logic.
    public int minimumCoinDP(int[] coins, int amount) {

        int[] dp = new int[amount+1];

        //initializing the DP array.
        /* replace with arrays util ..for (int i = 1; i < dp.length; i++) {
            dp[i] = amount + 1;
        } */

        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for(int i = 1; i <= amount; i++) {
            for(int j = 0; j < coins.length; j++) {
                if( i - coins[j] >= 0) {
                    dp[i] = Math.min(dp[i], 1+ dp[i-coins[j]]);
                }
            }
        }
        return dp[amount];

    }

    public int coinChange(int[] coins, int amount) {
        List<Integer> result = new ArrayList<Integer>();
        List<Integer> tempResult = new ArrayList<Integer>();
        int count = 0;
        if(amount == 0) return 0;
        int max = 0;
        int maxIndex = 0;
        Arrays.sort(coins);
        for(int i = 0; i < coins.length; i++) {
            if (coins[i] > max) {
                max = coins[i];
                maxIndex = i;
            }
        }

        backtrack(coins, amount, tempResult, result, maxIndex);
        //backtrackWithLoop(coins, amount, tempResult, result);
        count = result.size();
        System.out.println(result);
        return count == 0 ? -1 : count;
    }

    public void backtrack(int[] coins, int amount, List<Integer> tempResult, List<Integer> result, int maxIndex) {
        if(amount < 0) {
            return;
        }

        if(amount == 0) {
            if(result.size() == 0 ){
                result.addAll(tempResult);
            } else {
                if(tempResult.size() < result.size()) {
                    result.clear();
                    result.addAll(tempResult);
                }
            }
            return;
        }

        for(int i = maxIndex; i < coins.length; i++) {
            tempResult.add(coins[i]);
            //if(tempResult.size() > 10) {tempResult.clear(); continue;}
            backtrack(coins, amount - coins[i], tempResult, result,coins.length - i);
            if(tempResult.size() > 0 ) tempResult.remove(tempResult.size()-1);

        }

    }

    public void backtrackWithLoop(int[] coins, int amount, List<Integer> tempResult, List<Integer> result) {
        if(amount < 0) {
            return;
        }
        int count = amount;
        for(int i = 0; i < coins.length; i++) {
            tempResult.clear();
            tempResult.add(coins[i]);
            count = amount - coins[i];
            int innerCount = amount;
            List<Integer> innerList = new ArrayList<>();
            for(int j = 0; j < coins.length; j++) {
                sameNumberTargetCheck (coins, count, j, tempResult, result);
                tempResult.clear();
                tempResult.add(coins[i]);
                count = amount - coins[i];
                if(innerCount - coins[j] >= 0) {
                    innerList.add(coins[j]);
                    innerCount = innerCount - coins[j];
                }
                addToResult(innerCount, innerList, result);

            }
            innerList.clear();

        }

    }

    public void sameNumberTargetCheck (int[] coins, int count, int j, List<Integer> tempResult, List<Integer> result) {
        while (count - coins[j] >= 0) {
            tempResult.add(coins[j]);
            count = count - coins[j];
        }
        addToResult(count, tempResult, result);
    }

    public void addToResult(int count,List<Integer> tempResult, List<Integer> result) {
        if(count == 0) {
            if(result.size() == 0 ){
                result.addAll(tempResult);
            } else {
                if(tempResult.size() < result.size()) {
                    result.clear();
                    result.addAll(tempResult);
                }
            }
        }
    }

    public int coinChange1(int[] coins, int amount) {

        int[] memo = new int[amount+1];
        int result = backTrack(coins, amount, memo, amount+1);
        System.out.println(result);

        return result > amount ? -1 : result;

    }

    public int backTrack(int[] coins, int amount, int[] memo, int result) {
        if(memo[amount] !=0) {
            return memo[amount];
        }
        if(amount == 0) {
            result = 0;
        } else {
            // result = amount+1;
            for(int coin : coins) {
                int subProblem = amount - coin;
                if(subProblem < 0) continue;
                int tempResult = backTrack(coins, subProblem, memo, result);
                result = Math.min(result,  tempResult + 1);
                //System.out.println(result);
            }
        }
        memo[amount] = result;
        return result;
    }
    public static void main(String[] args) {
        FindMinimumCoins fmc = new FindMinimumCoins();
        System.out.println(fmc.coinChange(new int[]{1,2,5,10},100));
        System.out.println(fmc.minimumCoinDP(new int[]{1,2,5,10},100));
        System.out.println(fmc.coinChange1(new int[]{186,419,83,408},10000));
    }

}
