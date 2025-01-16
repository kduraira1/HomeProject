package home;

import java.util.ArrayList;
import java.util.List;

public class FindTriplet {
    List<List<Integer>> getTriplets(int[] arr) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        int i =0;
        int j=0;
        int k =0;
        while(i < arr.length) {
            j= i+1;
            k = j + 1;
            while(k < arr.length) {
               if( arr[i] + arr[j] + arr[k] == 0) {
                   List<Integer> tripletList = new ArrayList<Integer>();
                   tripletList.add(arr[i]);
                   tripletList.add(arr[j]);
                   tripletList.add(arr[k]);
                   result.add(tripletList);
               }
                j++;
                k++;
            }
            i++;
        }
        return result;
    }

    boolean containsTriplet(int[] arr) {
        if (arr == null || arr.length < 3) {
            return false;
        }
        int i = Integer.MAX_VALUE;
        int j =  Integer.MAX_VALUE;
        int count = 0;
        while(count < arr.length) {
            if (arr[count] <= i) {
                i = arr[count];
            } else if (arr[count] <= j) {
                j = arr[count];
            } else {

                System.out.println( i + " " + j + " " + arr[count]);
                return true;
            }
            count ++;
        }
        return false;
    }
    public static void main(String[] args){
        FindTriplet ft = new FindTriplet();
        int[] arr = new int[] {-1,0,1,2,-1,-4};
        //int[] arr = new int[] {0,0,0};
        //int[] arr = new int[] {0,1,1};
        List<List<Integer>> result = ft.getTriplets(arr);
        System.out.println(result.toString());
        System.out.println(ft.containsTriplet(arr));

    }
}
