package ThreadDemo;

public class ThreadDemo04 {
    public static void main(String[] args) {
        System.out.println("主线程开始！");
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10;i++){
                    try{

                        Thread.sleep(500);
                    }catch (Exception e){
                        System.out.println("错误状态e:"+e);
                    }
                System.out.println("子线程i:"+i);
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
        for (int i=0;i<10;i++){
            try{

                Thread.sleep(200);
            }catch (Exception e){
                System.out.println("错误状态e:"+e);
            }
            System.out.println("主线程i:"+i);
        }
        System.out.println("主线程结束！");
    }
}
