package Mockup;

import java.util.ArrayList;
import java.util.List;

public class CapOneAddRemoveFindPair {

    public int mySolution(String[] query, int diff) {
        return findPairsCount(getNumbersList(query), diff);
    }

    public List<Integer> getNumbersList(String[] query) {
        List<Integer> numbers = new ArrayList<>();
        for (String q : query) {
            if(q.charAt(0) =='+') {
                numbers.add(Integer.parseInt(q.substring(1)));
            } else if(q.charAt(0) == '-') {
                numbers.remove(Integer.valueOf(Integer.parseInt(q.substring(1))));
            } else {
                System.out.println("Invalid input and skip it");
            }
        }
        System.out.println(numbers);
        return numbers;
    }

    public int findPairsCount(List<Integer> numbers, int diff) {
        int result = 0;
        for(int i =0; i < numbers.size(); i++) {
            for (int j=0;j < numbers.size(); j++)  {
                if( i == j) continue;
                if((numbers.get(i) - numbers.get(j)) == diff) {
                    result++;
                }

            }
        }
        System.out.println(result);
        return result;
    }
    public static void main(String[] args) {

        String[] query = new String[] {"+4", "+5", "+6", "+6","-6", "+8"};
        int diff = 2;

        CapOneAddRemoveFindPair cofp = new CapOneAddRemoveFindPair();
        System.out.println(cofp.mySolution(query, diff));

    }
}
