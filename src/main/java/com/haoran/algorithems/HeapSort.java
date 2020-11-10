package com.haoran.algorithems;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {5,7,3,7,9,4,0,4,8,9,0};
        for (int i = 0;i<arr.length;i++){
            insertHeap(arr,arr[i],i);
        }
        for (int i = arr.length; i > 0; i--) {
            int res = arr[0];
            swap(arr,0,i-1);
            heapfiy(arr,0,i-1);
        }
        IntStream.of(arr).forEach(o-> System.out.print(o+" "));
    }



    private  static void heapfiy(int[] arr,int i,int size){
        int left = 2*i+1;
        int right = 2*i+2;
        while (left<size){
            int largest = right<size&&arr[left]<arr[right]?right:left;
            if(arr[largest]>arr[i]){
                swap(arr,i,largest);
            }
            i = largest;
            left = 2*i+1;
            right = 2*i+2;
        }
    }

    private static void insertHeap(int arr[] ,int i,int size){
        int index = size;
        int parent = (index-1)/2;
        while (index>parent){
            if(arr[parent]<arr[index]){
                swap(arr,index,parent);
            }
            index = parent;
            parent = (index-1)/2;
        }
    }
    private static void swap(int[] arr,int i,int j){
        if(i==j){
            return;
        }
        arr[i] = arr[i]^arr[j];
        arr[j] = arr[i]^arr[j];
        arr[i] = arr[i]^arr[j];
    }
}
