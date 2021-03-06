package com.mann.tank;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Explode {

	/**
	 * 爆炸大小的宽度
	 */
	private static final int WIDTH = ResourceMgr.explodes[0].getWidth();

	/**
	 * 爆炸大小的高度
	 */
	private static final int HEIGHT = ResourceMgr.explodes[0].getHeight();

	/**
	 * 爆炸的横坐标
	 */
	private int x;

	/**
	 * 爆炸的纵坐标
	 */
	private int y;

	/**
	 * 爆炸的当前锚点
	 */
	private int step = 0;

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

	public TankFrame getTankFrame() {
		return tankFrame;
	}

	public void setTankFrame(TankFrame tankFrame) {
		this.tankFrame = tankFrame;
	}

	public static int getWidth() {
		return WIDTH;
	}

	public static int getHeight() {
		return HEIGHT;
	}

	/**
	 * 爆炸所在的窗口对象
	 */
	private TankFrame tankFrame = null;

	public Explode(int x, int y, TankFrame tankFrame) {
		this.x = x;
		this.y = y;
		this.tankFrame = tankFrame;
		new Audio("audio/explode.wav").run();
		
	}

	public void paint(Graphics g) {
		g.drawImage(ResourceMgr.explodes[step++], this.x, this.y, null);
		if (step >= ResourceMgr.explodes.length) {
			tankFrame.explodeList.remove(this);
		}
	}

}
