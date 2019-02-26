package com.example.demo.sortDemo;

public class quickSortdemo {
	public static void main(String[] args) {
		int[] a={2,6,7,2,4,5,6,7,90,34,4};
		quickSort(a,0,a.length-1);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+"  ");
		}
	}
    /*快速排序
     * 从数列中挑出一个元素，称为 "基准"(pivot)，重新排序数列，
     * 所有元素比基准值小的摆放在基准前面，
     * 所有元素比基准值大的摆在基准的后面(相同的数可以到任一边)。
     * 在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区(partition)操作。
     * 递归地(recursive)把小于基准值元素的子数列和大于基准值元素的子数列排序。  
     */
	public static void quickSort(int[]  a ,int left,int right) {  
        if(left < right){  
            int i,j,t,temp;  
            temp=a[left]; //temp中存的就是基准数  
            i=left;  
            j=right;  
            while(i!=j)  
            {  
                //顺序很重要，要先从右边开始找  
                while(a[j]>=temp && i<j)  
                    j--;  
                //再找右边的  
                while(a[i]<=temp && i<j)  
                    i++;  
                //交换两个数在数组中的位置  
                if(i<j)  
                {  
                    t=a[i];  
                    a[i]=a[j];  
                    a[j]=t;  
                }  
            }  
            //最终将基准数归位  
            a[left]=a[i];  
            a[i]=temp;  
            quickSort(a,left,i-1);//继续处理左边的，这里是一个递归的过程  
            quickSort(a,i+1,right);//继续处理右边的 ，这里是一个递归的过程  
        }  
    }  
	/*
	 * 选择排序(Selection sort)是一种简单直观的排序算法。它的工作原理如下。
	 * 首先在未排序序列中找到最小元素，存放到排序序列的起始位置，
	 * 然后，再从剩余未排序元素中继续寻找最小元素，
	 * 然后放到排序序列末尾。
	 * 以此类推，直到所有元素均排序完毕。
	 * */
    public void selectSort(int[] array) {  
        int min;  
        int tmp = 0;  
        for (int i = 0; i < array.length; i++) {  
            min = array[i];  
            for (int j = i; j < array.length; j++) {  
                if (array[j] < min) {  
                    min = array[j];//最小值  
                    tmp = array[i];  
                    array[i] = min;  
                    array[j] = tmp;  
                }  
            }  
        }  
    }  
    
    
    /*
     * 冒泡 
     * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * 对每一对相邻元素作同样操作，从开始第一对到结尾的最后一对。在这一点，最后的元素会是最大的数。
     * 针对所有的元素重复以上的步骤，除了最后一个。
     * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
     * */ 
    private void pubbleSort(int[] numbers) {  
        int temp;//记录临时变量  
        int size = numbers.length;//数组大小  
        for (int i = 0; i < size - 1; i++) {  
            for (int j = i + 1; j < size; j++) {//索引不同的两层for循环  
                if (numbers[i] < numbers[j]) {//交互数据从大到小排列顺序  大的放前面  
                    temp = numbers[i];  
                    numbers[i] = numbers[j];  
                    numbers[j] = temp;  
                }  
            }  
        }  
    }  
    /*插入排序
     * 从第一个元素开始，该元素可以认为已经被排序；
     * 取出下一个元素，在已经排序的元素序列中从后向前扫描；
     * 如果该元素(已排序)大于新元素，将该元素移到下一位置；
     * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
     * 将新元素插入到该位置中，重复步骤2。
     * */ 
    private void InsertSort(int[] a) {  
        long t1 = System.nanoTime();  
        //直接插入排序  
        for (int i = 1; i < a.length; i++) {  
            //待插入元素  
            int temp = a[i];  
            int j;  
            for (j = i - 1; j >= 0; j--) {  
                //将大于temp的往后移动一位  
                if (a[j] > temp) {  
                    a[j + 1] = a[j];  
                } else {  
                    break;  
                }  
            }  
            a[j + 1] = temp;//插入进来  
        }  
    } 
    
    /*希尔排序 
     * 插入排序在对几乎已经排好序的数据操作时，效率高，即可以达到线性排序的效率；
     * 但插入排序一般来说是低效的， 因为插入排序每次只能将数据移动一位。 
     */
    private void HeerSort(int[] a) {  
        int d = a.length / 2;  
        while (true) {  
            for (int i = 0; i < d; i++) {  
                for (int j = i; j + d < a.length; j += d) {  
                    int temp;  
                    if (a[j] > a[j + d]) {  
                        temp = a[j];  
                        a[j] = a[j + d];  
                        a[j + d] = temp;  
                    }  
                }  
            }  
            if (d == 1) {  
                break;  
            }  
            d--;  
        }  
    }  
}
