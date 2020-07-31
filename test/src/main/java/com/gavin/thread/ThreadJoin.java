package com.gavin.thread;

/**
 * @author gavin
 * @version 1.0
 * @date 2020/7/31 10:08 上午
 * @Description 线程的join示例
 */
public class ThreadJoin {

    static class ThreadA implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println("我是子线程，我先睡一秒");
                Thread.sleep(1000);
                System.out.println("我是子线程，我睡完了一秒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * @description //join()让当前线程陷入“等待”状态，等join的这个线程执行完成后，再继续执行当前线程。
     * @author gavin
     * @date 2020/7/31 10:22 上午
     * @params  * @param args
     * @return void
     */
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new ThreadA());
        thread.start();
        thread.join();
        System.out.println("如果不加join方法，我会先被打出来，加了就不同了");
    }

}
