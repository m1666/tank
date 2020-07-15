package com.mann.tank;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Explode {

	/**
	 * 爆炸的宽度
	 */
	private static final int WIDTH = ResourceMgr.explodes[0].getWidth();

	/**
	 * 爆炸的高度
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
	 * 爆炸是否还在界面内
	 */
	private boolean liveing = true;

	/**
	 * 爆炸所在的窗口对象
	 */
	private TankFrame tankFrame = null;

	/**
	 * 爆炸绘画到的步骤
	 */
	private int step = 0;

	public Explode(int x, int y, TankFrame tankFrame) {
		this.x = x;
		this.y = y;
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

	public boolean isLiveing() {
		return liveing;
	}

	public void setLiveing(boolean liveing) {
		this.liveing = liveing;
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

	public void paint(Graphics g) {

		g.drawImage(ResourceMgr.explodes[this.step++], this.x, this.y, null);
		if (this.step >= ResourceMgr.explodes.length) {
			this.step = 0;
		}
	}
}
