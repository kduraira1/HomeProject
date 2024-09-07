import java.util.*;

public class Anagrams {
    public boolean isAnagram(String str1, String str2) {
        if(str1.length() != str2.length()) return false;
        char[] chars1 = str1.toCharArray();
        Arrays.sort(chars1);
        String sortedStr1 = Arrays.toString(chars1);
        char[] chars2 = str2.toCharArray();
        Arrays.sort(chars2);
        String sortedStr2 = Arrays.toString(chars2);
        System.out.println( "Str 1 " + sortedStr1 + " str 2 " + sortedStr2);
        return sortedStr1.equals(sortedStr2);

    }

    public boolean isAnagram1(String str1, String str2) {
        if(str1.length() != str2.length()) return false;
        List<Character> list = new ArrayList<>();
        for(char c : str1.toCharArray()) {
            list.add(Character.valueOf(c));
        }
        System.out.println( list.toString());
        for(char c : str2.toCharArray()) {
            list.remove(Character.valueOf(c));
        }
        System.out.println(list.size());
        return (list.size() == 0) ;

    }
    public List<List<String>> findAnagramList(String[] anas) {
        List<List<String>> result = new ArrayList<List<String>>();
        HashMap<String, List<String>> anaMap = new HashMap<>();
        for (String str : anas) {
            char[] charArr = str.toString().toCharArray();
            Arrays.sort(charArr);
            String sorted = Arrays.toString(charArr);
            if(anaMap.containsKey(sorted)) {
                anaMap.get(sorted).add(str);
            } else {
                List<String> list = new ArrayList<String>();
                list.add(str);
                anaMap.put(sorted, list);
            }
        }
        for(List<String> list : anaMap.values()) {
            result.add(list);
        }

        return result;

    }

    // alternate better way

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);

            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }

            map.get(sortedWord).add(word);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args){
        Anagrams ana = new Anagrams();
        System.out.println(ana.isAnagram1("anagram", "nagaram"));
        String[] strArr = new String[] {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> result = ana.findAnagramList(strArr);
        System.out.println(result);
    }
}
