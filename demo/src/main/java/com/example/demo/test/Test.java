package com.example.demo.test;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Test extends JFrame {
	private RainCanvas canvas=new RainCanvas(800, 600);
	
	public Test() {
		super("Test");
		setUndecorated(true);
		setSize(1000,600);
		setVisible(true);
		canvas=new RainCanvas(this.getWidth(), this.getHeight());
		getContentPane().add(canvas);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		Test test=new Test();
		test.canvas.startRain();
	}
}
