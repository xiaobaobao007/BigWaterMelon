package pers.xiaobaobao.bigwatermelon.swing;

import java.awt.*;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

import pers.xiaobaobao.bigwatermelon.domain.WaterMelon;
import pers.xiaobaobao.bigwatermelon.util.MathUtil;
import pers.xiaobaobao.bigwatermelon.util.NamedThreadFactory;

import static pers.xiaobaobao.bigwatermelon.config.Constant.PAINT_TIME;

/**
 * @author bao meng yang <932824098@qq.com>
 * @date 2021/2/4，14:28:28
 */
public class GamePanel extends JPanel {

	public static final int START_X = 50;
	public static final int START_Y = 50;
	public static final int X_MAX = 300;
	public static final int Y_MAX = 300;

	private final LinkedList<WaterMelon> waterMelonList = new LinkedList<>();
	ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("paint"));

	public void init() {
		Random random = new Random();
		for (int i = 1; i <= 3; i++) {
			WaterMelon waterMelon = new WaterMelon(i, random.nextInt(100) - 50, random.nextInt(100) - 50, this);
			waterMelon.setSize(random.nextInt(40) + 40);
			waterMelon.setX(random.nextInt(X_MAX - waterMelon.getSize()));
			waterMelon.setY(random.nextInt(Y_MAX - waterMelon.getSize()));

			waterMelonList.add(waterMelon);
		}

		start();
	}

	private void start() {
		executor.scheduleWithFixedDelay(this::repaint, 0, PAINT_TIME, TimeUnit.MILLISECONDS);
	}

	/**
	 * 是否是静止状态
	 */
	public boolean isStatic(WaterMelon waterMelon) {
		return waterMelon.getY() == waterMelon.getSize();
	}

	/**
	 * 检测球之间的碰撞，并设置碰撞后的运动
	 */
	public void judgeCollision(WaterMelon waterMelon) {
		for (WaterMelon target : waterMelonList) {
			if (target == waterMelon) {
				continue;
			}
			if (MathUtil.isCollision(waterMelon, target)) {
				MathUtil.setGravityAfterCollision(waterMelon, target);
			}
		}
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		g.drawRect(0, 0, X_MAX, Y_MAX);

		for (WaterMelon waterMelon : waterMelonList) {
			paintWaterMelon(waterMelon, g);
			System.out.printf("%-70s", waterMelon);
		}
		System.out.println();
	}

	private void paintWaterMelon(WaterMelon waterMelon, Graphics g) {
		waterMelon.calculateG(X_MAX, Y_MAX);
		g.drawOval(waterMelon.getX(), Y_MAX - waterMelon.getY() - waterMelon.getSize(), waterMelon.getSize(), waterMelon.getSize());
		// g.drawString(waterMelon.get, Y_MAX - waterMelon.getY() - waterMelon.getSize(), waterMelon.getSize(), waterMelon.getSize());
	}
}
