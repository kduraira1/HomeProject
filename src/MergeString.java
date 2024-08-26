public class MergeString {
    public static String merge(String str1, String str2){
        StringBuffer strBuff = new StringBuffer();
        int i;
        for( i=0; i < Math.min(str1.length(), str2.length()); i++) {
            strBuff.append(str1.charAt(i));
            strBuff.append(str2.charAt(i));
        }
        if((str1.length()) == i ) {
            strBuff.append(str2.substring(i));
        } else {
            strBuff.append(str1.substring(i));
        }

        return strBuff.toString();

    }


    public static void main(String[] args) {
        String str1 = "ABCDE";
        String str2 = "abcdeF";
        System.out.println(merge(str1, str2));
    }
}
