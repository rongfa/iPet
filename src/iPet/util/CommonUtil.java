package iPet.util;

import iPet.util.mail.MailSenderInfo;
import iPet.util.mail.SimpleMailSender;

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

	/**
	 * @Description: 发送邮件
	 * @param address
	 *            发送的email地址
	 * @param message
	 *            邮件信息
	 * @return 发送状态
	 */
	public static boolean send(String address, String message) {
		// 这个类主要是设置邮件
		MailSenderInfo mailInfo = new MailSenderInfo();
		mailInfo.setMailServerHost("smtp.163.com");
		mailInfo.setMailServerPort("25");
		mailInfo.setValidate(true);
		mailInfo.setUserName("chinarongfa@163.com");
		mailInfo.setPassword("RongFa=897570.0");
		mailInfo.setFromAddress("chinarongfa@163.com");
		mailInfo.setToAddress(address);
		mailInfo.setSubject("iPet验证信息");
		mailInfo.setContent("您的验证码是：" + message + ",如果非本人操作请反馈给我们; 温馨提示：此邮件由系统发送，请勿直接回复。");
		return SimpleMailSender.sendHtmlMail(mailInfo);
	}
}
