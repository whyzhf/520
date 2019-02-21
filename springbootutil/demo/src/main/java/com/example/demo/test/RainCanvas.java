package com.example.demo.test;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

@SuppressWarnings("serial")
public class RainCanvas extends Canvas implements Runnable {
	private int width, height;
	private Image offScreen;// 缓冲图片
	private char[][] charset;// 随机字符集合
	private int[] pos;// 列的起始位置
	private Color[] colors = new Color[30];// 列的渐变颜色

	public RainCanvas(int width, int height) {
		this.width = width;
		this.height = height;
		// 生成ASCII可见字符集合
		Random rand = new Random();
		charset = new char[width / 10][height / 10];
		for (int i = 0; i < charset.length; i++) {
			for (int j = 0; j < charset[i].length; j++) {
				charset[i][j] = (char) (rand.nextInt(96) + 48);
			}
		}
		// 随机化列起始位置
		pos = new int[charset.length];
		for (int i = 10; i < pos.length; i++) {
			pos[i] = rand.nextInt(pos.length);
		}
		// 生成从黑色到绿色的渐变颜色，最后一个保持为白色
		for (int i = 0; i < colors.length - 1; i++) {
			colors[i] = new Color(0, 255 / colors.length * (i + 1), 0);
		}
		colors[colors.length - 1] = new Color(255, 255, 255);
		// 设定背景颜色
		setBackground(Color.black);
		setSize(width, height);
		// 默认窗口打开
		setVisible(true);

	}

	// 启动线程
	public void startRain() {
		new Thread(this).start();
	}

	@SuppressWarnings("unused")
	public void drawRain() {
		if (offScreen == null) {
			return;
		}
		Random rand = new Random();
		Graphics g = offScreen.getGraphics();// 抽象画笔
		g.clearRect(0, 0, width, height);
		g.setFont(new Font("Arial", Font.PLAIN, 14));

		for (int i = 0; i < charset.length; i++) {
			int speed = rand.nextInt(3);
			for (int j = 0; j < colors.length; j++) {
				int index = (pos[i] + j) % charset[i].length;
				g.setColor(colors[j]);
				g.drawChars(charset[i], index, 1, i * 10, index * 10);
			}
			pos[i] = (pos[i] + 1) % charset[i].length;
		}
	}

	public void update(Graphics g) {
		paint(g);

	}

	@Override
	public void run() {
		while (true) {
			drawRain();
			repaint();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}

	}

	public void paint(Graphics g) {
		// 当组件显示时检测是否需要创建缓冲图片，在组建还不可见是调用createImage将返回null
		if (offScreen == null) {
			offScreen = createImage(width, height);
		}
		g.drawImage(offScreen, 0, 0, this);
	}
}
