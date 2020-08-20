package com.example.leetcodejava.Algorithm.Search.BFS;

import android.graphics.Point;

import java.util.LinkedList;
import java.util.Queue;

// BFS 广度优先搜索
// 广度优先搜索一层一层地进行遍历，每层遍历都是以上一层遍历的结果作为起点
// 遍历一个距离能访问到的所有节点。需要注意的是，遍历过的节点不能再次被遍历。
public class LeetCode1091 {
    /**
     * LeetCode1091.二进制矩阵中的最短路径(计算在网格中从原点到特定点的最短路径长度)   Medium
     *
     * 在一个 N × N 的方形网格中，每个单元格有两种状态：空（0）或者阻塞（1）。
     *
     * 一条从左上角到右下角、长度为 k 的畅通路径，由满足下述条件的单元格 C_1, C_2, ..., C_k 组成：
     *
     * 相邻单元格 C_i 和 C_{i+1} 在八个方向之一上连通（此时，C_i 和 C_{i+1} 不同且共享边或角）
     * C_1 位于 (0, 0)（即，值为 grid[0][0]）
     * C_k 位于 (N-1, N-1)（即，值为 grid[N-1][N-1]）
     * 如果 C_i 位于 (r, c)，则 grid[r][c] 为空（即，grid[r][c] == 0）
     * 返回这条从左上角到右下角的最短畅通路径的长度。如果不存在这样的路径，返回 -1 。
     *
     * 示例 1：
     * 输入：[[0,1],[1,0]]
     * 输出：2
     *
     * 示例 2：
     * 输入：[[0,0,0],[1,1,0],[1,1,0]]
     * 输出：4
     *
     * 提示：
     * 1 <= grid.length == grid[0].length <= 100
     * grid[i][j] 为 0 或 1
     */

    /**
     * 解题思路
     * （1）BFS的问题一般都会选用队列方式实现；
     * （2）代码模板如下：
     *
     * void BFS()
     * {
     *     定义队列;
     *     定义备忘录，用于记录已经访问的位置；
     *
     *     判断边界条件，是否能直接返回结果的。
     *
     *     将起始位置加入到队列中，同时更新备忘录。
     *
     *     while (队列不为空) {
     *         获取当前队列中的元素个数。
     *         for (元素个数) {
     *             取出一个位置节点。
     *             判断是否到达终点位置。
     *             获取它对应的下一个所有的节点。
     *             条件判断，过滤掉不符合条件的位置。
     *             新位置重新加入队列。
     *         }
     *     }
     * }
     *
     *  在二维平面上，八个方向可以进行移动，使用int[][] directions表示八个方向
     *  二维平面常规做法，使用函数boolean inGrid(int x, int y)判断某个点是否在矩形范围内
     *
     *  循环结束后，可能是搜索完成但没有到达右下角，此时grid[row - 1][col - 1] == 0；
     *  也可能是已经找到到达右下角的路径，按BFS，此时grid[row - 1][col - 1]即为答案。
     *  所以最后返回grid[row - 1][col - 1] == 0 ? -1 : grid[row - 1][col - 1];
     */

    private int[][] directions = {{0,1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {-1, -1}, {-1, 0}, {-1, 1}};

    private int row,col;

    public int shortestPathBinaryMatrix(int[][] grid) {
        row =grid.length;
        col =grid[0].length;
        if (grid[0][0]==1||grid[row-1][col-1]==1)
            return -1;
        Queue<int[]> queue=new LinkedList<>();
        grid[0][0]=1;//直接用grid进行记录,按照题意 起点也有长度1
        queue.add(new int[]{0,0});//将左上角的初始点加入队列
        while (!queue.isEmpty() && grid[row - 1][col - 1] == 0) {
            int[] prePoint = queue.remove();//上一个经过的点
            int preLength=grid[prePoint[0]][prePoint[1]];//截止到上一个点，当前的总长度
            for (int i=0;i<8;i++){
                int newX = prePoint[0]+directions[i][0];
                int newY = prePoint[1]+directions[i][1];
                if (isGrid(newX,newY)&&grid[newX][newY]==0){
                    grid[newX][newY] = preLength+1;
                    queue.add(new int[]{newX, newY});
                }
            }
        }
        return grid[row-1][col-1]==0?-1:grid[row-1][col-1];
    }

    private boolean isGrid(int x,int y){//是否在区域内
        return x>=0&&x<row&&y>=0&&y<col;
    }
}

