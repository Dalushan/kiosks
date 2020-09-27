package com.deercode.thread.thread_demo;

/**
 * @author LuLianShan
 * @ClassName ThreadDemo
 * @create 2020/9/27 10:34
 */
public class ThreadDemo extends Thread {
    Integer i = 0;

    @Override
    public void run() {
        i++;
        System.out.println("number" + i);
    }
}
