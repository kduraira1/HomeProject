package home;

import java.util.Arrays;

public class BinarySearch {

    public String findElement(int[] arr, int target, int start, int end) {
        if ( start > end) return "Match not found";
        int mid  = (int) Math.floor( (end+start)/ 2 );

        if(arr[mid] == target) {
            return "Match found " + mid;
        }
        if(arr[mid] > target) {
            return findElement(arr, target, start, mid-1);
        }
        if (arr[mid] < target) {
            return findElement(arr, target,mid+1 , end);
        }
        return " match not found";
    }
    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int[] arr = new int[] {4, 3, 6, 2, 8, 0, 7, 8};
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(bs.findElement(arr, 8, 0, 8));
    }
}
