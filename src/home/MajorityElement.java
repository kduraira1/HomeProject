package home;

import java.util.Arrays;

public class MajorityElement {
    public int findMajorityElement(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length/2];
    }

    public static void main(String[] args) {
        MajorityElement me = new MajorityElement();
       System.out.println( me.findMajorityElement(new int[] {2,2,1,1,1,2,2}));

    }
}
