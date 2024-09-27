import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Input: root = [3,9,20,null,null,15,7]
//Output: [[3],[9,20],[15,7]].
public class LevelOrderTraverse {


    public List<List<Integer>> levelOrderTraverse(TreeNode tree) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList();
        queue.add(tree);
        while(!queue.isEmpty() ) {
            List<Integer> levelList = new ArrayList<>();
            int levelSize = queue.size();
            while(levelSize > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                levelList.add(node.val);
                levelSize --;
            }
            result.add(levelList);
        }
        return  result;
    }


    //Input: root = [3,9,20,null,null,15,7]
    public static void main(String[] args) {
        LevelOrderTraverse lot = new LevelOrderTraverse();
        TreeNode right = new TreeNode(20, new TreeNode(15), new TreeNode(17));
        System.out.println(lot.levelOrderTraverse(new TreeNode(3, new TreeNode(9),right) ));

    }
}
