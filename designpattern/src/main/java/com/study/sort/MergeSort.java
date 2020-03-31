package com.study.sort;

import java.util.Arrays;


public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {4, 2, 3, 990, 5, 9, 8};
        mSort(arr, 0, arr.length - 1);
        System.out.println("归并排序 = " + Arrays.toString(arr));
    }

    private static void mSort(int[] arr, int start, int end) {
        if (start >= end) return;
        int mid = start + (end - start) / 2;
        mSort(arr, start, mid);
        mSort(arr, mid + 1, end);
        mergeSort(arr, start, mid, end);
    }

    private static void mergeSort(int[] arr, int start, int mid, int end) {
        int[] copy = arr.clone();
        int i = start;
        int k = start;
        int j = mid + 1;
        while (k <= end) {
            if (i > mid) {
                arr[k++] = copy[j++];
            } else if (j > end) {
                arr[k++] = copy[i++];
            } else if (copy[j] < copy[i]) {
                arr[k++] = copy[j++];
            } else {
                arr[k++] = copy[i++];
            }
        }
    }
}
