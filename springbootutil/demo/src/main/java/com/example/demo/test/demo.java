package com.example.demo.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class demo {
	public static void main(String[] args) {
		//alistDemo();
		//System.out.println("最大公约数："+ maxPubDataDemo(12,12));
		//System.out.println("最小公倍数："+ minPubDataDemo(12,12));
		/*int[] arr=new int[]{0,1,0,2,0,1,1,0,0,2,1,1,2};
		int[] arr2=sortThreeColor(arr);
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i]+"  ");
		}*/
		String Str="124568_7";
		  System.out.println(Str.subSequence(0, Str.indexOf("_")) );
		
	}

	/**
	 * Arrays.asList虽然返回的是list,但是数据实际上还是存在数组里，
	 * 通过修改数组数据，可以修改list值，而list无法新增值
	 */
	public static void alistDemo() {
		String[] str=new String[]{"12","ww","dd"};
		List<String> lis=Arrays.asList(str);
		//lis.add("11");
		str[2]="125";
		lis.forEach(e->System.out.println(e));
	}
	
	/**
	 * 最大公约数
	 * */
	public static int maxPubDataDemo(int a,int b) {
		int minNum= a<=b?a:b;
		for (int i = minNum; i > 1 ; i--) {
			if(a%i==0&&b%i==0){
				return i;
			}
		}
		return 1; 
	}
	/**
	 * 最小公倍数
	 * */
	public static int minPubDataDemo(int a,int b) {
		int minNum= a<=b?a:b;
		int maxNum= a>b?a:b;
		if(maxNum%minNum==0){
			return maxNum;
		}
		for (int i = minNum; i > 1 ; i--) {
			if(a%i==0&&b%i==0){
				return i*(a/i)*(b/i);
			}
		}
		return a*b; 
		
	}
	 public static int[] sortThreeColor(int[] arr) {
	        int left=-1;
	        int right=arr.length;
	        int i=0;
	        while(i<right){//蓝、白、红
	     	   if(arr[i]==0){//蓝:往前移00
	                swap(arr,i,++left);
	     		   i++;
	     	   }else if(arr[i]==2){//红：往后移
	     		   swap(arr,i,--right);
	     	   }else{
	     		   i++;
	     	   }
	        }
	        return arr;
	     }
	     public static  void swap(int[] a, int i, int j) {
	 	       if(i!=j){
	 	    	   int temp=a[i];
	                a[i]=a[j];
	                a[j]=temp;
	 	       }
	 }
}
