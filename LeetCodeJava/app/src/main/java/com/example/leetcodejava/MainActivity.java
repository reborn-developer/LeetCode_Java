package com.example.leetcodejava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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


        List<String> list = new ArrayList<>(Arrays.asList("ale", "apple", "monkey", "plea"));
        List<String> lis2 = new ArrayList<>(Arrays.asList("a", "b", "c"));

        LeetCode524 leetCode524 = new LeetCode524();
//        leetCode524.findLongestWord("abpcplea", list);
        leetCode524.findLongestWord("abpcplea", lis2);

//        leetCode524.findLongestWord2("abpcplea", list);


    }
}
