package com.mann.tank;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class TankFrame extends Frame {

	Tank myTank = new Tank(200, 200, Dir.DOWN, this);
	List<Bullet> bulletList = new ArrayList<>();
	protected static final int GAME_WIDTH = 800;
	protected static final int GAME_HEIGHT = 600;

	public TankFrame() {
		// 创建窗口
		this.setSize(GAME_WIDTH, GAME_HEIGHT);
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

	// 利用双缓冲解决坦克闪烁问题
	Image offScreenImage = null;

	@Override
	public void update(Graphics g) {
		if (offScreenImage == null) {
			offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
		}
		Graphics gOffScreen = offScreenImage.getGraphics();
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.BLACK);
		gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
		gOffScreen.setColor(c);
		paint(gOffScreen);
		g.drawImage(offScreenImage, 0, 0, null);
	}

	@Override
	public void paint(Graphics g) {

		Color c = g.getColor();
		g.setColor(Color.WHITE);
		g.drawString("当前子弹的数量：" + bulletList.size(), 5, 40);
		g.setColor(c);

		myTank.paint(g);
		for (int i = 0; i < bulletList.size(); i++) {
			bulletList.get(i).paint(g);
		}

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

			setMainTankDir();

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
			case KeyEvent.VK_SPACE:
				myTank.fire();
				break;
			default:
				break;
			}

			setMainTankDir();
		}

		private void setMainTankDir() {
			if (!bL && !bU && !bR && !bD)
				myTank.setMoving(false);
			else {
				myTank.setMoving(true);
				if (bL)
					myTank.setDir(Dir.LEFT);
				else if (bU)
					myTank.setDir(Dir.UP);
				else if (bR)
					myTank.setDir(Dir.RIGHT);
				else if (bD)
					myTank.setDir(Dir.DOWN);
			}
		}

	}

}
