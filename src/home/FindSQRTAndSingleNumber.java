package home;

public class FindSQRTAndSingleNumber {
    // 16 = 4
    public int mySqrt(int x) {
        // For special cases when x is 0 or 1, return x.
        if (x == 0 || x == 1)
            return x;

        // Initialize the search range for the square root.
        int start = 1;
        int end = x;
        int mid = -1;

        // Perform binary search to find the square root of x.
        while (start <= end) {
            // Calculate the middle point using "start + (end - start) / 2" to avoid integer overflow.
            mid = start + (end - start) / 2;

            // If the square of the middle value is greater than x, move the "end" to the left (mid - 1).
            if ((long) mid * mid > (long) x)
                end = mid - 1;
            else if (mid * mid == x)
                // If the square of the middle value is equal to x, we found the square root.
                return mid;
            else
                // If the square of the middle value is less than x, move the "start" to the right (mid + 1).
                start = mid + 1;
        }

        // The loop ends when "start" becomes greater than "end", and "end" is the integer value of the square root.
        // However, since we might have been using integer division in the calculations,
        // we round down the value of "end" to the nearest integer to get the correct square root.
        return Math.round(end);
    }


    public int singleNumber(int[] nums) {
        int single = 0;
        for(int num : nums) {
            single ^= num; // 0^1 = 1;  1^1 = 0; 0^3 = 3
        }
        return  single;
    }
    // 48  1+ 47/2 = 24 1, 23

    public static void main(String[] args) {
        FindSQRTAndSingleNumber fsqrt = new FindSQRTAndSingleNumber();

        System.out.println(fsqrt.mySqrt(7));
        System.out.println(fsqrt.singleNumber(new int[] { 1,1,3,2,2}));
    }
}
