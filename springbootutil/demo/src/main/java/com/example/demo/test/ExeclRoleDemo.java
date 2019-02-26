package com.example.demo.test;

public class ExeclRoleDemo {
	 public static void main(String[] args) {
		 //最大值，最小值，分几段（x-1）
	        standard(1000,490,5);
	        Runtime run= Runtime.getRuntime();
	        System.out.println("最大线程数："+run.availableProcessors());
	        System.out.println("最大可用内存："+run.maxMemory());
	        System.out.println("可用内存："+run.totalMemory());
	        System.out.println("空闲内存："+run.freeMemory());

	        

	    }

	    public static void standard(double cormax, double cormin, double cornumber) {
	    	//double cormax 输入的最大刻度
	    	//double cormin 输入的最下刻度
	    	//double cornumber 需要分几段
	        double realmaxmoney;//计算后真实最大刻度
	        double realminmoney; //计算后真实记录最小刻度
	        double corstep;// 每段刻度间距
	        double tmpstep;//选取规范步长
	        double tmpnumber;// 真实最大刻度-真实记录最小刻度/规范步长
	        double temp;//
	        double extranumber;//
	        realmaxmoney = Double.valueOf(cormax);
	        realminmoney = Double.valueOf(cormin);
	        if (cormax <= cormin){//如果最大值小于最小值，结束
	            return;
	        }
	        corstep = (cormax - cormin) / cornumber; //计算输入数据的分段间距
	        
	        //Math.pow(x,y):x的y次方    Math.log(corstep)：对数     (Math.log(corstep) / Math.log(10)) =ln corstep
	        if (Math.pow(10, (int) (Math.log(corstep) / Math.log(10))) == corstep) {
	            temp = Math.pow(10, (int) (Math.log(corstep) / Math.log(10)));
	        } else {
	            temp = Math.pow(10, ((int) (Math.log(corstep) / Math.log(10)) + 1));
	        }
	        tmpstep = corstep / temp;
	        //选取规范步长
	        if (tmpstep >= 0 && tmpstep <= 0.1) {
	            tmpstep = 0.1;
	        } else if (tmpstep >= 0.100001 && tmpstep <= 0.2) {
	            tmpstep = 0.2;
	        } else if (tmpstep >= 0.200001 && tmpstep <= 0.25) {
	            tmpstep = 0.25;
	        } else if (tmpstep >= 0.250001 && tmpstep <= 0.5) {
	            tmpstep = 0.5;
	        } else {
	            tmpstep = 1;
	        }
	        tmpstep = tmpstep * temp;
	        //规范化最大刻度，最小刻度
	        if ((int) (cormin / tmpstep) != (cormin / tmpstep)) {
	            if (cormin < 0) {
	                cormin = (-1) * Math.ceil(Math.abs(cormin / tmpstep)) * tmpstep;
	            } else {
	                cormin = (int) (Math.abs(cormin / tmpstep)) * tmpstep;
	            }

	        }
	        if ((int) (cormax / tmpstep) != (cormax / tmpstep)) {
	            cormax = (int) (cormax / tmpstep + 1) * tmpstep;
	        }
	        tmpnumber = (cormax - cormin) / tmpstep;
	        if (tmpnumber < cornumber) {
	            extranumber = cornumber - tmpnumber;
	            tmpnumber = cornumber;
	            if (extranumber % 2 == 0) {
	                cormax = cormax + tmpstep * (int) (extranumber / 2);
	            } else {
	                cormax = cormax + tmpstep * (int) (extranumber / 2 + 1);
	            }
	            cormin = cormin - tmpstep * (int) (extranumber / 2);
	        }
	        cornumber = tmpnumber;

	        double nummoney = 0;
	        String text = "";
	        double keduwidth = (cormax - cormin) / cornumber;
	        for (int i = 1; nummoney < realmaxmoney; i++) {
	            nummoney = keduwidth * i + cormin;
	            text = text + String.valueOf(nummoney) + "---";
	        }
	        System.out.println("最终刻度:"+ cormin+"---"+text);

	    }
	    
	    
	    
}
