package com.deercode.thread.runnable_demo;

import com.deercode.thread.Counter;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author LuLianShan
 * @ClassName RunnableDemoTest
 * @create 2020/9/27 11:23
 */
class RunnableDemoTest {

    @Test
    void runnableDemo() {
        RunnableDemo runnableDemo = new RunnableDemo();
        new Thread(new RunnableDemo()).start();
        new Thread(runnableDemo).start();
    }

    @Test
    void countFor() {
        final Counter counter = new Counter();
        Date date = new Date();
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    counter.inc();
                }
            }).start();
        }
        Date date1 = new Date();
        System.out.println((date1.getTime() - date.getTime()) + "毫秒 " +counter.toString());
    }
}