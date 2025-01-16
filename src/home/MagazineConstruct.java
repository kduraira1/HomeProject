package home;

import java.util.ArrayList;
import java.util.List;

public class MagazineConstruct {

    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        int[] alphabets_counter = new int[26];

        for (char c : magazine.toCharArray())
            alphabets_counter[c-'a']++;

        for (char c : ransomNote.toCharArray()){
            if (alphabets_counter[c-'a'] == 0) return false;
            alphabets_counter[c-'a']--;
        }
        return true;
    }

    public boolean canConstruct1(String ransomNote, String magazine) {
        List<Character> list1 = new ArrayList<>();
        for(char c : magazine.toCharArray()) {
            list1.add(Character.valueOf(c));
        }

        for(char c : ransomNote.toCharArray()) {
            if(!list1.isEmpty() && list1.contains(c)) {
                list1.remove(Character.valueOf(c));
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        MagazineConstruct mc = new MagazineConstruct();
        //System.out.println(mc.canConstruct("aa", "aab"));
        System.out.println(mc.canConstruct1("aa", "aab"));

    }
}
