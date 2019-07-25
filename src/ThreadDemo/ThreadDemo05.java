package ThreadDemo;

public class ThreadDemo05 {
    public static void main(String[] args){
        System.out.println("主线程开始！");
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("子线程执行开始！");
                for (int i=0;i<10;i++){
                    System.out.println("子线程i:"+i);
                    try{
                        Thread.sleep(100);
                    }catch (Exception e){
                        System.out.println("错误提示e:"+e);
                    }
                }
                System.out.println("子线程执行完毕！");
            }
        });
        thread.start();
        try{
            thread.join();
        }
        catch (Exception e){
            System.out.println("错误提示e:"+e);
        }
        for (int i=0;i<=10;i++){
            System.out.println("主线程i:"+i);
            try{
                Thread.sleep(100);
            }catch (Exception e){
                System.out.println("错误提示e:"+e);
            }
        }
        System.out.println("主线程完毕！");
    }
}
