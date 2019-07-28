/*
 * Copyright (c) 2019. changjie.xian All Rights Reserved
 *
 */

package com.xcj.concurrent;

/**
 * @Classname MyTest1
 * @Description 演示线程的随机性
 * @Date 2019-07-28 14:05
 * @Author changjiexian
 */
public class MyTest1 {
    public static void main(String[] args) {
        //调用myThread线程
        MyThread thread = new MyThread();
        thread.setName("myThread");
        thread.start();

        //控制主线程
        try {
            for (int i = 0; i < 10; i++) {
                int time = (int) Math.random() * 1000;
                Thread.sleep(time);
                System.out.println("main=" + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }

    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    int time = (int) Math.random() * 1000;
                    Thread.sleep(time);
                    System.out.println("run=" + Thread.currentThread().getName());

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println(e.toString());
            }
        }
    }
}
