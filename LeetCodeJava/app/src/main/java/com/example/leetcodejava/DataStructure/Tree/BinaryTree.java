package com.example.leetcodejava.DataStructure.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树
 *
 * 二叉树的遍历方式
 * 从节点之间位置关系的角度来看，二叉树的遍历分为4种。
 * 1. 前序遍历。
 * 2. 中序遍历。
 * 3. 后序遍历。
 * 4. 层序遍历。
 *
 * 从更宏观的角度来看，二叉树的遍历归结为两大类。
 * 1. 深度优先遍历（前序遍历、中序遍历、后序遍历)。
 * 2、广度优先遍历（层序遍历)
 */
public class BinaryTree {

    /**
     *  构建二叉树
     *  @param inputList 输入序列
     */
    public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        TreeNode node = null;

        if (inputList == null || inputList.isEmpty()) {
            return null;
        }

        Integer data = inputList.removeFirst();
        if (data != null) {
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(inputList);
            node.rightChild = createBinaryTree(inputList);
        }
        return node;
    }

    /**
     * 1、前序遍历(递归)
     * 二叉树的前序遍历，输出顺序是根节点、左子树、右子树。
     *
     *  @param node 二叉树节点
     */
    public static void preOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        preOrderTraveral(node.leftChild);
        preOrderTraveral(node.rightChild);
    }


    /**
     * 2、中序遍历(递归)
     * 二叉树的中序遍历，输出顺序是左子树、根节点、右子树。
     * @param node 二叉树节点
     */
    public static void inOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraveral(node.leftChild);
        System.out.println(node.data);
        inOrderTraveral(node.rightChild);
    }

    /**
     * 3、二叉树后序遍历(递归)
     * 二叉树的后序遍历，输出顺序是左子树、右子树、根节点。
     * @param node 二叉树节点
     */
    public static void postOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraveral(node.leftChild);
        postOrderTraveral(node.rightChild);
        System.out.println(node.data);
    }

    /**
     * 绝大多数可以用递归解决的问题，其实都可以用另一种数据结构来解决，这种数据结构就是栈 。因为递归和栈都有回溯的特性。
     * 如何借助栈来实现二叉树的非递归遍历呢？
     */

    /**
     * 1、前序遍历(非递归)
     * 二叉树的前序遍历，输出顺序是根节点、左子树、右子树。
     *
     *  @param  root 二叉树根节点
     */
    public static void preOrderTraveralWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode treeNode = root;

        while (treeNode != null || !stack.isEmpty()) {
            // 迭代访问节点的左孩子，并入栈
            while (treeNode != null) {
                System.out.println(treeNode.data);
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }

            // 如果节点没有左孩子，则弹出栈顶节点，访问节点右孩子
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.rightChild;
            }
        }
    }

    /**
     * 二叉树层序遍历
     * @param root 二叉树根节点
     *
     * 二叉树同一层次的节点之间是没有直接关联的，如何实现这种层 序遍历呢？
     * 这里同样需要借助一个数据结构来辅助工作，这个数据结构就是队列
     */
    public static void levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.data);

            if (node.leftChild != null) {
                queue.offer(node.leftChild);
            }
            if (node.rightChild != null) {
                queue.offer(node.rightChild);
            }
        }

    }




}
