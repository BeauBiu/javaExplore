package ThreadDemo;

public class ThreadDemo03 {
    public static void main(String[] args) {
        System.out.println("主线程开始！");
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<5;i++){
                    System.out.println("子i:"+i);
                }
            }
        });
        thread.start();
        for (int i=0;i<5;i++){
            System.out.println("主i:"+i);
        }
        System.out.println("主线程结束！");
    }
}
