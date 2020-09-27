package com.deercode.thread;

import java.util.concurrent.Semaphore;

/**
 * @author LuLianShan
 * @ClassName ThreadCommunication
 * @create 2020/9/27 20:27
 */
/* * 方案1
   定义一个信号量，该类内部维持了多个线程锁，可以阻塞多个线程，释放多个线程，
   线程的阻塞和释放是通过 permit 概念来实现的
   线程通过 semaphore.acquire()方法获取 permit，如果当前 semaphore 有 permit 则分配给该线程，
   如果没有则阻塞该线程直到 semaphore
   调用 release（）方法释放 permit。
   构造函数中参数：permit（允许） 个数，
 * */
public class ThreadCommunicationProgramme1 {
    private static Integer num = 0;
//   线程锁
    private static Semaphore semaphore = new Semaphore(0);

//    创建abc三个线程
    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
//                    模拟耗时
                    Thread.sleep(1000);
                    num = 1;
//                    初始化完成后释放两个permit
                    semaphore.release(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
//                获取一个permit, 如果没有可用的permit则等待, 否则消耗一个permit
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "获取到 num 的值为：" + num);
            }
        });

        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
//                获取一个permit, 如果没有可用的permit则等待, 否则消耗一个permit
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + "获取到 num 的值为：" + num);
            }
        });
        
//        运行
        threadA.start();
        threadB.start();
        threadC.start();

    }
}
