package ThreadDemo;
class Test{
    public static Integer integer=0;
    public Integer demo(){
        return ++integer;
    }
}
public class ThreadLocalDemo extends Thread {
    private Test test;
    //这是一个构造器
    public ThreadLocalDemo(Test test){
        this.test=test;
    }
    @Override
    public void run() {
        for (int i=0;i<3;i++) {
            try {
                Thread.sleep(200);
            }catch (Exception e) {
                System.out.println(e);
            }
            System.out.println(Thread.currentThread().getName() + ", " + test.demo());
        }
    }

    public static void main(String[] args) {
        Test test=new Test();
        ThreadLocalDemo t1=new ThreadLocalDemo(test);
        ThreadLocalDemo t2=new ThreadLocalDemo(test);
        t1.start();
        t2.start();
    }
}
