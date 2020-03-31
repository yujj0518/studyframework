package com.study.sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {4,2,3,990,5,9,8};
        insertSort(arr);
        System.out.println("插入排序 = " + Arrays.toString(arr));
    }

    private static void insertSort(int[] arr) {
        for (int i = 0,j,current; i < arr.length; i++) {
            current = arr[i];
            for (j = i-1; j >= 0 && arr[j] > current;j--) {
                arr[j+1] = arr[j];
            }
            arr[j+1] =current;

        }
    }
}
