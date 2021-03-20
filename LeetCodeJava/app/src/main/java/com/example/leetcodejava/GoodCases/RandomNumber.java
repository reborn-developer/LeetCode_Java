package com.example.leetcodejava.GoodCases;

/**
 *  等概率随机数
 *  https://www.bilibili.com/video/BV1sN411Q7yV?p=3
 */
public class RandomNumber {
    /**
     *  1、给你一个随机数f，等概率返回1-5中的一个数字，这是你唯一可以利用的随机机制，如何实现等概率返回1~7中的一个数字
     */

    // 此函数只能用，不能修改
    // 等概率返回1-5
    public static int f() {
        return (int)(Math.random() * 5) + 1;
    }


    // 等概率得到0和1
    public static int a() {
        int ans = 0;
        do {
            ans = f();
        } while (ans == 3);
        return ans < 3 ? 0 : 1;
    }

    // 等概率返回0-6
    public static int b() {
        int ans = 0;
        do {
            ans = (a() << 2) + (a() << 1) + (a() << 0);
        } while (ans == 7);
        return ans;
    }

    // 等概率返回1-7
    public static int c() {
        return b() + 1;
    }

    public static void test1() {
        int[] count = new int[8]; // 0 1 2 ... 7
        int testTime = 10000000;
        for (int i = 0; i < testTime; i++) {
            int ans = c();
            count[ans]++;
        }
        for (int i = 0 ; i < 8; i++) {
            System.out.println(i + ":" + count[i]);
        }
    }

    /**
     *  2、给你一个随机数f2，等概率返回7-13中的一个数字，这是你唯一可以利用的随机机制，如何实现等概率返回26~39中的一个数字
     */
    // 此函数只能用，不能修改
    // 等概率返回7-13
    public static int f2() {
        return b() + 7;// 此处应该写一个随机的
    }

    // 等概率得到0和1
    public static int d() {
        int ans = 0;
        do {
            ans = f2();
        } while (ans == 10);
        return ans < 10 ? 0 : 1;
    }

    // 等概率返回0-13
    public static int e() {
        int ans = 0;
        do {
            ans = (d() << 3) + (d() << 2) + (d() << 1) + (d() << 0);
        } while (ans == 14 || ans == 15);
        return ans;
    }

    // 等概率返回26-39
    public static int g() {
        return e() + 26;
    }

    public static void test2() {
        for (int i = 0 ; i < 8; i++) {
            System.out.println(i + ":" + g());
        }
    }

    /**
     *  3、给你一个随机数f，等概率返回a-b中的一个数字，这是你唯一可以利用的随机机制，如何实现等概率返回c~d中的一个数字
     */


    /**
     *  4、给你一个随机数f4，以p概率返回0，以1-p概率返回1，这是你唯一可以利用的随机机制，如何实现等概率0和1
     */
    // 此函数只能用，不能修改
    // 内部内容不可见
    public static int f4() {
        return Math.random() < 0.92 ? 0 : 1;
    }

    // 等概率返回0和1
    public static int l() {
        int first = 0;
        do {
            first = f4(); // 要么0 要么1

        } while (first == f4());
        return first;
    }

    public static void test4() {
        int[] count = new int[2]; // 0 1
        for (int i = 0; i < 1000000; i++) {
            int ans = l();
            count[ans]++;
        }
        System.out.println(count[0] + "," + count[1]);
    }
}
