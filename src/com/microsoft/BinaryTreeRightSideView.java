package com.microsoft;

import com.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Input: [1,2,3,null,5,null,4]
 * Output: [1, 3, 4]
 * Explanation:
 * <p>
 * 1            <---
 * /    \
 * 2     3         <---
 * \      \
 * 5       4        <---
 */
public class BinaryTreeRightSideView {

    public static void main(String[] args) {

        TreeNode root = new TreeNode (1);
        root.left = new TreeNode (2);
        root.left.right = new TreeNode (5);
        root.right = new TreeNode (3);
        root.right.right = new TreeNode (4);

        System.out.println (rightSideView (root));

        System.out.println (rightSideView1 (root));
    }

    static List<Integer> rightSideView(TreeNode root) {
        List<Integer> visibleValues = new ArrayList<> ();

        if (root == null) {
            return visibleValues;
        }

        Queue<TreeNode> queue = new LinkedList<> ();
        queue.add (root);

        while (!queue.isEmpty ()) {
            int size = queue.size ();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.remove ();
                if(i == size-1){
                    visibleValues.add (current.val);
                }

                if(current.left!=null){
                    queue.add (current.left);
                }

                if(current.right!=null){
                    queue.add (current.right);
                }
            }
        }

        return visibleValues;
    }

    static List<Integer> rightSideView1(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        doRight(root,0,res);

        return res;
    }

    static void doRight(TreeNode root , int level , List<Integer> res)
    {
        if(root==null)
        {
            return;
        }

        if(res.size()==level)
        {
            res.add(root.val);
        }

        doRight(root.right,level+1,res);
        doRight(root.left,level+1,res);

    }
}
