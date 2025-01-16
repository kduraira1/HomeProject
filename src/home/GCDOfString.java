package home;

public class GCDOfString
{
    //Greatest Common Denominator
    public String gcd(String str1, String str2) {
        // Check if concatenated strings are equal or not, if not return ""
        if (!(str1 + str2).equals(str2 + str1))
            return "";
        int index = findGCD(str1.length(), str2.length());
        return str1.substring(0, index);
    }

    public int findGCD(int a, int b) {
       return b == 0 ? a : findGCD(b, a % b);
    }

    public static void main(String[] args) {
        GCDOfString gcdString = new GCDOfString();
        System.out.println(gcdString.gcd("ABCABC", "AB"));
    }
}