package DP;

public class KnapSack {
    //int[] memo = new memo[100][100]
    // weight -1 3 4 5
    // values- 1 4 5 7
    // max weight : 7

    public int recursiveKnapSack(int[] weight, int[] values, int maxWeight, int size) {
        //Calculate base condition.
        if(maxWeight == 0 || size == 0) {
            return 0;
        }
        // Choice diagram implementation
        if(weight[size-1] <= maxWeight) {
            return  Math.max((values[size-1] + recursiveKnapSack(weight, values, maxWeight - weight[size-1], size -1 )),
                    recursiveKnapSack(weight, values, maxWeight, size -1 ));

        } else {
            return  recursiveKnapSack(weight, values, maxWeight, size -1 );
        }
    }

    public int recursiveKnapSackWithMemo(int[] weight, int[] values, int maxWeight, int size, int[][] memo) {
        //Calculate base condition.
        if(maxWeight == 0 || size == 0) {
            return 0;
        }
        if(memo[size][maxWeight] != -1) {
            return memo[size][maxWeight];
        }
        // Choice diagram implementation
        if(weight[size-1] <= maxWeight) {
           memo[size][maxWeight] =  Math.max((values[size-1] + recursiveKnapSackWithMemo(weight, values, maxWeight - weight[size-1], size -1, memo)),
                   recursiveKnapSackWithMemo(weight, values, maxWeight, size -1,memo));
           return memo[size][maxWeight];

        } else {
            memo[size][maxWeight] = recursiveKnapSackWithMemo(weight, values, maxWeight, size -1, memo);
            return  memo[size][maxWeight];
        }
    }

    public int knapSackBottomUPDP(int[] weight, int[] values, int maxWeight, int size) {
        //Calculate base condition.
        int[][] memo = new int[size + 1][maxWeight + 1];
        if (maxWeight == 0 || size == 0) {
            return 0;
        }
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[0].length; j++) {
                if (i == 0 || j == 0) memo[i][j] = 0;
            }

        }
        // Choice diagram implementation
    // Weight is row and max weight is J
        for (int i = 1; i < size+1; i++) {
            for (int j = 1; j < maxWeight +1 ; j++) {
                if (weight[i-1] <= j) {
                    int include = values[i-1] + memo[i - 1][j - weight[i - 1]];
                    memo[i][j] = Math.max(include,
                            memo[i - 1][j]);
                    //return memo[i][j];

                } else {
                    memo[i][j] = memo[i - 1][j];
                    //return  memo[size][maxWeight];
                }
            }
        }
        return memo[size][maxWeight];
    }

    public  static void  main(String[] arg) {

        int[] weight = new int[] {1,3,4,5};
        int[] values = new int[] {1,4,5,7};

        KnapSack ks = new KnapSack();
        int[][] memo = new int[5][8];


        // one size bigger
       for(int i = 0; i < memo.length; i++) {
           for(int j = 0; j < memo[0].length; j++) {
               memo[i][j] = -1;
           }
       }

        System.out.println(ks.recursiveKnapSack(weight, values, 7, 4));
        System.out.println(ks.recursiveKnapSackWithMemo(weight, values, 7, 4, memo));
        int[] weight1 = new int[] {1,3,4,5};
        int[] values1 = new int[] {1,4,5,7};
        System.out.println(ks.knapSackBottomUPDP(weight1, values1, 7,4));


    }
}
