/*
 * Copyright (c) 2019. changjie.xian All Rights Reserved
 *
 */

package com.xcj.concurrent;

/**
 * @author changjiexian
 * main-psvm
 * print-sout
 *
 */
public class MutithreadUse {
    /**
     * 起一个线程时代码运行顺序与代码执行顺序无关，cpu会以随机的时间来调用线程中的run方法
     * @param args
     */
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println("thread over");

    }
    static class MyThread extends Thread{
        @Override
        public void run() {
            super.run();
            System.out.println("MyThread");
        }
    }
}
