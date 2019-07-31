package ThreadTransform;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Transform03 {
    //无界队列，没有边界的队列
    //括号里的内容声明支持的队列数
    //当存的时候，如果队列已满则会等待
    //当取的时候，如果队列为空的时候也会等待
    //阻塞式在一定程度上可以避免丢失数据
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue =new ArrayBlockingQueue<>(3);
        blockingQueue.offer("张三");
        blockingQueue.offer("李四",3, TimeUnit.SECONDS);
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll(3,TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(3,TimeUnit.SECONDS));
    }
}
