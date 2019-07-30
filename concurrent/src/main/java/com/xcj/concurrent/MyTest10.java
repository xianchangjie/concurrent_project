/*
 * Copyright (c) 2019. changjie.xian All Rights Reserved
 *
 */

package com.xcj.concurrent;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname MyTest10
 * @Description TODO
 * @Date 2019-07-29 22:51
 * @Author changjiexian
 */
public class MyTest10 {

    public static void main(String[] args) {
        Object lock = new Object();
        MyThread1 myThread1 = new MyThread1(lock);
        myThread1.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MyThread2 myThread2 = new MyThread2(lock);
        myThread2.start();


    }

    static class ProcessSomething {
        static List<String> s = new ArrayList();

        public static void addToList(String str) {
            s.add(str);
        }

        public static int getListSize() {
            return s.size();
        }
    }

    static class MyThread1 extends Thread {
        private Object lock;

        public MyThread1(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            synchronized (lock) {
                if (ProcessSomething.getListSize() != 5) {
                    System.out.println("before wait() time = " + System.currentTimeMillis());
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("after wait() time = " + System.currentTimeMillis());

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
                for (int i = 0; i < 10; i++) {
                    ProcessSomething.addToList(String.valueOf(i));
                    if (ProcessSomething.getListSize() == 5) {
                        lock.notify();
                        System.out.println("already notify");
                    }
                    System.out.println("add " + (i + 1) + "element");
                }
            }
        }
    }

}
