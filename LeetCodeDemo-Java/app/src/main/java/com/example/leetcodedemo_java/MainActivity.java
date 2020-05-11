package com.example.leetcodedemo_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LeetCode14 leetCode14 = new LeetCode14();
        leetCode14.testLeedtCode14();
    }

}


