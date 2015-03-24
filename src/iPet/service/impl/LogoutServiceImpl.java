package iPet.service.impl;

import iPet.service.ILogoutService;
import iPet.util.UserContext;

/**
 * @Description:登出
 * @author rongfa
 * @date 2015-3-24 下午9:22:37
 */
public class LogoutServiceImpl implements ILogoutService {

	@Override
	public void logout() {
		UserContext.removeCurrentUser();
	}
}
