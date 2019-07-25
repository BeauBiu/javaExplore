package ThreadDemo;
class ThreadTest07 extends Thread{
    public volatile boolean flag = true;

    @Override
    public void run() {
        System.out.println("子线程开始!!!");
        while (flag){

        }
        System.out.println("子线程结束!!!");
    }
    public void setRuning(boolean flag){
        this.flag = flag;
    }
}
public class ThreadDemo07 {
    public static void main(String[] args) {
        ThreadTest07 threadTest07=new ThreadTest07();
        threadTest07.start();
        try{
            Thread.sleep(3000);
        }catch (Exception e){
            System.out.println(e);
        }
        threadTest07.setRuning(false);
        System.out.println("flag已经改为false");
        try{
            Thread.sleep(1000);
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("flag:"+threadTest07.flag);
    }
}
