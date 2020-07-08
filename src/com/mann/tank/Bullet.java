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

	public Bullet(int x, int y, Dir dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}

	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.RED);
		g.fillOval(x, y, WIDTH, HEIGHT);
		g.setColor(c);

		move();
	}

	private void move() {
		switch (this.dir) {
		case LEFT:
			x -= SPEED;
			break;
		case UP:
			y -= SPEED;
			break;
		case RIGHT:
			x += SPEED;
			break;
		case DOWN:
			y += SPEED;
			break;
		default:
			break;
		}
	}

}
