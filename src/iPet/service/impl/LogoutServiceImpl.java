package iPet.service.impl;

import iPet.service.ILogoutService;
import iPet.util.UserContext;

public class LogoutServiceImpl implements ILogoutService {

	@Override
	public void logout() {
		UserContext.removeCurrentUser();
	}
}
