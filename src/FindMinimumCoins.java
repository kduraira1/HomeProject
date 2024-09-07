import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindMinimumCoins {

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

    public static void main(String[] args) {
        FindMinimumCoins fmc = new FindMinimumCoins();
        System.out.println(fmc.coinChange(new int[]{1,2,5,10},27));
    }

}
