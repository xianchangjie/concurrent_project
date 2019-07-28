/*
 * Copyright (c) 2019. changjie.xian All Rights Reserved
 *
 */

package com.xcj.concurrent;

/**
 * @Classname MyTest3
 * @Description TODO
 * @Date 2019-07-28 14:40
 * @Author changjiexian
 */
public class MyTest3 {
    /**
     * <p>如果要创建线程的类已经有了一个父类，这时就不能再继承<i>Thread</i>类了，因为java不支持多继承</p>
     * <p>所以这时候就要实现Runnable接口</p>
     * <hr><blockquote></blockquote>
     * @param args
     */
    public static void main(String[] args) {
        MyRun myRun = new MyRun();
        Thread t = new Thread(myRun);
        t.start();
        System.out.println("run over");


    }
    static class MyRun implements Runnable{
        public void run() {
            System.out.println("runnable。。。");
        }
    }
}
