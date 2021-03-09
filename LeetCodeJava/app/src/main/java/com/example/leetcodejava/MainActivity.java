package com.example.leetcodejava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.leetcodejava.Algorithm.BinarySearch.LeetCode34;
import com.example.leetcodejava.Algorithm.GreedyAlgorithm.LeetCode763;
import com.example.leetcodejava.Algorithm.Search.BFS.LeetCode1091;
import com.example.leetcodejava.Algorithm.Sort.BubbleSort;
import com.example.leetcodejava.Algorithm.Sort.BucketSort;
import com.example.leetcodejava.Algorithm.Sort.CountSort;
import com.example.leetcodejava.Algorithm.Sort.HeapSort;
import com.example.leetcodejava.Algorithm.Sort.LeetCode75;
import com.example.leetcodejava.Algorithm.Sort.QuickSort;
import com.example.leetcodejava.DataStructure.BinaryHeap;
import com.example.leetcodejava.DataStructure.LinkedList.MyLinkedList;
import com.example.leetcodejava.DataStructure.Tree.BinaryTree;
import com.example.leetcodejava.DataStructure.Tree.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        LeetCode14 leetCode14 = new LeetCode14();
//        leetCode14.testLeedtCode14();
//
//        LeetCode520 leetCode520 = new LeetCode520();
//        leetCode520.detectCapitalUse("TesT");

//        LeetCode5 leetCode5 = new LeetCode5();
//        leetCode5.longestPalindrome1("babad");
//        leetCode5.longestPalindrome1("cbbd");
//        leetCode5.longestPalindrome2("babad");

//        LeetCode521 leetCode521 = new LeetCode521();
//        leetCode521.findLUSlength("aba", "cdc");

//        String[] target = {"aba","cbc","eae"};
//        LeetCode522 leetCode522 = new LeetCode522();
//        leetCode522.findLUSlength(target);

//        String[] caseStrs = {"aba", "cdc", "eae"};
//        String[] caseStrs = {"bd", "e", "abc", "ab", "abc"};
//        LeetCode522 leetCode522 = new LeetCode522();
//        leetCode522.findLUSlength(caseStrs);

//        LeetCode6 leetCode6 = new LeetCode6();
//        leetCode6.convert("LEETCODEISHIRING", 3);
//        leetCode6.convert("LEETCODEISHIRING", 4);


//        List<String> list = new ArrayList<>(Arrays.asList("ale", "apple", "monkey", "plea"));
//        List<String> lis2 = new ArrayList<>(Arrays.asList("a", "b", "c"));
//        LeetCode524 leetCode524 = new LeetCode524();
//        leetCode524.findLongestWord("abpcplea", list);
//        leetCode524.findLongestWord("abpcplea", lis2);
//        leetCode524.findLongestWord2("abpcplea", list);


//        int[] arr = {1,2,4,7,10,11,7,12,6,7,16,18,19};
//        LeetCode16 leetCode16 = new  LeetCode16();
//        leetCode16.subSort(arr);

//        int[] array = {3,0,6,1,5};
//        LeetCode274 leetCode274 = new LeetCode274();
//        leetCode274.hIndex(array);

//        LeetCode147 leetCode147 = new LeetCode147();
//        leetCode147.insertionSortList(leetCode147.testCaseNode());

//        LeetCode148 leetCode148 = new LeetCode148();
//        leetCode148.sortList(leetCode148.testCaseNode());

//        int[] arr = {3, 30, 34, 5, 9};
//        LeetCode179 leetCode179 = new LeetCode179();
//        leetCode179.largestNumber(arr);

//        int[] arr = {3,2,4,1};
////        LeetCode969 leetCode969 = new LeetCode969();
////        leetCode969.pancakeSort(arr);

//        LeetCode970 leetCode970 = new LeetCode970();
//        leetCode970.powerfulIntegers(2, 3, 10);

