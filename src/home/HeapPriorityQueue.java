package home;

import java.util.*;

public class HeapPriorityQueue {

    public int findKthLarge(int[] num, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // Sorts and keep the least on the top. is the core logic for heap.

        for(int i = 0; i < k; i ++) {
            pq.offer(num[i]);
        }
        for(int i = k; i < num.length; i++) {
            if(num[i] > pq.peek()) {
                pq.poll();
                pq.offer(num[i]);
            }
        }
        return pq.peek();

    }

    //K smallest pais.
    //nums1 = [1, 7, 11]
   // nums2 = [2, 4, 6]
   // k = 3  // out put....  [1,2][1,4] [1,6]

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        List<List<Integer>> result = new ArrayList<>();

        for(int i=0; i < Math.min(nums1.length, k); i++) {
            pq.offer(new int[] {nums1[i] + nums2[0], i, 0});
        }

        while( !pq.isEmpty() && k > 0) {
            int[] selectedArr = pq.poll();
            result.add(Arrays.asList(nums1[selectedArr[1]], nums2[selectedArr[2]]));
            k--;
            if(selectedArr[2] + 1 < nums2.length) {
                pq.offer(new int[] { nums1[selectedArr[1]] + nums2[selectedArr[2]+1], selectedArr[1], selectedArr[2] + 1});
            }
        }

        return  result;
    }
    public static void main(String[] args) {
        HeapPriorityQueue hp = new HeapPriorityQueue();
        System.out.println(hp.findKthLarge(new int[] { 3,2,3,1,2,4,5,5,6}, 4));
        System.out.println(hp.kSmallestPairs(new int[] { 1, 7, 11}, new int[] {2, 4, 6}, 3));
        int[][] matrix = { {1, 2, 3}, {4, 5} };

        int x = matrix[1][0];  // 4
        // [[1, 2, 3], [4, 5]]
        System.out.println(Arrays.deepToString(matrix));
        HashMap hashMap = new HashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        hashMap.put(3, 3);
        hashMap.put(4, 4);

        hashMap.forEach((key,value) ->{
            String msg = "key : " + key + " value : " + value;
            System.out.println(msg);
        });

    }
}
