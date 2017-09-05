package com.zzp.pratise.Sort;

/**
 * Created by zhuzhengping
 * on 2017/9/5.
 *
 * 冒泡排序
 */
public class BubbleSort {

//    将序列中所有元素两两比较，将最大的放在最后面。
//    将剩余序列中所有元素两两比较，将最大的放在最后面。
//    重复第二步，直到只剩下一个数。

    public void bubbleSort(int[] a){

//        设置循环次数。
//        设置开始比较的位数，和结束的位数。
//        两两比较，将最小的放到前面去。
//        重复2、3步，直到循环次数完毕。
        int length=a.length;
        int temp;
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length-i-1;j++){
                if(a[j]>a[j+1]){
                    temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
    }

}
