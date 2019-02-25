package why.thread;

/**
 * @Auther: why
 * @Data:2018/10/16
 * @Deacription: 多线程的实现方式二（优先）：实现runable()接口
 *                  解决了单继承问题
 */
public class RunableDemo {
    public static void main(String[] args) {
        //第一种实现方式：jdk8以前
        Thread th1=new Thread(new MyRunable("线程A:"));
        Thread th2=new Thread(new MyRunable("线程B:"));
        Thread th3=new Thread(new MyRunable("线程C:"));
        th1.start();
        th2.start();
        th3.start();
        //第二种实现方式（jdk8 lambda表达式创建）
        new MyRunable2().MyRunable();
        //第三种实现方式（推荐：由第二种改进）
        new MyRunable3().MyRunable();
    }
}

/**
 * 实现方式一
 */
class MyRunable implements Runnable{
    private String title;
    public  MyRunable(String title){
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

/**
 * 实现方式二
 */
class MyRunable2{
    public void MyRunable(){
        for (int x=1;x<4;x++){
            String title="线程"+x+":";
            Runnable run =() -> {
                for (int y=0;y<1000;y++){
                    System.out.println(title+"y="+y);
                }
            };
            new Thread(run).start();
        }
    }
}

/**
 * 实现方式三
 */
class MyRunable3{
    public void MyRunable(){
        for (int x=1;x<4;x++){
            String title="线程"+x+":";
            new Thread(() -> {
                for (int y=0;y<1000;y++){
                    System.out.println(title+"y="+y);
                }
            }).start();
        }
    }
}