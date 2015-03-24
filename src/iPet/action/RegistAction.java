package iPet.action;

import iPet.service.IUserService;
import iPet.util.CommonUtil;
import iPet.util.JSON;

import com.opensymphony.xwork2.ActionContext;

/**
 * @Description: 注册
 * @author rongfa
 * @date 2015-3-24 下午8:40:33
 */
public class RegistAction extends BaseAction {
	private static final long serialVersionUID = -3594186542832157672L;
	private IUserService userService;
	private String email;

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

	/**
	 * @Description: 获取验证码
	 * @return 返回视图
	 * @throws Exception
	 */
	public String getVerificationCode() throws Exception {
		ActionContext.getContext().getSession().put("actionName", "regist");
		ActionContext.getContext().getSession().put("email", email);
		JSON json = new JSON();
		if (userService.findUserByEmail(email) != null) {
			json.setSuccess(false);
			json.setMessage("该用户已注册");
		} else {
			String random = CommonUtil.getRandom();
			CommonUtil.send(email, random);
			ActionContext.getContext().getSession().put(email, random);
		}
		putJSON(json);
		return AJAX;
	}
}
