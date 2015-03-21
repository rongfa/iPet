package iPet.action;

import iPet.service.ILogoutService;

/**
 * @author Administrator
 */
public class LogoutAction extends BaseAction {
	private static final long serialVersionUID = -7179290958637332022L;
	private ILogoutService logoutService;

	public void setLogoutService(ILogoutService logoutService) {
		this.logoutService = logoutService;
	}

	public String execute() throws Exception {
		logoutService.logout();
		return LOGIN;
	}

}
