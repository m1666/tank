package com.mann.tank;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {

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
		g.fillRect(200, 200, 50, 50);
	}
	
	

}
