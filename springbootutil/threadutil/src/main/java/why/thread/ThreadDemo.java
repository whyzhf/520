package why.thread;

/**
 * @author dell
 * @Auther: why
 * @Data:2018/10/16
 * @Deacription: 多线程的实现方式一：继承Thread()类
 *     多线程要执行的功能都应该在run（）方法中进行定义，
 *     但是要启动多线程需要使用start（）方法：
 *              run（）方法是不能直接被调用的，直接调用不是多线程只是一个普通方法；
 *              start（）方法会启动多线程，执行顺序不可控，
 *                  底层依赖操作系统提供的方法   private native void start0()，
 *                  不同操作系统实现方法不同，所以使用 native关键是创建空方法(JNI技术)；
 *               start（）方法只能启动一次，多次启动会出现运行期异常   throw new IllegalThreadStateException();
 *
 *
 */
public class ThreadDemo {
    public static void main(String[] args) {
        new  Mythread("线程A：").start();
        new  Mythread("线程B：").start();
        new  Mythread("线程C：").start();
    }
}

/**
 * 多线程定义类
 */
class Mythread extends Thread{
    private  String title;
    public Mythread(String title){
        this.title=title;
    }
    @Override
    public void run() {
        getNum();
    }

    public void  getNum(){
        int ind=1000;
        for (int x=0;x<ind;x++){
            System.out.println(title+"X="+x);
        }
    }

}
