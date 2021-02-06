package pers.xiaobaobao.bigwatermelon.domain;

/**
 * @author bao meng yang <932824098@qq.com>
 * @date 2021/2/5，15:42:59
 */
public class Collision {
	private final int aM;
	private final float aX;
	private final float aY;

	private final int bM;
	private final float bX;
	private final float bY;
	private final double sin;
	private final double cos;

	public Collision(int aM, Gravity aG, int bM, Gravity bG, double sin, double cos) {
		this.aM = aM;
		this.aX = aG.getxV();
		this.aY = aG.getyV();

		this.bM = bM;
		this.bX = bG.getxV();
		this.bY = bG.getyV();

		this.sin = sin;
		this.cos = cos;
	}

	public void setGravity(Gravity g, boolean a) {
		if (a) {
			g.setxV(aX);
			g.setyV(aY);
		} else {
			g.setxV(bX);
			g.setyV(bY);
		}
	}

	private void calculate() {
		// 斜边长度
		double bevelA = Math.sqrt(aX * aX + aY * aY);
		double xA = 2 * aX * aY / bevelA;
		if (aY < 0) {

		}
		double yA = aX * aX / bevelA - aY * aY / bevelA;

		double bevelB = Math.sqrt(bX * bX + bY * bY);
		double xB = 2 * bX * bY / bevelB;
		double yB = bX * bX / bevelB - bY * bY / bevelB;

	}

	private double getV1(int m1, int m2, double v1, double v2) {
		return ((m1 - m2) * v1 + 2 * m2 * v2) / (m1 + m2);
	}

	private double getV2(int m1, int m2, double v1, double v2) {
		return ((m2 - m1) * v2 + 2 * m1 * v1) / (m1 + m2);
	}

}
