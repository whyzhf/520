package why.singleton;

/**
 * @Auther: why
 * @Data:2018/10/29
 * @Deacription: 懒汉式单例设计模式问题：
 *           懒汉式：1，私有化构造方法  2，通过静态方法内部调用私有化静态类参数实现单例
 *           缺点：单线程可用，多线程无法实现单例
 *           改进：在实例化对象使用synchironized(singleton.class)同步，再一次进行判空
 *           volatile优化：对象存储会产生一个副本，一般实例化会操作副本，使用volatile直接操作对象
 */
public class Singleton {
    public static void main(String[] args) {
        for (int i=0;i<5;i++){
            new Thread(()->{
                SingletonDemo.getInstance().print();
            },"线程"+i).start();
        }
    }
}

class SingletonDemo{
    private static  volatile  SingletonDemo instance;
    private SingletonDemo(){
        System.out.println(Thread.currentThread().getName()+":创建实例化");
    }
    public static SingletonDemo getInstance() {
        if(instance==null){
            synchronized (SingletonDemo.class) {
                if (instance == null) {
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }
    public void print(){
        System.out.println("【单例模式】");
    }
}
