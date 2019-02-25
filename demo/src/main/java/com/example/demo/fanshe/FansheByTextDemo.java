package com.example.demo.fanshe;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
/*
 * 我们利用反射和配置文件，可以使：应用程序更新时，对源码无需进行任何修改
 * 我们只需要将新类发送给客户端，并修改配置文件即可
 */
public class FansheByTextDemo {
	public static void main(String[] args) throws Exception {
		//通过反射获取Class对象
		Class dogClass = Class.forName(getValue("className"));//"fanshe.Student"
		//2获取show()方法
		Method m = dogClass.getMethod(getValue("methodName"));//show
		//3.调用show()方法
		m.invoke(dogClass.getConstructor().newInstance());
		
	}
	
	//此方法接收一个key，在配置文件中获取相应的value
	public static String getValue(String key) throws IOException{
		Properties pro = new Properties();//获取配置文件的对象
		File f=new File("./src/fanshe/pro.txt");//当我们升级这个系统时，不要Dog类，而需要新写一个Dog2的类时，这时只需要更改pro.txt的文件内容就可以了。代码就一点不用改动
		FileReader in = new FileReader(f);//获取输入流
		pro.load(in);//将流加载到配置文件对象中
		in.close();
		return pro.getProperty(key);//返回根据key获取的value值
	}
}
