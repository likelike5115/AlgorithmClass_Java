package com.like.sort1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description 小和问题：
 * 在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和。
 * 求一个数组的小和。例子：[1,3,4,2,5] 1左边比1小的数，没有；3左边比3小的数，1；
 * 4左边比4小的数，1、3；2左边比2小的数，1；5左边比5小的数，1、3、4、2；
 * 所以小和为1+1+3+1+1+3+4+2=16
 * @Author
 */
public class SmallSort {
    public static void main(String[] args) {
        System.out.println(smartSum());

    }
    public static int smartSum(){
//        Scanner scanner = new Scanner(System.in);
//        int length = scanner.nextInt();
//        int[] arr = new int[length];
//        while(scanner.hasNext()){
//            for (int i = 0; i < length; i++){
//                arr[i] = scanner.nextInt();
//            }
//        }
        int[] arr = new int[]{1,2,3,4};
        if(arr == null || arr.length < 2)
        {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }
    public static int process(int [] arr, int L, int R){
        if(L == R){
            return 0;
        }
        int mid = L + ((R - L) >> 1);
        return process(arr, L, mid) + process(arr, mid +1, R) +
                merge(arr, L, mid, R);  //疑问：这里为什么是直接相加，process递归到最后返回什么
    }
    public static int merge(int [] arr, int L, int mid, int R){
        int[] help = new int[R - L + 1];
        int p1 = L;
        int p2 = mid + 1;
        int i = 0;
        int res = 0;
        while(p1 <= mid && p2 <= R){
            res += (arr[p1] < arr[p2]) ? (R - p2 + 1) * arr[p1] : 0;
            help[i++] = (arr[p1] < arr[p2]) ? arr[p1++] : arr[p2++];
        }
        while(p1 <= mid){
            help[i++] = arr[p1++];
        }
        while(p2 <= R){
            help[i++] = arr[p2++];
        }
        for(i = 0; i < help.length; i++){
            arr[L + i] = help[i];
        }
        return res;
    }
}
