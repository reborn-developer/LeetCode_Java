package com.example.leetcodejava.DataStructure.Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树
 * https://www.bilibili.com/video/BV1sN411Q7yV?p=24
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
 * 2、广度优先遍历（层序遍历）)
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
     *  @param head 二叉树节点
     */
    public static void preOrderTraveral(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.println(head.data);
        preOrderTraveral(head.leftChild);
        preOrderTraveral(head.rightChild);
    }


    /**
     * 2、中序遍历(递归)
     * 二叉树的中序遍历，输出顺序是左子树、根节点、右子树。
     * @param head 二叉树节点
     */
    public static void inOrderTraveral(TreeNode head) {
        if (head == null) {
            return;
        }
        inOrderTraveral(head.leftChild);
        System.out.println(head.data);
        inOrderTraveral(head.rightChild);
    }

    /**
     * 3、二叉树后序遍历(递归)
     * 二叉树的后序遍历，输出顺序是左子树、右子树、根节点。
     * @param head 二叉树节点
     */
    public static void postOrderTraveral(TreeNode head) {
        if (head == null) {
            return;
        }
        postOrderTraveral(head.leftChild);
        postOrderTraveral(head.rightChild);
        System.out.println(head.data);
    }

    /**
     * 绝大多数可以用递归解决的问题，其实都可以用另一种数据结构来解决，这种数据结构就是栈 。因为递归和栈都有回溯的特性。
     * 如何借助栈来实现二叉树的非递归遍历呢？
     */


    /** 4、前序遍历（非递归)
     * 二叉树的前序遍历，输出顺序是根节点、左子树、右子树
     * @param  head 二叉树根节点
     * 1、弹出打印
     * 2、如有右边，压入右
     * 3、如有左边，压入左
     */
    public static void preWithStack(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.push(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.println(head.data);
                if (head.rightChild != null) {
                    stack.push(head.rightChild);
                }
                if (head.leftChild != null) {
                    stack.push(head.leftChild);
                }
            }
        }
    }

    /**
     * 5、中序遍历(非递归)
     * 二叉树的中序遍历，输出顺序是左子树、根节点、右子树。
     *
     *  @param  head 二叉树根节点
     *  1、整条左边界，依次入栈
     *  2、 1条件无法继续，弹出节点并打印，然后来到弹出节点的右树继续执行条件1
     */
    public static void inWithStack(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> stack = new Stack<TreeNode>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.leftChild;
                } else {
                    head = stack.pop();
                    System.out.println(head.data + "");
                    head = head.rightChild;
                }
            }
        }
    }

    /**
     * 6.1、二叉树后序遍历(非递归)
     * 二叉树的后序遍历，输出顺序是左子树、右子树、根节点。
     * @param head 二叉树节点
     *
     * 1、弹收集
     * 2、如有左，压入左
     * 3、如有右，压入右
     */
    public static void postWithStack(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> stack1 = new Stack<TreeNode>();
            Stack<TreeNode> stack2 = new Stack<TreeNode>(); // 辅助用来收集
            stack1.push(head);
            while (!stack1.isEmpty()) {
                head = stack1.pop();
                stack2.push(head);

                if (head.leftChild != null) {
                    stack1.push(head.leftChild);
                }
                if (head.rightChild != null) {
                    stack1.push(head.rightChild);
                }
            }

            while (!stack2.isEmpty()) {
                System.out.println(stack2.pop().data + "");
            }
        }
    }

    /**
     * 6.2、二叉树后续遍历（非递归) 优化版
     */
    public static void postWithStack2(TreeNode h) {
        if (h != null) {
            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.push(h);
            TreeNode c = null;
            while (!stack.isEmpty()) {
                c = stack.peek();
                if (c.leftChild != null && h != c.leftChild && h != c.rightChild) {
                    stack.push(c.leftChild);
                } else if (c.rightChild != null && h != c.rightChild) {
                    stack.push(c.rightChild);
                } else {
                    System.out.println(stack.pop().data + "");
                    h = c;
                }
            }
        }
    }



    /**
     * 7、二叉树层序遍历
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

    /**
     * 8、求二叉树的最大宽度 (使用Map)
     */
    public static int maxWidthUserMap(TreeNode head) {
        if (head == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        // key在哪一层，value
        HashMap<TreeNode, Integer> levelMap = new HashMap<>();
        levelMap.put(head, 1);

        int curLevel = 1; // 当前你正在统计哪一层的宽度
        int curLevelNodes = 0; // 当前层curLevel层,宽度目前是多少
        int max = 0;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            int curNodeLevel = levelMap.get(cur);
            if (cur.leftChild != null) {
                levelMap.put(cur.leftChild, curNodeLevel + 1);
                queue.add(cur.leftChild);
            }
            if (cur.rightChild != null) {
                levelMap.put(cur.rightChild, curNodeLevel + 1);
                queue.add(cur.rightChild);
            }

            if (curNodeLevel == curLevel) {
                curLevelNodes++;
            } else {
                max = Math.max(max, curLevelNodes);
                curLevel++;
                curLevelNodes = 1;
            }
        }
        max = Math.max(max, curLevelNodes);
        return max;
    }


    /**
     * 二叉树的序列化
     * 1、可以先用先序或者中序或者后序或者按层遍历，来实现二叉树的序列化
     * 2、用了什么方式序列化，就用什么样的方式反序列化
     */

    /**
     * 9.二叉树序列化-先序
     */
    public static Queue<String> preSerial(TreeNode head) {
        Queue<String> queue = new LinkedList<>();
        pres(head, queue);
        return queue;
    }

    public static void pres(TreeNode head, Queue<String> queue) {
        if (head == null) {
            queue.add(null);
        } else {
            queue.add(String.valueOf(head.data));
            pres(head.leftChild, queue);
            pres(head.rightChild, queue);
        }
    }

    /**
     * 10.二叉树反序列化-先序
     */
    public static TreeNode buildByPreQueue(Queue<String> preList) {
        if (preList == null || preList.size() == 0) {
            return null;
        }
        return preb(preList);
    }

    public static TreeNode preb(Queue<String> preList) {
        String value = preList.poll();
        if (value == null) {
            return null;
        }
        TreeNode head = new TreeNode(Integer.valueOf(value));
        head.leftChild = preb(preList);
        head.rightChild = preb(preList);
        return head;
    }


    /**
     * 11.二叉树序列化-按层序列化
     */
    public static Queue<String> levelSerial(TreeNode head) {
        Queue<String> ans = new LinkedList<>();
        if (head == null) {
            ans.add(null);
        } else {
            ans.add(String.valueOf(head.data));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(head);
            while (!queue.isEmpty()) {
                head = queue.poll();
                if (head.leftChild != null) {
                    ans.add(String.valueOf(head.leftChild.data));
                    queue.add(head.leftChild);
                } else {
                    ans.add(null);
                }
                if (head.rightChild != null) {
                    ans.add(String.valueOf(head.rightChild.data));
                    queue.add(head.rightChild);
                } else {
                    ans.add(null);
                }
            }
        }
        return ans;
    }


    /**
     * 12.二叉树反序列化-按层
     */
    public static TreeNode buildByLevelQueue(Queue<String> levelList) {
        if (levelList == null || levelList.size() == 0) {
            return null;
        }
        TreeNode head = generateNode(levelList.poll());
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (head != null) {
            queue.add(head);
        }
        TreeNode node = null;
        while (!queue.isEmpty()) {
            node = queue.poll();
            node.leftChild = generateNode(levelList.poll());
            node.rightChild = generateNode(levelList.poll());
            if (node.leftChild != null) {
                queue.add(node.leftChild);
            }
            if (node.rightChild != null) {
                queue.add(node.rightChild);
            }
        }
        return head;
    }

    public static  TreeNode generateNode(String val) {
        if (val == null) {
            return null;
        }
        return new TreeNode(Integer.valueOf(val));
    }
}
