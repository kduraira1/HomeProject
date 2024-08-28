import java.util.Arrays;

public class RemoveElement {
    public int updateArray(int[] arr, int removeElement) {
        int index = 0;
        for( int val : arr) {
            if(val != removeElement) {
                arr[index++] = val;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        RemoveElement re = new RemoveElement();
        int[] arr = new int[] { 1,3,4,5,3,6,3};
        System.out.println(Arrays.toString(arr));
        int count = re.updateArray(arr, 3);
        System.out.println(count);
        System.out.println(Arrays.toString(arr));

    }
}
