package com.example.leetcodejava.Algorithm.DivideAndConquer;

import java.util.ArrayList;
import java.util.List;

public class LeetCode241 {
    /**
     *  LeetCode241.为运算表达式设计优先级   Medium
     *
     *  给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。
     *  你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。
     *
     *  示例 1:
     *  输入: "2-1-1"
     *  输出: [0, 2]
     *  解释:
     *  ((2-1)-1) = 0
     *  (2-(1-1)) = 2
     *
     *  示例 2:
     *  输入: "2*3-4*5"
     *  输出: [-34, -14, -10, -10, 10]
     *  解释:
     *  (2*(3-(4*5))) = -34
     *  ((2*3)-(4*5)) = -14
     *  ((2*(3-4))*5) = -10
     *  (2*((3-4)*5)) = -10
     *  (((2*3)-4)*5) = 10
     */

    /**
     * 分治算法：
     * 思路：
     *
     * 例如以 2 * 3 - 4 * 5 为例。
     * 2 和 3 - 4 * 5 两部分，中间是 * 号相连。
     * 2 * 3 和 4 * 5 两部分，中间是 - 号相连。
     * 2 * 3 - 4 和 5 两部分，中间是 * 号相连。
     * 有了两部分的结果，然后再通过中间的符号两两计算加入到最终的结果中即可。
     *
     * 因此此题需要考虑分割的位置
     * 运用分治处理每个运算符分割的左右两部分，每次的步骤用递归直接带入处理即可
     *
     * 创建了 3 个函数帮助解决问题：
     * 找运算符
     * 计算运算符左右两个元素
     * 判断是否找到了这三种运算符
     */
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ans = new ArrayList<>();
        if (input == null || input.length() == 0) {
            return ans;
        }

        // 定义寻找运算符的索引
        int divIndex = findNextOperator(input, 0);
        // 如果运算符索引达到了字符串尾（出口情况），一个运算符，直接返回
        if (divIndex == input.length()) {
            ans.add(Integer.parseInt(input));
            return ans;
        }

        // 若有多个运算符，则挨个遍历
        while (divIndex < input.length()) {
            // 取出当前运算符
            char c = input.charAt(divIndex);
            List<Integer> leftNums = diffWaysToCompute(input.substring(0, divIndex));
            List<Integer> rightNums = diffWaysToCompute(input.substring(divIndex + 1));
            for (int left : leftNums) {
                for (int right : rightNums) {
                    ans.add(caculate(left, right, c));
                }
            }
            // 运算符索引移动到下一个运算符位置
            divIndex = findNextOperator(input, divIndex + 1);
        }
        return ans;
    }

    // 带上运算符进行 + - * 运算
    private int caculate(int left, int right, int operator) {
        int ans = 0;
        switch(operator) {
            case '+' : ans = left + right;
                break;
            case '-' : ans = left - right;
                break;
            case '*' : ans = left * right;
                break;
        }
        return ans;
    }

    // 找下一个运算符
    private int findNextOperator(String input, int start) {
        int index = start;
        while (index < input.length() && !isOperator(input.charAt(index))) {
            index++;
        }
        return index;
    }

    // 判断是否为以下三种运算符
    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*';
    }

}
