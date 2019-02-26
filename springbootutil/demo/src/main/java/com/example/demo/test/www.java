package com.example.demo.test;

public class www {

	public static void main(String[] args) {
		int[] arr=new int[]{0,1,0,2,0,1,1,0,0,2,1,2,2};
		System.out.println("leng:"+arr.length);
		int[] arr2=sortThreeColor(arr);
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i]+"  ");
		}
	}
	
  /**
	* 说明
	* 三色旗的问题最早由E.W.Dijkstra所提出，他所使用的用语为Dutch Nation Flag(Dijkstra为荷兰
	* 人)，而多数的作者则使用Three-Color Flag来称之。
	* 假设有一条绳子，上面有红、白、蓝三种颜色的旗子，起初绳子上的旗子颜色并没有顺序，
	* 希望将之分类，并排列为蓝、白、红的顺序，要如何移动次数才会最少，注意您只能在绳子上
	* 进行这个动作，而且一次只能调换两个旗子。
	* */
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
