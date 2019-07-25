package ThreadPoolDemo;

import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPool01 {
    public static void main(String[] args) {
        //线程池创建方式一,newCachedThreadPool方法
        /*ExecutorService newCachedThreadPool= Executors.newCachedThreadPool();
        for (int i=0;i<10;i++){
            final int temp=i;
            newCachedThreadPool.execute(new Runnable(){
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+", "+temp);
                }
            });
        }*/
        //线程池创建方式二,可指定线程数量,newFixedThreadPool方法
        /*ExecutorService newFixedThreadPool=Executors.newFixedThreadPool(3);
        for (int i=0;i<20;i++){
            final int temp=i;
            newFixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+", "+temp);
                }
            });
        }*/
        //线程池创建方式三，可以指定线程池大小（按照线程池大小调度线程）
        /*ScheduledExecutorService newScheduledThreadPool=Executors.newScheduledThreadPool(3);
        for (int i=0;i<20;i++){
            final int temp=i;
            newScheduledThreadPool.schedule(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+", "+temp);
                }
            }, 3, TimeUnit.SECONDS);//推迟三秒后执行
        }*/
        //线程池创建方式四（单化线程从上往下执行）
        ExecutorService newSingleThreadExecutor=Executors.newSingleThreadExecutor();
        for (int i=0;i<20;i++){
            final int temp=i;
            newSingleThreadExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+", "+temp);
                }
            });
        }
        newSingleThreadExecutor.shutdown(); //这里可以停止线程池（对线程池实例调用shutdown方法）
        /*总结：创建线程池有四种方式，包括newCachedThreadPool,newFixedThreadPool,newScheduledThreadPool,newSingleThreadPool
        * 创建线程需要通过Executors对象使用四个线程池方法才能生成线程池实例
        * 实例通过execute和schedule调用多线程*/
    }
}
