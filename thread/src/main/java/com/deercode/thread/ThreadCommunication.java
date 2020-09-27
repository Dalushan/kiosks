package com.deercode.thread;

/**
 * @author LuLianShan
 * @ClassName ThreadCommunication
 * @create 2020/9/27 20:27
 *
 * 三个线程 a、b、c 并发运行，b,c 需要 a 线程的数据怎么实现
 */
public class ThreadCommunication {
    private static Integer num = 0;

//    创建abc三个线程
    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    num = 1;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "获取到 num 的值为：" + num);
            }
        });

        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "获取到 num 的值为：" + num);
            }
        });

//        运行
        threadA.start();
        threadB.start();
        threadC.start();

    }
}
