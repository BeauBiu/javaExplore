package ThreadDemo;

class ThreadTest01 extends Thread{
    @Override
    public void run() {
        for (int i=0; i<5;i++){
            System.out.println("子i:"+i);
        }
    }
}
public class ThreadDemo01 {
    public static void main(String[] args) {
        //用户线程，守护进程，
        //主线程（程序入口），子线程，GC进程（绑定主线程）
        System.out.println("主线程开始！");
        ThreadTest01 threadTest01 = new ThreadTest01();
        threadTest01.start();
        for (int i=0; i<5;i++){
            System.out.println("主i:"+i);
        }
        System.out.println("主线程结束！ ");
    }
}
