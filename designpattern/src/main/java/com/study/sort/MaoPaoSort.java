package com.study.sort;

import java.util.Arrays;

public class MaoPaoSort {
    public static void main(String[] args) {
        int[] arr = {4,2,3,990,5,9,8};
        maoPao(arr);
        System.out.println("冒泡排序 = " + Arrays.toString(arr));
    }

    private static void maoPao(int[] arr) {
        boolean isSort = true;
        for (int i = 0; i < arr.length && isSort; i++) {
            isSort = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j+1] < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    isSort = true;
                }
            }
        }
    }
}
