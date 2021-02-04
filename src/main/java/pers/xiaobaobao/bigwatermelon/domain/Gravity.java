package pers.xiaobaobao.bigwatermelon.domain;

/**
 * @author bao meng yang <932824098@qq.com>
 * @date 2021/2/4，15:08:34
 */
public class Gravity {
	private int xV;
	private int yV;

	public void nextX(boolean collision) {
		if (xV == 0) {
			return;
		}
		if (collision) {
			xV = xV * -4 / 5;
		}
	}

	public void nextY(boolean collision) {
		if (collision) {
			yV++;
			yV = yV * -4 / 5;
		} else {
			yV--;
		}
	}

	public int getxV() {
		return xV;
	}

	public void setxV(int xV) {
		this.xV = xV;
	}

	public int getyV() {
		return yV;
	}

	public void setyV(int yV) {
		this.yV = yV;
	}

	@Override
	public String toString() {
		return "{" + "xV=" + xV + ", yV=" + yV + '}';
	}
}
