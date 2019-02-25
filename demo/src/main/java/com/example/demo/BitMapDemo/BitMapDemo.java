package com.example.demo.BitMapDemo;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Random;

public class BitMapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr =new int[]{1,2,3,9};
		BitSet bs=new BitSet(4);
		for (int i = 0; i < arr.length; i++) {
			bs.set(arr[i],true);
		}
		System.out.println(bs.size());
		System.out.println("-------");
		System.out.println(bs.get(3));
		
		
		
       //findNumFromNums();
	}

	/**
	 * 有1千万个随机数，随机数的范围在1到1亿之间。现在要求写出一种算法，将1到1亿之间没有在随机数中的数求出来？
	 */
	public static void findNumFromNums() {
		Random random=new Random();
	    List<Integer> list=new ArrayList<>();
	    for(int i=0;i<10000000;i++) {
	        int randomResult=random.nextInt(100000000);
	        list.add(randomResult);
	    }
	    System.out.println("产生的随机数有");
	    for(int i=0;i<list.size();i++) {
	        System.out.println(list.get(i));
	    }
	    BitSet bitSet=new BitSet(100000000);
	    for(int i=0;i<10000000;i++){
	        bitSet.set(list.get(i));
	    }
	    
	    System.out.println("0~1亿不在上述随机数中有"+bitSet.size());
	    for (int i = 0; i < 100000000; i++){
	        if(!bitSet.get(i)){
	            System.out.println(i);
	        }
	    }
	}
  
}
