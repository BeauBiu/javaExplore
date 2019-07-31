package ThreadDemo;
/*
同步代码块：synchronized(object){}
非静态同步方法：对需要加锁的方法使用synchronized修饰该方法
非静态同步代码块等效于synchronized(this){}
测试同步代码块和非静态同步方法这两种加锁方式加的是否是同一把锁
通过设置一个flag测试两种加锁方式
当两把锁不一致时会有线程安全问题
*/
class ThreadTest08 extends Thread{
    public int count=100;
    private static Object object=new Object();
    public boolean flag=true;

    @Override
    public void run() {
        if(flag){
            while (count>0) {
                sale();
            }
        }else {
            synchronized (this) {
                while (count>0) {
                    try {
                        Thread.sleep(10);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    System.out.println("窗口" + Thread.currentThread().getName() + "销售第" + (100 - count + 1) + "张票！");
                    count--;
                }
            }
        }
    }
    public synchronized void sale(){
        try{
            Thread.sleep(10);
        }catch (Exception e){
            System.out.println(e);
        }
        if (count>0) {
            System.out.println("窗口" + Thread.currentThread().getName() + "销售第" + (100 - count + 1) + "张票！");
            count--;
        }
    }
    public void setFlag(Boolean flag){
        this.flag=flag;
    }
}
public class ThreadDemo08 {
    public static void main(String[] args) {
        ThreadTest08 threadTest08=new ThreadTest08();
        Thread thread01=new Thread(threadTest08,"一号");
        Thread thread02=new Thread(threadTest08,"二号");
        thread01.start();
        try {
            Thread.sleep(40);
        }catch (Exception e){
            System.out.println(e);
        }
        threadTest08.setFlag(false);
        thread02.start();
    }
}
