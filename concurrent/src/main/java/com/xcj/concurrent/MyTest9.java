/*
 * Copyright (c) 2019. changjie.xian All Rights Reserved
 *
 */

package com.xcj.concurrent;

/**
 * @Classname MyTest9
 * @Description TODO
 * @Date 2019-07-29 22:34
 * @Author changjiexian
 */
public class MyTest9 {

    public static void main(String[] args) {
        Object lock = new Object();
        MyThread1 myThread1 = new MyThread1(lock);
        myThread1.start();
        try {
            System.out.println("before sleep() time="+System.currentTimeMillis());
            Thread.sleep(3000);
            System.out.println("after sleep() time="+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        MyThread2 myThread2 = new MyThread2(lock);
        myThread2.start();



    }


    static class MyThread1 extends Thread {
        private Object lock;

        public MyThread1(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            synchronized (lock) {
                try {
                    System.out.println("before wait() time=" + System.currentTimeMillis());
                    lock.wait();
                    System.out.println("after wait() time=" + System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    static class MyThread2 extends Thread {
        private Object lock;

        public MyThread2(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            synchronized (lock) {
                System.out.println("before notify() time=" + System.currentTimeMillis());
                lock.notifyAll();
                System.out.println("after notify() time=" + System.currentTimeMillis());
            }
        }
    }

}
