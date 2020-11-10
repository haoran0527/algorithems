package com.haoran.algorithems;

public class QuickSort2 {

    public static void main(String[] args) {
        int[] arr = {5,7,3,7,9,4,0,4,8,9,0};
        quickSort(arr,0,arr.length-1);
        for(int i:arr){
            System.out.println(i+"");
        }
    }

    private static void quickSort(int[] arr,int l,int r){
        if(l>r){
            return;
        }
        int[] middle = quickSortOnce(arr,l,r);
        quickSort(arr,l,middle[0]-1);
        quickSort(arr,middle[1]+1,r);
    }

    private static int[] quickSortOnce(int[] arr,int l ,int r){
        if(l>r){
            return new int[]{-1,-1};
        }
        if(l==r){
            return new int[]{l,r};
        }
        int num = arr[r];
        int less = l-1;
        int more = r;
        int index = l;
        while (index<more){
            if(arr[index]==num){
                index++;
            }else if(arr[index]<num){
                swap(arr,index++,++less);
            }else {
                swap(arr,index,--more);
            }
        }
        swap(arr,more,r);
        return new int[]{less+1,more};
    }

    private static void  swap(int[] arr,int i,int j){
        if(i==j){
            return;
        }
        arr[i] = arr[i]^arr[j];
        arr[j] = arr[i]^arr[j];
        arr[i] = arr[i]^arr[j];

    }
}
