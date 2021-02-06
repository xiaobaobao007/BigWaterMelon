package pers.xiaobaobao.bigwatermelon.util;

import pers.xiaobaobao.bigwatermelon.domain.Gravity;
import pers.xiaobaobao.bigwatermelon.domain.WaterMelon;

/**
 * @author bao meng yang <932824098@qq.com>
 * @date 2021/2/4，17:54:22
 */
public class MathUtil {

	/**
	 * 是否发生了碰撞
	 */
	public static boolean isCollision(WaterMelon a, WaterMelon b) {
		return power(a.getX() - b.getX()) + power(a.getY() - b.getY()) < power((a.getSize() + b.getSize()) >> 1);
	}

	public static int power(int a) {
		return a * a;
	}

	/**
	 * 碰撞之后，设置各方向速度
	 */
	public static void setGravityAfterCollision(WaterMelon a, WaterMelon b) {
		a.back();
		b.back();

		Gravity aG = a.getGravity();
		Gravity bG = b.getGravity();

		aG.setxV(-aG.getxV());
		bG.setxV(-bG.getxV());

		// float xV = (aG.getxV() + bG.getxV()) / 2;
		// float yV = (aG.getyV() + bG.getyV()) / 2;
		//
		// if (xV == 0) {
		// 	aG.setxV(0);
		// 	bG.setxV(0);
		// } else {
		//
		// }
	}

	private static double getVerticalLineSlope(WaterMelon a, WaterMelon b) {
		return -1.0D * Math.abs(a.getX() - b.getX()) / Math.abs(a.getY() - b.getY());
	}
}
