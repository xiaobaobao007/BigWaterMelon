package pers.xiaobaobao.bigwatermelon.swing;

import java.awt.*;
import java.util.LinkedList;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

import pers.xiaobaobao.bigwatermelon.domain.WaterMelon;
import pers.xiaobaobao.bigwatermelon.util.NamedThreadFactory;

/**
 * @author bao meng yang <932824098@qq.com>
 * @date 2021/2/4，14:28:28
 */
public class GamePanel extends JPanel {

	public static final int START_X = 50;
	public static final int START_Y = 50;
	public static final int X_MAX = 400;
	public static final int Y_MAX = 400;
	private static final long PAINT_TIME = 25L;

	private final LinkedList<WaterMelon> waterMelonList = new LinkedList<>();
	ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("paint"));

	public void init() {
		WaterMelon waterMelon = new WaterMelon(10, 30, this);
		waterMelon.setX(50);
		waterMelon.setY(50);
		waterMelon.setSize(30);

		waterMelonList.add(waterMelon);

		start();
	}

	private void start() {
		executor.scheduleWithFixedDelay(this::repaint, PAINT_TIME, PAINT_TIME, TimeUnit.MILLISECONDS);
	}

	/**
	 * 是否是静止状态
	 */
	public boolean isStatic(WaterMelon waterMelon) {
		return waterMelon.getY() == waterMelon.getSize();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		g.drawRect(0, 0, X_MAX, Y_MAX);

		for (WaterMelon waterMelon : waterMelonList) {
			paintWaterMelon(waterMelon, g);
		}
	}

	private void paintWaterMelon(WaterMelon waterMelon, Graphics g) {
		waterMelon.calculateG(X_MAX, Y_MAX);
		g.drawOval(waterMelon.getX(), Y_MAX - waterMelon.getY() - waterMelon.getSize(), waterMelon.getSize(), waterMelon.getSize());
	}
}
