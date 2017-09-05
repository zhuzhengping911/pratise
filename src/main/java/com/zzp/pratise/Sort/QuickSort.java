package com.zzp.pratise.Sort;

/**
 * Created by zhuzhengping
 * on 2017/9/5.
 *
 * 快速排序
 */
public class QuickSort {
//
//    选择第一个数为p，小于p的数放在左边，大于p的数放在右边。
//    递归的将p左边和右边的数都按照第一步进行，直到不能递归。

    public static void quickSort(int[] numbers, int start, int end) {
        if (start < end) {
            int base = numbers[start]; // 选定的基准值（第一个数值作为基准值）
            int temp; // 记录临时中间值
            int i = start, j = end;
            do {
                while ((numbers[i] < base) && (i < end))
                    i++;
                while ((numbers[j] > base) && (j > start))
                    j--;
                if (i <= j) {
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                    i++;
                    j--;
                }
            } while (i <= j);
            if (start < j)
                quickSort(numbers, start, j);
            if (end > i)
                quickSort(numbers, i, end);
        }
    }
}
