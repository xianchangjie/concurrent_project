/*
 * Copyright (c) 2019. changjie.xian All Rights Reserved
 *
 */

package com.xcj.concurrent;

/**
 * @Classname MyTest7
 * @Description TODO
 * @Date 2019-07-28 20:20
 * @Author changjiexian
 */
public class MyTest7 {
    /**
     * <h2>对象及变量的并发访问</h2>
     *
     * <h3>方法内部的变量线程安全</h3>
     * <p>
     * 方法中的变量不存在线程不安全，一定是线程安全的，这是方法内部的变量是私有的特性造成的
     * 每个线程执行的时候会把方法的私有变量（局部变量）存放在各自栈帧的工作内存中（栈帧进入虚拟机栈），虚拟机栈-线程间不共享，故不存在线程安全问题。
     * </p>
     * <p>synchronized-如果多个线程访问多个对象，jvm会创建多个锁</p>
     * * <h3>实例变量线程不安全</h3>
     * @param args
     */
    public static void main(String[] args) {

    }
}
