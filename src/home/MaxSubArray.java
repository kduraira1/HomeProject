package home;

public class MaxSubArray {

    public int findMaxSubArray(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for(int val : arr ) {
            currSum = Math.max(val, currSum + val);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
    public static void main(String[] args){
        MaxSubArray msa = new MaxSubArray();
        System.out.println(msa.findMaxSubArray(new int[] {2,-1,0,5,7,8,9}));

    }
}
