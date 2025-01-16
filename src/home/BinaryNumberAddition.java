package home;

public class BinaryNumberAddition {
    // 1101 + 1100 = 1001

    public String addBinary(String str1, String str2) {
        int start = 0;
        int end1 = str1.length() -1;
        int end2 = str2.length() - 1;

        int carry = 0;
        StringBuilder strBuild = new StringBuilder();
        while(end1 >= 0 || end2 >=0) {
            int sum = carry;
            if(end1 >= 0) sum += str1.charAt(end1--) - '0';
            if(end2 >=0) sum += str2.charAt(end2--) - '0';
            carry = sum > 1 ? 1 : 0;
            strBuild.append(sum %2);
        }
        if(carry != 0) strBuild.append(carry);
        return strBuild.reverse().toString();
    }


    public static void main(String[] args) {
        BinaryNumberAddition bna = new BinaryNumberAddition();
        System.out.println(bna.addBinary("1101", "1100"));
    }

}
