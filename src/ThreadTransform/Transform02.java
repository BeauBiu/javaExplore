package ThreadTransform;

import java.util.concurrent.ConcurrentLinkedQueue;

/*阻塞式队列和非阻塞式队列*/
public class Transform02 {
    //阻塞式优势：防止队列容器溢出或者说防止丢失
    public static void main(String[] args) {
        //阻塞式对象是属于并发式的
        //非阻塞式队列，无界
        ConcurrentLinkedQueue<String> concurrentLinkedQueue=new ConcurrentLinkedQueue<String>();
        concurrentLinkedQueue.offer("张三");
        concurrentLinkedQueue.offer("李四");
        concurrentLinkedQueue.offer("刘斌");
        //获取队列
        System.out.println(concurrentLinkedQueue.poll());
        System.out.println(concurrentLinkedQueue.poll());
        System.out.println(concurrentLinkedQueue.poll());
        //遵循先进先出、后进后出原则
        //从队列中获取完毕后即将其销毁（poll方法）
        //获取队列个数
        System.out.println(concurrentLinkedQueue.size());
    }
}
