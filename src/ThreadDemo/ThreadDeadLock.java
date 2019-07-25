package ThreadDemo;
/*这里展示了死锁产生的原因，即同步里面嵌套同步*/
class ThreadDemo06 implements Runnable{
    private int count=100;
    private Object object=new Object();
    @Override
    public void run() {
        synchronized (object) {
            try {
                Thread.sleep(1);
            }catch (Exception e){
                System.out.println(e);
            }
            sale01();
        }
    }
    public synchronized void sale01(){
        if (count>0){
            System.out.println(Thread.currentThread().getName() + ", 出售第" + (100-count+1) + "张票！");
            count--;
        }
    }
}
public class ThreadDeadLock {
    public static void main(String[] args) {
        ThreadDemo06 threadDemo01=new ThreadDemo06();
        ThreadDemo06 threadDemo02=new ThreadDemo06();
        Thread t1=new Thread(threadDemo01, "窗口1");
        Thread t2=new Thread(threadDemo02, "窗口2");
        t1.start();
        t2.start();
    }
}
