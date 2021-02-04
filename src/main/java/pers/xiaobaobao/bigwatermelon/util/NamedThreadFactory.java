package pers.xiaobaobao.bigwatermelon.util;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author bao meng yang <932824098@qq.com>
 * @date 2021/2/3，14:33:51
 */
public class NamedThreadFactory implements ThreadFactory {

	private final AtomicInteger threadNumber = new AtomicInteger(1);
	private final String namePrefix;

	public NamedThreadFactory(String namePrefix) {
		this.namePrefix = namePrefix;
	}

	@Override
	public Thread newThread(Runnable runnable) {
		return new Thread(runnable, namePrefix + " thread-" + threadNumber.getAndIncrement());
	}

}
