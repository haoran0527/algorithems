package com.haoran.algorithems;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class testHashSet {

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a,b)-> b-a);
        queue.stream().toArray(Integer[]::new);
        new Thread(()->{
            Set<String> strings = new HashSet<>();
            for (int i = 0; i < 10; i++) {
                try {
                    TimeUnit.MILLISECONDS.sleep(new Random().nextInt(100));
                    System.out.println("t1"+i+">"+strings.add("http://zhwp.istarshine.com/images/2020/07/26/96863cbe-8feb-49f7-a794-bcc1f515a60b.jpg"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (Exception ee){
                    ee.printStackTrace();
                }
            }
        },"t1").start();
        new Thread(()->{
            Set<String> strings = new HashSet<>();
            for (int i = 0; i < 10; i++) {
                try {
                    TimeUnit.MILLISECONDS.sleep(new Random().nextInt(100));
                    System.out.println("t2"+i+">"+strings.add("http://zhwp.istarshine.com/images/2020/07/26/96863cbe-8feb-49f7-a794-bcc1f515a60b.jpg"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (Exception ee){
                    ee.printStackTrace();
                }
            }
        },"t2").start();
    }
}
