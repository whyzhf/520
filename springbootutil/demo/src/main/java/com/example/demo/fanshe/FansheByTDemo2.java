package com.example.demo.fanshe;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Properties;
/*
 * 通过反射越过泛型检查
 * 
 * 例如：有一个String泛型的集合，怎样能向这个集合中添加一个Integer类型的值？
 */
public class FansheByTDemo2 {
	
	public static void main(String[] args) throws Exception{
		ArrayList<Integer> strList = new ArrayList<>();
		strList.add(11);
		strList.add(22);
	
		//获取ArrayList的Class对象，反向的调用add()方法，添加数据
		Class<?> listClass = strList.getClass(); //得到 strList 对象的字节码 对象
		//获取add()方法
		Method m = listClass.getMethod("add", Object.class);
		//调用add()方法,添加值
		m.invoke(strList, "we");
		
		//遍历集合
		for(Object obj : strList){
			System.out.println(obj);
		}
	}

	
}
