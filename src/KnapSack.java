import java.util.Arrays;

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
           memo[size][maxWeight] =  Math.max((values[size-1] + recursiveKnapSack(weight, values, maxWeight - weight[size-1], size -1 )),
                    recursiveKnapSack(weight, values, maxWeight, size -1 ));
           return memo[size][maxWeight];

        } else {
            memo[size][maxWeight] = recursiveKnapSack(weight, values, maxWeight, size -1 );
            return  memo[size][maxWeight];
        }
    }

    public  static void  main(String[] arg) {

        int[] weight = new int[] {1,3,4,5};
        int[] values = new int[] {1,4,5,7};

        KnapSack ks = new KnapSack();
        int[][] memo = new int[5][8];
       for(int i = 0; i < memo.length; i++) {
           for(int j = 0; j < memo[0].length; j++) {
               memo[i][j] = -1;
           }
       }

        System.out.println(ks.recursiveKnapSack(weight, values, 7, 4));
        System.out.println(ks.recursiveKnapSackWithMemo(weight, values, 7, 4, memo));


    }
}
