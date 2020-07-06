package com.mann.tank;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
	
	private static int x = 200, y = 200;

	public TankFrame() {
		// 创建窗口
		this.setSize(800, 600);
		this.setResizable(false);
		this.setTitle("tank war");
		this.setVisible(true);
		
		// 按键监听
		this.addKeyListener(new MyKeyListener());

		// 创建监听器，监听当点击叉叉的时候，退出系统
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// 当点击叉叉的时候，退出系统
				System.exit(0);
			}

		});
	 }

	@Override
	public void paint(Graphics g) {
		
		// paint方法会使整个画布刷新
		System.out.println("【paint方法】: x = " + x + ", y = " + y);
		g.fillRect(x, y, 50, 50);
		x += 10;
		y += 10;
	}
	
	// 键盘监听处理类
	class MyKeyListener extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			// 当按键按下去时触发
			System.out.println("key pressed");
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// 当按键按抬起时触发
			System.out.println("key released");
		}
		
	}
	

}
