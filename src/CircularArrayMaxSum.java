public class CircularArrayMaxSum {
    //Input: nums = [1,-2,3,-2]
    //Output: 3
    public int findMaxSum(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;
        int currMaxSum = 0;
        int currMinSum = 0;
        int total = 0;
        for(int i=0; i < nums.length; i++) {
            total += nums[i];
            currMaxSum = Math.max(currMaxSum + nums[i], nums[i]);
            currMinSum = Math.max(currMinSum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, currMaxSum);
            minSum = Math.min(minSum, currMaxSum);
        }
        return maxSum < 0 ? maxSum : Math.max(maxSum, total - minSum);
    }

    public static void main(String[] args) {
        CircularArrayMaxSum cams = new CircularArrayMaxSum();
        System.out.println(cams.findMaxSum(new int[] {1,-2,3,-2}));
    }
}
