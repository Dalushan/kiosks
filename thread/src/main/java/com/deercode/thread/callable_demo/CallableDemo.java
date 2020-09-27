package com.deercode.thread.callable_demo;

import java.util.Date;
import java.util.concurrent.Callable;

/**
 * @author LuLianShan
 * @ClassName CallableDemo
 * @create 2020/9/27 11:33
 */
public class CallableDemo implements Callable<Object> {
    private String taskNum;

    public CallableDemo(String taskNum) {
        this.taskNum = taskNum;
    }

    @Override
    public Object call() throws Exception {
        System.out.println(">>>" +taskNum+ "任务开始");
        long ms = 0;
        try {
            Date date = new Date();
            Thread.sleep(1000);
            Date date1 = new Date();
            ms = date.getTime() - date1.getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(">>>" +taskNum+ "任务结束");
        return taskNum + "任务返回运行结果, 当前任务时间["+ms+"毫秒]";
    }
}
