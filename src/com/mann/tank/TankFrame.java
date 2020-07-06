package com.mann.tank;

import java.awt.Frame;
import java.awt.Graphics;
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
		
		System.out.println("x = " + x + ", y = " + y);
		g.fillRect(x, y, 50, 50);
		x += 50;
		y += 50;
	}
	
	
	

}
