package com.deercode.thread.runnable_demo;

/**
 * @author LuLianShan
 * @ClassName RunnableDemo
 * @create 2020/9/27 11:22
 */
public class RunnableDemo implements Runnable{
    @Override
    public void run() {
        System.out.println("Runnable number " + "1");
    }
}
