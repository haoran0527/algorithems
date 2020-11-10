package com.haoran.algorithems;


import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 插入区间
 *
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 *
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 */
public class InsertArea implements InsertAreaTest {

    public static void main(String[] args) {
        /*int [][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int [] newInterval = {2,3};
        int[][] list = insert(intervals,newInterval);
        System.out.println(JSON.toJSONString(list));*/
        InsertArea insertArea = new InsertArea() {
            @Override
            public void test() {
                System.out.println("1111");
            }
        };
        insertArea.test();
    }

    private static int[][] insert(int[][] arr, int[] a){
        List<int[]> list = new ArrayList<>();
        int flag = 0;// 0 合并前 1合并中 2合并完成并添加到了结果集合
        for (int[] ar:arr) {
            if(ar[1]>=a[0] && a[0]>=ar[0] ){//可以合并
                flag = 1;
                if(ar[0]<a[0]){
                    a[0] = ar[0];
                }
            }
            if(ar[0]<=a[1] && ar[1]>=a[1]){//可以合并
                flag = 1;
                if(ar[1]>a[1]){
                    a[1] = ar[1];//mark
                }
            }
            if(ar[0]<a[0] && ar[1]>a[1]){//可以合并
                flag = 1;

            }
            if(flag!=2 && ar[0] > a[1]){
                flag = 2;
                list.add(a);
            }
            if(flag != 1){
                list.add(ar);
            }
        }
        if(flag != 2){
            list.add(a);
        }
        return  list.toArray(new int[list.size()][2]);
    }
}
