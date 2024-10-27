import com.sun.source.tree.Tree;

/*
Input: root = [3,9,20,null,null,15,7]
Output: 3
*/
public class BinaryTreeTraverse {
    public int depthOfBinaryTree( TreeNode root) {
        if (root == null) return 0;
        return 1+Math.max(depthOfBinaryTree(root.left),depthOfBinaryTree(root.right));

    }
    public int depthOfBinaryTree1( TreeNode root) {
        if (root == null) return 0;
        int lhs = 1 + depthOfBinaryTree(root.left);
        int rhs = 1 + depthOfBinaryTree(root.right);
        return Math.max(lhs,rhs);

    }

    public boolean isSymmetric(TreeNode node) {
        if(node == null) return true;
        return recursive(node.left, node.right);
    }

    public boolean recursive(TreeNode node1, TreeNode node2) {
        if(node1 == null && node2 == null) return true;
        if(node1 == null || node2 == null) {
            return false;
        }
        return node1.val == node2.val && recursive(node1.left, node2.right) && recursive(node1.right, node2.left);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if(root.left == null & root.right == null && root.val == targetSum) {
            return true;
        }
        boolean left = hasPathSum(root.left, targetSum - root.val);
        boolean right = hasPathSum(root.right, targetSum - root.val);
        return left || right;
    }

    public TreeNode buildBST(int[] nums, int low, int high) {
        if(low > high) return null;
        int mid = low + (high - low) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBST(nums, low, mid-1);
        root.right = buildBST(nums, mid+1,high);
        return root;
    }

    /*A leaf node is a node with no children.
    //Input: root = [1,2,3]
    //Output: 25 */

    public int treeSum(TreeNode node) {
        return treeSum(node, 0);
    }

    public int treeSum(TreeNode node, int count) {
        if(node == null) return 0;
        count = count * 10 + node.val;
        if(node.left == null && node.right == null) return count;
        return treeSum(node.left, count) +  treeSum(node.right, count);
    }

    public void printTree(TreeNode node) {
        if (node == null) { return; }
        System.out.print(node.val + " ");
        printTree(node.left);
        printTree(node.right);
    }
    public static void main(String[] args) {
        BinaryTreeTraverse btt = new BinaryTreeTraverse();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println("Depth 1 : " + btt.depthOfBinaryTree(root));
        System.out.println("depth 2: " + btt.depthOfBinaryTree1(root));

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);
        root1.right.left = new TreeNode(4);
        root1.right.right = new TreeNode(3);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(4);
        System.out.println(btt.isSymmetric(root1));
        System.out.println(btt.hasPathSum(root1,7));
        TreeNode resultNode = btt.buildBST(new int[] { 1,2,3,4,5,6}, 0,5);
        btt.printTree(resultNode);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        System.out.println("\n" + btt.treeSum(root1));
    }
}
