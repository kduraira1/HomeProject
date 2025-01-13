package Mockup;

public class CapOneFind3elements {
    public int mySolution(int[] patterns, int target) {
        int count = 0;
        for (int i =0; i < patterns.length; i++) {
            if( (i +2) < patterns.length) {
                if((patterns[i] > target)  &&
                        (patterns[i + 1] > target) &&
                                (patterns[i + 2] > target)) {
                            count++;
                }
            }
        }

        return count;
    }


    public static void main(String[] args) {

        int[] patterns = new int[] {1,3,5,7,10,11, 12};
        int target = 3;

        CapOneFind3elements CFf3e = new CapOneFind3elements();
        System.out.println(CFf3e.mySolution(patterns, target));

    }
}
