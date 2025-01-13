package Mockup;

public class CapOneFindTargetSubstring {
    public int mySolution(String[] patterns, int target) {
        int result = 0;

        for(String pattern : patterns) {
            result += checkStringForTarget(pattern, target);
        }
        return result;
    }

    public int checkStringForTarget(String pattern, int target) {
        int count = 0;
        char intChar;
        for(int i = 0; i < pattern.length(); i ++)
        {
            if( (i+1) < pattern.length() && pattern.charAt(i) == pattern.charAt(i + 1)) {
                intChar = pattern.charAt(i);
                count++;
            }
        }
        if(count > 0) count++;
        if (count == target) System.out.println(pattern);
        return count == target ? 1: 0;
    }


    public static void main(String[] args) {

        String[] patterns = new String[] {"efaaag", "efaaaa", "eaaaah", "skdfubbbe","asdfawe", "kkkjklk"};
        int target = 3;

        CapOneFindTargetSubstring CFTS = new CapOneFindTargetSubstring();
        System.out.println(CFTS.mySolution(patterns, target));

    }
}
