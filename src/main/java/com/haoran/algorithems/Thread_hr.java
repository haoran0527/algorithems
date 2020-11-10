package com.haoran.algorithems;

import java.util.ArrayList;
import java.util.List;

public class Thread_hr {
    volatile boolean condition = false;
    volatile int size = 0;
    volatile boolean isOver = false;
    List list = new ArrayList<>();

    void add(Object o){
        list.add(o);
    }

    int size(){
        return list.size();
    }

     static Thread_hr t = new Thread_hr();

    public static void main(String[] args) {

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"启动");
            while(true){
//                System.out.println("0000 ---> "+t.size);
                if(t.condition && t.size == 5){
                    System.out.println("1111 --->" + t.size);
                    System.out.println("5 个了！！！");
                    t.condition = false;
                    t.isOver = true;
                    break;
                }else if(t.condition){
                    System.out.println("2222--->" + t.size);
                    t.condition = false;
                }
            }
            System.out.println("t1 over");
        },"t1").start();

        new  Thread(()->{
            System.out.println(Thread.currentThread().getName()+"启动");
            int x = 0;
            while (true){
                if(t.condition){
                   continue;
                }
                t.size ++;
                t.add(x++);
                System.out.println("加了个"+x+" t.size is "+t.size);
                /*try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                if(x>10){
                    break;
                }
                if(!t.isOver){
                    t.condition = true;
                }
            }
            System.out.println("t2 over");
        },"t2"
        ).start();
    }
}
