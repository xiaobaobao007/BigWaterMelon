package pers.xiaobaobao.bigwatermelon.domain;

import pers.xiaobaobao.bigwatermelon.swing.GamePanel;

/**
 * @author bao meng yang <932824098@qq.com>
 * @date 2021/2/4，14:19:10
 */
public class WaterMelon {
	private int x;
	private int y;
	private int level;
	private int size;
	private int r;
	private final Gravity gravity;
	private final GamePanel gamePanel;

	public WaterMelon(int xV, int yV, GamePanel gamePanel) {
		gravity = new Gravity();
		gravity.setxV(xV);
		gravity.setyV(yV);
		this.gamePanel = gamePanel;
	}

	/**
	 * 是否是静止状态
	 */
	public boolean isStatic() {
		return gravity.getxV() == 0 && gravity.getyV() == 0 && gamePanel.isStatic(this);
	}

	public void calculateG(int xMax, int yMax) {
		if (isStatic()) {
			return;
		}

		x += gravity.getxV();
		y += gravity.getyV();

		boolean xCollision = true;
		if (x < 0) {
			x = 0;
		} else if (x + size > xMax) {
			x = xMax - size;
		} else {
			xCollision = false;
		}
		gravity.nextX(xCollision);

		boolean yCollision = true;
		if (y < 0) {
			y = 0;
		} else if (y + size > yMax) {
			y = yMax - size;
		} else {
			yCollision = false;
		}
		gravity.nextY(yCollision);
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

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
		r = size / 2;
	}

	public int getR() {
		return r;
	}

	@Override
	public String toString() {
		return "{" + "x=" + x + ", y=" + y + ", level=" + level + ", size=" + size + ", gravity=" + gravity + '}';
	}
}
