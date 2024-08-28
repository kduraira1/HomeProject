import java.util.Arrays;
// Refer coding practice page for better coding.
public class CompressLetters {
    public int updateArray(char[] charArr){
        int count = 0;
        int index = 0;
        //char ch = charArr[0];
        if(charArr.length == 1) return 1;
        for (int i = 0; i < charArr.length -1; i++) {
           if(charArr[i] == charArr[i+1]) {
               count++;
           } else {
               count++;
               charArr[index++] = charArr[i];
               if(count > 1) {
                   String countStr = String.valueOf(count);
                   for(int j = 0; j < countStr.length(); j++) {
                       charArr[index++] = countStr.charAt(j);
                   }
               }
               count = 0;
           }

        }
        if(count > 1) {
            count++;
            charArr[index++] = charArr[charArr.length -1];
            String countStr = String.valueOf(count);
            for(int j = 0; j < countStr.length(); j++) {
                charArr[index++] = countStr.charAt(j);
            }
        }
        return index;
    }

    public static void main(String[] args) {
        CompressLetters cl = new CompressLetters();
        //char[] charArr = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        char[] charArr = {'a'};
        //char[] charArr = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        System.out.println(cl.updateArray(charArr));
        System.out.println(Arrays.toString(charArr));
    }
}
