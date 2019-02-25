/**
 * 
 */
package com.example.demo.java8demo;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.BiConsumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;





/**
 * @author why
 * 
 *
 * 类描述：
 * 创建时间：2017年9月12日 下午6:07:26
 * 修改人：dell
 * 修改时间：2017年9月12日 下午6:07:26
 * 修改备注：
 * @version
 * 2017年9月12日
 */
public class StreamDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//通过stream()方法即可获取流对象：
		Stream<Person> stream = new ArrayList<Person>().stream();
		List<Person> list = stream.collect(Collectors.toList());
		//通过Arrays类提供的静态函数stream()获取数组的流对象：
		Stream<String> stream2 = Arrays.stream(new String[]{"chaimm","peter","john"});
		//直接将几个值变成流对象：
		Stream<String> stream3 = Stream.of("chaimm","peter","john");
		//将文件变成流对象：
		try(Stream lines = Files.lines(Paths.get("文件路径名"),Charset.defaultCharset())){
			//可对lines做一些操作
		}catch(IOException e){
		} 
		//所有
		List<Person> result = list.stream()
                .filter(Person::isStudent)	//筛选
                .collect(Collectors.toList());//转list
		//去重
		List<Person> result2 = list.stream()
	            .distinct()
	            .collect(Collectors.toList());
		//截取前3个
		List<Person> result3 = list.stream()
                .limit(3)
                .collect(Collectors.toList());
	
		//跳过前3个
		List<Person> result4 = list.stream()
                .skip(3)
                .collect(Collectors.toList());
		//对流中的每个元素执行一个函数，使得元素转换成另一种类型输出。流会将每一个元素输送给map函数，并执行map中的Lambda表达式，最后将执行结果存入一个新的流中。
		//如，获取每个人的姓名(实则是将Perosn类型转换成String类型)：
		List<String> result5 = list.stream()
                .map(Person::getName)          
                .collect(Collectors.toList());
		
		
		
		//合并多个流 
		List<String> list2 = new ArrayList<String>();
		list2.add("I am a boy");
		list2.add("I love the girl");
		list2.add("But the girl loves another girl");

	    //首先将list变成流：
		list2.stream();
	    // 按空格分词：
	    list2.stream()
	            .map(line->line.split(" "));
	    //分完词之后，每个元素变成了一个String[]数组。
	    //将每个String[]变成流：
	    list2.stream()
	            .map(e->e.split(" "))
	            .map(Arrays::stream);
	    //此时一个大流里面包含了一个个小流，我们需要将这些小流合并成一个流。
	    //将小流合并成一个大流：
	    //用flatMap替换刚才的map
	    list2.stream()
	            .map(line->line.split(" "))
	            .flatMap(Arrays::stream);
	    //去重
	    list2.stream()
	            .map(line->line.split(" "))
	            .flatMap(Arrays::stream)
	            .distinct()
	            .collect(Collectors.toList());
	    
	    //anyMatch用于判断流中是否存在至少一个元素满足指定的条件，这个判断条件通过Lambda表达式传递给anyMatch，执行结果为boolean类型。
	    //如，判断list中是否有学生：
	    boolean result1 = list.stream()
	                .anyMatch(Person::isStudent);
	    //allMatch用于判断流中的所有元素是否都满足指定条件，这个判断条件通过Lambda表达式传递给anyMatch，执行结果为boolean类型。
	    //如，判断是否所有人都是学生：
	    boolean result6 = list.stream()
	                .allMatch(Person::isStudent);
	    
	    //noneMatch与allMatch恰恰相反，它用于判断流中的所有元素是否都不满足指定条件：
	    boolean result7 = list.stream()
	                .noneMatch(Person::isStudent);
	   // findAny能够从流中随便选一个元素出来，它返回一个Optional类型的元素。
	    Optional<Person> person = list.stream()
	                                        .findAny();
	    
	   /*Optional是Java8新加入的一个容器，这个容器只存1个或0个元素，它用于防止出现NullpointException，它提供如下方法：
	    	isPresent()
	    		判断容器中是否有值。
	    	ifPresent(Consume lambda)
	    		容器若不为空则执行括号中的Lambda表达式。
	    	T get()
	    		获取容器中的元素，若容器为空则抛出NoSuchElement异常。
	    	T orElse(T other)
	    		获取容器中的元素，若容器为空则返回括号中的默认值。
    	注:	OptionalDemo,OptionalTest 有详细解释
	    */ 
	 //   获取第一个元素findFirst
	    Optional<Person> person2 = list.stream()
                .findFirst();
	    
	    /*归约是将集合中的所有元素经过指定运算，折叠成一个元素输出，如：求最值、平均数等，这些操作都是将一个集合的元素折叠成一个元素输出。
		在流中，reduce函数能实现归约。
			reduce函数接收两个参数：
    				初始值
    				进行归约操作的Lambda表达式
	     */
	 //   计算所有人的最大年龄
	    OptionalInt age = list.stream()
                .mapToInt(Person::getAge)
                .max();
	 //   计算所有人的年龄和
	    int sum = list.stream()
                .collect(Collectors.summingInt(Person::getAge));
	    //   计算所有人的年龄平均值
	    double avg = list.stream()
                .collect(Collectors.averagingInt(Person::getAge));
	    /*Collectors.summarizingInt函数能一次性将最值、均值、总和、元素个数全部计算出来，并存储在对象IntSummaryStatisics中。
		可以通过该对象的getXXX()函数获取这些值。*/
	    
	    //将所有人的名字连接成一个字符串
	    String names2 = list.stream().map(Person::getName)
                .collect(Collectors.joining());
	    //每个字符串默认分隔符为空格，若需要指定分隔符，则在joining中加入参数即可：
	    String names3 = list.stream().map(Person::getName)
	                            .collect(Collectors.joining(", "));



	    //注 map里可以写方法,如下:
		String[] arr={"1","2","3"};
		String aString= Arrays.stream(arr).map( a->{
			 if (a.equals("2")) {
				 return "1"+a;
			 }else{
				 return "2"+a;
			 }
		 }
		).collect(Collectors.joining(","));//或者 .reduce(",",(a,b)->a+b)
		
		//注  join和reduce都可以拼接字符串,
		//reduce 内部是 String拼接
		//join 内部是StringBuilder
		
		//分组求最大值
		List<Person> Perlist=new ArrayList<>();
		Person p1=new Person("w",2,"n");
		Person p2=new Person("w",3,"n");
		Person p3=new Person("w1",4,"n");
		Person p4=new Person("w2",5,"n");
		Perlist.add(p1);
		Perlist.add(p2);
		Perlist.add(p3);
		Perlist.add(p4);
		  Map<String, Optional<Person>> groupBy=Perlist.stream()
				.collect(Collectors.groupingBy(Person::getName,
						Collectors.maxBy(Comparator.comparingInt(Person::getAge))));
		
		
		groupBy.forEach((K,V)->System.out.println("K:"+K+"  V:"+V));
	}
		
	
}
