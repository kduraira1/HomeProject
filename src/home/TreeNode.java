package home;

/**
 * Definition for a binary tree node. */
 public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
         this.right = right;
      }
    public void printTree(TreeNode node) {
        if (node == null) { return; }
        System.out.print(node.val + " ");
        printTree(node.left);
        printTree(node.right);
    }
 }