//        int[] num1 = {1,2,2,1};
//        int[] num2 = {2,2};
//        LeetCode350 leetCode350 = new LeetCode350();
////        leetCode350.intersect(num2, num1);
//        leetCode350.intersect2(num2, num1);

//        int[] num1 = {1,2,2,1};
//        int[] num2 = {2,2};
//        LeetCode349 leetCode349 = new LeetCode349();
//        leetCode349.intersection(num1, num2);

//        LeetCode242 leetCode242 = new LeetCode242();
//        leetCode242.isAnagram("anagram", "nagaram");


//        int[] num = {-10, -3, 0 , 5, 9};
//        LeetCode108 leetCode108 = new LeetCode108();
//        leetCode108.sortedArrayToBST(num);

//        LeetCode32 leetCode32 = new LeetCode32();
//        leetCode32.longestValidParentheses(")()())");

//        LeetCode44 leetCode44 = new LeetCode44();
//        leetCode44.isMatch("adceb", "*a*b");

//        int[] a = {8,7,6,5,4,3,2,1};
//        QuickSort.quickSort(a, 0, 7);

//        double[] b = {4.12, 6.421, 0.0023, 3.0, 2.123,8.122, 4.12};
//        BucketSort.bucketSort(b);

//        int[] num = {2,0,1,0,2,1,1};
//        LeetCode75 leetCode75 = new LeetCode75();
//        leetCode75.sortColors(num);

//        LeetCode763 leetCode763 = new LeetCode763();
//        leetCode763.char2Index('a');

//        int[] num = {5,7,7,8,8,10};
//        LeetCode34 leetCode34 = new LeetCode34();
//        leetCode34.searchRange(num, 8);


//        int[] array = {5,8,6,3,9,2,1,7};
//        BubbleSort.bubbleSort(array);
//        System.out.println(array);
//
//        BubbleSort.bubbleSort2(array);
//        System.out.println(array);

//        BubbleSort.bubbleSort3(array);
//        System.out.println(array);


//        int[] array = new int[] {1,3,2,6,5,7,8,9,10,0};
//        System.out.println(Arrays.toString(array));
//        BinaryHeap.upAdjust(array);
//        System.out.println(Arrays.toString(array));
//
//        array = new int[] {7,1,3,10,5,2,8,9,6};
//        System.out.println(Arrays.toString(array));
//        BinaryHeap.buildHeap(array);
//        System.out.println(Arrays.toString(array));

//
//        int[] array = new int[] {1,3,2,6,5,7,8,9,10,0};
//        System.out.println(Arrays.toString(array));
//        HeapSort.heapSort(array);
//        System.out.println(Arrays.toString(array));

//        int[] array = new int[]{4,4,6,5,3,2,8,1,7,5,6,0,10};
//        int[] sortedArray = CountSort.countSort(array);
//        System.out.println(Arrays.toString(sortedArray));


//        LinkedList<Integer> inputList = new LinkedList<Integer>(Arrays.asList(new Integer[]{3,2,9,null,null,10,null,null,8,null,4}));
//        LinkedList<Integer> inputList = new LinkedList<Integer>(Arrays.asList(new Integer[]{1,2,3,4,5,null,6}));
//
//        TreeNode treeNode = BinaryTree.createBinaryTree(inputList);
//        System.out.println("前序遍历:");
//        BinaryTree.preOrderTraveral(treeNode);
//
//        System.out.println("中序遍历:");
//        BinaryTree.inOrderTraveral(treeNode);
//
//        System.out.println("后序遍历:");
//        BinaryTree.postOrderTraveral(treeNode);
//
//        System.out.println("前序遍历非递归:");
//        BinaryTree.preOrderTraveralWithStack(treeNode);



        testLinkedList();

    }

    public static void testLinkedList() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.insert(3,0);
        myLinkedList.insert(7,1);
        myLinkedList.insert(9,2);
        myLinkedList.insert(5,3);
        myLinkedList.insert(6,1);
        myLinkedList.remove(0);
        myLinkedList.output();
    }
}

