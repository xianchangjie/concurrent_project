/*
 * Copyright (c) 2019. changjie.xian All Rights Reserved
 *
 */

package com.xcj.concurrent;

/**
 * @Classname MyTest8
 * @Description 线程间的通信
 * @Date 2019-07-29 22:09
 * @Author changjiexian
 */
public class MyTest8 {
    public static void main(String[] args) {
        String s = "";
        System.out.println("synchronized above");
        try {
            synchronized (s){
                System.out.println("wait above");
                s.wait();
                System.out.println("wait below");
            }
            System.out.println("synchronized below");
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }
    }
}
