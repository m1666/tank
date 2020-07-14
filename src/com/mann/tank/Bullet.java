package com.mann.tank;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet {

	/**
	 * 子弹发射速度
	 */
	private static final int SPEED = 10;

	/**
	 * 子弹大小的宽度
	 */
	private static final int WIDTH = ResourceMgr.bulletD.getWidth();

	/**
	 * 子弹大小的高度
	 */
	private static final int HEIGHT = ResourceMgr.bulletD.getHeight();

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
	private boolean liveing = true;

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

	public boolean isLive() {
		return liveing;
	}

	public void setLive(boolean live) {
		this.liveing = live;
	}

	public static int getSpeed() {
		return SPEED;
	}

	public static int getWidth() {
		return WIDTH;
	}

	public static int getHeight() {
		return HEIGHT;
	}

	public void paint(Graphics g) {
		if (!liveing) {
			this.tankFrame.bulletList.remove(this);
		}

		switch (dir) {
		case LEFT:
			g.drawImage(ResourceMgr.bulletL, this.x, this.y, null);
			break;
		case UP:
			g.drawImage(ResourceMgr.bulletU, this.x, this.y, null);
			break;
		case RIGHT:
			g.drawImage(ResourceMgr.bulletR, this.x, this.y, null);
			break;
		case DOWN:
			g.drawImage(ResourceMgr.bulletD, this.x, this.y, null);
			break;
		default:
			break;
		}

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
			this.liveing = false;
		}
	}

	/**
	 * 坦克碰撞验证
	 * 
	 * @param tank
	 */
	public void collideWith(Tank tank) {
		Rectangle rectBullet = new Rectangle(this.x, this.y, this.WIDTH, this.HEIGHT);
		Rectangle rectTank = new Rectangle(tank.getX(), tank.getY(), tank.getWidth(), tank.getHeight());
		if (rectBullet.intersects(rectTank)) {
			tank.die();
			this.die();
		}
	}

	public void die() {
		this.liveing = false;
	}

}
