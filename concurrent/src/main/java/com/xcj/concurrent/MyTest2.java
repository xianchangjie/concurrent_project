/*
 * Copyright (c) 2019. changjie.xian All Rights Reserved
 *
 */

package com.xcj.concurrent;

/**
 * @Classname MyTest2
 * @Description TODO
 * @Date 2019-07-28 14:35
 * @Author changjiexian
 */
public class MyTest2 {
    /**
     * 运行结果
     * 1
     * 5
     * 4
     * 3
     * 2
     * 结论：start方法的调用顺序与线程的启动顺序无关
     * @param args
     */
    public static void main(String[] args) {
        MyThread myThread1 = new MyThread(1);
        MyThread myThread2 = new MyThread(2);
        MyThread myThread3 = new MyThread(3);
        MyThread myThread4 = new MyThread(4);
        MyThread myThread5 = new MyThread(5);
        myThread1.start();
        myThread2.start();
        myThread3.start();
        myThread4.start();
        myThread5.start();
    }

    static class MyThread extends Thread{
        int i;
        public MyThread(int param) {
            i = param;
        }

        @Override
        public void run() {
            System.out.println(i);
        }
    }

}
