package home;

public class HappyNumber {
    public boolean isHappyNumber(int n) {
        do{
            char[] chars = String.valueOf(n).toCharArray();
            int sum = 0;
            for(char c : chars) {
                int digit = c - '0';
                sum = sum  +  digit * digit;
            }
            n = sum;
            System.out.println("Current n value " + n);
        } while(n > 9);
        return n == 1;
    }// 19

    public static void main(String[] args) {
        HappyNumber hn = new HappyNumber();
        System.out.println(hn.isHappyNumber(20));
    }
}
