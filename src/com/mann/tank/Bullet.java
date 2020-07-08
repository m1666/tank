package com.mann.tank;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet {

	/**
	 * 子弹发射速度
	 */
	private static final int SPEED = 10;

	/**
	 * 子弹大小的宽度
	 */
	private static final int WIDTH = 5;

	/**
	 * 子弹大小的高度
	 */
	private static final int HEIGHT = 5;

	/**
	 * 子弹的横坐标
	 */
	private int x;

	/**
	 * 子弹的纵坐标
	 */
	private int y;

	/**
	 * 子弹方向
	 */
	private Dir dir;

	/**
	 * 子弹是否还在界面内
	 */
	private boolean live = true;
	
	/**
	 * 子弹所在的窗口对象
	 */
	private TankFrame tankFrame = null;

	public Bullet(int x, int y, Dir dir, TankFrame tankFrame) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tankFrame = tankFrame;
	}

	public void paint(Graphics g) {
		if (!live) {
			this.tankFrame.bulletList.remove(this);
		}
		Color c = g.getColor();
		g.setColor(Color.RED);
		g.fillOval(x, y, WIDTH, HEIGHT);
		g.setColor(c);

		move();
	}

	private void move() {
		switch (this.dir) {
		case LEFT:
			this.x -= SPEED;
			break;
		case UP:
			this.y -= SPEED;
			break;
		case RIGHT:
			this.x += SPEED;
			break;
		case DOWN:
			this.y += SPEED;
			break;
		default:
			break;
		}
		if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) {
			this.live = false;
		}
	}

}
