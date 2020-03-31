package com.study.sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {4, 2, 3, 990, 5, 9, 8};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("快速排序 = " + Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int index = getIndex(arr, start, end);
            quickSort(arr, 0, index - 1);
            quickSort(arr, index + 1, end);

        }
    }

    private static int getIndex(int[] arr, int start, int end) {
//        Random random = new Random();
//       int temp = arr[start + random.nextInt(end - start)];
        int temp = arr[start];
        while (start < end) {
            while (start < end && arr[end] >= temp) {
                end--;
            }
            arr[start] = arr[end];
            while (start < end && arr[start] <= temp) {
                start++;
            }
            arr[end] = arr[start];

        }
        arr[start] = temp;
        return start;
    }
}
