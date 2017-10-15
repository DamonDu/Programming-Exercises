/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.Queue;
import java.util.LinkedList;

//非迭代实现
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> p_queue = new LinkedList<TreeNode>();
        Queue<TreeNode> q_queue = new LinkedList<TreeNode>();
        TreeNode p_temp, q_temp;
        p_queue.offer(p);
        q_queue.offer(q);
        while(!p_queue.isEmpty() && !q_queue.isEmpty()) {
        	p_temp = p_queue.poll();
        	q_temp = q_queue.poll();
        	if (p_temp == null && q_temp == null) {//都为空的情况单独判断
        		continue;
        	}
        	if (p_temp == null || q_temp == null) {//前一个if已排除了两者都为空的情况
        		return false;
        	}
        	if (p_temp.val != q_temp.val) {
        		return false;
        	}
        	else {
        		p_queue.offer(p_temp.left);
        		p_queue.offer(p_temp.right);
        		q_queue.offer(q_temp.left);
        		q_queue.offer(q_temp.right);
        	}
        }
        return true;
    }
}

/*
迭代实现
public boolean isSameTree(TreeNode p, TreeNode q) {
    if(p == null && q == null) return true;
    if(p == null || q == null) return false;
    if(p.val == q.val)
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    return false;
}
 */