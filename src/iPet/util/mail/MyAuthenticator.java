package iPet.util.mail;

import javax.mail.*;

/**
 * @Description: 发送邮件用户信息（需要验证时才用F）
 * @author rongfa
 * @date 2015-3-24 下午9:35:39
 */
public class MyAuthenticator extends Authenticator {
	String userName = null;
	String password = null;

	public MyAuthenticator() {
	}

	public MyAuthenticator(String username, String password) {
		this.userName = username;
		this.password = password;
	}

	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(userName, password);
	}
}