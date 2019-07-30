/*
 * Copyright (c) 2019. changjie.xian All Rights Reserved
 *
 */

package com.xcj.concurrent;

/**
 * @Classname MyTest6
 * @Description TODO
 * @Date 2019-07-28 19:58
 * @Author changjiexian
 */
public class MyTest6 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread thread = new Thread(myThread,"A");
        thread.start();
    }

    /**
     * <h2>多线程里面this.getName()和currentThread.getName()有什么区别?</h2>
     * this的意思是代表当前对象的。而this在线程的环境下，代表的是当前线程实例对象本身。所以this.getName是当前线程实例对象的线程名称是什么。
     *
     */

    static class MyThread extends Thread{
        public MyThread() {
            System.out.println(this.getId());
//
//            System.out.println("Mythread-start");
//            System.out.println("Mythread-this.getName:"+this.getName());
//
//            System.out.println("Mythread-Thread.currentThread.getName:"+Thread.currentThread().getName());
//            System.out.println("Mythread-end");
        }

        @Override
        public void run() {
            System.out.println(this.getId());
//            System.out.println("run-start");
//            System.out.println("this.getName:"+this.getName());
//            System.out.println("Thread.currentThread.getName:"+Thread.currentThread().getName());
//            System.out.println("run-end");
        }
    }
}
