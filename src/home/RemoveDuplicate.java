package home;

import java.util.Arrays;

public class RemoveDuplicate {
    public void removeDuplicate(int[] arr) {
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int count = 1;
        for(int i =1; i < arr.length; i++) {
            if(arr[i] != arr[i-1]) {
               arr[count++] = arr[i];
            }
        }
        while(count < arr.length) {
            arr[count++] = 0;
        }
    }

    public static void main(String[] args) {
        RemoveDuplicate rd = new RemoveDuplicate();
        int[] arr = new int[] { 1,3,4,5,3,6,3};
        System.out.println(Arrays.toString(arr));
        rd.removeDuplicate(arr);
        System.out.println(Arrays.toString(arr));

    }
}
