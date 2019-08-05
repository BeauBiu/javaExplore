import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
class TaskThread implements Runnable{
    private String stringName;
    //这里对TaskThread类进行重新构造，为其构造了一个新的参数stringName
    public TaskThread(String stringName) {
        this.stringName = stringName;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+":"+stringName);
    }
}
public class ThreadPool02 {
    public static void main(String[] args) {
        //这里是线程编排（阻塞式队列）
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2, 0L, TimeUnit.MINUTES,
                new LinkedBlockingQueue<Runnable>(3));
        threadPoolExecutor.execute(new TaskThread("任务1"));
        threadPoolExecutor.execute(new TaskThread("任务2"));
        threadPoolExecutor.execute(new TaskThread("任务3"));
        threadPoolExecutor.execute(new TaskThread("任务4"));
        threadPoolExecutor.execute(new TaskThread("任务5"));
        //在任务5执行时，阻塞队列已经满了，这时任务5调用了最大线程数内未被使用的线程
        //执行到任务6时，阻塞队列已经满了，线程的使用度已经达到最大值2了，因此任务6就没办法执行了（报错）
        threadPoolExecutor.execute(new TaskThread("任务6"));
    }
}
