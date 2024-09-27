import java.lang.reflect.Array;
import java.util.*;

public class BackTrackingSolutions {
    public List<List<Integer>> generateSubsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> subsetList = new ArrayList<Integer>();
        Arrays.sort(nums);
        backTrackSubsets(nums, subsetList, result, 0);
        return result;
    }

    public void backTrackSubsets(int[] nums, List<Integer> subsetList, List<List<Integer>> result, int index) {
        //if(!result.contains(subsetList))
        result.add(new ArrayList<>(subsetList));
        // pass it with new ArrayList because, we are removing elements from
        // subsetlist but retain the listed added in the result.
        for(int i=index; i < nums.length; i++) {
            if( i > index  && nums[i] == nums[i-1])  continue;
            subsetList.add(nums[i]);
            backTrackSubsets(nums, subsetList, result, i+1);
            subsetList.removeLast();
        }
    }

    public List<List<Integer>> permutation(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> permList = new ArrayList<Integer>();
        Arrays.sort(nums);
        backTrackPermutate(nums, permList, result);
        return result;
    }

    public void backTrackPermutate(int[] nums, List<Integer> permuteList, List<List<Integer>> result) {
        if(permuteList.size() == nums.length) {
            result.add(new ArrayList<>(permuteList));
        }
        // pass it with new ArrayList because, we are removing elements from
        // subsetlist but retain the listed added in the result.
        for(int i=0; i < nums.length; i++) {
            //if( i > index  && nums[i] == nums[i-1])  continue;
            if(permuteList.contains(nums[i])) continue;
            permuteList.add(nums[i]);
            backTrackPermutate(nums, permuteList, result);
            permuteList.removeLast();
        }
    }

    public Set<List<Integer>> targetSum(int[] nums, int target) {
        Set<List<Integer>> result = new HashSet<List<Integer>>();
        List<Integer> targetList = new ArrayList<Integer>();
        Arrays.sort(nums);
        backTrackTargetSum(nums, targetList, result, target, 0);
        return result;
    }

    public void backTrackTargetSum(int[] nums, List<Integer> targetSumList, Set<List<Integer>> result, int target, int index) {
        if(target < 0) return;
        else if(target == 0) {
            result.add(new ArrayList<>(targetSumList)); // new is needed else it will remove elements from result during recursive call.
            return;
        }else {

            // pass it with new ArrayList because, we are removing elements from
            // subsetlist but retain the listed added in the result.
            for (int i = index; i < nums.length; i++) {
                //if( i > index  && nums[i] == nums[i-1])  continue;
                //if(permuteList.contains(nums[i])) continue;
                targetSumList.add(nums[i]);
                backTrackTargetSum(nums, targetSumList, result, (target - nums[i]), i);
                targetSumList.remove(targetSumList.size() - 1);
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, target, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < nums.length; i++){
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1);
            }
        }
    }
    public boolean isPalindrome(String str, int start, int end){
        if(str.isEmpty()) return false;
        while(start < end) {
            if(!(str.charAt(start) == str.charAt(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public List<List<String>> combinationPalindrome(String input) {
        List<List<String>> list = new ArrayList<>();
        backtrackPalindrome(list, new ArrayList<>(), input, 0);
        return list;
    }

    private void backtrackPalindrome(List<List<String>> list, List<String> tempList, String input, int start){
        //aab
        if( start == input.length() && !tempList.isEmpty()) {
            list.add(new ArrayList<>(tempList));
        }

        for(int i=start; i < input.length(); i++){
            if(isPalindrome(input,start, i)){
                tempList.add(input.substring(start, i+1));
                backtrackPalindrome(list, tempList, input, i+1);
                if(!tempList.isEmpty() ) tempList.remove(tempList.size() - 1);
            }


        }

    }


    public List<List<String>>  palindormOptions(String str) {
        List<List<String>> palResult = new ArrayList<>();
        backTrackPal(str, palResult, new ArrayList<>(), 0);
        return palResult;
    }
    public void backTrackPal(String str, List<List<String>> result, List<String> tempResult, int index) {
        if(index  == str.length()) result.add(new ArrayList<>(tempResult));  // very important to add new Array as we remove it below for tempResult.
        if(str == null) return;
        for(int i =index; i < str.length() ; i++) {
            if(isPalinDrome1(str,index, i)) {
                tempResult.add(str.substring(index,i+1));
                backTrackPal(str, result, tempResult, i+1);
                tempResult.removeLast();
            }

        }
    }

    public boolean isPalinDrome1(String str, int start, int end){
        if(str.isEmpty()) return false;
        while (start <end) {
            if(str.charAt(start++) != str.charAt(end--) ) {
                return false;
            }
        }
        return  true;
    }



    public static void main(String[] args){
        BackTrackingSolutions bts = new BackTrackingSolutions();
        /*System.out.println((bts.generateSubsets(new int[] {1,2,2})).toString());
        System.out.println((bts.permutation(new int[] {1,2,3})).toString());
        System.out.println((bts.targetSum(new int[] {2,3,5}, 8)).toString());
        System.out.println((bts.combinationSum(new int[] {2,3,5}, 8)).toString()); */
        System.out.println(bts.combinationPalindrome("aab"));
        System.out.println(bts.palindormOptions("iTopiNonAvevanoNipoti"));


    }

}
