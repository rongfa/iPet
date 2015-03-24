package iPet.util;

import java.util.Random;

/**
 * @Description: 公共工具类
 * @author rongfa
 * @date 2015-3-24 下午9:34:45
 */
public abstract class CommonUtil {

	/**
	 * @Description: 获取验证码
	 * @return 验证码F
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
