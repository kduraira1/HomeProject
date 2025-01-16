package home;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrainingGround {
    Trie root = new Trie();

    public  List<List<String>> palindromeGeneration(String palString) {
        List<List<String>> resultSet = new ArrayList<>();
        backTrack_1(resultSet, new ArrayList<>(), palString, 0);

        return resultSet;
    }
    public void backTrack_1(List<List<String>> resultSet, List<String> tempResult, String palStr, int index ) {
        if(index == palStr.length() ) {
            resultSet.add(new ArrayList<>(tempResult));
        } else {
            for (int i = index; i < palStr.length(); i++) {
                if (isPalindrome(palStr, index, i)) {
                    tempResult.add(palStr.substring(index, i + 1));
                    backTrack_1(resultSet, tempResult, palStr, i + 1);
                    // tempResult.remove(tempResult.size() - 1);
                    tempResult.removeLast();

                }
            }
        }

    }

    public boolean isPalindrome(String str, int start,  int end) {
        while(start < end) {
            if(str.charAt(start++) != str.charAt(end--)) return false;
        }
        return true;
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

    public String reverString(String str) {
        StringBuilder strRev = new StringBuilder();
        for(int i = str.length() -1; i >= 0; i --) {
            strRev.append(str.charAt(i));
        }
        return strRev.toString();
    }

    public String removeDuplicate(String str) {
        if (str == null) return str;
        StringBuilder strRev = new StringBuilder();
        strRev.append(str.charAt(0));
        for(int i = 1; i < str.length(); i++) {
            if(Character.toLowerCase(str.charAt(i-1) ) != Character.toLowerCase(str.charAt(i))) {
                strRev.append(str.charAt(i));
            }
        }

        return strRev.toString();
    }

    public void quickSort(int[] arr) {
        for(int i=0; i < arr.length; i++) {
            if(arr[i] != i+1) {
                int temp = arr[i];
                int index = arr[i] -1;
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }
        for(int a : arr) {
            System.out.println(a);
        }
    }
// find all subsets.
    public List<List<Integer>> findAllSubsets(int[] arr) {
        List<List<Integer>> resultSet = new ArrayList<List<Integer>>();
        List<Integer> tempResult = new ArrayList<>();
        generateSubSets(resultSet, tempResult, arr, 0);
        return resultSet;

    }

    public void generateSubSets(List<List<Integer>> resultSet, List<Integer> tempResult, int[] arr, int index) {
        resultSet.add(new ArrayList<>(tempResult));
        for(int i = index; i < arr.length; i++) {
            if(tempResult.contains(arr[i])) continue;
            tempResult.add(arr[i]);
            generateSubSets(resultSet,tempResult, arr, i+1 );
            tempResult.remove(tempResult.size() -1);
        }
    }

    //Implement home.Trie
    class Trie {
        Trie[] children;
        boolean endOfWord;
        Trie() {
            children = new Trie[26];
            endOfWord = false;
        }
    }

    public void addElement(String word) {
        Trie TrieInsert = root;
        for(int i = 0; i < word.length(); i++) {
            if(TrieInsert.children[word.charAt(i) - 'a'] == null) {
                TrieInsert.children[word.charAt(i) - 'a'] = new Trie();
            }
            TrieInsert = TrieInsert.children[word.charAt(i) - 'a'];
        }
        TrieInsert.endOfWord = true;
    }
    public boolean search(String word) {
        Trie TrieInsert = root;
        for(int i = 0; i < word.length(); i++) {
            if(TrieInsert.children[word.charAt(i) - 'a'] == null) {
                return false;
            }
            TrieInsert =  TrieInsert.children[word.charAt(i) - 'a'];
        }
        return TrieInsert.endOfWord;
    }

    public boolean searchPrefix(String word) {
        Trie TrieInsert = root;
        for(int i = 0; i < word.length(); i++) {
            if(TrieInsert.children[word.charAt(i) - 'a'] == null) {
                return false;
            }
            TrieInsert = TrieInsert.children[word.charAt(i) - 'a'];
        }
        return true;
    }
    public void printDictionary(Trie lroot, int index) {
        Trie printObj = lroot;
        if(printObj.endOfWord) {
            System.out.println(".");
            index = 0;
            //return;
        }
        for(int i = index; i < printObj.children.length -1; i ++) {
            if(printObj.children[i] != null) {
                System.out.print( (char) (i + 'a'));
                printDictionary(printObj.children[i], 0);
            }
        }
    }

    public int findMinimumCoins(int[] coins, int amount) {
        // 1,3,5,7,10  & 75
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, amount + 1);
        memo[0]  = 0;
        for(int i = 1; i <= amount; i++) {
            for(int j = 0; j < coins.length; j++) {
                if(i - coins[j] >= 0) {
                   // if (i - coins[j] <= i) {
                        memo[i] = Math.min(1 + memo[i - coins[j]], memo[i]);
                    /*} else {
                        memo[i] = memo[i - coins[j]];
                    } */
                }
            }
        }
        System.out.println(Arrays.toString(memo));
        return memo[amount];

    }

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


    public List<List<String>> palindromeBT(String palStr) {
        List<List<String>> result = new ArrayList<>();
        palBackTrack(result, new ArrayList<String>(), palStr,0);
        return result;
    }

    void palBackTrack(List<List<String>> result, List<String> tempList, String palStr, int start) {
        if(start == palStr.length()) {
            result.add(new ArrayList<>(tempList));
            return;
        } else {
            for(int i = start; i < palStr.length(); i++) {
                if(isPalinD(palStr,start, i) ){
                    tempList.add(palStr.substring(start, i+1));
                    palBackTrack(result, tempList, palStr, i+1);
                    //tempList.removeLast();
                    tempList.remove(tempList.size() -1 );
                }
            }
        }
    }

    public boolean isPalinD(String palStr, int start, int end) {
        while( start < end) {
            if(palStr.charAt(start++) != palStr.charAt(end--)) return false;
        }
        return true;
    }

    public void mergeStringAlt(String str1, String str2) {
        StringBuilder strB = new StringBuilder();
        int min = Math.min(str1.length(), str2.length());

        for(int i = 0; i < min; i++) {
            strB.append(str1.charAt(i));
            strB.append(str2.charAt(i));
        }

         if(min == str1.length()) {
             strB.append(str2.substring(min));
         } else { strB.append(str1.substring(min));}

        System.out.println(strB.toString());

    }

    public void reverseVowels(String str) {
        //Using String Builder
        StringBuilder reversed = new StringBuilder();
        StringBuilder reversed1 = new StringBuilder();

        int start = 0;
        int end = str.length() -1;
//"myamyemyo"
        while( start <= end) {
          while(!isVowel(str.charAt(start)) && start < str.length()) {
            reversed.append(str.charAt(start++));
           }
            while(!isVowel(str.charAt(end)) && end >=0) {
                reversed1.append(str.charAt(end--));
            }
            if(start <end) {
                reversed1.append(str.charAt(start++));
                reversed.append(str.charAt(end--));
            } else if (start == end) {
                reversed.append(str.charAt(start++));
           }

        }
        String rev = reverString(reversed1.toString());
        System.out.println( reversed.append(rev));

        // Using Character array
    }
    // Function to swap characters at index x andk , bxzkv'kjeczx

    public String reverseVowels1(String s) {
        int start = 0;
        int end  = s.length() - 1;
        // Convert String to char array as String is immutable in Java
        char[] sChar = s.toCharArray();

        // While we still have characters to traverse
        while (start < end) {
            // Find the leftmost vowel
            while (start < s.length () && !isVowel(sChar[start])) {
                start++;
            }
            // Find the rightmost vowel
            while (end >= 0 && !isVowel(sChar[end])) {
                end--;
            }
            // Swap them if start is left of end
            if (start < end) {
                swap(sChar, start++, end--);
            }
        }

        // Converting char array back to String
        return new String(sChar);
    }
    public boolean isVowel(char c) {
        return  c == 'a' ||  c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
        c == 'A' ||  c == 'E' || c == 'I' || c == 'O' || c == 'U' ? true : false;
    }

    // Function to swap characters at index x and y
    void swap(char[] chars, int x, int y) {
        char temp = chars[x];
        chars[x] = chars[y];
        chars[y] = temp;
    }

    // FInd Triplet ( I < J<K) -

    public boolean findTriplet(int[] nums) {
       int count = 0;
       int i = Integer.MAX_VALUE;
       int j = Integer.MAX_VALUE;
       while(count < nums.length) {
           if(nums[count] <= i) {
               i = nums[count];
           } else if (nums[count] <= j) {
               j = nums[count];
           } else {
               System.out.println( "Triplet exist : " + " i=" + i + ", j= " + j + ", k= " + nums[count]);
               return true;
           }
           count++;
       }
       return false;
    }

    //Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
    // such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

    public List<List<Integer>> findThreeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i= 0; i < nums.length; i++) {
           if (i > 0 && nums[i] == nums[i-1]) {
               System.out.println("Skipping ... " + nums[i] +  "  " + nums[i-1]);
                continue;
            }
            int j = i + 1;
            int k = nums.length -1;
            while( j < k) {
                int total = nums[i] + nums[j] + nums[k];
                if(total < 0) {
                    j++;
                } else if ( total > 0) {
                    k--;
                } else {
                    System.out.println("Found the triplet : "  + nums[i] + " " + nums[j] + " " + nums[k]);
                    //List<Integer> triplet = new ArrayList<>();
                    //triplet.add(nums[i]);triplet.add(nums[j]);triplet.add(nums[k]);
                    result.add( Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    while (nums[j] == nums[j-1] && j < k) {
                        j++;
                    }

                }
            }
        }

        return result;
    }

    // Remove Duplicate from Sorted List
   public ListNode removeDuplicateNode(ListNode head) {

        home.ListNode dummy = new home.ListNode();
        //dummy.next = new ListNode();
        home.ListNode result = dummy;
        if(head == null || head.next == null) {
            return head;
        }
        while(head !=null) {
            if(head.next != null && head.val == head.next.val) {
                while(head.next != null && head.val == head.next.val) {
                    head= head.next;
                }
                result.next = head.next;
            } else {
                head = head.next;
            }
        }
        return dummy.next;
        //return null;

    }

    public TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if(inStart > inEnd || postStart > postEnd ){
            return null;
        }
        int rootValue = postorder[postEnd];
        TreeNode root = new TreeNode(rootValue);
        int rootIndex = 0;
        for(int i =inStart; i <= inEnd; i++) {
            if(rootValue == inorder[i]) {
                rootIndex = i;
                break;
            }
        }
        if (rootIndex == -1 ){
            System.out.println("unable to find root index from in order list");
            return null;
        }
        int leftSize = rootIndex - inStart;
        int rightSize = inEnd - rootIndex;
        root.left = buildTree(inorder, inStart, rootIndex-1, postorder, postStart, postStart + leftSize -1);
        root.right = buildTree(inorder,rootIndex+1, inEnd, postorder, postEnd - rightSize, postEnd -1);
        return root;

    }

    public static void main(String[] args){
        TrainingGround tg = new TrainingGround();
        System.out.println(tg.palindromeGeneration("aab"));
        //System.out.println(tg.palindormOptions("aab"));
        //System.out.println(tg.palindromeGeneration("iTopiNonAvevanoNipoti"));
        //System.out.println(tg.palindromeGeneration("iTopiNonAvevanoNipoti"));
        System.out.println(tg.reverString("My test String"));
        System.out.println(tg.removeDuplicate("MMy tesSt Strriing"));
        tg.quickSort(new int[] { 4,2,3,1,5,8,9,6,10,7});
        System.out.println(tg.findAllSubsets(new int[] { 1,2,3,4}).toString());
        tg.addElement("test");
        tg.addElement("testt");
        tg.addElement("book");
        tg.addElement("radar");
        tg.addElement("abcd");
        System.out.println(tg.search("test"));
        System.out.println(tg.search("tes"));
        System.out.println(tg.searchPrefix("tes"));
        System.out.println(tg.searchPrefix("abc"));
        tg.printDictionary(tg.root,0);
        // 1,3,5,7,10  & 75 - coin change..minimum coin
        int[] coins = new int[] {1,3,5,7,10};
        System.out.println(tg.findMinimumCoins( coins, 75));
        System.out.println(tg.minimumCoinDP( coins, 75));
        System.out.println(tg.palindromeBT("iTopiNonAvevanoNipoti"));
        System.out.println(tg.palindromeGeneration("iTopiNonAvevanoNipoti"));
        tg.mergeStringAlt("Hello", "test");
        tg.reverseVowels("myamyemyo");
        System.out.println(tg.reverseVowels1("myamyemyo"));
        tg.reverseVowels("aeiou");
        System.out.println(tg.reverseVowels1("aeiou"));
        System.out.println(tg.findTriplet(new int[] { 4,2,3,1,5,8,9,6,10,7}));
        System.out.println(tg.findThreeSum(new int[] {-1,0,1,2,-1,4}));
        home.ListNode l1 = new home.ListNode(2,new home.ListNode(2, new home.ListNode(3, new home.ListNode(4, null))));
        home.ListNode result = tg.removeDuplicateNode(l1);
        while(result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
       TreeNode treenNode = tg. buildTree(new int[]{9,3,15,20,7},0,4,new int[]{9,15,7,20,3}, 0, 4);
        System.out.println();
        treenNode.printTree(treenNode);


    }
}
