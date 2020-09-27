package com.deercode.thread;

/**
 * @author LuLianShan
 * @ClassName Counter
 * @create 2020/9/27 16:55
 * 统计类
 */
public class Counter {
    private volatile Integer count = 0;

    public void inc() {
        try {
            Thread.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
    }

//    @Override
//    public String toString() {
//        return "[count : " + count + "]";
//    }

    @Override
    public String toString() {
        return "Counter{" +
                "count=" + count +
                '}';
    }
}
