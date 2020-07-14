package com.mann.tank;

import java.awt.Color;
import java.awt.Graphics;

public class Tank {

	/**
	 * 坦克的横坐标
	 */
	private int x;

	/**
	 * 坦克的纵坐标
	 */
	private int y;

	/**
	 * 坦克的初始方向
	 */
	private Dir dir = Dir.DOWN;

	/**
	 * 坦克的移动状态
	 */
	private boolean moving = false;

	/**
	 * 坦克的默认速度
	 */
	private static final int SPEED = 5;

	/**
	 * 坦克的宽度
	 */
	private static final int WIDTH = ResourceMgr.tankD.getWidth();

	/**
	 * 坦克的高度
	 */
	private static final int HEIGHT = ResourceMgr.tankD.getHeight();

	/**
	 * 坦克的默认生成状态
	 */
	private boolean living = true;

	/**
	 * 坦克所在的窗口对象
	 */
	private TankFrame tankFrame = null;

	public Tank(int x, int y, Dir dir, TankFrame tankFrame) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tankFrame = tankFrame;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Dir getDir() {
		return dir;
	}

	public void setDir(Dir dir) {
		this.dir = dir;
	}

	public static int getSpeed() {
		return SPEED;
	}

	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	public static int getWidth() {
		return WIDTH;
	}

	public static int getHeight() {
		return HEIGHT;
	}

	public boolean isLiving() {
		return living;
	}

	public void setLiving(boolean living) {
		this.living = living;
	}

	public void paint(Graphics g) {
		if (!living) {
			this.tankFrame.tankList.remove(this);
		}

		switch (dir) {

		case LEFT:
			g.drawImage(ResourceMgr.tankL, this.x, this.y, null);
			break;
		case UP:
			g.drawImage(ResourceMgr.tankU, this.x, this.y, null);
			break;
		case RIGHT:
			g.drawImage(ResourceMgr.tankR, this.x, this.y, null);
			break;
		case DOWN:
			g.drawImage(ResourceMgr.tankD, this.x, this.y, null);
			break;
		default:
			break;
		}

		move();
	}

	public void fire() {
		int bX = this.x + Tank.getWidth() / 2 - Bullet.getWidth() / 2;
		int bY = this.y + Tank.getHeight() / 2 - Bullet.getHeight() / 2;
		this.tankFrame.bulletList.add(new Bullet(bX, bY, this.dir, this.tankFrame));
	}

	private void move() {
		if (!moving)
			return;
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

	public void die() {
		this.living = false;
	}
}
