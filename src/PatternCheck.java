import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PatternCheck {

    //Input: pattern = "abba", s = "dog cat cat dog"
      public boolean doesFollowPattern(String pattern, String input) {
          String[] splitString = input.split("\\s+");
          StringBuilder strBuild = new StringBuilder();
          for (String s : splitString) {
              strBuild.append(s.charAt(0));
          }
          String createdPattern = strBuild.toString();
          Map<Character, Integer> map1 = new HashMap<>();
          Map<Character, Integer> map2 = new HashMap<>();
          for (char c : pattern.toCharArray()) {
              map1.put(c, map1.getOrDefault(c, 0) + 1);

          }
          for (char c : createdPattern.toCharArray()) {
              map2.put(c, map2.getOrDefault(c, 0) + 1);

          }


         //return map1.values().equals(map2.values());
         for(int i = 0; i < map1.size();i++ ) {
             System.out.println(map1.get(pattern.charAt(i)));
             System.out.println(map2.get(createdPattern.charAt(i)));
             if (!map1.get(pattern.charAt(i)).equals(map2.get(createdPattern.charAt(i)))) {
                 return false;
             }
         }
         return true;
      }

    public boolean isIsomorphic (String s, String t){
        // Create arrays to store the index of characters in both strings
        int[] indexS = new int[26]; // Stores index of characters in string s
        int[] indexT = new int[26]; // Stores index of characters in string t

        // Get the length of both strings
        int len = s.length();

        // If the lengths of the two strings are different, they can't be isomorphic
        if (len != t.length()) {
            return false;
        }

        // Iterate through each character of the strings
        for (int i = 0; i < len; i++) {
            // Check if the index of the current character in string s
            // is different from the index of the corresponding character in string t
            if (indexS[s.charAt(i) - 'a'] != indexT[t.charAt(i) - 'a']) {
                return false; // If different, strings are not isomorphic
            }
            // Update the indices of characters in both strings
            indexS[s.charAt(i) - 'a'] = i + 1; // updating index of current character.. we are tracking position rather character count. Important.
            indexT[t.charAt(i) - 'a'] = i + 1; // updating index of current character
        }

        // If the loop completes without returning false, strings are isomorphic
        return true;
    }

    public static void main(String[] args) {
        PatternCheck pc = new PatternCheck();
        System.out.println( pc.doesFollowPattern("abba", "dog cat cat dog"));
        System.out.println(pc.isIsomorphic("abba", "dccd"));


    }

}
