package ThreadDemo;

class ThreadDemo implements Runnable{
    private static int count=100;//变量静态
    private static Object object=new Object();//锁静态，使方法同步同一把锁
    /*对于同步代码块可以通过将变量静态化实现线程安全*/

    @Override
    public void run() {
        while (count>0){
            synchronized (this.getClass()) {
                //
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    System.out.println(e);
                }
                sale();
            }
        }
    }
    /*public synchronized void sale(){
    *//*这种方式加锁会买超火车票，解决方式是加一个判断框*//*
        if (count>0) {
            System.out.println(Thread.currentThread().getName() + ", 出售第" + (100 - count + 1) + "张火车票");
            count--;
        }
    }*/
    /*public void sale(){
    *//*同步代码块方式，其中object是同步代码对象*//*

        synchronized (object) {
            if (count > 0) {
                System.out.println(Thread.currentThread().getName() + ", 出售第" + (100 - count + 1) + "张火车票");
                count--;
            }
        }
    }*/
    public static void sale(){
    /*去除了同步代码块，将方法静态化，锁机制放置在进程当中*/
        if (count > 0) {
            System.out.println(Thread.currentThread().getName() + ", 出售第" + (100 - count + 1) + "张火车票");
            count--;
        }
    }
}
public class ThreadSafeDemo {
    public static void main(String[] args) {
        ThreadDemo threadDemo01=new ThreadDemo();
        ThreadDemo threadDemo02=new ThreadDemo();
        Thread t1=new Thread(threadDemo01, "窗口1");
        Thread t2=new Thread(threadDemo02, "窗口2");
        t1.start();
        t2.start();
    }
}

