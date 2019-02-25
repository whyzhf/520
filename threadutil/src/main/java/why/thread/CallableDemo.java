package why.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Auther: why
 * @Data:2018/10/16
 * @Deacription: 多线程的实现方式三（有返回值）：实现callable()接口
 *          Runnable与Callable的区别：
 *              1，Runnable是在JDK1.0提出来的，Callable是JDK1.5之后提出的
 *              2，java.lang.runnable 接口之中只提供有一个run（）方法，没有返回值
 *                  java.util.concurrent.Callable接口提供有call（）方法，有返回值（通过FutureTask 中get（）方法获取）
 */
public class CallableDemo {
    public static void main(String[] args) {
        FutureTask<String> task=new FutureTask<>(new MyCallable());
        new Thread(task).start();
        String result= null;
        try {
            result = task.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("线程返回数据："+result);
    }
}

class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("**************线程启动**************");
        return "***************线程关闭***************";
    }
}