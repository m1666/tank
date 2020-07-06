package com.mann.tank;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Demo {

	public static void main(String[] args) {
		Frame f = new Frame();

		// 创建窗口
		f.setSize(800, 600);
		f.setResizable(false);
		f.setTitle("tank war");
		f.setVisible(true);

		// 创建监听器，监听当点击叉叉的时候，退出系统
		f.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// 当点击叉叉的时候，退出系统
				System.exit(0);
			}

		});
	}

}
