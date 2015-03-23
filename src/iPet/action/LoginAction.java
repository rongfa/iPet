package iPet.action;

import iPet.model.User;
import iPet.service.ILoginService;
import iPet.util.JSON;
import iPet.util.UserContext;

/**
 * @author Administrator
 */
public class LoginAction extends BaseAction {
	private static final long serialVersionUID = -7179290958637332022L;
	private ILoginService loginService;
	private String name;
	private String password;

	public void setLoginService(ILoginService loginService) {
		this.loginService = loginService;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String execute() throws Exception {
		return LOGIN;
	}
	
	public String login() throws Exception {
		JSON json = new JSON();
		User user = loginService.login(name, password);
		if (user != null) {
			json.setMessage("登录成功");
			UserContext.addCurrentUser(user);
		} else {
			json.setSuccess(false);
			json.setMessage("用户名或密码错误");
		}
		putJSON(json);
		return AJAX;
	}

}
