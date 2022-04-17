package com.like.sort1;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Description 实现堆排序
 * @Author
 */
public class HeapSort {
    @Test
    public void HeapSortTest(){
        int[] arr = new int[]{6,1,3,9,7,2,4};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void heapSort(int[] arr){
        if(arr == null || arr.length <2)
        {
            return;
        }
        for(int i = arr.length - 1; i>=0; i--){
            heapify(arr, i, arr.length);
        }
        int heapSize = arr.length;//完全二叉树能确保顶部节点为最大值，每次都把这个值放入数组末尾
        while(heapSize > 0){
            swap(arr, 0, --heapSize);
            heapify(arr, 0, heapSize);
        }

    }
    public static void insertHeap(int[] arr, int currentNode, int heapSize){
        int parentNode = (int)((currentNode - 1) / 2);
        if(parentNode >= 0){
            while(arr[parentNode] < arr[currentNode]){
                swap(arr, currentNode, parentNode);
                currentNode = parentNode;
            }
        }


    }
    public static void heapify(int[] arr, int currentNode, int heapSize){
        int leftChild = currentNode * 2 + 1;
        while(leftChild < heapSize)
        {
                int largest = (leftChild + 1 < heapSize &&
                        arr[leftChild + 1] > arr[leftChild]) ? leftChild + 1 : leftChild;
                largest = arr[currentNode] > arr[largest] ? currentNode : largest;
                //要找出parent node和两个子节点中最大的那个
                if(largest == currentNode){
                    break;
                }
                swap(arr, currentNode, largest);
                currentNode = largest;
                leftChild = currentNode * 2 + 1;
        }

    }
    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
