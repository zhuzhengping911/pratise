package com.zzp.pratise.Sort;

/**
 * Created by zhuzhengping
 * on 2017/9/5.
 *
 * 简单选择排序
 */
public class SelectSort {

//    (如果每次比较都交换，那么就是交换排序；如果每次比较完一个循环再交换，就是简单选择排序。)
//
//    遍历整个序列，将最小的数放在最前面。
//    遍历剩下的序列，将最小的数放在最前面。
//    重复第二步，直到只剩下一个数

    public void selectSort(int[] a) {

//        首先确定循环次数，并且记住当前数字和当前位置。
//        将当前位置后面所有的数与当前数字进行对比，小数赋值给key，并记住小数的位置。
//        比对完成后，将最小的值与第一个数的值交换。
//        重复2、3步
        int length = a.length;
        for (int i = 0; i < length; i++) {//循环次数
            int key = a[i];
            int position=i;
            for (int j = i + 1; j < length; j++) {//选出最小的值和位置
                if (a[j] < key) {
                    key = a[j];
                    position = j;
                }
            }
            a[position]=a[i];//交换位置
            a[i]=key;
        }
    }
}
