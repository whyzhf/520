package com.example.demo.java8demo;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;


public class Demo2 {
	public static void main(String[] args) {
		List<Object[]> list =new ArrayList<Object[]>();
		Object[] obj={"w","5","1"};
		Object[] obj1={"w","6","2"};
		Object[] obj2={"w","4","3"};
		Object[] obj3={"w","2","4"};
		Object[] obj4={"w","5","1"};
		Object[] obj5={"w","1","6"};
		list.add(obj);
		list.add(obj1);
		list.add(obj2);
		list.add(obj3);
		list.add(obj4);
		list.add(obj5);
		
		list.stream().distinct().filter(e->e[2]!=null && !"".equals(e[2])).forEach(e->{
			System.out.println(e[0]+":"+e[1]+":"+e[2]);
		});
		/*OptionalInt a;
		try {
			a = list.stream().filter(e->"".equals(e[2])||null!=e[2]||"null".equalsIgnoreCase((String)e[2])).mapToInt(e->Integer.parseInt((String)e[2])).max();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			a=OptionalInt.of(-10);
		}
		System.out.println(a.getAsInt());*/
		
		
		List<String> list1 = new ArrayList();
        list1.add("1111");
        list1.add("2222");
        list1.add("3333");

        List<String> list2 = new ArrayList();
        list2.add("3333");
        list2.add("4444");
        list2.add("5555");

        // 交集
        List<String> intersection = list1.stream().filter(item -> list2.contains(item)).collect(Collectors.toList());
        System.out.println("---得到交集 intersection---");
        intersection.parallelStream().forEach(System.out :: println);

        // 差集 (list1 - list2)
        List<String> reduce1 = list1.stream().filter(item -> !list2.contains(item)).collect(Collectors.toList());
        System.out.println("---得到差集 reduce1 (list1 - list2)---");
        reduce1.parallelStream().forEach(System.out :: println);

        // 差集 (list2 - list1)
        List<String> reduce2 = list2.stream().filter(item -> !list1.contains(item)).collect(Collectors.toList());
        System.out.println("---得到差集 reduce2 (list2 - list1)---");
        reduce2.parallelStream().forEach(System.out :: println);

        // 并集
        List<String> listAll = list1.parallelStream().collect(Collectors.toList());
        List<String> listAll2 = list2.parallelStream().collect(Collectors.toList());
        listAll.addAll(listAll2);
        System.out.println("---得到并集 listAll---");
        listAll.parallelStream().forEach(System.out :: println);

        // 去重并集
        List<String> listAllDistinct = listAll.stream().distinct().collect(Collectors.toList());
        System.out.println("---得到去重并集 listAllDistinct---");
        listAllDistinct.parallelStream().forEach(System.out :: println);

        System.out.println("---原来的List1---");
        list1.parallelStream().forEach(System.out :: println);
        System.out.println("---原来的List2---");
        list2.parallelStream().forEach(System.out :: println);

        // 一般有filter 操作时，不用并行流parallelStream ,如果用的话可能会导致线程安全问题

    }

}
	
	


