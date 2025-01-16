package home;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NextGreaterElement {

        public static void main(String[] args) {
            int[] arr = {4, 8, 5, 2, 9, 1};

            int[] result = findNextGreaterElements(arr);

            System.out.println("Original array: " + Arrays.toString(arr));
            System.out.println("Next greater elements: " + Arrays.toString(result));
            List<Integer> list2 = new ArrayList<>();
            for (int num : arr) {
                list2.add(num);
            }

            Collections.sort(list2);
            list2.forEach( (i)-> System.out.println(i));

        }

        public static int[] findNextGreaterElements(int[] arr) {
            int[] result = new int[arr.length];
            Arrays.fill(result, -1); // Initialize with -1

            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] > arr[i]) {
                        result[i] = arr[j];
                        break; // Move to the next element once a greater element is found
                    }
                }
            }

            return result;
        }
    }
