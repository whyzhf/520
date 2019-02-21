package com.example.demo.MVPDemo;

import java.util.Observable;

public class WeatherStationN extends Observable {
	 private float temperature;
	    public WeatherStationN() {
	        // 由于继承了Observable，它已经创建了一个Vector来存放Observer对象的容器，所以此处不用再建立ArrayList
	    }

	    /*
	     *  此方法用于气象站收到的数据,并且调用更新使数据实时通知给观察者
	     */
	    public void setMeasurements(float temp){
	        this.temperature = temp;
	        System.out.println("气象站测量的温度为：" + temp + "℃");
	        // 更新强调用表示有状态更新
	        setChanged();
	        notifyObservers(temperature);
	    }
}
