package why.thread;

/**
 * @Auther: why
 * @Data:2018/10/17
 * @Deacription:
 */
public class ThreadTest {
    public static void main(String[] args) {
        System.out.println(text());
    }

    public static String text(){
        System.out.println("执行方法一。。。。。。。。。。。");
        new Thread(()->{//子线程执行耗时方法。需要返回值是使用callable
            for (int x=0;x<10;x++){
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        System.out.println("执行方法二。。。。。。。。。。。");
        return "11111";
    }
}

