package pers.xiaobaobao.bigwatermelon.config;

import java.util.LinkedHashMap;

/**
 * @author bao meng yang <932824098@qq.com>
 * @date 2021/2/4，14:20:29
 */
public class Config {

	public static final LinkedHashMap<Integer, Integer> SIZE = new LinkedHashMap<>();
	public static final int MAX_LEVEL;

	static {
		SIZE.put(1, 10);
		SIZE.put(2, 20);

		MAX_LEVEL = SIZE.size();
	}

}
