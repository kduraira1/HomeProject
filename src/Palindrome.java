public class Palindrome {
    public boolean isPalindrome(int pal) {
        int pal1 = pal;
        int rev = 0;
        while(pal !=0) {
            rev =  rev *10 + pal %10;
            pal = pal / 10;
        }
        System.out.println(rev);
        return rev == pal1;
    }

    public static void main(String[] args) {
        Palindrome pal = new Palindrome();
        System.out.println(pal.isPalindrome(124521));
    }
}
