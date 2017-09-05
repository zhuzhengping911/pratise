package com.zzp.pratise.Sort;

/**
 * Created by zhuzhengping
 * on 2017/9/5.
 * 希尔排序
 */
public class SheelSort {

    /**
     * 将数的个数设为n，取奇数k=n/2，将下标差值为k的书分为一组，构成有序序列。
       再取k=k/2 ，将下标差值为k的书分为一组，构成有序序列。
       重复第二步，直到k=1执行简单插入排序
     * @param a
     */
    public static void sheelSort(int[] a){

        /**
         * 首先确定分的组数。
          然后对组中元素进行插入排序。
           然后将length/2，重复1,2步，直到length=0为止。
         *
         *
         */
        int d  = a.length;
        while (d!=0) {
            d=d/2;
            for (int x = 0; x < d; x++) {//分的组数
                for (int i = x + d; i < a.length; i += d) {//组中的元素，从第二个数开始
                    int j = i - d;//j为有序序列最后一位的位数
                    int temp = a[i];//要插入的元素
                    for (; j >= 0 && temp < a[j]; j -= d) {//从后往前遍历。
                        a[j + d] = a[j];//向后移动d位
                    }
                    a[j + d] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {

        int[] a = {1,2,45,7,78,0,99};
        sheelSort(a);
        for (int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
    }
}
