package iPet.util;

import java.util.Random;

public abstract class CommonUtil {
	/**
	 * 获取验证码
	 * @return 验证码
	 */
	public static String getRandom() {
		String randomStr = "";
		Random random = new Random();
		for (int i = 0; i < 6; i++) {
			randomStr += random.nextInt(9);
		}
		return randomStr;
	}
}
