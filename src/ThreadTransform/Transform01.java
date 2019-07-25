package ThreadTransform;

class Res{
    public String name;
    public String sex;
    //flag为true的情况下允许读操作，但是不允许写操作
    public boolean flag=false;
}
class IntThread extends Thread{
    public Res res;
    public IntThread(Res res){
        this.res=res;
    }
    @Override
    public void run() {
        int count=0;
        for(int i=0;i<100;i++){
            synchronized (res) {
                if (res.flag){
                    try {
                        res.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (count == 0) {
                    res.name = "小红";
                    res.sex = "女";
                } else {
                    res.name = "小军";
                    res.sex = "男";
                }
                count = (count + 1) % 2;/*这里count会变成01序列循环出现*/
                res.flag=true; //释放当前锁对象
                //res.notify();
            }/*这里在实时刷新res对象实例的值，在读的过程中刷新的速度不等于写的速度就会发生数据错乱*/
        }
    }
}
class OutThread extends Thread {
    public Res res;
    public OutThread(Res res) {
        this.res = res;
    }

    @Override
    public void run() {
        for (int i=0;i<100;i++){
            synchronized (res) {
                if (!res.flag){
                    try {
                        res.wait();//进程等待
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(res.name + ", " + res.sex);
                res.flag=false;
                //res.notify();//唤醒被等待的对象
            }
        }
    }
}
public class Transform01 {
    public static void main(String[] args) {
        Res res=new Res();
        IntThread intThread=new IntThread(res);
        OutThread outThread=new OutThread(res);
        intThread.start();
        outThread.start();
        //副本变量没有及时刷新到主内存中
        //读和写都得加锁才能解决数据错乱问题
        //读的时候加锁，读的过程中写不得对该对象操作
        //写的时候加锁，写的过程中读不允许对该对象操作
        //只有wait没有notify时，锁会永远等待
    }
}
