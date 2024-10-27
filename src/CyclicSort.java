import java.util.Arrays;

public class CyclicSort {
        public static void main(String[] args) {
            int[] arr = {3, 1, 5, 4, 2};
            cyclicSort(arr);
            for(int a : arr) {
                System.out.print(a +  " ");
            }
        }
        public static void cyclicSort(int[] arr) {
            for(int i = 0; i < arr.length; i++) {
                int correctIndex  = arr[i] - 1;
                if(arr[i] != arr[correctIndex]) {
                    int temp = arr[correctIndex];
                    arr[correctIndex] = arr[i];
                    arr[i] = temp;
                }
            }

        }
}

