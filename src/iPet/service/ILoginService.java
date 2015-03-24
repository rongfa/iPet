package iPet.service;

import iPet.model.User;

/**
 * @Description: 登入service层
 * @author rongfa
 * @date 2015-3-24 下午9:22:06
 */
public interface ILoginService {
	/**
	 * @Description:登陆
	 * @param name
	 *            姓名/邮箱
	 * @param password
	 *            密码
	 * @return 登陆的用户F
	 */
	User login(String name, String password);
}
