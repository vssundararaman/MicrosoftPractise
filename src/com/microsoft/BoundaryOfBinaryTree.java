package com.microsoft;

import com.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BoundaryOfBinaryTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode (1);
        root.right = new TreeNode (2);
        root.right.left = new TreeNode (3);
        root.right.right = new TreeNode (4);

        System.out.println (boundaryOfBinaryTree (root));

    }

    static List<Integer> boundaryOfBinaryTree(TreeNode root) {

        List<Integer> result = new ArrayList<> ();

        if (root == null) {
            return result;
        }
        result.add (root.val);
        leftBoundary (root.left,result);
        leaves (root.left,result);
        leaves (root.right,result);
        rightBoundary (root.right,result);
        return result;
    }

    static void leftBoundary(TreeNode root, List<Integer> result) {
        if (root == null || (root.left == null && root.right == null)) return;
        result.add (root.val);
        if(root.left == null) leftBoundary (root.right,result);
        else leftBoundary (root.left,result);
    }

    static void rightBoundary(TreeNode root, List<Integer> result){
        if(root ==null || (root.left == null && root.right == null)) return;
        result.add (root.val);
        if(root.right == null) rightBoundary (root.left,result);
        else rightBoundary (root.right,result);
    }

    static void leaves(TreeNode root, List<Integer> result){
        if(root == null) return;
        if(root.left == null && root.right ==null){
            result.add (root.val);
            return;
        }
        leaves (root.left,result);
        leaves (root.right,result);
    }
}
