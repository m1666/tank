package com.mann.tank;

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
	private Dir dir = Dir.STOP;

	/**
	 * 坦克的默认速度
	 */
	private static final int SPEED = 10;

	public Tank(int x, int y, Dir dir) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
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



	public void paint(Graphics g) {
		g.fillRect(this.x, this.y, 50, 50);

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
