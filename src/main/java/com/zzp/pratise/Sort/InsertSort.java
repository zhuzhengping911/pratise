package com.zzp.pratise.Sort;

/**
 * Created by zhuzhengping
 * on 2017/9/4.
 * 插入排序
 */
public class InsertSort {


//    将第一个数和第二个数排序，然后构成一个有序序列
//    将第三个数插入进去，构成一个新的有序序列。
//    对第四个数、第五个数……直到最后一个数，重复第二步
    public static void insertSort(int[] a){

//        首先设定插入次数，即循环次数，for(int i=1;i<length;i++)，1个数的那次不用插入。
//        设定插入数和得到已经排好序列的最后一个数的位数。insertNum和j=i-1。
//        从最后一个数开始向前循环，如果插入数小于当前数，就将当前数向后移动一位。
//        将当前数放置到空着的位置，即j+1

        int length=a.length;//数组长度，将这个提取出来是为了提高速度。
        int insertNum;//要插入的数
        for(int i=1;i<length;i++){//插入的次数
            insertNum=a[i];//要插入的数
            int j=i-1;//已经排序好的序列元素个数
            while(j>=0&&a[j]>insertNum){//序列从后到前循环，将大于insertNum的数向后移动一格
                a[j+1]=a[j];//元素移动一格
                j--;
            }
            a[j+1]=insertNum;//将需要插入的数放在要插入的位置。
        }
    }


    public static void main(String[] args) {

        int[] a = {1,2,45,7,78,0,99};
        insertSort(a);
        for (int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
    }
}
