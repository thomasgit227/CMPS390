package Assignments.Assignment5;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class BinaryTree {

    TreeNode root;
    
    public BinaryTree() {
        root = null;
    }

    public BinaryTree(int value) {
        root = new TreeNode(value);
    }

    public BinaryTree(TreeNode root) {
        this.root = root;
    }

    public TreeNode makeTreeNode(int value) {
        return new TreeNode(value);
    }

    public void addNodeToTree(int value) {
        TreeNode curr = root;

        if(root == null) {
            root = makeTreeNode(value);
        }
        else {
            boolean isSearching = true;
            while(isSearching) {
                //Go Left
                if(value < curr.getValue()) {
                    if(curr.left != null) {
                        curr = curr.left;
                    }
                    else {
                        isSearching = false;
                        curr.left = makeTreeNode(value);
                    }
                }
                //Go Right
                else if(value > curr.getValue()) {
                    if(curr.right != null) {
                        curr = curr.right;
                    }
                    else {
                        isSearching = false;
                        curr.right = makeTreeNode(value);
                    }
                }
                //Equal Values
                else {
                    isSearching = false;
                }
            }
            
        }
    }

    public int addNodeToTreeTrackingComparisons(int value) {
        TreeNode curr = root;
        int comparisons = 0;

        if(root == null) {
            comparisons++;
            root = makeTreeNode(value);
        }
        else {
            boolean isSearching = true;
            while(isSearching) {

                comparisons += 2; //Check Left AND Right (Technically in this code, im checking 3 times)
                //Go Left
                if(value < curr.getValue()) {
                    if(curr.left != null) {
                        curr = curr.left;
                    }
                    else {
                        isSearching = false;
                        curr.left = makeTreeNode(value);
                    }
                }
                //Go Right
                else if(value > curr.getValue()) {
                    if(curr.right != null) {
                        curr = curr.right;
                    }
                    else {
                        isSearching = false;
                        curr.right = makeTreeNode(value);
                    }
                }
                //Equal Values
                else {
                    isSearching = false;
                }
            }    
        }
        return comparisons;
    }

    public void addNodesFromFile(String path) throws IOException {
        File file = new File(path);
        Scanner scanner = new Scanner(file); 
        int comparisons = 0;
        while (scanner.hasNextLine()) {
            int nextInt = scanner.nextInt();
            comparisons += addNodeToTreeTrackingComparisons(nextInt);
        }
        scanner.close();
        System.out.printf("The Tree has been Created, and %d Comparisons were Made\n", comparisons);

    }

    public void printInOrder(TreeNode curr) {
        if (curr.left != null) {
            printInOrder(curr.left);
        }
        curr.print();
        if (curr.right != null) {
            printInOrder(curr.right);
        }
    }
}
