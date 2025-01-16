package home;

import java.util.Arrays;

// Logic is ... Divide and conquer.  Dived into two set and recursively go into small array. Then swap the elements.
public class MergeSort {
    public void mergeSort(int[] arr, int len) {
        if (len < 2) { // coz you can't divide into half if it's less than 2.
            return;
        }
        int[] left = new int[len/2];
        int[] right = new int[len/2];
        for(int i = 0; i < len/2; i ++) {
            left[i] = arr[i];
        }
        int index = 0;
        for(int i = len/2; i < len; i ++) {
            right[index++] = arr[i];
        }
        mergeSort(left, left.length);
        mergeSort(right, right.length);
        merge(arr, left, right, left.length, right.length);
    }

    public void merge(int[] arr, int[] left, int[] right, int leftSize, int rightSize) {
        int i = 0;
        int j = 0;
        int index = 0;
        while ( i < leftSize && j < rightSize) {
            if (left[i] < right[j]) {
                arr[index++] = left[i++];
            } else {
                arr[index++] = right[j++];
            }
        }
        while( i < leftSize) {
            arr[index++] = left[i++];
        }
        while( j < rightSize) {
            arr[index++] = right[j++];
        }
    }

    public static void main(String[] args){
        MergeSort ms = new MergeSort();
        int[] arr = new int[] {4,3,6,2,8,0,7,8};
        System.out.println(Arrays.toString(arr));
        ms.mergeSort(arr, 8);
        System.out.println(Arrays.toString(arr));
    }
}
