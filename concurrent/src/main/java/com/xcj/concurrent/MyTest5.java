/*
 * Copyright (c) 2019. changjie.xian All Rights Reserved
 *
 */

package com.xcj.concurrent;

/**
 * @Classname MyTest5
 * @Description TODO
 * @Date 2019-07-28 16:59
 * @Author changjiexian
 */
public class MyTest5 {
    /**
     * <h1>实例变量和线程安全</h1>
     * <p>自定义线程实例与其他线程可以有共享和不共享之分</p>
     * <hr>
     * <p>synchronized 可以在任意对象以及方法上加锁🔒,使加🔒的这段代码成为"互斥区"/"临界区"
     * <br>当一个线程想要执行同步方法里面的代码时，线程首先尝试去拿这把锁,如果能拿到锁，则可以执行synchronized里面的代码。
     * 如果拿不到这把锁，那么线程会不断尝试拿这把锁，知道能够拿到这把锁为止，而且使多个线程同时去争抢这把锁</p>
     * <i>"非线程安全":</i>
     * <p>指多个线程对同一个对象中的同一个实例变量进行操作时会出现值被更改，值不同步的情况</p>
     * <p><code>Thread.currentThread().getName()</code>Thread.currentThread()可以获取当前线程对象 </p>
     * @param args
     */
    public static void main(String[] args) {

        MyThread myThread = new MyThread();
        Thread thread = new Thread(myThread,"A");
        Thread thread2 = new Thread(myThread,"B");
        Thread thread3 = new Thread(myThread,"C");
        Thread thread4 = new Thread(myThread,"D");

        thread.start();
//        thread.run();
        thread2.start();
        thread3.start();
        thread4.start();
        System.out.println("----------------");
        System.out.println(Thread.currentThread().getName());


    }

    static class MyThread extends Thread {
        private int count = 5;

        @Override
        public synchronized void run() {
            count--;
            System.out.println(Thread.currentThread().getName() + "/" + count);
        }
    }
}
