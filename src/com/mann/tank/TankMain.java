package com.mann.tank;

public class TankMain {

	public static void main(String[] args) throws InterruptedException {

		TankFrame tankFrame = new TankFrame();

		// 初始化敌方坦克
		for (int i = 0; i < 5; i++) {
			tankFrame.tankList.add(new Tank(50 + i * 80, 200, Dir.DOWN, tankFrame));
		}

		while (true) {
			Thread.sleep(50);
			tankFrame.repaint();
		}
	}

}
