package home;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
// Remember only Objects array ( STring[] ) can be converted as list using Arrays. For primitive types you have to do as below

public class ArrayToList {
    public static <T> List<T> convertArrayToList(T array[])
    {

        // Create an empty List
        List<T> list = new ArrayList<>();

        // Iterate through the array
        for (T t : array) {
            // Add each element into the list
            list.add(t);
        }

        // Return the converted List
        return list;
    }
    public static void main(String[] args) {
        int[] intArray = {1, 2, 3, 4, 5};

        // Method 1: Using Arrays.stream() and boxed()
        List<Integer> list1 = Arrays.stream(intArray)
                .boxed()
                .collect(Collectors.toList());

        // Method 2: Using for loop
        List<Integer> list2 = new ArrayList<>();
        for (int num : intArray) {
            list2.add(num);
        }

        System.out.println(list1);
        System.out.println(list2);

        // Create an Array
        String array[]
                = { "Geeks", "forGeeks", "A Computer Portal" };

        // Print the Array
        System.out.println("Array: "
                + Arrays.toString(array));

        // convert the Array to List
        List<String> list = convertArrayToList(array);

        // Print the List
        System.out.println("List: " + list);
    }
}