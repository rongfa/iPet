package iPet.action;

import iPet.service.ILogoutService;

/**
 * @Description: 登出
 * @author rongfa
 * @date 2015-3-24 下午8:39:51
 */
public class LogoutAction extends BaseAction {
	private static final long serialVersionUID = -7179290958637332022L;
	private ILogoutService logoutService;

	public void setLogoutService(ILogoutService logoutService) {
		this.logoutService = logoutService;
	}

	@Override
	public String execute() throws Exception {
		logoutService.logout();
		return LOGIN;
	}

}
