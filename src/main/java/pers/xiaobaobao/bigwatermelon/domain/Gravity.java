package pers.xiaobaobao.bigwatermelon.domain;

import pers.xiaobaobao.bigwatermelon.config.Constant;

/**
 * @author bao meng yang <932824098@qq.com>
 * @date 2021/2/4，15:08:34
 */
public class Gravity {
	private float xV;
	private float yV;

	public void nextX(boolean collision) {
		if (xV == 0) {
			return;
		}
		if (collision) {
			xV = xV * -Constant.COLLISION_PER;
		} else if (xV > 0) {
			xV -= Constant.AIR_RESISTANCE;
			if (xV < 0) {
				xV = 0;
			}
		} else {
			xV += Constant.AIR_RESISTANCE;
			if (xV > 0) {
				xV = 0;
			}
		}
	}

	public void nextY(boolean collision) {
		if (collision) {
			yV++;
			yV = yV * -Constant.COLLISION_PER;
		} else {
			yV--;
		}
	}

	public float getxV() {
		return xV;
	}

	public void setxV(float xV) {
		this.xV = xV;
	}

	public float getyV() {
		return yV;
	}

	public void setyV(float yV) {
		this.yV = yV;
	}

	@Override
	public String toString() {
		return "{" + "xV=" + (int) xV + ", yV=" + (int) yV + '}';
	}
}
