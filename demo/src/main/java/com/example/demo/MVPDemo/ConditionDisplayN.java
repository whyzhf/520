package com.example.demo.MVPDemo;

import java.util.Observer;
import java.util.Observable;
public class ConditionDisplayN implements Observer,DisplayElement{
    private Observable observable;
    private float temp;

    public ConditionDisplayN(Observable observable) {
        // 构造器需要Observable作为参数
        this.observable = observable;
        observable.addObserver(this);
    }
    @Override
    public void display() {
        // 将数据显示在布告板上
        System.out.println("布告板显示当前温度为：" + temp + "℃");
    }

    @Override
    public void update(Observable o, Object arg) {
        // 当被观察者有更新使触发
        if (o instanceof WeatherStationN) {
            this.temp = (float) arg;
            display();
        }
    }
}