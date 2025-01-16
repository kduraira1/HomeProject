package home;

class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}


public class QuadTree {


    public Node generateQuadTree(int[][] nums, int i, int j, int w) {
        if(isAllNodeSame(nums, i, j, w)) {
            return new Node(nums[i][j] == 0 ? false : true, true);
        }
        Node node = new Node(true, false);
        node.topLeft = generateQuadTree(nums,i,j, w/2);
        node.topRight = generateQuadTree(nums,i,j+w/2, w/2);
        node.bottomLeft = generateQuadTree(nums,i+w/2, j, w/2);
        node.bottomRight = generateQuadTree(nums,i+w/2, j+w/2, w/2);
        return node;
    }

    public boolean isAllNodeSame(int[][] nums, int i, int j, int w) {
        for(int x=i; x < i+w; x++) {
            for(int y = j; y < j+w; y++) {
                if(nums[x][y] != nums[i][j] ) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        QuadTree qt = new QuadTree();
        int[][] grid = new int[][] {
                        {1,1,1,1,0,0,0,0},
                        {1,1,1,1,0,0,0,0},
                        {1,1,1,1,1,1,1,1},
                        {1,1,1,1,1,1,1,1},
                        {1,1,1,1,0,0,0,0},
                        {1,1,1,1,0,0,0,0},
                        {1,1,1,1,0,0,0,0},
                        {1,1,1,1,0,0,0,0}};
        Node node = qt.generateQuadTree(grid,0,0,grid.length);


        System.out.println(node.isLeaf + "  " +  node.val);

    }

}
