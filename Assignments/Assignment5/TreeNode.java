package Assignments.Assignment5;

public class TreeNode extends Node {
    TreeNode left;
    TreeNode right;
    
    public TreeNode() {
        super();
        left = null;
        right = null;
    }

    public TreeNode(int value) {
        super(value);
        left = null;
        right = null;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }
}
