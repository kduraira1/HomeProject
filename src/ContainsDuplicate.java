import java.util.Arrays;

public class ContainsDuplicate {
    public boolean hasDuplicate(int[] arr) {
        Arrays.sort(arr);
        for(int i =1; i < arr.length; i++) {
            if(arr[i] == arr[i-1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate cd = new ContainsDuplicate();
        int[] arr = new int[] { 1,3,4,5,3,6,3};
        System.out.println(Arrays.toString(arr));
        boolean dup = cd.hasDuplicate(arr);
        System.out.println(dup);
        System.out.println(Arrays.toString(arr));

    }

}
