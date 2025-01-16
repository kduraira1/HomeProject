package home;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.



Example 1:

Input: nums = [-1,0,1,2,-1,-4] */
public class ThreeSum {
    public List<List<Integer>> findThreeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = j + 1; //nums.length -1;
            //while(k > i && j < nums.length) {
            while(j < nums.length && k < nums.length) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> threeSumList = new ArrayList<Integer>();
                    threeSumList.add(nums[i]);
                    threeSumList.add(nums[j]);
                    threeSumList.add(nums[k]);
                    result.add(threeSumList);
                }
                k++;
                j++;
            }

        }
        return result;
    }
    public static void main(String[] args) {
        ThreeSum ts = new ThreeSum();
        System.out.println(ts.findThreeSum(new int[] {-1,0,1,2,-1,-4}));
        Stack stack = new Stack();
        stack.push("abc");
        stack.push("def");
        stack.push("ghi");
        //String joined = String.join("/", stack);
        String path = "/" + String.join("/", stack); //joined + "/";
        System.out.println(path);
        String[] directories = path.split("/");
        System.out.println(Arrays.toString(directories));
    }


}
