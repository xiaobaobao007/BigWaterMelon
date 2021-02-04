package pers.xiaobaobao.bigwatermelon.swing;

import java.awt.*;

import javax.swing.*;

/**
 * @author bao meng yang <932824098@qq.com>
 * @date 2021/2/4，14:29:42
 */
public class GameFrame extends JFrame {

	private static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 500;

	private final GamePanel gamePanel;

	public GameFrame() {
		super.setName("合成大西瓜");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int frameX = (int) (screenSize.getWidth() - FRAME_WIDTH) / 2;
		int frameY = (int) (screenSize.getHeight() - FRAME_HEIGHT) / 2;
		this.setLocation(Math.max(frameX, 0), Math.max(frameY, 0));
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setLayout(null);

		gamePanel = new GamePanel();
		gamePanel.setLayout(null);
		gamePanel.setBounds(GamePanel.START_X, GamePanel.START_Y, GamePanel.X_MAX + 10, GamePanel.Y_MAX + 10);

		this.add(gamePanel);

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}

	public void start() {
		gamePanel.init();
	}

}
