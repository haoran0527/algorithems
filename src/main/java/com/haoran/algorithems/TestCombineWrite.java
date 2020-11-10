package com.haoran.algorithems;

public class TestCombineWrite {

    private static int  SIZE = 1<<24;
    private static int MASK = SIZE -1;
    public static void main(String[] args) {
        byte[] intArrayA = new byte[SIZE];
        byte[] intArrayB = new byte[SIZE];
        byte[] intArrayC = new byte[SIZE];
        byte[] intArrayD = new byte[SIZE];
        byte[] intArrayE = new byte[SIZE];
        byte[] intArrayF = new byte[SIZE];
        long start = System.currentTimeMillis();
        for (int i=0;i<SIZE;i++){
            int index = i & MASK;
            byte b = (byte) i;
            intArrayA[index] = b;
            intArrayB[index] = b;
            intArrayC[index] = b;
            intArrayD[index] = b;
            intArrayE[index] = b;
            intArrayF[index] = b;
        }
        long end = System.currentTimeMillis();
        System.out.println("planA 耗时："+(end-start));
        long start1 = System.currentTimeMillis();
        for (int i=0;i<SIZE;i++){
            int index = i & MASK;
            byte b = (byte) i;
            intArrayA[index] = b;
            intArrayB[index] = b;
            intArrayC[index] = b;
        }
        for (int i=0;i<SIZE;i++){
            int index = i & MASK;
            byte b = (byte) i;
            intArrayD[index] = b;
            intArrayE[index] = b;
            intArrayF[index] = b;
        }
        long end1 = System.currentTimeMillis();
        System.out.println("planB 耗时："+(end1-start1));
    }
}
