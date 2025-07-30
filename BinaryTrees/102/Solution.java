import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.levelOrder(null);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> tree = new ArrayList<>();
        generateList(root, tree);
        return tree;
    }

    void generateList(TreeNode node, List<List<Integer>> tree) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.remove();
                temp.add(head.val);
                if (head.left != null) queue.add(head.left);
                if (head.right != null) queue.add(head.right);
            }
            tree.add(new ArrayList<>(temp));
        }
    }
}
