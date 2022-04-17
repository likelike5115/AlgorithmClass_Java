package com.like.sort1;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Description 实现三种基本排序方法
 * @Author
 */
public class SortBasics {
    //选择排序 找出前n个数的最小值，把最小值挪到开头
    @Test
    public void selectionSort(){
        int[] arr = new int[]{4,1,9,3,8,1,6,2};
        if(arr == null || arr.length <= 1){
            return;
        }

        for(int i = 1; i < arr.length - 1; i++){
            int max = arr[0];
            int maxIndex = 0;
            for(int j = 0; j < arr.length - i + 1; j++){
                if(arr[j] > max){
                    max = arr[j];
                    maxIndex = j;
                }
            }
            swap(arr, maxIndex, arr.length - i);
        }
        System.out.println(Arrays.toString(arr));

    }
    //冒泡排序 两个数一组比较大小，将最大数一直交换到数组末尾
    @Test
    public void bubbleSort(){
        int[] arr = new int[]{5,2,8,3,1,7,4,3};
        if(arr == null || arr.length <= 1){
            return;
        }
        for(int i = 0; i < arr.length - 1; i++){
            for(int j = 0; j < arr.length - i - 1; j++){
                if(arr[j] > arr[j + 1]){
                    swap(arr, j, j+1);
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    //插入排序 前n个数是排好序的，第n+1个数插入到前面排好序的数中
    @Test
    public void insertionSort(){
        int[] arr = new int[]{5,2,8,3,1,7,4,3};
        if(arr == null || arr.length <= 1){
            return;
        }
        int j=0;    //该位置及该位置之前的元素为一个有序表
        int val=0;    //用于存储要进行排序的值
        for(int i=1;i<arr.length;i++) {
            val=arr[i];  //保存用于插入的元素
            j=i-1;
            while(j>=0&&val<arr[j]) {  //找到插入的位置
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=val;
            System.out.printf("第%d次排序的结果是： \n",i);
            System.out.println(Arrays.toString(arr));
        }
    }


    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
