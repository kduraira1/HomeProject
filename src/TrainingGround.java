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

    //Implement Trie
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

    }
}
