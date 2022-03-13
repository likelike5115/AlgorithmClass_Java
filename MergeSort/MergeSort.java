package com.like.sort1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description MergeSort实现
 * @Author
 */
public class MergeSort {
    public static void main(String[] args) {
        System.out.println("请输入数组长度:");
        Scanner scan = new Scanner(System.in);
        int length = scan.nextInt();
        int[] arr = new int[length];
        System.out.println("请输入数组:");
        for(int i = 0; i < length;i++){
            arr[i] = scan.nextInt();
        }
        process(arr, 0, length - 1);
        System.out.println(Arrays.toString(arr));


    }
    public static void process(int arr[], int L, int R){
        if(L == R)
        {
            return;
        }
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);



    }
    public static void merge(int arr[], int L, int mid, int R){
        int[] help = new int[R-L+1];//不是arr.length
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= R) {
            help[i++] = (arr[p1] <= arr[p2]) ? arr[p1++] : arr[p2++];

        }
        while(p1 <= mid){
            help[i++] = arr[p1++];
        }
        while(p2 <= R){
            help[i++] = arr[p2++];
        }
//        for(int j = L, k = 0; j <= R && k <= i; j++ , k++){
//            arr[j] = help[k];
//        }
        for(i = 0; i < help.length; i++){
            arr[L + i] = help[i];
        }
    }
}
