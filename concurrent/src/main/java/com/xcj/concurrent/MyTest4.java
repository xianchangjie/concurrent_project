/*
 * Copyright (c) 2019. changjie.xian All Rights Reserved
 *
 */

package com.xcj.concurrent;

/**
 * @Classname MyTest4
 * @Description
 * @Date 2019-07-28 16:37
 * @Author changjiexian
 */
public class MyTest4 {
    /**
     * <h1>实例变量和线程安全</h1>
     * <p>自定义线程实例与其他线程可以有共享和不共享之分</p>
     * @param args
     */
    public static void main(String[] args) {
        MyThread myThread = new MyThread("A");
        MyThread myThread2 = new MyThread("B");
        MyThread myThread3 = new MyThread("C");
        myThread.start();
        myThread2.start();
        myThread3.start();
    }

    static class MyThread extends Thread{
        int count = 5;

        public MyThread(String name) {
            this.setName(name);
        }

        @Override
        public void run() {
            while (count>0){
                count--;
                System.out.println(this.getName()+"/"+count);
            }
        }
    }
}
