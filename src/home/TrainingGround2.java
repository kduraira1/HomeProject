package home;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class TrainingGround2 {

    ///Find K Pairs with Smallest Sums

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) ->a[0]-b[0]);
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        for(int i =0; i < Math.min(k, nums1.length); i++) {
            pq.add(new int[] { nums1[i] + nums2[0], i, 0});
        }
        int count = 0;
        while( count < k) {
            int[] smallpair = pq.poll();
            result.add(Arrays.asList(nums1[smallpair[1]], nums2[smallpair[2]]));
            count++;
            if(count < k && smallpair[2] + 1 < nums2.length) {
                pq.offer(new int[] {nums1[smallpair[1]] + nums2[smallpair[2]+1],
                smallpair[1], smallpair[2] + 1});
            }
        }
        return result;
    }

    //Tree node path sum

    public int treePathSum(TreeNode root, int pathSum) {
        if(root == null) {
            return 0 ;
        }
        pathSum = 10 * pathSum + root.val;
        System.out.println(pathSum);
        if(root.left == null && root.right == null)
            return pathSum;
        return treePathSum(root.left, pathSum) + treePathSum(root.right, pathSum);

    }

    public boolean symetric(TreeNode root) {
        return symDFS(root.left, root.right);
    }

    public boolean symDFS(TreeNode node1, TreeNode node2) {
        if(node1 == null & node2 == null) return true;
        if(node1 == null || node2 == null) return false;
        return node1.val == node2.val && symDFS(node1.left, node2.right) &&
                symDFS(node1.right, node2.left);
    }

    public boolean hasPathSum(TreeNode node1, int targetSum) {
        if(node1 == null) {
            return false;
        }
        if(node1.left == null && node1.right == null) {
            return targetSum == node1.val;
        }
        return  hasPathSum(node1.left, targetSum - node1.val)  || hasPathSum(node1.right, targetSum - node1.val);
    }
    public static void main(String[] args) {
        TrainingGround2 tg2 = new TrainingGround2();
        List<List<Integer>> result = tg2.kSmallestPairs(new int[] {1,7,11 }, new int[] {2,4,6}, 3);
        for(List<Integer> list : result) {
            System.out.println(list.toString());
        }
        /* nums1 = [1, 7, 11]
        nums2 = [2, 4, 6]
        k = 3 */
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(tg2.treePathSum(root, 0));
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);
        root1.right.left = new TreeNode(4);
        root1.right.right = new TreeNode(3);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(4);
        System.out.println(tg2.symetric(root1));
        System.out.println(tg2.hasPathSum(root1, 7)); // true
        System.out.println(tg2.hasPathSum(root1, 9)); // false



    }
}
