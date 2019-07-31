package ThreadTransform;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class ProducerThread implements Runnable{
    public BlockingQueue<String> blockingQueue;
    public volatile boolean FLAG=true;
    public ProducerThread(BlockingQueue<String> blockingQueue){
        this.blockingQueue=blockingQueue;
    }
    @Override
    public void run() {
        System.out.println("生产者线程已经启动！！！");
        try{
            while (FLAG){

            }
        }catch (Exception e){
            System.out.println(e);
        }finally {
            System.out.println("生产者线程结束！！！");
        }
    }
}
class CustomerThread implements Runnable{
    @Override
    public void run() {

    }
}
public class Transform04 {
    public static void main(String[] args) {

    }
}
