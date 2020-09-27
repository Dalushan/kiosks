package com.deercode.thread.callable_demo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author LuLianShan
 * @ClassName CallableDemoTest
 * @create 2020/9/27 11:43
 */
class CallableDemoTest {

    @Test
    void callableDemo() throws ExecutionException, InterruptedException {
        CallableDemo callableDemo = new CallableDemo("demo");

        FutureTask<Object> task = new FutureTask<Object>(callableDemo);
        new Thread(task).start();

        Object o = task.get();
        System.out.println(o);
    }

    /*callable 线程池添加信息*/
    @Test
//    synchronized void callablePoolDemo() throws ExecutionException, InterruptedException {
    void callablePoolDemo() throws ExecutionException, InterruptedException {
        System.out.println("---程序开始---");
        // 计时Start
        Date d1 = new Date();
        int taskSize = 5;
        // 创建线程池
        ExecutorService pool = Executors.newFixedThreadPool(taskSize);
        // 创建有多个返回值的任务
        ArrayList<Future> list = new ArrayList<>();
        // 循环添加信息
        for (int i = 0; i < taskSize; i++) {
            CallableDemo callable = new CallableDemo(i + "");
            // 执行并获取对象
            Future<Object> future = pool.submit(callable);
            list.add(future);
        }
        // 关闭线程池
        pool.shutdown();

        // 循环显示所有并发添加的信息
        for (Future future : list) {
            System.out.println(future.get().toString());
        }
        // 计时End
        Date d2 = new Date();
        System.out.println("运行时间" + (d2.getTime() - d1.getTime()) + "毫秒");
        System.out.println("---运行结束---");

    }
}