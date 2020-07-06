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
//		System.out.println("【paint方法】: x = " + x + ", y = " + y);
		g.fillRect(x, y, 50, 50);
		// x += 10;
		// y += 10;
	}

	// 键盘监听处理类
	class MyKeyListener extends KeyAdapter {
		
		// 左、上、右、下 四个按键的默认状态。
		boolean bL = false;
		boolean bU = false;
		boolean bR = false;
		boolean bD = false;

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			switch (key) {
			case KeyEvent.VK_LEFT:
				bL = true;
				break;
			case KeyEvent.VK_UP:
				bU = true;
				break;
			case KeyEvent.VK_RIGHT:
				bR = true;
				break;
			case KeyEvent.VK_DOWN:
				bD = true;
				break;
			default:
				break;
			}
			// x += 200;
			// repaint();

		}

		@Override
		public void keyReleased(KeyEvent e) {
			int key = e.getKeyCode();
			switch (key) {
			case KeyEvent.VK_LEFT:
				bL = false;
				break;
			case KeyEvent.VK_UP:
				bU = false;
				break;
			case KeyEvent.VK_RIGHT:
				bR = false;
				break;
			case KeyEvent.VK_DOWN:
				bD = false;
				break;
			default:
				break;
			}
		}

	}

}
