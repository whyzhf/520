package com.example.demo.listGroup;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.example.demo.listGroup.CommonUtils.*;


public class Test {
 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 准备一个集合
 
		final int loop = 1000 * 1000;
		List<Data> list = new ArrayList<Data>(); // size=8 * loop
		for (int i = 0; i < loop; i++) {
			list.add(new Data().setId(1L).setCourseId(200010L).setContent("AAA"));
			list.add(new Data().setId(2L).setCourseId(200010L).setContent("BBB"));
			list.add(new Data().setId(3L).setCourseId(200011L).setContent("CCC"));
			list.add(new Data().setId(4L).setCourseId(200011L).setContent("DDD"));
			list.add(new Data().setId(5L).setCourseId(200010L).setContent("EEE"));
			list.add(new Data().setId(6L).setCourseId(200011L).setContent("FFF"));
			list.add(new Data().setId(7L).setCourseId(200010L).setContent("GGG"));
			list.add(new Data().setId(8L).setCourseId(200012L).setContent("HHH"));
		}
		// 进行分组 1
		long time = System.currentTimeMillis();
		Map<Long, List<Data>> map2 = new LinkedHashMap<Long, List<Data>>();
		listGroup2Map(list, map2, Data.class, "getId");// 输入方法名
		
		long duration = System.currentTimeMillis() - time;
 
		System.out.println("分组一执行：" + duration + "毫秒!");
 
		// 分组二
		time = System.currentTimeMillis();
		Map<Long, List<Data>> map = group(list, new GroupBy<Long>() {
			@Override
			public Long groupby(Object obj) {
				Data d = (Data) obj;
				return d.getCourseId(); // 分组依据为课程ID
			}
		});
 
		duration = System.currentTimeMillis() - time;
 
		System.out.println("分组二执行：" + duration + "毫秒!");
 
	}
 
}