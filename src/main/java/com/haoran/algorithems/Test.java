package com.haoran.algorithems;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.util.CollectionUtils;

import javax.sound.midi.Soundbank;
import java.util.*;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public class Test {
    static  Thread t1;
    static Thread t2 ;

    public static void main(String[] args) {
        int[] s = new int[]{2,3,5,6};
        List<List<Integer>> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for(int i:s){
            List<Integer> list = new ArrayList<>();
            Set<Integer> set = new HashSet<>();

            all(s,set,list,res);
        }
        System.out.println(JSON.toJSONString(res));
        //System.out.println(max2(s));
    }

    private static void all(int[] arr,Set<Integer> set, List<Integer> list, List<List<Integer>> res){
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.offer("");
        LinkedList<Object> linkedList = new LinkedList<>();
        for (int i:arr){
            if(set.add(i)){
                list.add(i);
            }else{
                continue;
            }
            if(list.size() == arr.length){
                List<Integer> tmp = list.stream().map((x)->x).collect(Collectors.toList());
                res.add(tmp);
                return;
            }else{
                all(arr,set,list,res);
            }
        }


    }

    public static int max2(int[] s) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for(int i:s){
            if(queue.size()>=2){//第二大 =》2
                if(queue.peek()<i){
                    queue.poll();
                    queue.add(i);
                }
            }else {
                queue.add(i);
            }
        }
        return queue.poll();
    }
}
