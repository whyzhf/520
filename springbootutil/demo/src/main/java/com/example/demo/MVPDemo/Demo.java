package com.example.demo.MVPDemo;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 // 首先创建一个主题/被观察者
        WeatherStationN weatherStationN = new WeatherStationN();
        // 创建观察者并将被观察者对象传入
        ConditionDisplayN conditionDisplayN = new ConditionDisplayN(weatherStationN);

        // 设置气象站模拟收到的气温数据
        weatherStationN.setMeasurements(30);
        weatherStationN.setMeasurements(25);
        weatherStationN.setMeasurements(20);
	}

}
