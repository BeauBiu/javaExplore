package ThreadDemo;

class ThreadTest implements Runnable{
    public void run(){
        for (int i=0;i<5;i++){
            System.out.println("子i:"+i);
        }
    }
}
public class ThreadDemo02 {
    public static void main(String[] args) {
        System.out.println("main..主线程开始");
        ThreadTest threadTest=new ThreadTest();
        Thread thread=new Thread(threadTest);
        thread.start();
        for (int i=0;i<5;i++){
            System.out.println("主i:"+i);
        }
        System.out.println("main..主线程结束");
    }
}
