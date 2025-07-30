import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {
        TreeNode iterator = root;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> output = new ArrayList<>();
        stack.push(iterator);
        while (!stack.isEmpty()) {
            TreeNode head = stack.pop();
            output.add(head.val);
            if(head.left != null) stack.add(head.left);
            if(head.right != null) stack.add(head.right);
        }
        return output;
    }
}
